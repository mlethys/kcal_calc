package pl.mlethys.calorieCalc.model.mailSending;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextArea;

/**
 * 
 * @author mlethys
 * @version
 */
public class Mail 
{
    private final String FROM = "kcalcalc@gmail.com";
    private final String TO = "michal.kabala@gmail.com";
    private final String PASSWORD = "kcalcalcpass";
    private final String HOST = "smtp.gmail.com";
    private final String PORT = "465";
    private final String SUBJECT = "Bug report";
    private String startMsg;
    private String usersMsg;
    private Properties properties;
    private String text;
    
    public Mail() 
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String osName = "os.name";
        String osVersion = "os.version";
        startMsg = "This bug report has been generated on " + dateFormat.format(date) + "\n"
                    + "OS: " + System.getProperty(osName) + " Version: " + System.getProperty(osVersion) + "\n"
                    + "With users message:\n"; 
        
        properties = new Properties();
        setProperties();
    }
    
    public void setText(JTextArea textArea) throws EmptyMessageException
    {
        if(!textArea.getText().isEmpty())
        {
            usersMsg = textArea.getText();
        }
        else
        {
            throw new EmptyMessageException();
        }
        text = startMsg + usersMsg;
    }
    

            
    public void sendMessage() throws MessagingException
    {
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(properties, auth);     
        MimeMessage msg = new MimeMessage(session);
        msg.setText(text);
        msg.setSubject(SUBJECT);
        msg.setFrom(new InternetAddress(FROM));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        Transport.send(msg);        
    }
    
    private void setProperties()
    {
        properties.put("mail.smtp.user", FROM);
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        properties.put("mail.smtp.socketFactory.port", PORT);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
    }
  
    private class SMTPAuthenticator extends Authenticator 
    {
        @Override
        public PasswordAuthentication getPasswordAuthentication() 
        {
            return new PasswordAuthentication(FROM, PASSWORD);
        }
    }
}
