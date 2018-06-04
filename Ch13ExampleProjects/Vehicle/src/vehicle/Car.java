/********************************************************************
 * Car.java
 * Ben Davis
 * 
 * Subclass for Vehicle.java
 ********************************************************************/
package vehicle;

public class Car extends Vehicle{
    private int numberOfDoors;
    private boolean tintedWindows;
    
    //****************************************************************
    
    // Constructors
    public Car()
        { }
    
    public Car(String make, String model, int vin, String color,
            int year, int mileage, int numberOfDoors, boolean tintedWindows) {
        super(make,model,vin,color,year,mileage);
        this.numberOfDoors = numberOfDoors;
        this.tintedWindows = tintedWindows;
    }
    
    //***************************************************************
    
    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }
    
    public boolean getTintedWindows() {
        return this.tintedWindows;
    }
    
    //****************************************************************
    
    @Override
    public String display() {
        String out = super.display() + getNumberOfDoors() +
                " doors" +
                (getTintedWindows() ? ", tinted windows" : "");
        return out;
    }
}
