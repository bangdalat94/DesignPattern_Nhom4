package Btvn.mvc;

import Btvn.mvc.observer.Publisher;

public class TemperatureModel extends Publisher {

    private double celsius;
    private double fahrenheit;
    public TemperatureModel
    (){
        
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        this.fahrenheit = celsiusToFahrenheit(celsius);
        notifySubscribers();
    }
    
    public double getCelsius() {
        return celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        this.celsius = fahrenheitToCelsius(fahrenheit);
        notifySubscribers();
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void c2f(double celsius) {
        setFahrenheit(celsiusToFahrenheit(celsius));
    }

    public void f2c(double fahrenheit) {
        setCelsius(fahrenheitToCelsius(fahrenheit));
    }


    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
