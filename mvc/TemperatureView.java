package Btvn.mvc;

import Btvn.mvc.command_prosessor.Command;
import Btvn.mvc.command_prosessor.CommandProcessor;
import Btvn.mvc.command_prosessor.C2fCommand;
import Btvn.mvc.command_prosessor.ExitCommand;
import Btvn.mvc.command_prosessor.F2cCommand;
import Btvn.mvc.observer.Subscriber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureView extends JFrame implements Subscriber {

    private JLabel jLabelInputRemote1, jLabelInputRemote2;
    private static JTextField jTextFieldInputRemote1;
    private static JTextField jTextFieldInputRemote2;
    private JPanel jPanelRemote;
    private MenuController menuControllerRemote;
    private JMenuBar menuBarRemote;
    private static CommandProcessor commandProcessorRemote;
    private static TemperatureModel temperatureModelRemote;
    private static EnterController enterControllerRemote;
    

    TemperatureView(TemperatureModel temperatureModelRemote, MenuController menuControllerRemote,CommandProcessor commandProcessorRemote, EnterController enterControllerRemote) {
        this.temperatureModelRemote = temperatureModelRemote;
        this.menuControllerRemote = menuControllerRemote;
        this.commandProcessorRemote = commandProcessorRemote;
        this.enterControllerRemote = enterControllerRemote;
        temperatureModelRemote.subscribe(this);
        buildPanel();
        buildMenu();
        setJMenuBar(menuBarRemote);
        add(jPanelRemote);
        setTitle("Temperature Converter");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextFieldInputRemote1.addActionListener(enterControllerRemote);
        jTextFieldInputRemote2.addActionListener(enterControllerRemote);

    }
    

    public void buildPanel() {
        jLabelInputRemote1 = new JLabel("Celsius");
        jTextFieldInputRemote1 = new JTextField("0.0", 10); // Thiết lập giá trị mặc định là "0.0"
        jPanelRemote = new JPanel();
        jPanelRemote.add(jLabelInputRemote1);
        jPanelRemote.add(jTextFieldInputRemote1);
    
        jLabelInputRemote2 = new JLabel("Fahrenheit");
        jTextFieldInputRemote2 = new JTextField("32.0", 10); // Thiết lập giá trị mặc định là "32.0"
        jPanelRemote.add(jLabelInputRemote2);
        jPanelRemote.add(jTextFieldInputRemote2);


       
    }
   
    static class EnterController implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField) e.getSource();
            try {
                if (source == jTextFieldInputRemote1) {
                    double celsius = Double.parseDouble(jTextFieldInputRemote1.getText());
                    temperatureModelRemote.setCelsius(celsius);
                } else if (source == jTextFieldInputRemote2) {
                    double fahrenheit = Double.parseDouble(jTextFieldInputRemote2.getText());
                    temperatureModelRemote.setFahrenheit(fahrenheit);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: " + source.getText());
            }
        }
    }

    


    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu temMenuRemote = new JMenu("Commands");
        menuBarRemote.add(temMenuRemote);

        JMenuItem f2cItemRemote = new JMenuItem("c2f");
        f2cItemRemote.setActionCommand("c2f");
        f2cItemRemote.addActionListener(menuControllerRemote);

        JMenuItem c2fItemRemote = new JMenuItem("f2c");
        c2fItemRemote.setActionCommand("f2c");
        c2fItemRemote.addActionListener(menuControllerRemote);

        JMenuItem exitItemRemote = new JMenuItem("exit");
        exitItemRemote.setActionCommand("exit");
        exitItemRemote.addActionListener(menuControllerRemote);

        temMenuRemote.add(f2cItemRemote);
        temMenuRemote.add(c2fItemRemote);
        temMenuRemote.add(exitItemRemote);
    }

    static class MenuController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            Command commandRemote = null;
            if (command.equals("f2c")) {
                double fahrenheit = Double.parseDouble(jTextFieldInputRemote2.getText());
                commandRemote = new F2cCommand(temperatureModelRemote, fahrenheit);
                commandProcessorRemote.execute(commandRemote);
            //f2c
            } else if (command.equals("c2f")) {
                double celsius = Double.parseDouble(jTextFieldInputRemote1.getText());
                commandRemote = new C2fCommand(temperatureModelRemote, celsius);
                commandProcessorRemote.execute(commandRemote);
            //exit  
            } else if (command.equals("exit")) {
                System.exit(0);
            }
            
        }
        
    }

    



    @Override
    public void update() {
        double fahrenheit = temperatureModelRemote.getFahrenheit();
        double celsius = temperatureModelRemote.getCelsius();

        // Format số celsius và fahrenheit để chỉ hiển thị 2 số sau dấu chấm
        String formattedCelsius = String.format("%.2f", celsius);
        String formattedFahrenheit = String.format("%.2f", fahrenheit);

        jTextFieldInputRemote1.setText(formattedCelsius);
        jTextFieldInputRemote2.setText(formattedFahrenheit);
    }
}
