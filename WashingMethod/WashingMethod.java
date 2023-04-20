package WashingMethod;
import RandomHelper.DumbString;
import Vehicles.Vehicle;
import Staff.Staff;
import Staff.Intern;
import Enums.Cleanliness;
import Actions.Wash;

public abstract class WashingMethod {


    public abstract void performWashing(Vehicle v, DumbString s);
//    public static void washing(Vehicle v, Staff s){
//
//
//
//        // initilase the newCondition
//
//        Cleanliness newCondition = v.getCleanliness();
//        double bonus = 0;
//
//        //Redirecting to washing methods.
//        switch (i.getWashingMethod()) {
//            case "Chemical":
//
//                newCondition = ChemicalWash.doChemicalWash(v);
//                bonus = Wash.getBonus(v,i,newCondition);
//                System.out.println(i.getName() + " washed " + v.getVehicleName() + " using " + i.getWashingMethod() + " method and achieved " + newCondition + ". Earned bonus of $" + bonus);
//                break;
//            case "ElbowGrease":
//                newCondition = ElbowGreaseWash.doElbowGreaseWash(v);
//                bonus = Wash.getBonus(v,i,newCondition);
//                System.out.println(i.getName() + " washed " + v.getVehicleName() + " using " + i.getWashingMethod() + " method and achieved " + newCondition + ". Earned bonus of $" + bonus);
//                break;
//            case "Detailed":
//                newCondition = DetailedWash.doDetailedWash(v);
//                bonus = Wash.getBonus(v,i,newCondition);
//                System.out.println(i.getName() + " washed " + v.getVehicleName() + " using " + i.getWashingMethod() + " method and achieved " + newCondition + ". Earned bonus of $" + bonus);
//                break;
//        }
//
//
//       // System.out.println( s.getName() + " washed " + v.getCleanliness() + " and made it to "+newCondition+ "(got bonus of $" + bonus+")");
//        v.setCleanliness(newCondition);
//
//    }

    
}
