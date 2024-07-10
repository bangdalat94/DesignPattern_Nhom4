package Btvn.mvc.command_prosessor;

import Btvn.mvc.TemperatureModel;

public class CommandProcessor {
    private static CommandProcessor instance = null;

    public CommandProcessor(){}
    public static CommandProcessor getInstance() {
        if (instance == null) {
            instance = new CommandProcessor();
        }
        return instance;
    }

    public void execute(Command command) {
        command.execute();
        
    }
}
