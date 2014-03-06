package pl.mlethys.calorieCalc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabbedPanel extends JTabbedPane
{
    private final String TAB_TITLE;
    private final ArrayList<TabPanel> TAB_PANELS;
    private final int MAX_PRODUCTS = 8;
    private final JTabbedPane TABBED_PANE;
    
    public TabbedPanel()
    {
        super();
        TABBED_PANE = this;
        TAB_TITLE = "Meal";
        TAB_PANELS = new ArrayList<>();
    }
    
    
    public JButton createTabButton(final String title)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = TABBED_PANE.indexOfTab(title);
                TAB_PANELS.remove(index);
                TABBED_PANE.remove(index);
            }
        });
        return button;
    }
    
    public ArrayList<TabPanel> getTabPanels()
    {
        return TAB_PANELS;
    }
    
    public String getTabTitle()
    {
        return TAB_TITLE;
    }

}
