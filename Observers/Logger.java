package Observers;

import Enums.ObserverActions;

import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Observer {
    String fileName;
    FileWriter fw;
    //This is the singleton pattern
    private Logger(){

    }
    private static Logger myInstance= null;
    public static Logger getInstance()
    {
        if(myInstance == null){
            myInstance = new Logger();
            return myInstance;
        }
        return myInstance;

    }
    public void setFile(String fileName)
    {
        this.fileName =fileName;
    }
    public void update(ObserverActions a, String message, double money){
        String text;

        switch (a)
        {
            case budget:
                text = "TOOK LOAN: Added money to the FNCD.FNCD budget due to low funds. Current FNCD.FNCD budget: "+ money+"\n";
                break;
            case announcement:
                text =message;
                break;
//            case staffMoney:
//                text = message+money;
//                break;
//            case FNCDMoney:
//                text = message + money;
//                break;
            default:
                text = "";
                break;
        }
        try {
            try {
                fw = new FileWriter(fileName,true);
            }
            catch (IOException e)
            {
                System.out.println("Unable to create the file");
                throw new RuntimeException(e);
            }
            fw.write(text);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to write to the file");
            throw new RuntimeException(e);
        }

    }
}
