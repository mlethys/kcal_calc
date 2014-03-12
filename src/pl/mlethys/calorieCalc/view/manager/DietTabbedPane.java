package pl.mlethys.calorieCalc.view.manager;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 * @author mlethys
 * @version
 */
public class DietTabbedPane extends JTabbedPane implements TabbedPane
{
    private final String TAB_TITLE;
    private JPanel tabTitlePanel;
    private JLabel tabTitleLabel;
    private ArrayList<DayTabbedPane> days;
        
    public DietTabbedPane()
    {
        super();
        TAB_TITLE = "Diet";
        days = new ArrayList<>();
    }
    
    public DietTabbedPane getDietTabbedPane()
    {
        return this;
    }
    
    public DayTabbedPane getDay(int index)
    {
        if(index == -1)
        {
            return null;
        }
        return days.get(index);
    }
    
    @Override
    public void addTab()
    {
        String tmpTitle = TAB_TITLE + " " + getTabCount();
        DayTabbedPane tmpDay = new DayTabbedPane();
        addTab(tmpTitle, tmpDay);
        days.add(tmpDay);
        tabTitleLabel = new JLabel(tmpTitle);
        tabTitlePanel = new JPanel();
        tabTitlePanel.add(tabTitleLabel);
        tabTitlePanel.add(createTabButton(tmpTitle));
        setTabComponentAt(getTabCount() - 1, tabTitlePanel);
    }
    
    @Override
    public JButton createTabButton(final String TAB_TITLE)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int confirmed = JOptionPane.showConfirmDialog(null, 
                "Do you want to save diet before close?", "Save diet",
                JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) 
                {
                    //TODO: saving file
                    int tabIndex = getDietTabbedPane().indexOfTab(TAB_TITLE);;
                    getDietTabbedPane().remove(tabIndex);
                    days.remove(tabIndex);
                }
                else
                {
                    int tabIndex = getDietTabbedPane().indexOfTab(TAB_TITLE);;
                    getDietTabbedPane().remove(tabIndex);
                    days.remove(tabIndex);
                }
            }
        });
        return button;
    }
}
