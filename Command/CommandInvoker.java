package Command;

import RandomHelper.CommandParams;
// Command pattern invoker
public class CommandInvoker {
    private int number;
    private Command[] cmds ;
    public CommandInvoker(int number)
    {
        cmds = new Command[number];
        this.number = number;
        Command noCommand = new NoCommand();
        for(int i=0;i<number;i++)
        {
            cmds[i]=noCommand;
        }
    }
    public void setCommand(int slot, Command onCmd)
    {
        cmds[slot] = onCmd;
    }
    public void onButton(int slot, CommandParams cmdParams)
    {
        cmds[slot].execute(cmdParams);
    }

}
