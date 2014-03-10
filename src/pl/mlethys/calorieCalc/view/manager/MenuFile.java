package pl.mlethys.calorieCalc.view.manager;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import pl.mlethys.calorieCalc.view.Menu;

/**
 * 
 * @author mlethys
 * @version
 */
public class MenuFile extends JMenu implements Menu
{
    private final JMenuItem NEW_DIET;
    private final JMenuItem OPEN_DIET;
    private final JMenuItem SAVE;
    private final JMenuItem EXIT;
    
    public MenuFile()
    {
        super("File");
        NEW_DIET = new JMenuItem("New diet");
        OPEN_DIET = new JMenuItem("Open diet");
        SAVE = new JMenuItem("Save");
        EXIT = new JMenuItem("Exit");
        
    }
    
    @Override
    public void addItems()
    {
        add(NEW_DIET);
        add(OPEN_DIET);
        add(SAVE);
        add(EXIT);
    }

}
