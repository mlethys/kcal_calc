package pl.mlethys.calorieCalc.view.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.DatabaseInfo;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductsTabBody extends JPanel implements ActionListener
{
    private String query;
    private final ProductsTabbedPane PARENT;
    
    public ProductsTabBody(String tabTitle, ProductsTabbedPane parent)
    {
        setLayout(new GridLayout(10, 10));
        PARENT = parent;
        
        query = "SELECT PRODUCT_NAME FROM PRODUCTS "
                + "INNER JOIN CATEGORIES ON "
                + "PRODUCTS.CATEGORY = CATEGORIES.CATEGORY_ID "
                + "WHERE KCAL.CATEGORIES.CATEGORY_NAME = "
                + "'" + tabTitle + "'";
        DatabaseInfo categories = new DatabaseInfo();
        
        try
        {
            setButtons(categories.getInfo(query));
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ProductsTabBody.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ProductsTabBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setButtons(ResultSet resultSet) throws SQLException
    {
        while(resultSet.next())
        {
            String buttonBody = "<html><p>" + resultSet.getString("PRODUCT_NAME") + "</p>";
            JButton button = new JButton(buttonBody);
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        PARENT
            .getSelectedProducts()
            .getProductsSelected()
            .add(e.getActionCommand().substring(9, e.getActionCommand().length() - 4));
    }
}
