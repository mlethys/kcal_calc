package pl.mlethys.calorieCalc.model;

import java.util.ArrayList;

/**
 * 
 * @author mlethys
 * @version
 */
public class SelectedProductsContainer 
{
    private ArrayList<CalculatedProduct> productsSelected;
    
    public SelectedProductsContainer()
    {
        productsSelected = new ArrayList<>();
        
    }
    
    public ArrayList<CalculatedProduct> getProductsSelected()
    {
        return productsSelected;
    }
    
}
