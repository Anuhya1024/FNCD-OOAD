package WashingMethod;

import Enums.Cleanliness;
import Enums.Condition;
import Staff.Staff;
import Vehicles.Vehicle;
import RandomHelper.*;

public class ChemicalWash extends WashingMethod{

    public void performWashing(Vehicle v, DumbString msg)
    {
        msg.string += "Washed using chemical washing\n";
        Cleanliness oldCleanliness = v.getCleanliness();
        Cleanliness newCleanliness;
        int n = RandomHelper.getRandomNumber(1, 100);
        if(oldCleanliness == Cleanliness.dirty)
        {
            if(n<=80)
            {
                newCleanliness= Cleanliness.clean;
                v.setCleanliness(newCleanliness);
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness+"\n";

            }
            else if(n<=90)
            {
                newCleanliness= Cleanliness.sparkling;
                v.setCleanliness(newCleanliness);
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness+"\n";

            }
            else if(n<=100)
            {
                if(v.getCondition()!=Condition.broken){
                    v.setCondition(Condition.broken);
                    msg.string +=v.getVehicleName()+" condition is broken now"+"\n";
                }
            }
        }
        else if(oldCleanliness == Cleanliness.clean)
        {
            if(n<=10)
            {
                newCleanliness= Cleanliness.dirty;
                v.setCleanliness(newCleanliness);
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness+"\n";

            }
            else if(n<=30)
            {
                newCleanliness= Cleanliness.sparkling;
                v.setCleanliness(newCleanliness);
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness+"\n";

            }
            else if(n<=40)
            {
                if(v.getCondition()!=Condition.broken){
                    v.setCondition(Condition.broken);
                    msg.string +=v.getVehicleName()+" condition is broken now"+"\n";
                }
            }

        }

    }

}
