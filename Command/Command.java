package Command;

import RandomHelper.CommandParams;
// This is the interface for the Command pattern.

public interface Command {
    public void execute(CommandParams cmdParams);
    
}
