package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pl.mlethys.calorieCalc.model.CalculatedMeal;

/**
 * 
 * @author mlethys
 * @version
 */
public class TabPanel extends JPanel
{
    private MealsPanel mealsPanel;
    private SummaryPanel summaryPanel;
    private ArrayList<TabBody> meals;
    
    public TabPanel()
    {
        super();
        setLayout(new BorderLayout());
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        meals = new ArrayList<>();
        mealsPanel = new MealsPanel();
        add(mealsPanel, BorderLayout.NORTH);
        summaryPanel = new SummaryPanel();
        add(summaryPanel, BorderLayout.SOUTH);
    }
    
    public void addTabBody()
    {
        TabBody tabBody = new TabBody(this);
        mealsPanel.add(tabBody);
        meals.add(tabBody);
    }
    
    public ArrayList<TabBody> getMeals()
    {
        return meals;
    }
    
    
    public class MealsPanel extends JPanel
    {
        public MealsPanel()
        {
            super();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
        }
    }
    
    public class SummaryPanel extends JPanel
    {
        private JButton summaryButton;
        
        public SummaryPanel()
        {
            super();
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
            summaryButton = new JButton("Summary");
            summaryButton.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    float tmpKcal = 0;
                    float tmpCarbs = 0;
                    float tmpFats = 0;
                    float tmpProteins = 0;
                    
                    if(!meals.isEmpty())
                    {
                        for(TabBody meal : meals)
                        {
                            if(meal.getProductFrame() != null)
                            {
                                if(!meal
                                    .getProductFrame()
                                    .getProductPanel()
                                    .getProductsTabbedPane()
                                    .getSelectedProducts()
                                    .getProductsSelected()
                                    .isEmpty())
                                {
                                    CalculatedMeal readyMeal = new CalculatedMeal();
                                    readyMeal
                                        .setSummaryInfo(meal
                                                            .getProductFrame()
                                                            .getProductPanel()
                                                            .getProductsTabbedPane()
                                                            .getSelectedProducts()
                                                            .getProductsSelected());
                                    
                                    tmpKcal += readyMeal.getKcal();
                                    tmpProteins += readyMeal.getProteins();
                                    tmpFats += readyMeal.getFats();
                                    tmpCarbs += readyMeal.getCarbs();
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(summaryButton, "KCal: " + tmpKcal + "\n"
                                                    + "Proteins: " + tmpProteins + "\n"
                                                    + "Fats: " + tmpFats + "\n"
                                                    + "Carbs: " + tmpCarbs);
                }
            });
            
            add(summaryButton);
        }
    }
}
