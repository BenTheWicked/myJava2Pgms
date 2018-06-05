/********************************************************************
 * Car.java
 * Dean & Dean
 * 
 * This defines and compares cars. (pg. 616)
 ********************************************************************/
package ch14car;

public class Ch14Car {
    private String make;        // car's make
    private int year;           // car's listed year
    private String color;       // car's color
    
    //****************************************************************
    
    public Ch14Car(String make, int year, String color) {
        this.make = make;
        this.year = year;
        this.color = color;
    }   // end Car constructor
    
    //****************************************************************
    
    public boolean equals(Ch14Car otherCar) {
        return otherCar != null &&
                make.equals(otherCar.make) &&
                year == otherCar.year &&
                color.equals(otherCar.color);
    }   // end equals
}   // end class Ch14Car
