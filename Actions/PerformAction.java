package Actions;

import Staff.*;
import Vehicles.Vehicle;

import java.util.List;
import RandomHelper.*;

public abstract class PerformAction {
    private Vehicle vehicle;

    private Staff s;
    public Vehicle getVehicle()
    {
        return vehicle;
    }
    public Staff getStaff()
    {
        return s;
    }

    public abstract void work(Vehicle v, Staff s, DumbString msg);
    public double work(List<Vehicle> vehicleList, Staff s, Customer c, DumbString msg){ return 0;};
  

}
