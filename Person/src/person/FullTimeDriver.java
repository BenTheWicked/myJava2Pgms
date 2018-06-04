/*********************************************************************
 * FullTimeDriver.java
 * Dean & Dean
 * 
 * This is the driver for the FullTime.java subclass. (pg. 583)
 *********************************************************************/
package person;

public class FullTimeDriver {
    public static void main(String[] args) {
        FullTime fullTimer = new FullTime("Shreya", 5733, 80000);
        
        fullTimer.display();
        System.out.println(fullTimer.getName());
    }
}   // end FullTimeDriver class
