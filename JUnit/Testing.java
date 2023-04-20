package JUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import WashingMethod.*;
import Vehicles.Vehicle;
import Enums.Cleanliness;
import Enums.Condition;
import Enums.EmployeeTypes;
import Enums.VehicleTypes;
import RandomHelper.DumbString;
import Staff.*;


public class Testing {

// Tests for chemical Wash
    @Test
    public void testDirtyVehicleClean() {
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.dirty);
        ChemicalWash cw = new ChemicalWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.clean){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using chemical washing\nCar01's cleanliness changed from dirty to clean\n";
            assertEquals(msg1.string,msg.string );
        }
        
       
        
    }

    @Test
    public void testCleanVehicleDirty() {
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.clean);
        ChemicalWash cw = new ChemicalWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.dirty){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using chemical washing\nCar01's cleanliness changed from clean to dirty\n";
            assertEquals(msg1.string,msg.string );
        }


        
    }

    // Tests for ElbowGrease
    @Test
    public void testElbowGreaseDirtyVehicleClean() {
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.dirty);
        ElbowGreaseWash cw = new ElbowGreaseWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.clean){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using Elbow Grease washing\nCar01's cleanliness changed from dirty to clean\n";
            assertEquals(msg1.string,msg.string );
        }


        
    }

    @Test
    public void testElbowGreaseCleanVehicleDirty() {
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.clean);
        ElbowGreaseWash cw = new ElbowGreaseWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.dirty){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using Elbow Grease washing\nCar01's cleanliness changed from clean to dirty\n";
            assertEquals(msg1.string,msg.string );
        }
        
    }

    // Test for Detailed wash

    @Test
    public void testDetailedDirtyVehicleClean(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.dirty);
        DetailedWash cw = new DetailedWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.clean){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using detailed washing\nCar01's cleanliness changed from dirty to clean\n";
            assertEquals(msg1.string,msg.string );
        }


    }

    // Test for detailed wash
    @Test
    public void testDetailedCleanVehicleDirty(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.clean);
        DetailedWash cw = new DetailedWash();
        DumbString msg = new DumbString("");
        cw.performWashing(vehicle,msg);
        if(vehicle.getCleanliness() == Cleanliness.dirty){
            DumbString msg1 = new DumbString("");
            msg1.string += "Washed using detailed washing\nCar01's cleanliness changed from clean to dirty\n";
            assertEquals(msg1.string,msg.string );
        }
    }

    // Test method for setting cleanliness for vehicles.

    @Test
    public void testCleanliness(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setCleanliness(Cleanliness.clean);
        assertEquals(Cleanliness.clean, vehicle.getCleanliness());
    }

    // Testing winning count of vehicle
    @Test
    public void testWinningCount(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        vehicle.setWinningCount(2);
        assertEquals(2, vehicle.getWinningCount());

    }

    // Testing getVehicleName method
    @Test
    public void testVehicleName(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        
        assertEquals("Car01", vehicle.getVehicleName());

    }

    //Testing getName method of Staff
    @Test
    public void testStaffName(){
        Mechanic s = new Mechanic("Staff01");
        
        assertEquals("Staff01", s.getName());

    }

    //Testing dailySalaryRate method of Mechanic
    @Test
    public void testStaffSalary(){
        Mechanic s = new Mechanic("Staff01");
        assertEquals(75, s.getDailySalaryRate(),2);

    }

    //Testing staff type of Mechanic
    @Test
    public void testStaffType(){
        Mechanic s = new Mechanic("Staff01");
        assertEquals(EmployeeTypes.mechanic, s.getStaffType());

    }

    //Testing getVehicleType method of Vehicle
    @Test
    public void testVehicleType(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        
        assertEquals(VehicleTypes.cars, vehicle.getVehicleType());

    }

    //Testing getCondition method of Vehicle
    @Test
    public void testVehicleCondition(){
        Vehicle vehicle = new Vehicle(1000, Condition.used, VehicleTypes.cars, "Car01");
        
        assertEquals(Condition.used, vehicle.getCondition());

    }

   //Testing cost price of vehicle
   @Test
    public void testVehicleCostPrice(){
         Vehicle vehicle = new Vehicle(1000, Condition.veryNew, VehicleTypes.cars, "Car01");
         
         assertEquals(1000, vehicle.getCostPrice(),2);
    
    }



   
}
