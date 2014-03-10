package pl.mlethys.calorieCalc.view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
    
    public MenuDiet(final TabbedPane tabbedPane)
    {
        super("Diet");
        NEW_DAY = new JMenuItem("Add new day");
        NEW_DAY.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 tabbedPane.addTab();
            }
        });
        NEW_MEAL = new JMenuItem("Add new meal");
    }
    
    @Override
    public void addItems()
    {
        add(NEW_DAY);
        add(NEW_MEAL);
    }

}
