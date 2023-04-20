package Staff;

import Enums.EmployeeTypes;

public class Driver extends Staff {
    private static int idCounter = 1;
    private int racePosition;
    private Boolean injuredStatus;


    public Driver() {

        super("Driver # " + idCounter, 150.0, EmployeeTypes.driver);
        idCounter++;
    }

    public int getRacePosition()
    {
        return racePosition;
    }
    public void setRacePosition(int racePosition)
    {
        this.racePosition = racePosition;
    }

    public void setInjuredStatus(Boolean b)
    {
        this.injuredStatus =b;
    }
    public Boolean getInjuredStatus()
    {
        return this.injuredStatus;
    }
}
