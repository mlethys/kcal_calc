package pl.mlethys.calorieCalc.controller;

import java.awt.EventQueue;
import javax.swing.UIManager;
import pl.mlethys.calorieCalc.view.Frame;

/**
 *
 * @author mlethys
 * @version beta 0.1.0
 */
/**
 * 
 * Main class of application
 */
public class CalorieCalc
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Frame frame = new Frame();
                UIManager.put("swing.boldMetal", Boolean.FALSE);
            }
        });
    }
    
}
