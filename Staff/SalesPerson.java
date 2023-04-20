package Staff;

import Enums.EmployeeTypes;

public class SalesPerson extends Staff {
    private static int idCounter = 1;

    public SalesPerson() {
        super("Salesperson #" + idCounter, 100.0, EmployeeTypes.salesPerson);
        idCounter=idCounter+1;
    }
    public SalesPerson(String name) {
        super(name, 100.0, EmployeeTypes.salesPerson);
    }
}
