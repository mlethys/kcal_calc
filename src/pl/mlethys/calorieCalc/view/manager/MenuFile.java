package pl.mlethys.calorieCalc.view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import pl.mlethys.calorieCalc.view.MainPanel;
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
    
    public MenuFile(final JFrame parent, final DietTabbedPane tabbedPane)
    {
        super("File");
        
        NEW_DIET = new JMenuItem("New diet");
        NEW_DIET.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabbedPane.addTab();
            }
        });
        
        OPEN_DIET = new JMenuItem("Open diet");
        OPEN_DIET.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               
            }
        });
        SAVE = new JMenuItem("Save");
        
        EXIT = new JMenuItem("Exit");
        EXIT.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.getContentPane().removeAll();
                parent.setJMenuBar(null);
                parent.repaint();
                parent.add(new MainPanel(parent));
                parent.setVisible(true);
            }
        });
        
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
