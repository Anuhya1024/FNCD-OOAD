package Command;

import RandomHelper.CommandParams;

public class GetSalesPersonName implements Command{

    public void execute(CommandParams cmdParams)
    {
        System.out.println(cmdParams.getSalesPerson().getName());
    }

}
