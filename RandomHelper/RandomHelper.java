package RandomHelper;

import Enums.Cleanliness;
import Enums.Condition;
import Vehicles.Vehicle;
import Enums.VehicleTypes;
import Staff.Customer;
import Enums.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//import javax.lang.model.util.ElementScanner6;

public class RandomHelper {

    //check possibility at the end of every day one Staff.Mechanic, one Salesperson, and one Staff.Intern may quit the FNCD.FNCD. There is a 10% chance for each Staff.Staff type that one member may quit
    public static boolean quit() {
        int n = getRandomNumber(1, 100);
        if (n <= 10) {
            return true;
        }
        return false;
    }

    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    static public double setBasePriceForCars()
    {
        return getRandomNumber(10000, 20000);
    }
    static public double setBasePriceForPickUpCars()
    {
        return getRandomNumber(10000, 40000);
    }
    static public double setBasePriceForPerformanceCars()
    {
        return getRandomNumber(20000, 40000);
    }
    static public Condition setCondition()
    {
        int n = getRandomNumber(0, 2);
        return Condition.values()[n];

    }
    public static Condition updateCondition(Condition condition)
    {
        switch(condition)
        {
            case broken: return Condition.used;
            case used : return Condition.veryNew;
            default: return Condition.veryNew;
        }
    }
    public static Cleanliness degradeCleanliness(Cleanliness cleanliness)
    {
       
        switch(cleanliness)
        {
            case sparkling: return Cleanliness.clean;
            case clean: return Cleanliness.dirty;
            default: return Cleanliness.dirty;

        }
    }
    public static Condition repair(Vehicle v)
    {
        int n = getRandomNumber(1, 100);
        if( n<=80)
        {
            Condition newCondition = RandomHelper.updateCondition(v.getCondition());
            
            v.setCondition(newCondition);
            v.setCleanliness(RandomHelper.degradeCleanliness(v.getCleanliness()));
            return newCondition;
        }
        else
        {
            return Condition.notChanged;
        }
        

    }
    static public Cleanliness getCleanliness()
    {
        int n = getRandomNumber(1, 100);
        if(n <= 5)
        {
            return Cleanliness.sparkling;
        }
        else if( n<=40)
        {
            return Cleanliness.clean;
        }
        else
        {
            return Cleanliness.dirty;
        }
    }
    static public Boolean sell(int percentage)
    {
        int n = getRandomNumber(1, 100);
        if(n<=percentage)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

//    static public
    static public List<Customer> createCustomers(Days d)
    {
        List<Customer> customers = new ArrayList<Customer>(); 
        int n;
        if(d == Days.FRI || d == Days.SAT)
        {
            n = getRandomNumber(2, 8);
        }
        else
        {
            n =getRandomNumber(0, 5);
        }
        for(int i=0;i<n;i++)
        {
            int chanceOfBuying;
            chanceOfBuying = getRandomNumber(0, 2);
            int[] chance = new int[] {10,40,70};
            int l = getRandomNumber(0, 2);
            Customer c = new Customer(VehicleTypes.values()[l], chance[chanceOfBuying]);

            customers.add(c);
        }
        return customers;
    }
    // Generating the Monster truck name in random.
    public static String getMonsterTruckName()
    {
        String trucks[]={"Air Force Afterburner","Avenger","Bad News Travels Fast","Batman","Backwards Bob","Bear Foot (1979)","Bear Foot (F-150)","Bear Foot (2xtreme)","Bear Foot (Silverado)","Bear Foot USA","Bigfoot","Black Stallion","Blacksmith","Blue Thunder","Bounty Hunter","Brutus","Bulldozer","Captain's Curse","Cyborg","El Toro Loco","Grave Digger","Grinder","Gunslinger","Jurassic Attack","King Krunch","Lucas Oil Crusader","Madusa","Maximum Destruction (Max-D)","Mohawk Warrior","Monster Mutt","Monster Mutt Dalmatian","Predator","Shell Camino","Raminator","Snake Bite","Stone Crusher","Sudden Impact","Swamp Thing","The Destroyer","The Felon","USA-1","War Wizard","WCW Nitro Machine","Zombie"};
        int n = getRandomNumber(0,trucks.length-1);
        return trucks[n];
    }
    // Generating a washing method – Chemical, Elbow Grease, or Detailed in random.
    public static WashTypes getWashingMethod()
    {
        int n = getRandomNumber(0,WashTypes.values().length-1);
        return WashTypes.values()[n];
    }
    // setting the range for electric cars
    public static int setRange()
    {
        return getRandomNumber(60,400);
    }
    public static VehicleTypes getTodayRacingType()
    {
        return VehicleTypes.values()[getRandomNumber(2,VehicleTypes.values().length-1)];
    }

    public static ArrayList<Integer> getRacePositions(int n)
    {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        Collections.shuffle(temp);
        for(int i=0;i<n;i++)
        {
            pos.add(temp.get(i));
        }
        return pos;

    }
    public static int setSeatCapacity()
    {
        return getRandomNumber(0,250);
    }

    public static int setLoadCapacity()
    {
        return getRandomNumber(0,300);
    }
    public static int getRacingBonus()
    {
        return 150;
    }
    public static Boolean getInjuredStatus()
    {
        int n = getRandomNumber(1,100);
        if(n<=30)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean isExtendedWarranty() {
        int n = getRandomNumber(1,100);
        if(n<=25)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public static Boolean isRoadRescueCoverage()
    {
        int n = getRandomNumber(1,100);
        if(n<=5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean isUnderCoating()
    {
        int n= getRandomNumber(1,100);
        if(n<=10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean isSatelliteRadio()
    {
        int n = getRandomNumber(1,100);
        if(n<=40)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
