package pl.mlethys.calorieCalc.view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import pl.mlethys.calorieCalc.view.Menu;

/**
 * 
 * @author mlethys
 * @version
 */
public class MenuDiet extends JMenu implements Menu
{

    private final JMenuItem NEW_DAY;
    private final JMenuItem NEW_MEAL;
    
    public MenuDiet(final DietTabbedPane tabbedPane)
    {
        super("Diet");
        NEW_DAY = new JMenuItem("Add new day");
        NEW_DAY.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = tabbedPane.getSelectedIndex();
                if(index == -1)
                {
                    JOptionPane.showMessageDialog(NEW_DAY, "You have to create diet!");
                }
                else
                {
                    tabbedPane.getDay(index).addTab();
                }
            }
        });
        
        NEW_MEAL = new JMenuItem("Add new meal");
        NEW_MEAL.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = tabbedPane.getSelectedIndex();
                if(index == -1)
                {
                    JOptionPane.showMessageDialog(NEW_MEAL, "You have to create diet!");
                }
                else
                {
                    int index2 = tabbedPane.getDay(index).getSelectedIndex();
                    if(index2 == -1)
                    {
                        JOptionPane.showMessageDialog(NEW_MEAL, "You have to ceate new day!");
                    }
                    else
                    {
                        tabbedPane
                                .getDay(index)
                                .getPanel(index2)
                                .addTabBody();
                    }
                }
            }
        });
    }
    
    @Override
    public void addItems()
    {
        add(NEW_DAY);
        add(NEW_MEAL);
    }

}
