package Staff;

import Enums.EmployeeTypes;

// Example for Inheritance
public class Mechanic extends Staff {
    private static int idCounter = 1;

    // Example for Polymorphism
    public Mechanic() {
        super("Staff.Mechanic #" + idCounter, 75.0, EmployeeTypes.mechanic);
        idCounter=idCounter+1;
    }
    public Mechanic(String name) {
        super(name, 75.0, EmployeeTypes.mechanic);
    }
}
