/********************************************************************
 * EnhancedMPG.java
 * Ben Davis
 * 
 * This program is a copy from the Ch 7 assignment: MPG.java.
 ********************************************************************/
package enhancedmpg;
import java.util.*;             // Scanner and ArrayList
public class EnhancedMPG {
    private static double totalMiles, totalGallons, totalMPG;   
    // class variables
    private static int numTrips;        // class variable
    private double miles, gallons, mpg; // Instance variables
    
    //***************************************************************
    
    public EnhancedMPG(double miles, double gallons) {
        this.miles = (double) miles;
        this.gallons = (double) gallons;
        this.mpg = this.miles / this.gallons;
        totalMiles += this.miles;
        totalGallons += this.gallons;
        numTrips++;
    }
    
    public void displayCurrentMPG() {
        System.out.printf("This trip = %,.2f MPG\n", this.mpg);
    }
    
    public static void displayTotalMPG() {
        totalMPG = totalMiles / totalGallons;
        System.out.printf("For %d trips, total MPG = %,.2f\n", 
                numTrips, totalMPG);
    }
}
