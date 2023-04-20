package Vehicles;

import Enums.VehicleTypes;
import RandomHelper.RandomHelper;
// This is the Vehicle factory class for the factory pattern.
public class VehicleFactory {
    public Vehicle createVehicle(VehicleTypes vehicle)
    {
        Vehicle v;
        switch (vehicle)
        {
            case cars:
                v = new Cars(RandomHelper.setBasePriceForCars(),RandomHelper.setCondition() );
                return v;
            case electricCars:
                v = new ElectricCars(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition(),RandomHelper.setRange());
                return v;

            case monsterTrucks:
                v = new MonsterTrucks(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition());
                return v;

            case performanceCars:
                v = new PerformanceCars(RandomHelper.setBasePriceForPerformanceCars(),RandomHelper.setCondition());
                return v;

            case motorCycles:
                v = new MotorCycles(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition());
                return v;

            case pickUpCars:
                v = new PickUpCars(RandomHelper.setBasePriceForPickUpCars(),RandomHelper.setCondition() );
                return v;
            case bus:
                v = new Bus(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition(),RandomHelper.setSeatCapacity());
                return v;
            case electricBikes:
                v = new ElectricBikes(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition(),RandomHelper.setRange());
                return v;

            case trucks:
                v = new Trucks(RandomHelper.setBasePriceForCars(), RandomHelper.setCondition(),RandomHelper.setLoadCapacity());
                return v;

            default:
                v = new Vehicle(RandomHelper.setBasePriceForPickUpCars(),RandomHelper.setCondition(),VehicleTypes.bus,"Default Vehicle" );
                return v;
        }
    }
}
