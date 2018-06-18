/************************************************************
 * DanceRecitalDriver.java
 * Dean & Dean
 * 
 * This is the driver for the DanceRecital class. (pg. 818)
 ************************************************************/
package dancerecital;
import java.util.Scanner;

public class DanceRecitalDriver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        DanceRecital danceRecital = new DanceRecital();
        
        System.out.print("Name of the performance: ");
        danceRecital.setPerformance(stdIn.nextLine());
        System.out.print("Image file: ");
        danceRecital.setImage(stdIn.nextLine());
        System.out.print("Dance recital's date: ");
        danceRecital.setDate(stdIn.nextLine());
        System.out.print("Dance recital's time: ");
        danceRecital.setTime(stdIn.nextLine());
        System.out.print("Dance recital's venue: ");
        danceRecital.setVenue(stdIn.nextLine());
        danceRecital.displayPoster();
    }   // end main
}   // end class DanceRecitalDriver
