package pl.mlethys.calorieCalc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * 
 * @author mlethys
 * @version
 */

public class TabPanel extends JPanel
{
    private int counter;
    private JPanel productsPanel;
    private JPanel summaryButtonPanel;
    private final ArrayList<TabBody> PRODUCTS;
        
    public TabPanel()
    {
        PRODUCTS = new ArrayList<>();
        counter = 0;
        this.setLayout(new BorderLayout());
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 255));
        productsPanel = new JPanel();
        productsPanel.setOpaque(false);
        productsPanel.setBackground(new Color(255, 255, 255, 200));
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
        summaryButtonPanel = new JPanel();
        summaryButtonPanel.setLayout(new BorderLayout());
        add(productsPanel, BorderLayout.NORTH);
        add(summaryButtonPanel, BorderLayout.SOUTH);
    }

    public int getCounter()
    {
        return counter;
    }
        
    public JPanel getProductsPanel()
    {
        return productsPanel;
    }
        
    public JPanel getSummaryButtonPanel()
    {
        return summaryButtonPanel;
    }
        
    public void setCounter(int value)
    {
        counter = value;
    }
        
    public ArrayList<TabBody> getProducts()
    {
        return PRODUCTS;
    }
}  