package pl.mlethys.calorieCalc.view.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import pl.mlethys.calorieCalc.model.DatabaseInfo;
import pl.mlethys.calorieCalc.model.SelectedProductsContainer;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductsTabbedPane extends JTabbedPane 
{
    private final String CATEGORIES_QUERY = "SELECT CATEGORY_NAME FROM KCAL.CATEGORIES";
    private SelectedProductsContainer selectedProducts;    
    public ProductsTabbedPane()
    {
        super();
        DatabaseInfo categories = new DatabaseInfo();
        selectedProducts = new SelectedProductsContainer();
        try
        {
            setTabs(categories.getInfo(CATEGORIES_QUERY));
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ProductsTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ProductsTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setTabs(ResultSet categoriesResultSet) throws SQLException
    {
        while(categoriesResultSet.next())
        {
            String name = categoriesResultSet.getString("CATEGORY_NAME");
            addTab(name, new ProductsTabBody(name, this));
        }
       
    }
    
    public SelectedProductsContainer getSelectedProducts()
    {
        return selectedProducts;
    }
}
