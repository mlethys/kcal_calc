package pl.mlethys.calorieCalc.view.manager;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabPanel extends JPanel
{
    public TabPanel()
    {
        super();
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }
    
    public void addTabBody()
    {
        add(new TabBody());
    }
}
