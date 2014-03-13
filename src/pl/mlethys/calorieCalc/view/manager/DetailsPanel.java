package pl.mlethys.calorieCalc.view.manager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.CalculatedMeal;
import pl.mlethys.calorieCalc.model.CalculatedProduct;

/**
 * 
 * @author mlethys
 * @version
 */
public class DetailsPanel extends JPanel
{
   ArrayList<CalculatedProduct> products;
   private final int WIDTH = 600;
   private final int HEIGHT = 600;
   
   public DetailsPanel(ArrayList<CalculatedProduct> products)
   {
       super();
       setPreferredSize(new Dimension(WIDTH, HEIGHT));
       this.products = products;
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       add(new InfoPanel());
   }
   
  
   
   public class InfoPanel extends JPanel
   {
       
       private JLabel amountLabel;
       private JLabel nameLabel;
       private JLabel kcalLabel;
       private JLabel proteinLabel;
       private JLabel fatLabel;
       private JLabel carbLabel;
       public InfoPanel()
       {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.anchor = GridBagConstraints.WEST;
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(5, 5, 5, 5);
            
            nameLabel = new JLabel("Name:");
            add(nameLabel, c);
            c.gridx++;
            
            amountLabel = new JLabel("Amount:");
            add(amountLabel, c);
            c.gridx++;
            
            kcalLabel = new JLabel("Kcal:");
            add(kcalLabel, c);
            c.gridx++;
            
            proteinLabel = new JLabel("Proteins:");
            add(proteinLabel, c);
            c.gridx++;
            
            fatLabel = new JLabel("Fats:");
            add(fatLabel, c);
            c.gridx++;
            
            carbLabel = new JLabel("Carbs:");
            add(carbLabel, c);
            c.gridx++;
            
            c.gridx = 0;
            c.gridy++;
            System.out.println(c.gridy);
            setComponents(c, products);
       }
       
       private void setComponents(GridBagConstraints c, ArrayList<CalculatedProduct> products)
       {
           for(CalculatedProduct product : products)
           {
               add(new JLabel(product.getName()), c);
               c.gridx++;
               add(new JLabel(String.valueOf(product.getAmount())), c);
               c.gridx++;
               add(new JLabel(String.valueOf(product.getKcal())), c);
               c.gridx++;
               add(new JLabel(String.valueOf(product.getProteins())), c);
               c.gridx++;
               add(new JLabel(String.valueOf(product.getFats())), c);
               c.gridx++;
               add(new JLabel(String.valueOf(product.getCarbs())), c);
               c.gridx = 0;
               c.gridy++;
           }
       }
   }
}
