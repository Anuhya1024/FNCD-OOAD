package WashingMethod;

import Enums.Cleanliness;
import Enums.Condition;
import RandomHelper.*;
import Staff.Staff;
import Vehicles.Vehicle;

public class ElbowGreaseWash extends WashingMethod{

    public void performWashing(Vehicle v, DumbString msg)
    {
        msg.string += "Washed using Elbow Grease washing\n";
        Cleanliness oldCleanliness = v.getCleanliness();
        Cleanliness newCleanliness;
        int n = RandomHelper.getRandomNumber(1,100);
        if(oldCleanliness == Cleanliness.dirty)
        {
            if(n<=70)
            {
                newCleanliness = Cleanliness.clean;
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
            }
            else if(n<=75)
            {
                newCleanliness = Cleanliness.sparkling;
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
            }
            else if(n<=85)
            {
                if( v.getCondition() !=Condition.veryNew)
                {
                    v.setCondition(Condition.veryNew);
                    msg.string += v.getVehicleName()+ "Condition changed to new from "+oldCleanliness+"\n";
                }
                else
                {
                    msg.string +="Nothing Changed";
                }
            }

        }
        else if(oldCleanliness == Cleanliness.clean)
        {
            if(n<=15)
            {
                newCleanliness= Cleanliness.dirty;
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
            }
            else if(n<=30)
            {
                newCleanliness= Cleanliness.sparkling;
                msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
            }
            else if(n<=40)
            {
                if(v.getCondition()!=Condition.veryNew){
                    msg.string += v.getVehicleName()+ "Condition changed to new from "+oldCleanliness+"\n";
                    v.setCondition(Condition.veryNew);
                }
                else
                {
                    msg.string +="Nothing Changed";
                }
                newCleanliness=oldCleanliness;
            }

        }
    }
}
