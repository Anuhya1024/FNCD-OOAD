package Command;

import RandomHelper.CommandParams;

public class Buy implements Command{
    public void execute(CommandParams cmdParams)
    {
        cmdParams.getFncd().sellingWithSalesPerson(cmdParams.getCustomer(),cmdParams.getSalesPerson());
    }

}
