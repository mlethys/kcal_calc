package pl.mlethys.calorieCalc.view;

import pl.mlethys.calorieCalc.view.bugReport.BugReportFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * @author mlethys
 * @version beta 0.1.0
 */
public class MenuHelp extends JMenu implements Menu
{

    private final JMenuItem HELP_CONTENTS;
    private final JMenuItem ABOUT;
    private final JMenuItem CREDITS;
    private final JMenuItem BUG_REPORT;
    
    public MenuHelp()
    {
        super("Help");
        HELP_CONTENTS = new JMenuItem("Help contents");
        BUG_REPORT = new JMenuItem("Bug report");
        BUG_REPORT.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(BUG_REPORT, "This feature will provide anonymous data about your OS");
                BugReportFrame raportFrame = new BugReportFrame();
            }
        });
        ABOUT = new JMenuItem("About");
        ABOUT.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                 JOptionPane.showMessageDialog(ABOUT, "This application will help you keep your diet.\n"
                                                    + "It's based on Freeware license.\n"
                                                    + "Product version: Calorie Calculator beta 0.2.0");
            }
        });
        CREDITS = new JMenuItem("Credits");
        CREDITS.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                 JOptionPane.showMessageDialog(CREDITS, "This software is written and developed by Michał Kabała.\n"
                                                    + "Please notify that it's only early access version.\n"
                                                    + "I hope you enjoy ;)");
            }
        });
        HELP_CONTENTS.setEnabled(false);
    }
    
    @Override
    public void addItems()
    {
         add(HELP_CONTENTS);
         add(BUG_REPORT);
         add(ABOUT);
         add(CREDITS);
    }
}
