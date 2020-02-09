package cs134.miracosta.edu.ahernandez.model;

public class ShipItem {

    private int weightOfThePackage ;
    private double baseCost ;
    private double addedCost ;
    private double totalShippingCost ;

    public ShipItem()
    {
        weightOfThePackage = 0 ;
        baseCost = 3.00 ;
        addedCost = 0.00 ;
        totalShippingCost = 0.00 ;
    }

    public int getWeightOfThePackage()
    {
        return weightOfThePackage ;
    }
    public double getBaseCost()
    {
        return baseCost ;
    }
    public double getAddedCost()
    {
        return addedCost ;
    }
    public double getTotalShippingCost()
    {
        return totalShippingCost ;
    }
    public void setWeightOfThePackage(int weightOfThePackage)
    {
        this.weightOfThePackage = weightOfThePackage ;
        int numAddedCosts = (weightOfThePackage - 17) / 4 ;

        if(weightOfThePackage > 16)
        {
            addedCost = 0.50 ;
            addedCost += 0.50 * numAddedCosts ;
        }
        else
        {
            addedCost = 0.00 ;
        }

        totalShippingCost = baseCost + addedCost ;
    }
}
