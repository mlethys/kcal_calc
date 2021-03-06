package pl.mlethys.calorieCalc.view;

import java.awt.Color;
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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pl.mlethys.calorieCalc.model.CalculatedProduct;
import pl.mlethys.calorieCalc.model.EmptyStatementException;
import pl.mlethys.calorieCalc.model.NoUnitsFoundException;

/**
 *
 * @author mlethys
 * @version beta 0.1.0
 */
public class TabBody extends JComponent
{
    private JTextField nameField;
    private final JTextField AMOUNT_FIELD;
    private final JComboBox<String> UNITS_BOX;
    private final JButton SUBMIT_BUTTON;
    private final String[] UNITS = {"Grams", "Liters", "Mililiters", ""};
    private ArrayList<TabBody> productsCopy;
    private final GridBagConstraints C;
    private CalculatedProduct product;
    
    public TabBody()
    {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 255));
        C = new GridBagConstraints();
        C.anchor = GridBagConstraints.WEST;
        C.gridx = 0;
        C.gridy = 0;
        C.insets = new Insets(5, 5, 5, 5);
        nameField = new JTextField(20);
        productsCopy = new ArrayList<>();
        AMOUNT_FIELD = new JTextField(20)
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
        SUBMIT_BUTTON = new JButton("Submit");
        SUBMIT_BUTTON.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                product = new CalculatedProduct();
                try
                {            
                    product.setProductName(nameField);
                    product.setAmount(AMOUNT_FIELD);
                    product.setUnit(UNITS_BOX, UNITS);
                    product.setNutritionalValues();
                    if(product.getProductsFound().isEmpty())
                    {
                        JOptionPane.showMessageDialog(nameField, "Product not found!");
                    }
                    else if(product.getProductsFound().size() > 1)
                    {
                        MessagePanel msgPanel = new MessagePanel(product.getProductsFound().toArray(new String[product.getProductsFound().size()]));
                        JOptionPane.showMessageDialog(nameField, msgPanel);
                        nameField.setText(msgPanel.getSelectedProduct());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(nameField,"Product name: " + product.getName()
                                                        + "\nKCal = " + product.getKcal()
                                                        + "\nProteins = " + product.getProteins() + "g"
                                                        + "\nFats = " + product.getFats() + "g"
                                                        + "\nCarbs = " + product.getCarbs() + "g");
                    }
                } 
                catch (EmptyStatementException ex)
                {
                    JOptionPane.showMessageDialog(nameField, "All of fields are required!");
                } 
                catch (NoUnitsFoundException ex)
                {
                    JOptionPane.showMessageDialog(nameField, "You have to specify the units!");
                }    
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(TabBody.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex)
                {
                    Logger.getLogger(TabBody.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        UNITS_BOX = new JComboBox<>(UNITS);
        UNITS_BOX.setSelectedIndex(3);
        C.gridx++;
        add(new JLabel("Product name"), C);
        C.gridx++;
        add(new JLabel("Amount"), C);
        C.gridx++;
        add(new JLabel("Unit"), C);
        C.gridy++;
        C.gridx++;
        C.gridx++;
        add(SUBMIT_BUTTON, C);
        
        C.gridx = 0;
        C.gridx++;
        add(nameField, C);
        C.gridx++;
        add(AMOUNT_FIELD, C);
        C.gridx++;
        add(UNITS_BOX, C);
    }
    
    public void setProductsCopy(ArrayList<TabBody> products)
    {
        productsCopy = products;
    }
    public ArrayList<TabBody> getProductsCopy()
    {
        return productsCopy;
    }
    
    public void addComponent(JComponent component)
    {
        C.gridx = 0;
        add(component, C);
    }
    
    public CalculatedProduct getMeal()
    {
        return product;
    }
}
