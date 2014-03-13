package pl.mlethys.calorieCalc.view.manager;

import java.awt.Container;
import java.awt.Dimension;
import pl.mlethys.calorieCalc.view.manager.products.ProductFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.CalculatedProduct;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabBody extends JPanel
{
    private JButton addButton;
    private JButton detailsButton;
    private JButton deleteButton;
    private GridBagConstraints c;
    private TabBody tabBody;
    
    public TabBody()
    {
        super();
        tabBody = this;
        setOpaque(false);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        
        addButton = new JButton("Add products");
        addButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ProductFrame productFrame = new ProductFrame(tabBody);
            }
        });
        add(addButton, c);
    }
    
    public GridBagConstraints getGridBagConstraints()
    {
        return c;
    }
    
    public JButton getAddButton()
    {
        return addButton;
    }
    
    public void addDetailsButton(final ArrayList<CalculatedProduct> products)
    {
        detailsButton = new JButton("Details");
        detailsButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DetailsFrame detailsFrame = new DetailsFrame(products);
            }
        });
        add(detailsButton, c);
    }
    
    public void addDeleteButton()
    {
        deleteButton = new JButton("x");
        deleteButton.setMargin(new Insets(0, 0, 0, 0));
        deleteButton.setPreferredSize(new Dimension(18, 18));
        deleteButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Container tmpParent = tabBody.getParent();
                tmpParent.remove(tabBody);
                tmpParent.repaint();
                
            }
        });
        add(deleteButton, c);
    }
}
