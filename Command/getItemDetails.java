package Command;

import RandomHelper.CommandParams;

public class getItemDetails implements Command{
    public void execute(CommandParams cmdParams)
    {
        cmdParams.getFncd().getPreferredCars(cmdParams.getCustomer());
    }
}
