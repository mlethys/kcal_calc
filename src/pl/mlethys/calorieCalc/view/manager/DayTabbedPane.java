package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 * @author mlethys
 * @version
 */
public class DayTabbedPane extends JTabbedPane implements TabbedPane
{
    
    private final String TAB_TITLE = "Day";
    private JPanel tabTitlePanel;
    private JLabel tabTitleLabel;
    private ArrayList<TabPanel> panels;
    
    public DayTabbedPane()
    {
        super();
        panels = new ArrayList<>();
    }
    
    public DayTabbedPane getDayTabbedPane()
    {
        return this;
    }
    
    public TabPanel getPanel(int index)
    {
        return panels.get(index);
    }

    @Override
    public void addTab()
    {
        String tmpTitle = TAB_TITLE + " " + getTabCount();
        TabPanel tmpPanel = new TabPanel();
        addTab(tmpTitle, tmpPanel);
        panels.add(tmpPanel);
        tabTitleLabel = new JLabel(tmpTitle);
        tabTitlePanel = new JPanel();
        tabTitlePanel.add(tabTitleLabel);
        tabTitlePanel.add(createTabButton(tmpTitle));
        setTabComponentAt(getTabCount() - 1, tabTitlePanel);
    }

    @Override
    public JButton createTabButton(final String TITLE)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int tabIndex = getDayTabbedPane().indexOfTab(TITLE);
                System.out.println(tabIndex);
                getDayTabbedPane().remove(tabIndex);
                panels.remove(tabIndex);
            }
        });
        return button;
    }
}
