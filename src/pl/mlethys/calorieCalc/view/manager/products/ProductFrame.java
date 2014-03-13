package pl.mlethys.calorieCalc.view.manager.products;

import javax.swing.JFrame;
import pl.mlethys.calorieCalc.view.manager.ProductPanel;
import pl.mlethys.calorieCalc.view.manager.TabBody;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductFrame extends JFrame
{
    private ProductPanel productPanel;
    private TabBody tabBody;

    public ProductFrame(TabBody tabBody)
    {
        super("Products");
        this.tabBody = tabBody;
        productPanel = new ProductPanel(this);
        add(productPanel);
        setUndecorated(true);
        pack();
        setResizable(false);
        setLocationByPlatform(true);      
        setVisible(true);
    }
    
    public TabBody getTabBody()
    {
        return tabBody;
    }
}
