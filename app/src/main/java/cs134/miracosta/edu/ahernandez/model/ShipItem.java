package cs134.miracosta.edu.ahernandez.model;
/**
 * The ShipItem class is used to calculate the price of shipping an item.
 * Alfredo Hernandez Jr
 * CS 134 - Project 01: Shipping Calculator
 */
public class ShipItem {

    // Instance variables used to hold the weight and price of shipping an item.
    private int weightOfThePackage ;
    private static final double BASE_COST = 3.00 ;
    private double addedCost ;
    private double totalShippingCost ;

    /**
     * Default Constructor
     * Creates a new ShipItem, no parameters.
     */
    public ShipItem()
    {
        weightOfThePackage = 0 ;
        addedCost = 0.00 ;
        totalShippingCost = 0.00 ;
    }

    /**
     * Gets the entered weight.
     * @return The weight of the package.
     */
    public int getWeightOfThePackage()
    {
        return weightOfThePackage ;
    }

    /**
     * Gets the base cost of shipping an item.
     * @return The base cost of shipping.
     */
    public double getBaseCost()
    {
        return BASE_COST ;
    }

    /**
     * Gets the added cost of shipping an item.
     * @return The added cost to ship an item.
     */
    public double getAddedCost()
    {
        return addedCost ;
    }

    /**
     * Gets the total shipping cost of an item.
     * @return The total shipping cost of an item.
     */
    public double getTotalShippingCost()
    {
        return totalShippingCost ;
    }

    /**
     * Sets the weight of the package and uses that data to set the rest of the parameters.
     * @param weightOfThePackage the new weight of the package.
     */
    public void setWeightOfThePackage(int weightOfThePackage)
    {
        // Sets the weight of the package.
        this.weightOfThePackage = weightOfThePackage ;

        // Records every additional 4 ounces after 16.
        int numAddedCosts = (weightOfThePackage - 17) / 4 ;

        // Increases the added cost every 4 ounces after 16.
        if(weightOfThePackage > 16)
        {
            addedCost = 0.50 ;
            addedCost += 0.50 * numAddedCosts ;
        }
        else
        {
            addedCost = 0.00 ;
        }

        // Calculates the final cost to ship the item.
        totalShippingCost = BASE_COST + addedCost ;
    }
}
