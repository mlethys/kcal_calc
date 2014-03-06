package pl.mlethys.calorieCalc.model;

import java.util.ArrayList;
import pl.mlethys.calorieCalc.view.TabBody;

/**
 * 
 * @author mlethys
 * @version
 */
public class CalculatedMeal 
{
    private float kcal;
    private float proteins;
    private float carbs;
    private float fats;
    
    public CalculatedMeal()
    {
        kcal = 0;
        proteins = 0;
        carbs = 0;
        fats = 0;
    }
    
    public void calculateMeal(ArrayList<TabBody> products) throws NoProductsException
    {
        if (products.isEmpty())
        {
            throw new NoProductsException();
        }
        
        for(int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getMeal() == null)
            {
                return;
            }
            kcal += products.get(i).getMeal().getKcal();
            proteins += products.get(i).getMeal().getProteins();
            carbs += products.get(i).getMeal().getCarbs();
            fats += products.get(i).getMeal().getFats();
        }
       
    }
    
    public float getKcal()
    {
        return kcal;
    }
    
    public float getCarbs()
    {
        return carbs;
    }
    public float getFats()
    {
        return fats;
    }
    public float getProteins()
    {
        return proteins;
    }

}
