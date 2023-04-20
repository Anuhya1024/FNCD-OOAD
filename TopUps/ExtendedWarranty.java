package TopUps;

import RandomHelper.RandomHelper;
import Vehicles.*;

public class ExtendedWarranty extends AddTopUps{
    AddTopUps v;
    Boolean bool;

    public String getDescription()
    {
        if(bool)
            return v.getDescription()+"Added Extended Warranty ";
        else
        {
            return v.getDescription();
        }
    }
    public int getPercentage()
    {
        if(bool)
            return v.getPercentage()+20;
        return v.getPercentage();

    }
    public ExtendedWarranty(AddTopUps v)
    {
        this.v = v;
         bool =RandomHelper.isExtendedWarranty();
    }

}
