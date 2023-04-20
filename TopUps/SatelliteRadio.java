package TopUps;

import RandomHelper.RandomHelper;
import Vehicles.Vehicle;

public class SatelliteRadio extends AddTopUps {
    AddTopUps v;
    Boolean bool;

    public String getDescription()
    {
        if(bool)
            return v.getDescription()+"Added Satellite Radio ";
        return v.getDescription();
    }
    public int getPercentage()
    {
        if(bool)
            return v.getPercentage()+5;
        return v.getPercentage();
    }
    public SatelliteRadio(AddTopUps v)
    {
        this.v = v;
//        updateSellingPrice(this.v);
        bool =RandomHelper.isSatelliteRadio();

    }
}
