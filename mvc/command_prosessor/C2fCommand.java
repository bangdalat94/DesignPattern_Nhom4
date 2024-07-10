package Btvn.mvc.command_prosessor;

import Btvn.mvc.TemperatureModel;

public class C2fCommand extends Command {
    private double celsius;

    public C2fCommand(TemperatureModel temperatureModelRemote ,double celsius) {
        super(temperatureModelRemote);
        this.celsius = celsius;
    }

    @Override
    public void execute() {
        temperatureModelRemote.setCelsius(celsius);
    }
   
}
