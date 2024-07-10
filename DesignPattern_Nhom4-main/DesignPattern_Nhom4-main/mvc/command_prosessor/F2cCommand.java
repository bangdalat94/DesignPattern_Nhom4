package Btvn.mvc.command_prosessor;

import Btvn.mvc.TemperatureModel;

public class F2cCommand extends Command {
    private double fahrenheit;

    public F2cCommand(TemperatureModel temperatureModelRemote ,double fahrenheit) {
        super(temperatureModelRemote);
        this.fahrenheit = fahrenheit;
    }

    @Override
    public void execute() {
        temperatureModelRemote.setFahrenheit(fahrenheit);
    } 
}
