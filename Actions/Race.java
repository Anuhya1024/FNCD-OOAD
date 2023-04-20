package Actions;

import Actions.PerformAction;

import Enums.Condition;
import RandomHelper.RandomHelper;
import Staff.*;
import Vehicles.Vehicle;
import RandomHelper.*;

public class Race extends PerformAction{
    public void work(Vehicle v, Staff s, DumbString msg) {
        Driver d = (Driver) s;
        int pos = d.getRacePosition();
        if(pos<=3)
        {
            v.setWinningCount(v.getWinningCount()+1);
            s.earnBonusDaily(s.getBonusEarnedDaily()+ RandomHelper.getRacingBonus());
        }
        if(pos > 15)
        {
            v.setCondition(Condition.broken);
            d.setInjuredStatus(RandomHelper.getInjuredStatus());
        }
        msg.string += (s.getName() + "Drove " + v.getVehicleName() + "And stood at position "+ pos + "Injured status of driver "+ d.getInjuredStatus())+"\n";
        System.out.println(msg.string);
        return;
    }


}