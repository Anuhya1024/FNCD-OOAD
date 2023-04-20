package Vehicles;

import Enums.Cleanliness;
import Enums.Condition;
import Enums.VehicleTypes;
import RandomHelper.*;
import Staff.*;
import TopUps.*;

public class Vehicle {


    private double sellingPrice;
    private double costPrice;
    private double basePrice;
    protected Condition condition;
    private Cleanliness cleanliness;
    private VehicleTypes vehicleType;
    private String vehicleName;
    private int winningCount;
    private int topUpPercentage;

    private String vehicleDescription;
    public VehicleTypes getVehicleType()
    {
        return vehicleType;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition newCondition) {
        condition = newCondition;
    }

    SalesPerson salesPerson;
    public Vehicle(double basePrice, Condition condition, VehicleTypes VehicleType, String vehicleName)
    {
        this.basePrice = basePrice;
        this.condition = condition;
        calculateCostPrice(condition);
        sellingPrice = costPrice * 2.0;
        cleanliness = RandomHelper.getCleanliness();
        this.vehicleType = VehicleType;
        this.vehicleName = vehicleName;
        this.vehicleDescription = vehicleName+" ";
        this.topUpPercentage =100;

    }
    public String getVehicleName()
    {
        return vehicleName;
    }

    private void calculateCostPrice(Condition condition)
    {
        switch(condition)
        {
            case used:
                        costPrice = basePrice* 0.8;
                        break;

            case broken:
                        costPrice = basePrice* 0.5;
                        break;

            case veryNew:
                        costPrice = basePrice;
                        break;

            default:
                        costPrice = basePrice;
            return;


        }
    }
    public double getCostPrice()
    {
        return costPrice;
    }

    public double getSellingPrice()
    {
        if(winningCount > 1)
             topUpPercentage+= 10;
//        System.out.println("========Selling price+++++"+sellingPrice);
        return (this.sellingPrice*topUpPercentage/100);

    }
    public void addPercentage(int p)
    {
        this.topUpPercentage += p;
    }
    public Cleanliness getCleanliness()
    {
        return cleanliness;
    }
    public void setCleanliness(Cleanliness cleanliness)
    {
        this.cleanliness = cleanliness;
    }
    public void updateSellingPrice(double percentage)
    {
        sellingPrice = sellingPrice*percentage;
    }
    public void setWinningCount(int count)
    {
        this.winningCount = count;
    }
    public int getWinningCount()
    {
        return winningCount;
    }
    public void appendDescription(String msg)
    {
        this.vehicleDescription = this.vehicleDescription+" "+msg;
    }
    public String getVehicleDescription()
    {
        return vehicleDescription;
    }
    public void setTopUps(AddTopUps t)
    {
        this.vehicleDescription = t.getDescription();
        this.topUpPercentage += t.getPercentage();
    }


}
