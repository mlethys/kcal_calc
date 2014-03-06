package pl.mlethys.calorieCalc.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author mlethys
 * @version
 */
public class MessagePanel extends JPanel
{
    private JLabel textLabel;
    private JComboBox<String> products;
    
    public MessagePanel(String[] products)
    {
        textLabel = new JLabel("Select product");
        this.products = new JComboBox<>(products);
        add(textLabel);
        add(this.products);
    }
    
    public String getSelectedProduct()
    {
        return products.getSelectedItem().toString();
    }
}
