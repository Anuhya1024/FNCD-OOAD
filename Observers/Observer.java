package Observers;

import Enums.ObserverActions;

// Observer pattern
public interface Observer {
    public void update(ObserverActions a, String message, double money);
}
