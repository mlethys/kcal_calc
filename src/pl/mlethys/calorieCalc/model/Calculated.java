package pl.mlethys.calorieCalc.model;

import java.math.BigDecimal;

/**
 * 
 * @author mlethys
 * @version
 */
public abstract class Calculated 
{
    protected float kcal, proteins, fats, carbs;
    
    
    protected float round(float d, int decimalPlace) 
    {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public float getKcal()
    {
        return kcal;
    }
    
    public float getProteins()
    {
        return proteins;
    }
    
    public float getFats()
    {
        return fats;
    }
    
    public float getCarbs()
    {
        return carbs;
    }
}
