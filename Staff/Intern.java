package Staff;

import Enums.Cleanliness;
import Enums.EmployeeTypes;
import Enums.VehicleTypes;
import Enums.WashTypes;
import RandomHelper.DumbString;
import RandomHelper.RandomHelper;
import Vehicles.*;
import WashingMethod.*;
import WashingMethod.WashingMethod;


//Example for Cohesion
public class Intern extends Staff {
    private static int idCounter = 1;
    

    private WashingMethod washingMethod;

    // Example for Identity
    String name = "Staff.Intern #" + idCounter++;

// Each Intern will be assigned a Washing Method when instantiated – Chemical, Elbow Grease, or Detailed
    public Intern( WashTypes washing ) {

        super("Staff.Intern #" + idCounter, 50.0, EmployeeTypes.intern);
        idCounter++;

        // Strategy pattern
        switch (washing) {
            case chemical:
                washingMethod = new ChemicalWash();
                break;
            case detailed:
                washingMethod = new DetailedWash();
                break;
            case elbowGrease:
                washingMethod = new ElbowGreaseWash();
                break;
            default:
                washingMethod = new ChemicalWash();
                break;
        }
       
    }
    //washing method is set in the constructor
    
    public WashingMethod getWashingMethod() {
        return this.washingMethod;
    }
    public void performActivity(Vehicle v, DumbString msg)
    {

        msg.string+=("WASHING:: " + v.getVehicleName() + " is assigned to " + this.getName()+"\n");
        WashTypes washTypes = RandomHelper.getWashingMethod();
        Cleanliness oldCleanliness = v.getCleanliness();
        washingMethod.performWashing(v, msg);
        double bonus = 0;
        Cleanliness newCondition = v.getCleanliness();
        if (newCondition == Cleanliness.sparkling) {
            VehicleTypes type = v.getVehicleType();

            if (type == VehicleTypes.cars) {
                bonus = Cars.getWashBonus();
            } else if (type == VehicleTypes.pickUpCars) {
                bonus = PickUpCars.getWashBonus();
            } else if (type == VehicleTypes.performanceCars) {
                bonus = PerformanceCars.getWashBonus();
            }else if(type == VehicleTypes.monsterTrucks)
            {
                bonus = PerformanceCars.getWashBonus();
            }else if(type == VehicleTypes.electricCars)
            {
                bonus = ElectricCars.getWashBonus();
            }
            else if(type == VehicleTypes.motorCycles)
            {
                bonus = MotorCycles.getWashBonus();
            }


            //todayExpense += bonus;
            //Added bonus to person salary and updated the days worked
        }
        if (oldCleanliness != newCondition) {
            super.earnBonusDaily(super.getBonusEarnedDaily() + bonus);
            msg.string+=this.getName()+" received a bonus of "+bonus+"\n";

        }
        System.out.println(msg.string);

    }

    

}
