package Observers;

import Enums.ObserverActions;

public class Tracker implements Observer{
    private double todayExpense;
    private double todaySales;
    private double totalExpense;
    private double totalSales;
    private static Tracker myInstance = new Tracker();
    //This is the singleton pattern
    public static Tracker getInstance()
    {
        return myInstance;
    }
    private Tracker()
    {

    }
    private void updateTotalExpense(double today)
    {
        totalExpense +=today;
    }
    private void updateTotalSales(double today)
    {
        totalSales +=today;
    }
    public void update(ObserverActions a, String message, double money){
        String text;

        switch (a)
        {
            case staffMoney:
                updateTotalExpense(money);
                text = "TRACKER::Total money earned by all Staff: $"+totalExpense+"\n";
                break;
            case FNCDMoney:
                updateTotalSales(money);
                text = "TRACKER::Total money earned by the FNCD.FNCD: $"+totalSales+"\n";
                break;
//            case announcement:
//                text = message;
//                break;
            default:
                text = "";
                break;
        }
        System.out.print( text);

    }

}
