package pl.mlethys.calorieCalc.model;

import java.util.ArrayList;

/**
 * 
 * @author mlethys
 * @version
 */
public class SelectedProductsContainer 
{
    private ArrayList<String> productsSelected;
    
    public SelectedProductsContainer()
    {
        productsSelected = new ArrayList<>();
        
    }
    
    public ArrayList<String> getProductsSelected()
    {
        return productsSelected;
    }
    
}
