package Command;

import RandomHelper.CommandParams;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// Code Copyright: https://www.javatpoint.com/java-get-current-date
public class GetSystemTime implements Command{
    public void execute(CommandParams cmdParams)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
