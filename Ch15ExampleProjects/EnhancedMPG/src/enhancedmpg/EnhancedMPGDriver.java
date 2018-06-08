/********************************************************************
 * EnhancedMPGDriver.java
 * Ben Davis
 * 
 * Driver for EnhancedMPG.java
 ********************************************************************/
package enhancedmpg;
import static enhancedmpg.EnhancedMPG.displayTotalMPG;
import java.util.*;
public class EnhancedMPGDriver {
    public static double validation(String stdIn) {
        double number = 0.0;
        try {
            return number = Double.parseDouble(stdIn);
        }
        catch (NumberFormatException e) {
            System.out.println("Check that input");
            return number;
        }
        /*
        catch (InputMismatchException s) {
            System.out.println("Please enter a number");
            stdIn.next();
            return number;
        }
        */
    }
    
    //*************************************************************
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        ArrayList<EnhancedMPG> trips = new ArrayList<>();
        double miles = 0.0;         // user-entered values.
        double gallons = 0.0;       // user-entered values.
        boolean valid = false;      // validation marker
        int count = 0;              // hold position in Array
        String input = "";
        
        System.out.println("Ch 15 MPG Calculator by Ben Davis\n");
        
        do {
            System.out.print("Select (n)New trip, (d)Display total "
                    + "MPG, (q)Quit: ");
            input = stdIn.nextLine();
            
            switch (input.toLowerCase().charAt(0)) {
                case 'n':
                    // Handles new trip
                    valid = false;
                    while (!valid) {
                        System.out.print("Enter miles: ");
                        String userInput = stdIn.nextLine();
                        miles = validation(userInput);
                        if (miles <= 0.0) {
                            miles = 0.0;
                            valid = false;
                            System.out.println("Please enter a "
                                    + "positive number");
                        }
                        else {
                            valid = true;
                        }
                    }
                    valid = false;
                    while (!valid) {
                        System.out.print("Enter gallons: ");
                        String userInput = stdIn.nextLine();
                        gallons = validation(userInput);
                        if (gallons <= 0.0) {
                            gallons = 0.0;
                            valid = false;
                            System.out.println("Please enter a "
                                    + "positive number");
                        }
                        else {
                            valid = true;
                        }
                    }
                    trips.add(new EnhancedMPG(miles, gallons));
                    trips.get(count).displayCurrentMPG();
                    count++;
                    break;
                case 'd':
                    // Displays MPG
                    if (!trips.isEmpty()) {
                        displayTotalMPG();
                    }
                    else {
                        System.out.println("Try taking a trip first.");
                    }
                    break;
                case 'q':
                    break;
                default:
                    // Invalid entry
                    System.out.println("I did not understand.");
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}
