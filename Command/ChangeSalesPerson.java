package Command;

import FNCD.FNCD;
import RandomHelper.CommandParams;
import Staff.SalesPerson;

public class ChangeSalesPerson implements Command{

    
    public void execute(CommandParams cmdParams)
    {
        SalesPerson cur = cmdParams.getSalesPerson();
         FNCD fncd = cmdParams.getFncd();
        cmdParams.setSalesPerson(fncd.changeSalesPerson(cur));
    }
}
