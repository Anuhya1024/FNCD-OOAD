package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class ElectricCars extends Vehicle{
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    private int range;
//    private Condition condition;
    public ElectricCars(double basePrice, Condition condition, int range)
    {
        super(basePrice, condition, VehicleTypes.electricCars, "ElectricCars #"+counter);
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
        ElectricCars.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        ElectricCars.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        ElectricCars.repairBonus = repairBonus;
    }
    public void setCondition(Condition newCondition) {
        if(super.condition!= newCondition && newCondition == Condition.veryNew)
            this.range = this.range+100;

        super.condition = newCondition;
    }
    public int getRange()
    {
        return this.range;
    }
}
