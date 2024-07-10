package Btvn.mvc.command_prosessor;

import Btvn.mvc.TemperatureModel;

public abstract class Command {
    protected TemperatureModel temperatureModelRemote = null;

    public Command(TemperatureModel temperatureModelRemote){
        this.temperatureModelRemote = temperatureModelRemote;
    }

    public abstract void execute();
} 