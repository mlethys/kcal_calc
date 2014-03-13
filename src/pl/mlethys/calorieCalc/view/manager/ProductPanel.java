package pl.mlethys.calorieCalc.view.manager;

import pl.mlethys.calorieCalc.view.manager.products.ProductsTabbedPane;
import pl.mlethys.calorieCalc.view.manager.products.ProductFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.CalculatedProduct;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductPanel extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 500;
    private ProductsTabbedPane productsTabbedPane;
    private JButton doneButton;
    private final ProductFrame PARENT;
   
    public ProductPanel(final ProductFrame PARENT)
    {
        super();
        this.PARENT = PARENT;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        productsTabbedPane = new ProductsTabbedPane();
        add(productsTabbedPane);
        
        doneButton = new JButton("Done!");
        doneButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {          
                if(productsTabbedPane.getSelectedProducts().getProductsSelected().size() > 0)
                {
                    addProducts();
                    PARENT.getTabBody().addDetailsButton(productsTabbedPane.getSelectedProducts().getProductsSelected());
                    PARENT.getTabBody().getGridBagConstraints().gridy++;
                    PARENT.getTabBody().getGridBagConstraints().gridx = 0;
                    PARENT.getTabBody().remove(PARENT.getTabBody().getAddButton());
                    PARENT.getTabBody().repaint();
                }
                PARENT.dispose();
            }
        });
        add(doneButton, BorderLayout.SOUTH);
    }
    
    public ProductsTabbedPane getProductsTabbedPane()
    {
        return productsTabbedPane;
    }
    
    public void addProducts()
    {
        int index = 0;
        for(CalculatedProduct product : productsTabbedPane.getSelectedProducts().getProductsSelected())
        {
            JLabel productLabel = new JLabel(product.getName());
            PARENT.getTabBody().getGridBagConstraints().gridx++;
            PARENT
                .getTabBody()
                .add(productLabel, PARENT.getTabBody().getGridBagConstraints());
            PARENT.getTabBody().getGridBagConstraints().gridx++;
            
            if(index != productsTabbedPane.getSelectedProducts().getProductsSelected().size() - 1)
            {
                PARENT
                    .getTabBody()
                    .add(new JLabel("+"), PARENT.getTabBody().getGridBagConstraints());
            }
            index++;
        }
    }
}
