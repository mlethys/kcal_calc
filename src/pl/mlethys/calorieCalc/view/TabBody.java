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
import pl.mlethys.calorieCalc.model.PhraseNotFoundException;
import pl.mlethys.calorieCalc.model.TooManyResultsFoundException;

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
    private final String[] units = {"Grams", "Liters", "Mililiters", ""};
    private ArrayList<TabBody> productsCopy;
    private final GridBagConstraints C;
    private CalculatedProduct meal;
    
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
                meal = new CalculatedProduct();
                try
                {            
                    meal.getProductName(nameField);
                    meal.getAmount(AMOUNT_FIELD);
                    meal.getUnit(UNITS_BOX, units);
                    meal.setNutritionalValues();
                    JOptionPane.showMessageDialog(nameField,"Product name: " + nameField.getText() 
                                                    + "\nKCal = " + meal.getKcal()
                                                    + "\nProteins = " + meal.getProteins() + "g"
                                                    + "\nFats = " + meal.getFats() + "g"
                                                    + "\nCarbs = " + meal.getCarbs() + "g");
                } 
                catch (EmptyStatementException ex)
                {
                    JOptionPane.showMessageDialog(nameField, "All of fields are required!");
                } 
                catch (NoUnitsFoundException ex)
                {
                    JOptionPane.showMessageDialog(nameField, "You have to specify the units!");
                } 
                catch (PhraseNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(nameField, "Product not found!");
                } 
                catch (TooManyResultsFoundException ex)
                {
                    MessagePanel msgPanel = new MessagePanel(meal.getProductsFound().toArray(new String[meal.getProductsFound().size()]));
                    JOptionPane.showMessageDialog(nameField, msgPanel);
                    nameField.setText(msgPanel.getSelectedProduct());
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
        UNITS_BOX = new JComboBox<>(units);
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
        return meal;
    }
}
