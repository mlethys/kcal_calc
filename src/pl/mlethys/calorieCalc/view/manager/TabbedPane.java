package pl.mlethys.calorieCalc.view.manager;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabbedPane extends JTabbedPane
{
    private final String TAB_TITLE;
    private JPanel tabTitlePanel;
    private JLabel tabTitleLabel;
        
    public TabbedPane()
    {
        super();
        TAB_TITLE = "Day";
    }
    
    public TabbedPane getTabbedPane()
    {
        return this;
    }
    
    public void addTab()
    {
        String tmpTitle = TAB_TITLE + " " + getTabCount();
        addTab(tmpTitle, null);
        tabTitleLabel = new JLabel(tmpTitle);
        tabTitlePanel = new JPanel();
        tabTitlePanel.add(tabTitleLabel);
        tabTitlePanel.add(createTabButton(tmpTitle));
        setTabComponentAt(getTabCount() - 1, tabTitlePanel);
    }
    
    private JButton createTabButton(final String tabTitle)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int tabIndex = getTabbedPane().indexOfTab(tabTitle);;
                getTabbedPane().remove(tabIndex);
            }
        });
        return button;
    }
}
