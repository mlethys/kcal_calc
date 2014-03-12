package pl.mlethys.calorieCalc.view.manager;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }
    
    public void addTabBody()
    {
        add(new TabBody());
    }
}
