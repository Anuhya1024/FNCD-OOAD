package FNCD;//import java.io.*;
import Enums.*;
import Observers.Logger;
import Observers.Observer;
import Observers.Publisher;
import Observers.Tracker;
import RandomHelper.*;
import Staff.*;
import Vehicles.*;

import java.util.*;
import java.util.stream.Collectors;



public class FNCD {
    private List<Staff> staff;
    private List<SalesPerson> salespeople;
    private List<Mechanic> mechanics;
    private List<Intern> interns;
    private List<Driver> drivers;
    private List<Staff> departedStaff;
    private List<Vehicle> vehicles;
    private VehicleFactory vehicleFactory;
    private StaffFactory staffFactory;
    private double budget;
    private double salesForTheDay = 0;
    private double todayExpense;
    private Publisher publisher;
    private Observer tracker;
    private Logger dailyLogger;
    private String name;
    private ArrayList<Double> vehicleSold;
    private ArrayList<Double> staffEarned;
    private ArrayList<Double> FNCDEarned;
    private Double staffEarnedDaily;
    double vehicleSoldDaily;



    private void getLoan() {
        budget = budget + 250000;
        System.out.println("*********** FNCD.FNCD took loan of $250000 **************");
        publisher.notifyObservers(ObserverActions.budget, "", budget);
    }


    public void incrementBudget(double cost) {
        budget = budget + cost;
    }

    private void updateBudget(double cost) {
        if (budget < cost) {
            getLoan();
        }
        budget = budget - cost;
    }

    public FNCD(String name) {
        this.salespeople = new ArrayList<>();
        this.mechanics = new ArrayList<>();
        this.interns = new ArrayList<>();
        // this.cars = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.departedStaff = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.budget = 500000;
        publisher = new Publisher();
        tracker = Tracker.getInstance();
        publisher.registerObserver(tracker);
        vehicleFactory = new VehicleFactory();
        staffFactory = new StaffFactory();
        dailyLogger = Logger.getInstance();
        vehicleSold = new ArrayList<Double>();
        staffEarned = new ArrayList<Double>();
        FNCDEarned = new ArrayList<Double>();
        staffEarnedDaily=0.0;
        vehicleSoldDaily=0;
        this.name = name;

    }
    public String getName()
    {
        return this.name;
    }
    public ArrayList<Double> getVehicleSold(){
        return vehicleSold;
    }
    public ArrayList<Double> getStaffEarned(){
        return staffEarned;
    }
    public ArrayList<Double> getFNCDEarned(){
        return FNCDEarned;
    }


    // Open subroutine
    public void open(int i) {
        dailyLogger.setFile("Logger/Logger-" + i + ".txt");
        publisher.registerObserver(dailyLogger);
        System.out.println("*********** FNCD.FNCD has $" + budget + " budget **************");
        salesForTheDay = 0;
        todayExpense = 0;
        // Current three salespeople
        while (salespeople.size() < 3) {

            SalesPerson salesperson = (SalesPerson) staffFactory.createStaff(EmployeeTypes.salesPerson);
            this.salespeople.add(salesperson);
            staff.add(salesperson);
            System.out.println("Hired SalesPerson for : "+name + salesperson.getName());
        }

        // Current three mechanics
        while (mechanics.size() < 3) {
            Mechanic mechanic = (Mechanic) staffFactory.createStaff(EmployeeTypes.mechanic);
            this.mechanics.add(mechanic);
            staff.add(mechanic);
            System.out.println("Hired Mechanics for : "+name + mechanic.getName());
        }

        // Current three interns
        while (interns.size() < 3) {
            Intern intern = (Intern) staffFactory.createStaff(EmployeeTypes.intern);
            this.interns.add(intern);
            staff.add(intern);
            System.out.println("Hired Intern for : " + name +intern.getName());
        }
        // Adding drivers
        while (drivers.size() < 3) {
            Driver driver = (Driver) staffFactory.createStaff(EmployeeTypes.driver);
            this.drivers.add(driver);
            staff.add(driver);
            System.out.println("Hired Driver for : "+name + driver.getName());
        }


        // Add four vehicles of each type
        List<Vehicle> cars = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.cars)
                .collect(Collectors.toList());
        int carSize = cars.size();
        while (carSize < 6) {
            Cars car = (Cars) vehicleFactory.createVehicle(VehicleTypes.cars);
            vehicles.add(car);
            // updateBudget(car.getCostPrice());
            todayExpense += car.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + car.getVehicleName() + "of condition " + car.getCondition() + " of cleanliness " + car.getCleanliness() + "  " + car.getVehicleType() + " for $" + car.getCostPrice() + " Cost");
            carSize++;
        }
        List<Vehicle> pickUpCars = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.pickUpCars)
                .collect(Collectors.toList());
        int pickUpCarsSize = pickUpCars.size();
        while (pickUpCarsSize < 6) {
            PickUpCars pickUpCar = (PickUpCars) vehicleFactory.createVehicle(VehicleTypes.pickUpCars);
            vehicles.add(pickUpCar);
            // updateBudget(pickUpCar.getCostPrice());
            todayExpense += pickUpCar.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + pickUpCar.getVehicleName() + "of condition " + pickUpCar.getCondition() + " of cleanliness " + pickUpCar.getCleanliness() + " " + pickUpCar.getVehicleType() + " for $" + pickUpCar.getCostPrice() + " Cost");
            pickUpCarsSize++;
        }
        List<Vehicle> performanceCars = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.performanceCars)
                .collect(Collectors.toList());
        int performanceCarsSize = performanceCars.size();
        while (performanceCarsSize < 6) {
            PerformanceCars performanceCar = (PerformanceCars) vehicleFactory.createVehicle(VehicleTypes.performanceCars);
            vehicles.add(performanceCar);
            todayExpense += performanceCar.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + performanceCar.getVehicleName() + "of condition " + performanceCar.getCondition() + " of cleanliness " + performanceCar.getCleanliness() + " " + performanceCar.getVehicleType() + " for $" + performanceCar.getCostPrice() + " Cost");
            performanceCarsSize++;
        }
        //electric Cars
        List<Vehicle> electricCars = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.electricCars)
                .collect(Collectors.toList());
        int electricCarSize = electricCars.size();
        while (electricCarSize < 6) {
            ElectricCars electricCar = (ElectricCars) vehicleFactory.createVehicle(VehicleTypes.electricCars);
            vehicles.add(electricCar);
            todayExpense += electricCar.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + electricCar.getVehicleName() + "of Range " + electricCar.getRange() + "of condition " + electricCar.getCondition() + " of cleanliness " + electricCar.getCleanliness() + " " + electricCar.getVehicleType() + " for $" + electricCar.getCostPrice() + " Cost");
            electricCarSize++;
        }
        // Monster trucks
        List<Vehicle> monsterTrucks = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.monsterTrucks)
                .collect(Collectors.toList());
        int monsterTruckSize = monsterTrucks.size();
        while (monsterTruckSize < 6) {
            MonsterTrucks monsterTruck = (MonsterTrucks) vehicleFactory.createVehicle(VehicleTypes.monsterTrucks);
            vehicles.add(monsterTruck);
            todayExpense += monsterTruck.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + monsterTruck.getVehicleName() + "of condition " + monsterTruck.getCondition() + " of cleanliness " + monsterTruck.getCleanliness() + " " + monsterTruck.getVehicleType() + " for $" + monsterTruck.getCostPrice() + " Cost");
            monsterTruckSize++;
        }
        // Motor Cycles
        List<Vehicle> motorCycles = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.motorCycles)
                .collect(Collectors.toList());
        int motorCyclesSize = motorCycles.size();
        while (motorCyclesSize < 6) {
            MotorCycles motorCycle = (MotorCycles) vehicleFactory.createVehicle(VehicleTypes.motorCycles);
            vehicles.add(motorCycle);
            todayExpense += motorCycle.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + motorCycle.getVehicleName() + "of engineVolume" + motorCycle.getEngineSize() + "of condition " + motorCycle.getCondition() + " of cleanliness " + motorCycle.getCleanliness() + " " + motorCycle.getVehicleType() + " for $" + motorCycle.getCostPrice() + " Cost");
            motorCyclesSize++;
        }
        // Bus
        List<Vehicle> busses = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.bus)
                .collect(Collectors.toList());
        int busSize = busses.size();
        while (busSize < 6) {
            Bus bus = (Bus) vehicleFactory.createVehicle(VehicleTypes.bus);
            vehicles.add(bus);
            todayExpense += bus.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + bus.getVehicleName() + "of Seat Capacity" + bus.getSeatCapacity() + "of condition " + bus.getCondition() + " of cleanliness " + bus.getCleanliness() + " " + bus.getVehicleType() + " for $" + bus.getCostPrice() + " Cost");
            busSize++;
        }

        // Electric Bikes
        List<Vehicle> electricBikes = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.electricBikes)
                .collect(Collectors.toList());
        int electricBikeSize = electricBikes.size();
        while (electricBikeSize < 6) {
            ElectricBikes eBike = (ElectricBikes) vehicleFactory.createVehicle(VehicleTypes.electricBikes);
            vehicles.add(eBike);
            todayExpense += eBike.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + eBike.getVehicleName() + "of range " + eBike.getRange() + "of condition " + eBike.getCondition() + " of cleanliness " + eBike.getCleanliness() + " " + eBike.getVehicleType() + " for $" + eBike.getCostPrice() + " Cost");
            electricBikeSize++;
        }

        // Trucks
        List<Vehicle> trucks = vehicles.stream()
                .filter(p -> p.getVehicleType() == VehicleTypes.trucks)
                .collect(Collectors.toList());
        int truckSize = trucks.size();
        while (truckSize < 6) {
            Trucks truck = (Trucks) vehicleFactory.createVehicle(VehicleTypes.trucks);
            vehicles.add(truck);
            todayExpense += truck.getCostPrice();
            System.out.print("Purchased for the location: "+ name);
            System.out.println("Purchased " + truck.getVehicleName() + "of Load Capacity " + truck.getLoadCapacity() + "of condition " + truck.getCondition() + " of cleanliness " + truck.getCleanliness() + " " + truck.getVehicleType() + " for $" + truck.getCostPrice() + " Cost");
            truckSize++;
        }
        staffEarnedDaily=0.0;
        vehicleSoldDaily=0;

    }

    // Close subroutine
    public void close(int day) {


        // At the end of the day, the FNCD.FNCD will pay all of its Staff.Staff members. The amount paid to each Staff.Staff member is based on their role and the number of vehicles they sold or repaired.
        for (Staff s1 : staff) {
            if (s1.getStaffType() == EmployeeTypes.salesPerson) {
                SalesPerson sp = (SalesPerson) s1;
                double salary = sp.getDailySalaryRate();
                double bonus = sp.getBonusEarnedDaily();
                sp.earnBonus(sp.getBonusEarned() + bonus);
                sp.earnBonusDaily(0);
                double total = salary + bonus;
                System.out.println("Gave Salary of " + total);
                // updateBudget(total);
                todayExpense += total;
                staffEarnedDaily+=total;
                String msg = "Staff.SalesPerson " + sp.getName() + " got salary of $" + salary + " and bonus of $" + bonus + "\n";
                msg = name+msg;
                System.out.println(msg);
                publisher.notifyObservers(ObserverActions.announcement, msg, 0);
            } else if (s1.getStaffType() == EmployeeTypes.mechanic) {
                Mechanic m = (Mechanic) s1;
                double salary = m.getDailySalaryRate();
                double bonus = m.getBonusEarnedDaily();
                m.earnBonus(m.getBonusEarned() + bonus);
                m.earnBonusDaily(0);
                double total = salary + bonus;
                System.out.println("Gave Salary of " + total);
                // updateBudget(total);
                todayExpense += total;
                staffEarnedDaily+=total;
                String msg = "Staff.Mechanic " + m.getName() + " got salary of $" + salary + " and bonus of $" + bonus + "\n";
                msg = name+msg;
                System.out.println(msg);
                publisher.notifyObservers(ObserverActions.announcement, msg, 0);
            } else if (s1.getStaffType() == EmployeeTypes.mechanic) {
                Intern i = (Intern) s1;
                double salary = i.getDailySalaryRate();
                double bonus = i.getBonusEarnedDaily();
                i.earnBonus(i.getBonusEarned() + bonus);
                i.earnBonusDaily(0);
                double total = salary + bonus;
                System.out.println("Gave Salary of " + total);

                // updateBudget(total);
                todayExpense += total;
                staffEarnedDaily +=total;
                String msg = "Staff.Intern " + i.getName() + " got salary of $" + salary + " and bonus of $" + bonus + "\n";
                msg = name+msg;
                System.out.println(msg);
                publisher.notifyObservers(ObserverActions.announcement, msg, 0);
            } else if (s1.getStaffType() == EmployeeTypes.driver) {
                Driver d1 = (Driver) s1;
                double salary = d1.getDailySalaryRate();
                double bonus = d1.getBonusEarnedDaily();
                d1.earnBonus(d1.getBonusEarned() + bonus);
                d1.earnBonusDaily(0);
                double total = salary + bonus;
                System.out.print("Gave Salary of " + total);
                todayExpense += total;
                staffEarnedDaily +=total;
                String msg = ("Driver " + d1.getName() + " got salary of $" + salary + " and bonus of $" + bonus + "\n");
                msg = name+msg;
                System.out.println(msg);
                publisher.notifyObservers(ObserverActions.announcement, msg, 0);
            }
        }
        // It’s possible at the end of every day one Staff.Mechanic, one Salesperson, and one Staff.Intern may quit the FNCD.FNCD. There is a 10% chance for each Staff.Staff type that one member may quit

        for (int i = 0; i < staff.size(); i++) {
            Staff s = staff.get(i);
            if (s.getStaffType() == EmployeeTypes.salesPerson) {

                if (RandomHelper.quit()) {
                    departedStaff.add(s);
                    staff.remove(s);
                    salespeople.remove(s);
                    //Promoting intern
                    if (!interns.isEmpty()) {
                        Intern newSalesPerson = interns.remove(0);
                        SalesPerson salesPerson = new SalesPerson(newSalesPerson.getName());
                        salespeople.add(salesPerson);
                        // departedStaff.add(newSalesPerson);
                    }
                } else if (s.getStaffType() == EmployeeTypes.mechanic) {
                    if (RandomHelper.quit()) {
                        departedStaff.add(s);
                        staff.remove(s);
                        mechanics.remove(s);
                        if (!interns.isEmpty()) {
                            Intern newMechanic = interns.remove(0);
                            Mechanic mechanic = new Mechanic(newMechanic.getName());
                            mechanics.add(mechanic);
                            // departedStaff.add(newMechanic);
                        }
                    }
                } else if (s.getStaffType() == EmployeeTypes.intern) {
                    if (RandomHelper.quit()) {
                        departedStaff.add(s);
                        staff.remove(s);
                        interns.remove(s);
                        System.out.println("Staff.Intern " + s.getName() + " quit the FNCD.FNCD");
                    }
                } else if (s.getStaffType() == EmployeeTypes.driver) {
                    Driver d2 = (Driver) s;
                    if (d2.getInjuredStatus()) {
                        departedStaff.add(s);
                        staff.remove(s);
                        drivers.remove(s);
                        System.out.println("Driver " + s.getName() + " got injured, so removing him from FNCD.FNCD");
                    }
                }


            }
        }
        updateBudget(todayExpense);
        publisher.notifyObservers(ObserverActions.announcement, "============= End of the day + " + day + " for the Location"+name+"=========", 0);
        publisher.notifyObservers(ObserverActions.staffMoney, "", todayExpense);
        publisher.notifyObservers(ObserverActions.FNCDMoney, "", salesForTheDay);
        publisher.notifyObservers(ObserverActions.announcement, "============= End of the day for the Location"+name+"=====================", 0);
        report();
        publisher.removeObserver(dailyLogger);
        staffEarned.add(staffEarnedDaily);
        FNCDEarned.add(salesForTheDay);
        vehicleSold.add(vehicleSoldDaily);
        vehicleSoldDaily=0;

    }


    public void washing() {
        List<Vehicle> dirtyVehicles =
                vehicles.stream().
                        filter(p -> p.getCleanliness() == Cleanliness.dirty)
                        .collect(Collectors.toList());

        List<Vehicle> cleanVehicles =
                vehicles.stream().
                        filter(p -> p.getCleanliness() == Cleanliness.clean)
                        .collect(Collectors.toList());


        int n = interns.size();
        int dirtyVehiclesSize = dirtyVehicles.size();
        int vehicleCount = 0;


        for (int i = 0; i < n; i++) {
            interns.get(i).setDaysWorked(interns.get(i).getDaysWorked() + 1);
            DumbString msg = new DumbString(name);
            if (vehicleCount < dirtyVehiclesSize) {

                interns.get(i).performActivity(dirtyVehicles.get(vehicleCount), msg);
                publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                vehicleCount++;
                if (vehicleCount < dirtyVehiclesSize) {
                    interns.get(i).performActivity(dirtyVehicles.get(vehicleCount), msg);
                    publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                } else if (vehicleCount - dirtyVehiclesSize < cleanVehicles.size()) {
                    interns.get(i).performActivity(cleanVehicles.get(vehicleCount - dirtyVehiclesSize), msg);
                    publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                }

                vehicleCount++;
            } else {
                if (vehicleCount - dirtyVehiclesSize < cleanVehicles.size()) {
                    interns.get(i).performActivity(cleanVehicles.get(vehicleCount - dirtyVehiclesSize), msg);
                    publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                    vehicleCount++;
                }
                if (vehicleCount - dirtyVehiclesSize < cleanVehicles.size()) {
                    interns.get(i).performActivity(cleanVehicles.get(vehicleCount - dirtyVehiclesSize), msg);
                    publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                    vehicleCount++;
                }

            }

        }

    }


    public void Repairs() {
        List<Vehicle> repairsNeeded =
                vehicles.stream().
                        filter(p -> p.getCondition() != Condition.veryNew)
                        .collect(Collectors.toList());
        int personsCount = 0;
        for (Mechanic m : mechanics) {
            m.setDaysWorked(m.getDaysWorked() + 1);
        }
        DumbString msg = new DumbString(name);
        for (int i = 0; i < repairsNeeded.size(); i += 2) {
            if (personsCount < mechanics.size()) {
                mechanics.get(personsCount).performActivity(repairsNeeded.get(i), msg);
                System.out.println(msg.string);
                publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                if (i + 1 < repairsNeeded.size()) {
                    mechanics.get(personsCount).performActivity(repairsNeeded.get(i + 1), msg);
                    System.out.println(msg.string);
                    publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
                } else {
                    break;
                }
                personsCount++;
            }

        }
    }


    // get Customer preferredCars
    public void getPreferredCars(Customer c) {
        List<Vehicle> vehicleList =
                vehicles.stream().
                        filter(p -> p.getVehicleType() == c.getVehicleType()).sorted(Comparator.comparing(a -> a.getSellingPrice()))
                        .collect(Collectors.toList());

        System.out.println("-------------------------- CUSTOMER PREFERRED INVENTORY --------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("%15s %20s %20s %20s %20s %20s", "VEHICLE NAME | ", "COST PRICE|", " SELLING PRICE |", "CONDITION |", "CLEANLINESS CONDITION |", "CURRENT STATUS");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        for (Vehicle v : vehicleList) {
            System.out.printf("%15s %20s %20s %20s %20s %20s", v.getVehicleName(), v.getCostPrice(), v.getSellingPrice(), v.getCondition(), v.getCleanliness(), " In Stock");
            // System.out.println(v.getVehicleName() + " " + v.getCostPrice() + " " + v.getSellingPrice() + " " + v.getCondition() + " " + v.getCleanliness() + " In Stock");
            System.out.println();
        }

    }

    // selling routine
    public void selling(List<Customer> customers) {
        System.out.println("Selling Called");
        for (SalesPerson s : salespeople) {
            s.setDaysWorked(s.getDaysWorked() + 1);
        }
        DumbString msg = new DumbString(name);
        for (Customer c : customers) {
            Random rand = new Random();
            SalesPerson salesPerson = salespeople.get(rand.nextInt(salespeople.size()));
            double sellingPrice = salesPerson.performActivity(vehicles, c, msg);
            if(sellingPrice >0)
            {
                vehicleSoldDaily++;
            }
            publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
            updateBudget(sellingPrice);
            salesForTheDay += sellingPrice;
        }

    }

    public SalesPerson changeSalesPerson(SalesPerson s) {
        SalesPerson salesPerson = s;
        Random rand = new Random();
        if (s == null) {
            return salespeople.get(rand.nextInt(salespeople.size()));
        }
        while (s.getName() == salesPerson.getName()) {
            salesPerson = salespeople.get(rand.nextInt(salespeople.size()));
        }
        return salesPerson;


    }

    public void sellingWithSalesPerson(Customer customer, SalesPerson salesPerson) {
        DumbString msg = new DumbString(name);
        double sellingPrice = salesPerson.performActivity(vehicles, customer, msg);
        publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
        updateBudget(sellingPrice);
        salesForTheDay += sellingPrice;
    }

    public void racing() {
        System.out.println("Racing called");
        VehicleTypes vtype = RandomHelper.getTodayRacingType();
        List<Vehicle> raceVehicles =
                vehicles.stream().
                        filter(q -> q.getVehicleType() == vtype).
                        filter(p -> p.getCondition() != Condition.broken)
                        .collect(Collectors.toList());
        int raceFromFNCD = Math.min(3, raceVehicles.size());
        Collections.shuffle(drivers);
        ArrayList<Integer> pos = RandomHelper.getRacePositions(raceFromFNCD);
        DumbString msg = new DumbString(name);
        for (int i = 0; i < raceFromFNCD; i++) {
            drivers.get(i).setRacePosition(pos.get(i));
            drivers.get(i).performActivity(raceVehicles.get(i), msg);
            publisher.notifyObservers(ObserverActions.announcement, msg.string, 0);
        }


    }


    public void initializeBonus() {
        Cars.setRepairBonus(30);
        Cars.setSalesBonus(50);
        Cars.setWashBonus(25);

        PickUpCars.setRepairBonus(40);
        PickUpCars.setSalesBonus(60);
        PickUpCars.setWashBonus(30);

        PerformanceCars.setRepairBonus(50);
        PerformanceCars.setSalesBonus(70);
        PerformanceCars.setWashBonus(35);

        MotorCycles.setRepairBonus(30);
        MotorCycles.setSalesBonus(40);
        MotorCycles.setWashBonus(20);

        MonsterTrucks.setRepairBonus(70);
        MonsterTrucks.setSalesBonus(100);
        MonsterTrucks.setWashBonus(60);

        ElectricCars.setRepairBonus(40);
        ElectricCars.setSalesBonus(80);
        ElectricCars.setWashBonus(20);

        Bus.setRepairBonus(60);
        Bus.setWashBonus(80);
        Bus.setSalesBonus(140);

        ElectricBikes.setRepairBonus(20);
        ElectricBikes.setSalesBonus(40);
        ElectricBikes.setWashBonus(10);

        Trucks.setRepairBonus(120);
        Trucks.setSalesBonus(140);
        Trucks.setWashBonus(110);



    }

    public void vehicleReport() {
        System.out.println("-------------------------- VEHICLES INVENTORY FOR THE LOCATION "+name+"--------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("%15s %20s %20s %20s %20s %20s", "VEHICLE NAME | ", "COST PRICE|", " SELLING PRICE |", "CONDITION |", "CLEANLINESS CONDITION |", "CURRENT STATUS");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        for (Vehicle v : vehicles) {
            System.out.printf("%15s %20s %20s %20s %20s %20s", v.getVehicleName(), v.getCostPrice(), v.getSellingPrice(), v.getCondition(), v.getCleanliness(), " In Stock");
            // System.out.println(v.getVehicleName() + " " + v.getCostPrice() + " " + v.getSellingPrice() + " " + v.getCondition() + " " + v.getCleanliness() + " In Stock");
            System.out.println();
        }
    }

    public void report() {
        System.out.println("--------------------------  STAFF LIST FOR THE LOCATION "+name+"-----------------------------------------------");
        System.out.println();
        System.out.printf("%15s %20s %10s %10s %10s", "EMPLOYEE NAME | ", "NO. DAYS WORKED |", "TOTAL SALARY |", "BONUS EARNED |", "CURRENT STATUS");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Staff s : staff) {
            System.out.printf("%15s %20s %10s %10s %10s", s.getName(), s.getDaysWorked(), (s.calculatePay() - s.getBonusEarned()), s.getBonusEarned(), " Working");
            System.out.println();
        }
        for (Staff s1 : departedStaff) {
            System.out.printf("%15s %20s %10s %10s %10s", s1.getName(), s1.getDaysWorked(), (s1.calculatePay() - s1.getBonusEarned()), s1.getBonusEarned(), " Quit");
            // System.out.println(s.getName() + " " + s.getDaysWorked() + " " + (s.calculatePay()-s.getBonusEarned()) + " " + s.getBonusEarned() + " Working" );
            System.out.println();
        }
        vehicleReport();

        System.out.println("Location: "+ name +" Total $ in operating budget : " + budget + " Total sales $ for day: " + salesForTheDay + "Total Cost of the day: " + todayExpense);


    }
}