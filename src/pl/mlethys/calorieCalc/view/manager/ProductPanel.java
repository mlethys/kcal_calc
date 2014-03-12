package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
   
    public ProductPanel(final ProductFrame PARENT)
    {
        super();
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
                for(String product : productsTabbedPane.getSelectedProducts().getProductsSelected())
                {
                    JLabel productLabel = new JLabel(product);
                    PARENT.getTabBody().getGridBagConstraints().gridx++;
                    PARENT
                        .getTabBody()
                        .add(productLabel, PARENT.getTabBody().getGridBagConstraints());
                    PARENT.getTabBody().repaint();
                }
                PARENT.getTabBody().getGridBagConstraints().gridy++;
                PARENT.getTabBody().getGridBagConstraints().gridx = 0;
                PARENT.getTabBody().remove(PARENT.getTabBody().getAddButton());
                PARENT.getTabBody().repaint();
                PARENT.dispose();
            }
        });
        add(doneButton, BorderLayout.SOUTH);
    }
    
    public ProductsTabbedPane getProductsTabbedPane()
    {
        return productsTabbedPane;
    }
}
