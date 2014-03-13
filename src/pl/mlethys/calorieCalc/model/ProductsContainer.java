package pl.mlethys.calorieCalc.model;

import java.util.ArrayList;

/**
 * 
 * @author mlethys
 * @version
 */
public class ProductsContainer 
{
    private ArrayList<CalculatedProduct> productsSelected;
    
    public ProductsContainer()
    {
        productsSelected = new ArrayList<>();
        
    }
    
    public ArrayList<CalculatedProduct> getProductsSelected()
    {
        return productsSelected;
    }
    
}
