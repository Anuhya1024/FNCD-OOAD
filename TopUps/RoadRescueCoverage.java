package TopUps;

import RandomHelper.RandomHelper;
import Vehicles.Vehicle;

public class RoadRescueCoverage extends AddTopUps{
    AddTopUps v;
    Boolean bool;

    public String getDescription()
    {
        if(bool)
            return v.getDescription()+"Added Road Rescue Coverage ";
        return v.getDescription();
    }
    public int getPercentage()
    {
        if(bool)
            return v.getPercentage()+2;
        return v.getPercentage();
    }
    public RoadRescueCoverage(AddTopUps v)
    {
        this.v = v;
//        updateSellingPrice(this.v);
        bool =RandomHelper.isRoadRescueCoverage();

    }
}
