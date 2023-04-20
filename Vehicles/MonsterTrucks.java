package Vehicles;

import Enums.Condition;
import Enums.VehicleTypes;
import RandomHelper.RandomHelper;

public class MonsterTrucks extends Vehicle{
    private static int counter=1;
    private static int salesBonus;
    private static int washBonus;
    private static int repairBonus;
    public MonsterTrucks(double basePrice, Condition condition)
    {
        super(basePrice, condition, VehicleTypes.monsterTrucks, RandomHelper.getMonsterTruckName()+" "+ counter);
        counter++;
    }

    public static int getSalesBonus()
    {
        return salesBonus;
    }
    public static void setSalesBonus(int salesBonus)
    {
        MonsterTrucks.salesBonus = salesBonus;
    }
    public static int getWashBonus()
    {
        return washBonus;
    }
    public static void setWashBonus(int washBonus)
    {
        MonsterTrucks.washBonus = washBonus;
    }
    public static int getRepairBonus()
    {
        return repairBonus;
    }
    public static void setRepairBonus(int repairBonus)
    {
        MonsterTrucks.repairBonus = repairBonus;
    }

}
