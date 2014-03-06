package pl.mlethys.calorieCalc.view;

import java.awt.BorderLayout;
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
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author mlethys
 * @version beta 0.1.0
 */
/**
 * 
 * Class for main panel which contains all of components
 */
public class CalcPanel extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JMenuBar menuBar;
 //   private final JTabbedPane TABBED_PANE;
    private TabbedPanel TABBED_PANE;
    private MenuAdd menuAdd;
    private final JFrame PARENT;
    private ToolBar toolBar;

    /**
     * Constructor of panel
     * @param parent
     */
    public CalcPanel(JFrame parent)
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        UIManager.put("TabbedPane.contentOpaque", false);
        TABBED_PANE = new TabbedPanel();
        toolBar = new ToolBar(parent);
        add(toolBar, BorderLayout.PAGE_START);
        createMenuBar();
        add(TABBED_PANE);
        TABBED_PANE.add(menuBar);
        this.PARENT = parent;
        parent.setJMenuBar(menuBar);
    }
    
    /**
     * Methods creates menu bar on the top of panel
     */
    private void createMenuBar()
    {
        menuBar = new JMenuBar();
        MenuHelp menuHelp = new MenuHelp();
        menuHelp.addItems();
        menuAdd = new MenuAdd();
        menuAdd.setTabbedPanel(TABBED_PANE);
        menuAdd.addItems();
        menuBar.add(menuAdd);
        menuBar.add(menuHelp);
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
            Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return backgroundImage;
    }

    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(loadImage("kcal_background.jpg"), 0, 0, null);
    }
    /**
     * Method gets menu bar object
     * @return JMenuBar object
     */
    public JMenuBar getMenuBar()
    {
        return menuBar;
    }
}
