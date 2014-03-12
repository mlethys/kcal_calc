package pl.mlethys.calorieCalc.view.manager;

import javax.swing.JFrame;

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
        pack();
        setResizable(false);
        setLocationByPlatform(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public TabBody getTabBody()
    {
        return tabBody;
    }
}
