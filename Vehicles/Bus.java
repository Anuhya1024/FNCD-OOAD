package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class Bus extends Vehicle {
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    private int seatCapacity;
    //    private Condition condition;
    public Bus(double basePrice, Condition condition, int capacity)
    {
        super(basePrice, condition, VehicleTypes.bus, "Bus #"+counter);
        this.seatCapacity = capacity;
        setCondition(condition);
        counter++;
    }

    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        Bus.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        Bus.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        Bus.repairBonus = repairBonus;
    }
    public void setCondition(Condition newCondition) {

        super.condition = newCondition;
    }
    public int getSeatCapacity()
    {
        return this.seatCapacity;
    }
}
