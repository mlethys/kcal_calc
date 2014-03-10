package pl.mlethys.calorieCalc.view.manager;

import javax.swing.JTabbedPane;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabbedPane extends JTabbedPane
{
    private final String TAB_TITLE;
    
    
    public TabbedPane()
    {
        super();
        TAB_TITLE = "Day";
    }
    
    public void addTab()
    {
        this.addTab(TAB_TITLE, null);
    }
}
