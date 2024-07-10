package Btvn.mvc.command_prosessor;

import Btvn.mvc.TemperatureModel;

public class ExitCommand extends Command {


    public ExitCommand(TemperatureModel temperatureModelRemote) {
        super(temperatureModelRemote);
        
    }

    @Override
    public void execute(TemperatureModel temperatureModel) {
        temperatureModel.exit();
    }
}
