package Staff;

import Enums.VehicleTypes;

public class Customer {
    private VehicleTypes vehicleType;
    private int chanceOfBuying;

    // Example for Encapsulation
    
    public Customer(VehicleTypes v, int chanceOfBuying)
    {
        this.vehicleType =v;
        this.chanceOfBuying = chanceOfBuying;
    }
    public int getchanceOfBuying()
    {
        return chanceOfBuying;
    }
    public VehicleTypes getVehicleType()
    {
        return vehicleType;
    }
}
