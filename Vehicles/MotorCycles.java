package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;

public class MotorCycles extends Vehicle{
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;

    private int engineSize;
    public MotorCycles(double basePrice, Condition condition)
    {
        super(basePrice, condition, VehicleTypes.motorCycles, "MotorCycles #"+counter);
        counter++;
    }

    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        MotorCycles.salesBonus = salesBonus;
    }
    public void setEngineSize(int engineSize)
    {
        this.engineSize = engineSize;
    }
    public int getEngineSize()
    {
        return this.engineSize;
    }

    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        MotorCycles.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        MotorCycles.repairBonus = repairBonus;
    }
}
