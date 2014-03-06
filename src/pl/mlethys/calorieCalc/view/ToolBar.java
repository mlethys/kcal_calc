package pl.mlethys.calorieCalc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

/**
 * 
 * @author mlethys
 * @version
 */
public class ToolBar extends JPanel implements ActionListener
{
    private JButton newMealButton;
    private JButton newFoodButton;
    private JToolBar toolBar;
    
    public ToolBar()
    {
        super(new BorderLayout());
        setPreferredSize(new Dimension(800, 30));
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        newMealButton = new JButton();
        newMealButton.setToolTipText("Add new meal");
        
        newFoodButton = new JButton();
        newFoodButton.setToolTipText("Add new food");
        try
        {
            Image img = ImageIO.read(getClass().getResource("new_meal_icon.png"));
            newMealButton.setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("new_food_icon.png"));
            newFoodButton.setIcon(new ImageIcon(img));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(newFoodButton);
        toolBar.add(newMealButton);
        toolBar.setOpaque(false);
        add(toolBar);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == newMealButton)
        {
      
        }
    }
    
    
}