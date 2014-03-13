package pl.mlethys.calorieCalc.model;

import java.util.ArrayList;
import pl.mlethys.calorieCalc.view.TabBody;

/**
 * 
 * @author mlethys
 * @version
 */
public class CalculatedMeal extends Calculated
{
    
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
        float tmpKcal = 0;
        float tmpProteins = 0;
        float tmpCarbs = 0;
        float tmpFats = 0;
        for(int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getMeal() == null)
            {
                return;
            }
            tmpKcal += products.get(i).getMeal().getKcal();
            tmpProteins += products.get(i).getMeal().getProteins();
            tmpCarbs += products.get(i).getMeal().getCarbs();
            tmpFats += products.get(i).getMeal().getFats();
        }
        
        kcal = round(tmpKcal, 2);
        proteins = round(tmpProteins, 2);
        carbs = round(tmpCarbs, 2);
        fats = round(tmpFats, 2);
       
    }
    
    public void setSummaryInfo(ArrayList<CalculatedProduct> products)
    {
        for(CalculatedProduct product : products)
        {
            kcal += product.getKcal();
            proteins += product.getProteins();
            fats += product.getFats();
            carbs += product.getCarbs();
        }
    }
}
