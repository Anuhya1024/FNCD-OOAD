package Actions;

import Enums.Cleanliness;
import Enums.Condition;
import Staff.*;
import RandomHelper.*;
import Vehicles.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import TopUps.*;

public class Sell extends PerformAction {

    public void work(Vehicle v, Staff s, DumbString msg){return;};
    public double work(List<Vehicle> vehicles, Staff salesPerson, Customer c, DumbString msg ){
        msg.string += ("SELLING:: Staff.Customer preference "+ c.getVehicleType() + "; assigned to "+ salesPerson.getName()+"\n");
        List<Vehicle> vehicleList = 
            vehicles.stream().
            filter(p -> p.getVehicleType() == c.getVehicleType()).sorted(Comparator.comparing(a -> a.getSellingPrice()))
            .collect(Collectors.toList());
        int percentage=0;
        Vehicle v;
        percentage += c.getchanceOfBuying();
        if(vehicleList.size() > 0)
        {
            
            v = vehicleList.get(0);
            if(v.getCleanliness() == Cleanliness.sparkling)
            {
                percentage+=10;
            } 
            if(v.getCondition() == Condition.veryNew)
            {
                percentage+=10;
            }
            
        }
        else
        {
            
            List<Vehicle> vehicleListNew = 
            vehicles.stream().
            filter(p -> p.getVehicleType() != c.getVehicleType()).sorted(Comparator.comparing(a -> a.getSellingPrice()))
            .collect(Collectors.toList());
            percentage +=c.getchanceOfBuying()-20;
            v = vehicleListNew.get(0);
            msg.string +=("SELLING:: Staff.Customer preferred car is not in inventory, Hence showing him the car type" + v.getVehicleType()+"\n");
        }
        Boolean sold = RandomHelper.sell(percentage);
        System.out.println("Chance of Buying is "+ percentage);
        double sellingPrice=0;
        if(sold)
        {
            
            vehicles.remove(v);
            double sellingBonus=0;
            switch(v.getVehicleType())
            {
                case cars: sellingBonus = Cars.getSalesBonus();
                            break;
                case pickUpCars: sellingBonus = PickUpCars.getSalesBonus();
                            break;
                case performanceCars: sellingBonus = PerformanceCars.getSalesBonus();
                            break;
                case electricCars: sellingBonus = ElectricCars.getSalesBonus();
                    break;
                case monsterTrucks: sellingBonus = MonsterTrucks.getSalesBonus();
                    break;
                case motorCycles: sellingBonus = MotorCycles.getSalesBonus();
                break;

            }
            AddTopUps t = new AddTopUps();
            t = new ExtendedWarranty(t);
            t = new UnderCoating(t);
            t = new RoadRescueCoverage(t);
            t = new SatelliteRadio(t);
            v.setTopUps(t);
            msg.string+=v.getVehicleDescription();
            msg.string +=("SELLING::" +salesPerson.getName()+" sold the car of selling price "+ v.getSellingPrice()+ "(Received Bonus ="+ sellingBonus + ")\n" );
            // salesPerson.earnBonus(salesPerson.getBonusEarned()+sellingBonus);
            salesPerson.earnBonusDaily(salesPerson.getBonusEarnedDaily()+sellingBonus);
            sellingPrice= v.getSellingPrice();
        }
        else
        {
            msg.string +=("SELLING:: "+ salesPerson.getName()+" was not able to sell the car \n");
        }
        System.out.println(msg.string);
        return sellingPrice;

    };
    
}
