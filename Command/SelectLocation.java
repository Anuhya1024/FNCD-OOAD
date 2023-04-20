package Command;

import RandomHelper.CommandParams;

import java.util.Scanner;

public class SelectLocation implements Command{
    public void execute(CommandParams cmdParams)
    {
        System.out.println("Press 0: North     1: South");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        cmdParams.setFNCD(a);
        System.out.println("You are in your preferred location");
        cmdParams.setSalesPerson(cmdParams.getFncd().changeSalesPerson(null));
        System.out.println(cmdParams.getSalesPerson());

    }
}
