package WashingMethod;

import Enums.Cleanliness;
import Enums.Condition;
import RandomHelper.RandomHelper;
import Staff.Staff;
import Vehicles.Vehicle;
import RandomHelper.*;


public class DetailedWash extends WashingMethod{

    public void performWashing(Vehicle v, DumbString msg)
    {
        msg.string += "Washed using detailed washing\n";
        Cleanliness oldCleanliness = v.getCleanliness();
        Cleanliness newCleanliness;
        int n = RandomHelper.getRandomNumber(1,100);
        if(oldCleanliness == Cleanliness.dirty)
        {
            if(n<=60)
            {
                newCleanliness= Cleanliness.clean;
            }
            else if(n<=80)
            {
                newCleanliness= Cleanliness.sparkling;
            }
            else
            {
                newCleanliness= Cleanliness.dirty;
            }
            msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
        }
        else if(oldCleanliness == Cleanliness.clean)
        {
            if(n<=5)
            {
                newCleanliness= Cleanliness.dirty;
            }
            else if(n<=45)
            {
                newCleanliness= Cleanliness.sparkling;
            }
            else
            {
                newCleanliness= Cleanliness.clean;
            }
            msg.string+= v.getVehicleName()+"'s cleanliness changed from "+ oldCleanliness + " to " + newCleanliness;
        }


    }

}
