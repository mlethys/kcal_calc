package pl.mlethys.calorieCalc.view.manager;

import javax.swing.JFrame;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductFrame extends JFrame
{
    public ProductFrame()
    {
        super("Products");
        ProductPanel productPanel = new ProductPanel(this);
        add(productPanel);
        pack();
        setResizable(false);
        setLocationByPlatform(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
