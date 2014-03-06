package pl.mlethys.calorieCalc.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author mlethys
 * @version
 */
public class MainPanel extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JButton calcButton, dietButton;
    
    public MainPanel(final JFrame parent)
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(0, 2));
        calcButton = new JButton();
        dietButton = new JButton();
        try 
        {
            Image img = ImageIO.read(getClass().getResource("kcal_calc.jpg"));
            calcButton.setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("diet_menager.jpg"));
            dietButton.setIcon(new ImageIcon(img));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        calcButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CalcPanel calcPanel = new CalcPanel(parent);
                MainPanel.this.setVisible(false);
                parent.add(calcPanel);
            }
        });
        add(calcButton);
        add(dietButton);
    }
    
}
