package Staff;

import Enums.EmployeeTypes;
import RandomHelper.RandomHelper;
import Vehicles.Vehicle;

public class StaffFactory {
    public Staff createStaff(EmployeeTypes emp)
    {
        Staff s ;
        switch (emp)
        {
            case driver:
                s = new Driver();
                break;
            case intern:
                s = new Intern(RandomHelper.getWashingMethod());
                break;
            case mechanic:
                s = new Mechanic();
                break;
            case salesPerson:
                s = new SalesPerson();
                break;
            default:
                s = new SalesPerson();
                break;
        }
        return s;
    }

}
