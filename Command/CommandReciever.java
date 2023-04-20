package Command;
import FNCD.FNCD;
import RandomHelper.CommandParams;
// Command pattern receiver
public class CommandReciever {
    public void action(CommandInvoker invk, int action, CommandParams cmdParams)
    {
        invk.onButton(action,cmdParams); //1
    }
}
