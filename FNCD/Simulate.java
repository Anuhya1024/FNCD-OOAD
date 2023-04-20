package FNCD;

import Command.CommandInvoker;
import Command.CommandReciever;
import Command.SelectLocation;
import Enums.Days;
import RandomHelper.RandomHelper;
import Staff.Customer;

import java.util.List;
import java.util.Scanner;

import RandomHelper.*;
import Command.*;

public class Simulate {
    public static void simulateLastDay(FNCD north, FNCD south,List<Customer> customersSouth)
    {
        CommandInvoker invk = new CommandInvoker(8);
        invk.setCommand(0, new SelectLocation());
        invk.setCommand(1,new GetSalesPersonName());
        invk.setCommand(2, new GetSystemTime());
        invk.setCommand(3,new ChangeSalesPerson());
        invk.setCommand(4, new GetStoreInventory());
        invk.setCommand(5, new getItemDetails());
        invk.setCommand(6, new Buy());
        invk.setCommand(7, new Terminate());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulating Last Day");
        for(Customer c: customersSouth)
        {
            CommandParams cmd = new CommandParams(north,south);
            cmd.setCustomer(c);
            CommandReciever receiver = new CommandReciever();
            System.out.println("New customer arrived with a chance of buying "+c.getchanceOfBuying()+ "of car Type "+c.getVehicleType()+"Arrived");
            while(true)
            {

                System.out.println(" 1. Select FNCD LOCATION \n 2. Get SalesPerson Details \n 3. Ask SalesPerson Time \n" +
                        " 4. Ask for different SalesPerson\n 5. Ask SalesPerson current inventory \n 6. Ask for user selected inventory\n"
                        +" 7. Buy the vehicle\n 8. End the user interaction \n");
                int n =scanner.nextInt();

                if(n == 8)
                {
                    receiver.action(invk,n-1,cmd);
                    System.out.println("Terminated Current Customer\n");
                    break;
                }

                receiver.action(invk,n-1,cmd);
            }
        }


        // choosing FNCD.FNCD location;

    }
    public static void simulate(int days, FNCD north, FNCD south)
    {
        for(int i=0;i<days;)
        {
            for(Days d: Days.values()){
                if(i>=days)
                {
                    break;
                }

                List<Customer> customersNorth = RandomHelper.createCustomers(d);
                List<Customer> customersSouth = RandomHelper.createCustomers(d);

                System.out.println("************ FNCD North Day " + i + " ************");
                System.out.println("Opening FNCD.FNCD North........");
                north.open(i);
                System.out.println("************ FNCD South Day " + i + " ************");
                System.out.println("Opening FNCD.FNCD South........");
                south.open(i);


//                System.out.println("************ FNCD Wash Day " + i + " ************");

                System.out.println("North Washing.........");
                north.washing();
                System.out.println("South Washing.........");
                south.washing();
                System.out.println("North Repairing........");
                north.Repairs();
                System.out.println("South Repairing........");
                south.Repairs();
                if(i<30) {
                    System.out.println("North Selling...........");
                    north.selling(customersNorth);
                    System.out.println("South Selling ...........");
                    south.selling(customersSouth);
                }
                else if(i==30)
                {
                    Simulate.simulateLastDay(north,south,customersSouth);
                }

                if(d == Days.SUN || d == Days.WED)
                {
                    System.out.println("Racing in North........");
                    north.racing();
                    System.out.println("Racing in South........");
                    south.racing();
                }
                System.out.println("Closing in North...........");
                north.close(i);
                System.out.println("Closing in South...........");
                south.close(i);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        FNCD North = new FNCD("NORTH");
        FNCD South = new FNCD("SOUTH");
        North.initializeBonus();
        South.initializeBonus();
        Simulate.simulate(15, North, South);
        North.report();
        South.report();
        Charts.plot(North);
        Charts.plot(South);

    }
}