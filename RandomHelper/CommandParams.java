package RandomHelper;

import FNCD.FNCD;
import Staff.Customer;
import Staff.SalesPerson;

public class CommandParams {
    private FNCD curFncd, north, south;
    private Customer customer;
    private SalesPerson salesPerson;
    public CommandParams(FNCD north, FNCD south)
    {
        this.north = north;
        this.south = south;
        this.curFncd=north;
    }
    public void setFNCD(int a)
    {
        if(a==0)
        {
            curFncd = north;
        }
        else
        {
            this.curFncd = south;
        }
    }
    public FNCD getFncd()
    {
        return curFncd;
    }
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
    public Customer getCustomer()
    {
        return this.customer;
    }
    public void setSalesPerson(SalesPerson salesPerson)
    {
        this.salesPerson = salesPerson;
    }
    public SalesPerson getSalesPerson()
    {
        return salesPerson;
    }

}
