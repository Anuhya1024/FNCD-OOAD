package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class ElectricBikes extends Vehicle{
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    private int range;
    //    private Condition condition;
    public ElectricBikes(double basePrice, Condition condition, int range)
    {
        super(basePrice, condition, VehicleTypes.bus, "Electric Bikes #"+counter);
        this.range = range;
        setCondition(condition);
        counter++;
    }

    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        ElectricBikes.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        ElectricBikes.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        ElectricBikes.repairBonus = repairBonus;
    }
    public void setCondition(Condition newCondition) {

        super.condition = newCondition;
    }
    public int getRange()
    {
        return this.range;
    }
}
