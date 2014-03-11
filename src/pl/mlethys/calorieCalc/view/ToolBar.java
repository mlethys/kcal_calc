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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * 
 * @author mlethys
 * @version
 */
public class ToolBar extends JPanel implements ActionListener, MenuAddFeatures
{
    private JButton newMealButton;
    private JButton newFoodButton;
    private JButton jumpToStartButton;
    private JToolBar toolBar;
    private JFrame PARENT;
    private TabbedPanel tabbedPanel;
    
    public ToolBar(JFrame parent)
    {
        super(new BorderLayout());
        setPreferredSize(new Dimension(800, 30));
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        PARENT = parent;
        
        newMealButton = new JButton();
        newMealButton.setToolTipText("Add new meal");
        newMealButton.addActionListener(this);
        
        newFoodButton = new JButton();
        newFoodButton.setToolTipText("Add new food");
        newFoodButton.addActionListener(this);
        
        jumpToStartButton = new JButton();
        jumpToStartButton.setToolTipText("Jump to start");
        jumpToStartButton.addActionListener(this);
        try
        {
            Image img = ImageIO.read(getClass().getResource("new_meal_icon.png"));
            newMealButton.setIcon(new ImageIcon(img));
            
            img = ImageIO.read(getClass().getResource("new_food_icon.png"));
            newFoodButton.setIcon(new ImageIcon(img));
           
            img = ImageIO.read(getClass().getResource("jump_to_icon.png"));
            jumpToStartButton.setIcon(new ImageIcon(img));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(newFoodButton);
        toolBar.add(newMealButton);
        toolBar.add(jumpToStartButton);
        toolBar.setOpaque(false);
        add(toolBar);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == jumpToStartButton)
        {
            PARENT.getContentPane().removeAll();
            PARENT.setJMenuBar(null);
            PARENT.repaint();
            PARENT.add(new MainPanel(PARENT));
            PARENT.setVisible(true);
        }
        else if(source == newMealButton)
        {
            if(tabbedPanel.getMaxTabs() < tabbedPanel.getTabCount())
            {
                String msg = "You have reached the maximum number of meals!";
                JOptionPane.showMessageDialog(tabbedPanel, msg);
            }
            else
            {
                addMeal();
            }
        }
        else if(source == newFoodButton)
        {
            if (tabbedPanel.getTabCount() == 0)
            {
                String msg = "You have to create new meal at first!";
                JOptionPane.showMessageDialog(tabbedPanel, msg);
            }
            else
            {
                if(tabbedPanel
                    .getTabPanels()
                    .get(tabbedPanel.getSelectedIndex())
                    .getCounter() < tabbedPanel.getMaxProducts())
                    
                {
                    addFood();
                }
                else
                {
                    JOptionPane.showMessageDialog(tabbedPanel, "You have reached the maximum number of products!");
                }
            }
        }
    } 
    
    public void setTabbedPanel(TabbedPanel tabbedPanel)
    {
        this.tabbedPanel = tabbedPanel;
    }

    @Override
    public void addFood()
    {
        TabPanel tmp = tabbedPanel
            .getTabPanels()
            .get(tabbedPanel.getSelectedIndex());
        tmp.getProducts().add(new TabBody());
        tmp.getProducts()
            .get(tmp.getProducts().size() - 1)
            .addComponent(tabbedPanel.createProductButton(tmp.getProducts().get(tmp.getProducts().size() - 1)));
        tabbedPanel
            .getTabPanels()
            .get(tabbedPanel.getSelectedIndex())
            .getProductsPanel()
            .add(tmp.getProducts().get(tmp.getProducts().size() - 1));
        tabbedPanel
            .getTabPanels()
            .get(tabbedPanel.getSelectedIndex())
            .setCounter(tabbedPanel.getTabPanels().get(tabbedPanel.getSelectedIndex()).getCounter() + 1); 
        tabbedPanel.repaint();
    }

    @Override
    public void addMeal()
    {
        String tabTitle = tabbedPanel.getTabTitle()+ " " + tabbedPanel.getTabCount();
        JLabel titleLabel = new JLabel(tabTitle); 
        JPanel titlePanel = new JPanel();
        TabPanel tabPanel = new TabPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(tabbedPanel.createTabButton(tabTitle));
        tabbedPanel.addTab(tabTitle, tabPanel);
        tabPanel.getSummaryButtonPanel().add(tabbedPanel.createSummaryButton());
        tabbedPanel.setTabComponentAt(tabbedPanel.getTabCount() - 1, titlePanel);
        tabbedPanel.getTabPanels().add(tabPanel);       
    }
}
