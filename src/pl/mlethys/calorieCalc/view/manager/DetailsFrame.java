package pl.mlethys.calorieCalc.view.manager;

import java.util.ArrayList;
import javax.swing.JFrame;
import pl.mlethys.calorieCalc.model.CalculatedProduct;

/**
 * 
 * @author mlethys
 * @version
 */
public class DetailsFrame extends JFrame
{
    private DetailsPanel panel;
            
    public DetailsFrame(ArrayList<CalculatedProduct> products)
    {
        super("Details");
        panel = new DetailsPanel(products);
        add(panel);
        pack();
        setLocationByPlatform(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public DetailsPanel getDetailsPanel()
    {
        return panel;
    }
}
