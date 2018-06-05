/*******************************************************************
 * Ch15Car2.java
 * Dean & Dean
 * 
 * This instantiates a car and displays its properties. (pg. 620)
 *******************************************************************/
package ch14car2;

public class Ch14Car2 {
    private String make;        // car's make
    private int year;           // car's listed year
    private String color;       // car's color
    
    //****************************************************************
    
    public Ch14Car2(String make, int year, String color) {
        this.make = make;
        this.year = year;
        this.color = color;
    }   // end Ch14Car2 constructor
    
    //****************************************************************
    
    @Override
    public String toString() {
        return "make = " + make + ", year = " + year +
                ", color = " + color;
    }   // end toString
    
    //***************************************************************
    
    public static void main(String[] args) {
        Ch14Car2 car = new Ch14Car2("Honda", 1998, "silver");
        System.out.println(car);
    }
}
