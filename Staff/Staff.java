package Staff;

import Enums.EmployeeTypes;
import Vehicles.Vehicle;
import Actions.*;
import RandomHelper.*;
import java.util.List;

public abstract class Staff {
    private String name;
    private double dailySalaryRate;
    private int daysWorked;
    private double salaryEarned;
    private double bonusEarnedDaily;
    private double bonusEarned;
    private EmployeeTypes staffType;
    public PerformAction performAction;

    public Staff(String name, double dailySalaryRate, EmployeeTypes staffType) {
        this.name = name;
        this.dailySalaryRate = dailySalaryRate;
        this.staffType = staffType;
        setPerformAction();
    }
    private void setPerformAction()
    {
        switch(staffType)
        {
            case driver:
                performAction = new Race();
                break;
            case mechanic:
                performAction = new Repair();
                break;
            case salesPerson:
                performAction = new Sell();
                break;
        }
    }
    public double getBonusEarnedDaily() {
        return bonusEarnedDaily;
    }
    public String getName() {
        return name;
    }

    public double getDailySalaryRate() {
        return dailySalaryRate;
    }

    public EmployeeTypes getStaffType() {
        return staffType;
    }

    public void setStaffType(EmployeeTypes StaffType) {
        this.staffType = StaffType;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public double getSalaryEarned() {
        return salaryEarned;
    }

    public double getBonusEarned() {
        return bonusEarned;
    }

    public double calculatePay() {
        double pay = daysWorked * dailySalaryRate;
        pay += bonusEarned;
        return pay;
    }

    public void work(int days) {
        daysWorked += days;
    }

    public void earnBonus(double amount) {
        bonusEarned = amount;
    }
    public void earnBonusDaily(double amount) {
        bonusEarnedDaily = amount;
    }
    public void performActivity(Vehicle vehicle, DumbString msg)
    {
        performAction.work(vehicle, this, msg);
    }
    public double performActivity(List<Vehicle> v, Customer c, DumbString msg)
    {
        return performAction.work(v, this, c,msg);
    }
}