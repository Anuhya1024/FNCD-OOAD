package TopUps;
import Vehicles.*;
import RandomHelper.*;
// it acts as an abstract class for all the topUps.
//Every top up option should extend this class.

//Decorator Pattern
public  class AddTopUps {
    private int percentage;
    private String description;
    public int getPercentage()
    {
        return percentage;
    }
    public String getDescription()
    {
        return description;
    }
    public void updateSellingPrice(Vehicle v){};
    public AddTopUps()
    {
        percentage=0;
        description="";
    }

}
