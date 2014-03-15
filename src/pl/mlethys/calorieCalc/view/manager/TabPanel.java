package pl.mlethys.calorieCalc.view.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        TabBody tabBody = new TabBody();
        mealsPanel.add(tabBody);
        meals.add(tabBody);
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
                            if(meal.getDetailsFrame() != null)
                            {
                                System.out.println("chuju!");
                                tmpKcal += meal
                                            .getDetailsFrame()
                                            .getDetailsPanel()
                                            .getKcalData();
                                tmpCarbs += meal
                                            .getDetailsFrame()
                                            .getDetailsPanel()
                                            .getCarbsData();
                                tmpFats += meal
                                            .getDetailsFrame()
                                            .getDetailsPanel()
                                            .getFatsData();
                                tmpProteins += meal
                                            .getDetailsFrame()
                                            .getDetailsPanel()
                                            .getProteinsData();
                                
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
