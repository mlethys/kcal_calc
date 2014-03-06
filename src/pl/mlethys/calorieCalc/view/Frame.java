package pl.mlethys.calorieCalc.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mlethys
 * @version beta 0.2.0
 */
/**
 * Class draws main frame of application
 * 
 */
public class Frame extends JFrame
{
    private final MainPanel PANEL;
    /**
     * Constructor of frame
     */
    public Frame()
    {
        super("Calorie Calculator 0.2.0 beta");
        PANEL = new MainPanel(this);
        add(PANEL);
        pack();
        setResizable(false);
        setLocationByPlatform(true);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                int confirmed = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to exit the program?", "Exit Program",
                JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) 
                {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                else
                {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    
    public MainPanel getMainPanel()
    {
        return PANEL;
    }
}
