package pl.mlethys.calorieCalc.view.manager.products;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pl.mlethys.calorieCalc.model.CalculatedProduct;
import pl.mlethys.calorieCalc.model.EmptyStatementException;
import pl.mlethys.calorieCalc.model.NoUnitsFoundException;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductDetailsPanel extends JPanel
{
    private final int WIDTH = 300;
    private final int HEIGHT = 150;
    private JTextField amountField;
    private JComboBox<String> units;
    private JLabel amountLabel, unitsLabel;
    private JButton okButton;
    private final String[] UNITS = {"Grams", "Liters", "Mililiters", ""};
    private ProductDetailsFrame parent;
    private CalculatedProduct product;
    
    public ProductDetailsPanel(ProductDetailsFrame parent, ArrayList<CalculatedProduct> products)
    {
        super();
        this.parent = parent;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        
        amountLabel = new JLabel("Amount");
        add(amountLabel, c);
        c.gridx++;
        
        unitsLabel = new JLabel("Units");
        add(unitsLabel, c);
        c.gridx = 0;
        c.gridy++;
        
        setAmountField(c);
        c.gridx++;
        
        units = new JComboBox<>(UNITS);
        units.setSelectedIndex(3);
        add(units, c);
        c.gridx = 0;
        c.gridy++;
        
        setOkButton(c, products);
    }
    
    private void setAmountField(GridBagConstraints c)
    {
        amountField = new JTextField(10)
        {
            @Override
            public void processKeyEvent(KeyEvent ev)
            {
                char c = ev.getKeyChar();
      
                 if (c > 47 && c < 58 || c == 8 || ev.getKeyCode() == KeyEvent.VK_LEFT || ev.getKeyCode() == KeyEvent.VK_RIGHT)
                 {
                    super.processKeyEvent(ev);
                 }
   
            }
        };
        add(amountField, c);
    }
    
    private void setOkButton(GridBagConstraints c, final ArrayList<CalculatedProduct> PRODUCTS)
    {
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    product = new CalculatedProduct();
                    product.setNameByForce(parent.getWindowName());
                    product.getAmount(amountField);
                    product.getUnit(units, UNITS);
                    product.setNutritionalValues();
                    PRODUCTS.add(product);
                    parent.dispose();
                } 
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ProductDetailsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex)
                {
                    Logger.getLogger(ProductDetailsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (EmptyStatementException ex)
                {
                    JOptionPane.showMessageDialog(amountField, "You have to fill amount field!");
                } 
                catch (NoUnitsFoundException ex)
                {
                    JOptionPane.showMessageDialog(units, "You have to specify the units!");
                }   
            }
        });
        add(okButton, c);
    }
}
