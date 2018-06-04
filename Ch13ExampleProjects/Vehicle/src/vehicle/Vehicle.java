/********************************************************************
 * Vehicle.java
 * Ben Davis
 * 
 * This is the ancestor class for all vehicles in the simulation of an
 * used car lot.
 ********************************************************************/
package vehicle;
import java.util.ArrayList;
public class Vehicle {
    // Instance variables that all vehicles inherit
    private String make;
    private String model;
    private int vin;
    private String color;
    private int year;
    private int mileage;
    
    //****************************************************************
    
    //Constructors
    public Vehicle()
        { }
    
    public Vehicle(String make, String model, int vin, String color,
            int year, int mileage) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    
    //****************************************************************
    
    public String getMake() {
        return this.make;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public int getVIN() {
        return this.vin;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public int getMileage() {
        return this.mileage;
    }
    
    //*************************************************************
    
    //Display string
    public String display() {
        String out = "Vehicle " + getVIN() + ": " + getYear() +
            " " + getColor() + " " + getMake() + " " +
            getModel() + ", mileage " + getMileage();
        return out;
    }
}
