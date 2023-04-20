package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class PerformanceCars extends Vehicle {

    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    public PerformanceCars(double basePrice, Condition condition)
    {
        super(basePrice, condition, VehicleTypes.performanceCars,"PerformanceCar #"+counter);
        counter++;
    }
    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        PerformanceCars.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        PerformanceCars.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        PerformanceCars.repairBonus = repairBonus;
    }

    
}
