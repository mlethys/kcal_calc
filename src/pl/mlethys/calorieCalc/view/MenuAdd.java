package pl.mlethys.calorieCalc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.CalculatedMeal;
import pl.mlethys.calorieCalc.model.NoProductsException;

/**
 *
 * @author Michał Kabała
 * @version beta 0.1.0
 */
/**
 * 
 * Class for submenu in menu bar
 */
public class MenuAdd extends JMenu implements Menu, ActionListener, MenuFeatures
{
    private final JMenuItem NEW_MEAL;
    private final JMenuItem NEW_FOOD;
    private TabbedPanel tabbedPane;
    
    /**
     * Constructor of component
     */
    public MenuAdd()
    {
        super("Add");
        NEW_MEAL = new JMenuItem("New meal");
        NEW_FOOD = new JMenuItem("New product");
        NEW_MEAL.addActionListener(this);
        NEW_FOOD.addActionListener(this);
    }

    /**
     * Method adds options to submenu
     */
    @Override
    public void addItems()
    {
        add(NEW_MEAL);
        add(NEW_FOOD);
    }

    
    public void setTabbedPanel(TabbedPanel tabbedPane)
    {
        this.tabbedPane = tabbedPane;
        
    }
    
    @Override
    public void addMeal()
    {
        String tabTitle = tabbedPane.getTabTitle() + " " + tabbedPane.getTabCount();
        JLabel titleLabel = new JLabel(tabTitle); 
        JPanel titlePanel = new JPanel();
        TabPanel tabPanel = new TabPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(tabbedPane.createTabButton(tabTitle));
        tabbedPane.addTab(tabTitle, tabPanel);
        tabPanel.getSummaryButtonPanel().add(tabbedPane.createSummaryButton());
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, titlePanel);
        tabbedPane.getTabPanels().add(tabPanel);       
    }
    
    @Override
    public void addFood()
    {
        TabPanel tmp = tabbedPane
            .getTabPanels()
            .get(tabbedPane.getSelectedIndex());
        tmp.getProducts().add(new TabBody());
        tmp.getProducts()
            .get(tmp.getProducts().size() - 1)
            .addComponent(tabbedPane.createProductButton(tmp.getProducts().get(tmp.getProducts().size() - 1)));
        tabbedPane
            .getTabPanels()
            .get(tabbedPane.getSelectedIndex())
            .getProductsPanel()
            .add(tmp.getProducts().get(tmp.getProducts().size() - 1));
        tabbedPane
            .getTabPanels()
            .get(tabbedPane.getSelectedIndex())
            .setCounter(tabbedPane.getTabPanels().get(tabbedPane.getSelectedIndex()).getCounter() + 1); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if (source == NEW_MEAL )
        {
           addMeal();
        }
        else if (source == NEW_FOOD)
        {
            if (tabbedPane.getTabCount() == 0)
            {
                String msg = "You have to create new meal at first!";
                JOptionPane.showMessageDialog(tabbedPane, msg);
            }
            else
            {
                if(tabbedPane
                    .getTabPanels()
                    .get(tabbedPane.getSelectedIndex())
                    .getCounter() < tabbedPane.getMaxProducts())
                    
                {
                    addFood();
                }
                else
                {
                    JOptionPane.showMessageDialog(tabbedPane, "You have reached the maximum number of products!");
                }
            }
        }
    }
}
