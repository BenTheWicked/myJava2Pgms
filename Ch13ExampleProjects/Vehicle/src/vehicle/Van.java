/********************************************************************
 * Van.java
 * Ben Davis
 * 
 * This subclass extends Vehicle.java
 ********************************************************************/
package vehicle;

public class Van extends Vehicle {
    private int numberOfSlidingDoors;
    private boolean entertainmentCenter;
    
    //*****************************************************************
    
    public Van()
        { }
    
    public Van(String make, String model, int vin, String color,
        int year, int mileage, int numberOfSlidingDoors,
        boolean entertainmentCenter) {
        super(make,model,vin,color,year,mileage);
        this.numberOfSlidingDoors = numberOfSlidingDoors;
        this.entertainmentCenter = entertainmentCenter;
    }
    
    //****************************************************************
    
    public int getNumberOfSlidingDoors() {
        return this.numberOfSlidingDoors;
    }
    
    public boolean getEntertainmentCenter() {
        return this.entertainmentCenter;
    }
    
    //****************************************************************
    
    @Override
    public String display() {
        String out = super.display() + getNumberOfSlidingDoors() +
                " sliding doors" +
                (getEntertainmentCenter() ? " with entertainment"
                + "center" : ", no entertainment center");
        return out;
    }
}
