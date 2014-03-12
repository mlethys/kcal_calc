package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import pl.mlethys.calorieCalc.view.MenuHelp;

/**
 * 
 * @author mlethys
 * @version
 */
public class ManagerPanel extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private DietTabbedPane tabbedPane;
    private JMenuBar menuBar;
    private final Image BACKGROUND;
    private final JFrame PARENT;
    
    public ManagerPanel(JFrame parent)
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        UIManager.put("TabbedPane.contentOpaque", false);
        PARENT = parent; 
        tabbedPane = new DietTabbedPane();
        createMenuBar();
        parent.setJMenuBar(menuBar);
        add(tabbedPane);
        BACKGROUND = loadImage("manager_background.bmp");
    }
    
    private Image loadImage(String fileName)
    {
        Image backgroundImage = null;
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource(fileName)); 
        } 
        catch (IOException ex)
        {
            Logger.getLogger(ManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
        return backgroundImage;
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(BACKGROUND, 0, 0, null);
    }
    private void createMenuBar()
    {
        menuBar = new JMenuBar();
        
        MenuHelp menuHelp = new MenuHelp();
        menuHelp.addItems();
        
        MenuFile menuFile = new MenuFile(PARENT, tabbedPane);
        menuFile.addItems();
        MenuDiet menuDiet = new MenuDiet(tabbedPane);
        menuDiet.addItems();
        
        menuBar.add(menuFile);
        menuBar.add(menuDiet);
        menuBar.add(menuHelp);
    }
    
}
