package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class PickUpCars extends Vehicle {
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    public PickUpCars(double basePrice, Condition condition)
    {
        super(basePrice, condition, VehicleTypes.pickUpCars, "PickUpCars"+counter);
        counter++;
    }
    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        PickUpCars.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        PickUpCars.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        PickUpCars.repairBonus = repairBonus;
    }
    
}
