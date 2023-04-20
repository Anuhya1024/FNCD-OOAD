package Actions;

import Enums.Condition;
import Enums.VehicleTypes;
import Staff.*;
import Vehicles.*;
import RandomHelper.*;


public class Repair extends PerformAction {

    public void work(Vehicle v, Staff s,DumbString msg){
        msg.string += ("REPAIRING:: "+ v.getVehicleName() + " is assigned to " + s.getName()+"\n");
        System.out.println(msg.string);
        Condition olCondition = v.getCondition();
        Condition newCondition = RandomHelper.repair(v);
        if(newCondition == Condition.used)
        {
            v.updateSellingPrice(1.5);
        }
        if(newCondition == Condition.veryNew)
        {
            
            v.updateSellingPrice(1.25);
            
        }
        if(newCondition!= Condition.notChanged)
        {
            VehicleTypes type = v.getVehicleType();
            double bonus=0;
            if(type == VehicleTypes.cars)
            {
                bonus = Cars.getRepairBonus();
            }
            else if(type == VehicleTypes.pickUpCars)
            {
                bonus = PickUpCars.getRepairBonus();
            }
            else if(type == VehicleTypes.performanceCars)
            {
                bonus = PerformanceCars.getRepairBonus();
            }
            else if(type == VehicleTypes.monsterTrucks)
            {
                bonus = PerformanceCars.getRepairBonus();
            }
            else if(type == VehicleTypes.electricCars)
            {
                bonus = ElectricCars.getRepairBonus();
            }
            else if(type == VehicleTypes.motorCycles)
            {
                bonus = MotorCycles.getRepairBonus();
            }


            // todayExpense += bonus;
            // m.earnBonus(bonus);
            s.earnBonusDaily(s.getBonusEarnedDaily()+bonus);
            String text =("REPAIRING::" + s.getName() + " repaired " + olCondition +" "+v.getVehicleType()+ " and made it "+newCondition+  "(got bonus of $" + bonus+")"+"\n");
            System.out.println(text);
            msg.string +=text;
        }
        else
        {
            String text = ("REPAIRING:: " + s.getName() + " Was not succeeded in repairing "+ v.getVehicleName())+"\n";
            System.out.println(text);
            msg.string +=text;
        }
        return;
    }
    
}
