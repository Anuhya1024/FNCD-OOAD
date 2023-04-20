package Command;

import RandomHelper.CommandParams;

public class Terminate implements Command{
    public void execute(CommandParams cmdParams)
    {
        System.out.println("Terminated");
        return;
    }
}
