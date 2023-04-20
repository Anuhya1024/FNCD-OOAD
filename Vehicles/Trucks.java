package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class Trucks extends Vehicle{
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    private int loadCapacity;
    //    private Condition condition;
    public Trucks(double basePrice, Condition condition, int capacity)
    {
        super(basePrice, condition, VehicleTypes.trucks, "Trucks #"+counter);
        this.loadCapacity = capacity;
        setCondition(condition);
        counter++;
    }

    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        Trucks.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        Trucks.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        Trucks.repairBonus = repairBonus;
    }
    public void setCondition(Condition newCondition) {

        super.condition = newCondition;
    }
    public int getLoadCapacity()
    {
        return this.loadCapacity;
    }
}
