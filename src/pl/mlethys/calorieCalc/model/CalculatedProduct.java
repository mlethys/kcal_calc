package pl.mlethys.calorieCalc.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * 
 * @author mlethys
 * @version beta 0.1.0
 */
public class CalculatedProduct 
{
    private String name;
    private String unit;
    private int categoryId;
    private float kcal;
    private float proteins;
    private float fats;
    private float carbs;
    private float amount;
    private ArrayList<String> productsFound;
    
    public CalculatedProduct()
    {
        kcal = 0;
        proteins = 0;
        fats = 0;
        carbs = 0;
        amount = 0;
        unit = "";
        categoryId = 0;
        productsFound = new ArrayList<>();
    }
    
    public void getProductName(JTextField nameTextField) throws EmptyStatementException
    {
        if (nameTextField.getText().isEmpty() || "".equals(nameTextField.getText()))
        {
            throw new EmptyStatementException();
        }
        String tmp = nameTextField.getText();
        name = tmp.toLowerCase();
        
    }
    
    public void setNameByForce(String name)
    {
        this.name = name;
    }
    
    public void getAmount(JTextField amountTextField) throws EmptyStatementException
    {
        if (amountTextField.getText().isEmpty())
        {
            throw new EmptyStatementException();
        }
        String tmp = amountTextField.getText();
        amount = Float.parseFloat(tmp);
    }
    
    public float getAmount()
    {
        return amount;
    }
    
    public void getUnit(JComboBox unitComboBox, String[] units) throws NoUnitsFoundException
    {
        if ("".equals(units[unitComboBox.getSelectedIndex()]))
        {
            throw new NoUnitsFoundException();
        }
        unit = units[unitComboBox.getSelectedIndex()];
    }
    

    private String setQuery()
    {
        return "SELECT * from KCAL.PRODUCTS where product_name like '%" + name + "%'";
    }
    
    public ArrayList<String> getProductsFound()
    {
        return productsFound;
    }
    
    public void setNutritionalValues() throws ClassNotFoundException, SQLException
    {
       
        DatabaseInfo dbInfo = new DatabaseInfo();
        ResultSet resultSet = dbInfo.getInfo(setQuery());
        while(resultSet.next())
        {
            productsFound.add(resultSet.getString("product_name"));
        }
        resultSet.beforeFirst();
        while(resultSet.next())
        {
            kcal = resultSet.getFloat("kcal");
            proteins = resultSet.getFloat("proteins");
            fats = resultSet.getFloat("fats");
            carbs = resultSet.getFloat("carbs");
        }
        
        kcal = round(calculateKcal(), 2);
        proteins = round(calculateProtein(), 2);
        fats = round(calculateFat(), 2);
        carbs = round(calculateCarbs(), 2);
        
    }
    
    
    private Float calculateKcal()
    {
        if ("Liters".equals(unit))
        {
            amount = amount * 1000;
        }
        Float tmpKcal = (amount / 100) * kcal;
        return tmpKcal;
    }
    
    private Float calculateProtein()
    {
       /* if ("Liters".equals(unit))
        {
            amount = amount * 1000;
        }*/
        Float tmpProtein = (amount / 100) * proteins;
        return tmpProtein;
    }
    
    private Float calculateFat()
    {
       /* if ("Liters".equals(unit))
        {
            amount = amount * 1000;
        }*/
        Float tmpFat = (amount / 100) * fats;
        return tmpFat;
    }
    
    private Float calculateCarbs()
    {
      /*  if ("Liters".equals(unit))
        {
            amount = amount * 1000;
        }*/
        Float tmpCarbs = (amount / 100) * carbs;
        return tmpCarbs;
    }
    
    private float round(float d, int decimalPlace) 
    {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public float getKcal()
    {
        return kcal;
    }
    
    public float getProteins()
    {
        return proteins;
    }
    
    public float getFats()
    {
        return fats;
    }
    
    public float getCarbs()
    {
        return carbs;
    }
    
    public String getName()
    {
        return name;
    }
}
