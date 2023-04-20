package Command;

import RandomHelper.CommandParams;

public class GetStoreInventory implements Command{
    public void execute(CommandParams cmdParams)
    {
        cmdParams.getFncd().vehicleReport();
    }
}
