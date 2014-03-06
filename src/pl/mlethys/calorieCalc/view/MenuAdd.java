package pl.mlethys.calorieCalc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
public class MenuAdd extends JMenu implements Menu, ActionListener
{
    private final JMenuItem NEW_MEAL;
    private final JMenuItem NEW_FOOD;
    private JTabbedPane tabbedPane;
    private final String TAB_TITLE;
    private final ArrayList<TabPanel> TAB_PANELS;
    
    private final int MAX_PRODUCTS = 8;
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
        TAB_PANELS = new ArrayList<>();
        TAB_TITLE = "Meal";
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
    /**
     * Method creates button for tab in tabbed panel
     * @param title
     * @return 
     */
    private JButton createTabButton(final String title)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener()
        {
            /**
             * Method handles actions performed on button
             * @param e ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = tabbedPane.indexOfTab(title);
                TAB_PANELS.remove(index);
                tabbedPane.remove(index);
            }
        });
        return button;
    }
    
    private JButton createSummaryButton()
    {
        final JButton button = new JButton("Summary");
        
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                CalculatedMeal meal = new CalculatedMeal();
                try
                {
                    meal.calculateMeal(TAB_PANELS.get(tabbedPane.getSelectedIndex()).getProducts());
                    JOptionPane.showMessageDialog(tabbedPane, "Kcal: " + meal.getKcal() + "\n"
                                                                + "Proteins: " + meal.getProteins() + "\n"
                                                                + "Fats: " + meal.getFats() + "\n"
                                                                + "Carbs: " + meal.getCarbs());
                } 
                catch (NoProductsException ex)
                {
                    JOptionPane.showMessageDialog(tabbedPane, "You have to insert products first!");
                }
            }
        });
        return button;
    }
    
    private JButton createProductButton(final TabBody product)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(18, 18));
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TAB_PANELS.get(tabbedPane.getSelectedIndex()).setCounter(TAB_PANELS.get(tabbedPane.getSelectedIndex()).getCounter() - 1);
                product.removeAll();
                TAB_PANELS.get(tabbedPane.getSelectedIndex()).getProducts().remove(TAB_PANELS.get(tabbedPane.getSelectedIndex()).getProducts().size() - 1);
            }
        });
        return button;
    }
    
    
    /**
     * Methods creates copy of tabbed panel
     * @param tabbedPane JTabbedPane object
     */
    public void setTabbedPanel(JTabbedPane tabbedPane)
    {
        this.tabbedPane = tabbedPane;
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if (source == NEW_MEAL )
        {
            String tabTitle2 = TAB_TITLE + " " + tabbedPane.getTabCount();
            JLabel titleLabel = new JLabel(tabTitle2);
            TabPanel tabPanel = new TabPanel();
            JPanel titlePanel = new JPanel();
            titlePanel.add(titleLabel);
            titlePanel.add(createTabButton(tabTitle2));
            tabbedPane.addTab(tabTitle2, tabPanel); 
            tabPanel.getSummaryButtonPanel().add(createSummaryButton());
            tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, titlePanel);
            TAB_PANELS.add(tabPanel);
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
                if(TAB_PANELS.get(tabbedPane.getSelectedIndex()).getCounter() < MAX_PRODUCTS)
                {
                    TabPanel tmp = TAB_PANELS.get(tabbedPane.getSelectedIndex());
                    tmp.getProducts().add(new TabBody());
                    tmp.getProducts().get(tmp.getProducts().size() - 1).addComponent(createProductButton(tmp.getProducts().get(tmp.getProducts().size() - 1)));
                    TAB_PANELS.get(tabbedPane.getSelectedIndex()).getProductsPanel().add(tmp.getProducts().get(tmp.getProducts().size() - 1));
                    TAB_PANELS.get(tabbedPane.getSelectedIndex()).setCounter(TAB_PANELS.get(tabbedPane.getSelectedIndex()).getCounter() + 1);
                }
                else
                {
                    JOptionPane.showMessageDialog(tabbedPane, "You have reached the maximum number of products!");
                }
            }
        }
    }
}
