/*********************************************************************
 * Truck.java
 * Ben Davis
 * 
 * This subclass extends Vehicle.java
 *********************************************************************/
package vehicle;

public class Truck extends Vehicle {
    private int bedLength;
    private boolean bedliner;
    
    //*****************************************************************
    
    public Truck()
        { }
    
    public Truck(String make, String model, int vin, String color,
            int year, int mileage, int bedLength, boolean bedliner) {
        super(make,model,vin,color,year,mileage);
        this.bedLength = bedLength;
        this.bedliner = bedliner;
    }
    
    //****************************************************************
    
    public int getBedLength() {
        return this.bedLength;
    }
    
    public boolean getBedliner() {
        return this.bedliner;
    }
    
    //****************************************************************
    
    @Override
    public String display() {
        String out = super.display() + getBedLength() + 
                "\' bed length" +
                (getBedliner() ? " with bed liner" : ", no bed liner");
        return out;
    }
}
