package pl.mlethys.calorieCalc.view.bugReport;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * @author mlethys
 * @version
 */
public class BugReportFrame extends JFrame
{
    public BugReportFrame()
    {
        super("Bug report");
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationByPlatform(true);
        BugReportPanel bugReportPanel = new BugReportPanel(this);
        add(bugReportPanel);
        setVisible(true);
    }
    
}
