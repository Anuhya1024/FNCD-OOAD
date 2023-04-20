package TopUps;

import RandomHelper.RandomHelper;
import Vehicles.Vehicle;

public class UnderCoating extends AddTopUps{
    AddTopUps v;
    Boolean bool;

    public String getDescription()
    {
        if(bool)
            return v.getDescription()+"Added UnderCoating ";
        return v.getDescription();
    }
    public int getPercentage()
    {
        if(bool)
            return v.getPercentage()+5;
        return v.getPercentage();
    }
    public UnderCoating(AddTopUps v)
    {
        this.v = v;
//        updateSellingPrice(this.v);
        bool =RandomHelper.isUnderCoating();

    }
}
