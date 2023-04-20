package Observers;

import Enums.ObserverActions;

import java.util.ArrayList;

public class Publisher implements Subject{
    private ArrayList<Observer> observers;


    public Publisher()
    {
        observers = new ArrayList<Observer>();
    }


    public void registerObserver(Observer o){
        observers.add(o);

    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0)
        {
            observers.remove(o);
        }

    }
    public void notifyObservers(ObserverActions action, String message, double money){
        for(int i=0;i<observers.size();i++)
        {
            Observer obs = observers.get(i);
            obs.update(action, message,money);
        }

    }

}
