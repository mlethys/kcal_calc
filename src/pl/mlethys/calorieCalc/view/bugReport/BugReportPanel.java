package pl.mlethys.calorieCalc.view.bugReport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import pl.mlethys.calorieCalc.model.mailSending.EmptyMessageException;
import pl.mlethys.calorieCalc.model.mailSending.Mail;

/**
 * 
 * @author mlethys
 * @version
 */
public class BugReportPanel extends JPanel
{
    private JTextArea messageArea;
    private JButton sendButton;
    private JLabel textAreaLabel;
    
    public BugReportPanel(final JFrame parent)
    {    
        setLayout(new BorderLayout());
        textAreaLabel = new JLabel("Message");
        add(textAreaLabel, BorderLayout.NORTH);
        messageArea = new JTextArea();
        JScrollPane areaScrollPane = new JScrollPane(messageArea);
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messageArea.setLineWrap(true);
        add(areaScrollPane, BorderLayout.CENTER);
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Mail mail = new Mail();
                try
                {
                    mail.setText(messageArea);
                    mail.sendMessage();
                    JOptionPane.showMessageDialog(messageArea, "Report has been sent");
                    parent.dispose();
                } 
                catch (MessagingException ex)
                {
                    JOptionPane.showMessageDialog(messageArea, "Report hasn't been sent");
                    parent.dispose();
                } 
                catch (EmptyMessageException ex)
                {
                    JOptionPane.showMessageDialog(messageArea, "Don't you want to send empty mail, do you?");
                }
                
            }
        });
        add(sendButton, BorderLayout.SOUTH);
    }
}
