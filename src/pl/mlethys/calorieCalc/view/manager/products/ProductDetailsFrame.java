package pl.mlethys.calorieCalc.view.manager.products;

import java.util.ArrayList;
import javax.swing.JFrame;
import pl.mlethys.calorieCalc.model.CalculatedProduct;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductDetailsFrame extends JFrame
{
    private ProductDetailsPanel productDetailsPanel;
    private String windowName;
    
    public ProductDetailsFrame(String windowName, ArrayList<CalculatedProduct> products)
    {
        super(windowName);
        this.windowName = windowName;
        productDetailsPanel = new ProductDetailsPanel(this, products);
        add(productDetailsPanel);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }
    
    public String getWindowName()
    {
        return windowName;
    }

}
