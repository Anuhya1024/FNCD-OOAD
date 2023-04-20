package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class Cars extends Vehicle {

    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    public Cars(double basePrice, Condition condition)
    {
        super(basePrice, condition, VehicleTypes.cars, "Cars #"+counter);
        counter++;
    }
    
    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        Cars.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        Cars.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        Cars.repairBonus = repairBonus;
    }
    
}
