package Btvn.mvc;

import javax.swing.*;

import Btvn.mvc.TemperatureView.EnterController;
import Btvn.mvc.TemperatureView.MenuController;
import Btvn.mvc.command_prosessor.CommandProcessor;

public class TemperatureApp {

    public static void main(String[] args) {
            TemperatureModel temperatureModelRemote = new TemperatureModel();
            MenuController menuControllerRemote = new MenuController();
            CommandProcessor commandProcessorRemote = CommandProcessor.getInstance();
            EnterController  enterControllerRemote = new EnterController();
            
            TemperatureView temperatureView = new TemperatureView(temperatureModelRemote, menuControllerRemote, commandProcessorRemote, enterControllerRemote);
            
        };
    }

