package Observers;

import Enums.ObserverActions;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(ObserverActions actions, String message, double money);
}
