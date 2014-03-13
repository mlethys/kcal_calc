package pl.mlethys.calorieCalc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import pl.mlethys.calorieCalc.model.CalculatedMeal;
import pl.mlethys.calorieCalc.model.NoProductsException;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabbedPanel extends JTabbedPane
{
    private final String TAB_TITLE;
    private final ArrayList<TabPanel> TAB_PANELS;
    private final int MAX_PRODUCTS = 8;
    private final int MAX_TABS = 9;
    private final JTabbedPane TABBED_PANE;
    
    public TabbedPanel()
    {
        super();
        TABBED_PANE = this;
        TAB_TITLE = "Meal";
        TAB_PANELS = new ArrayList<>();
    }
    
    
    public JButton createTabButton(final String title)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(15, 15));
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = TABBED_PANE.indexOfTab(title);
                TAB_PANELS.remove(index);
                TABBED_PANE.remove(index);
            }
        });
        return button;
    }
    
    public JButton createSummaryButton()
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
                    meal.calculateMeal(TAB_PANELS.get(TABBED_PANE.getSelectedIndex()).getProducts());
                    JOptionPane.showMessageDialog(TABBED_PANE, "Kcal: " + meal.getKcal() + "\n"
                                                                + "Proteins: " + meal.getProteins() + "\n"
                                                                + "Fats: " + meal.getFats() + "\n"
                                                                + "Carbs: " + meal.getCarbs());
                } 
                catch (NoProductsException ex)
                {
                    JOptionPane.showMessageDialog(TABBED_PANE, "You have to insert products first!");
                }
            }
        });
        return button;
    }
    
    public JButton createProductButton(final TabBody product)
    {
        JButton button = new JButton("x");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(18, 18));
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TAB_PANELS
                    .get(TABBED_PANE.getSelectedIndex())
                    .setCounter(TAB_PANELS.get(TABBED_PANE.getSelectedIndex())
                    .getCounter() - 1);
                product.removeAll();
                TAB_PANELS
                    .get(TABBED_PANE.getSelectedIndex())
                    .getProducts()
                    .remove(TAB_PANELS.get(TABBED_PANE.getSelectedIndex()).getProducts().size() - 1);
                TABBED_PANE.repaint();
            }
        });
        return button;
    }
    
    public ArrayList<TabPanel> getTabPanels()
    {
        return TAB_PANELS;
    }
    
    public String getTabTitle()
    {
        return TAB_TITLE;
    }
    
    public int getMaxProducts()
    {
        return MAX_PRODUCTS;
    }
    
    public int getMaxTabs()
    {
        return MAX_TABS;
    }

}
