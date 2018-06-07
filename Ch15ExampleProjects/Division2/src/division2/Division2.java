/********************************************************************
 * Division2.java
 * Dean & Dean
 * 
 * This attempts to prevent division by zero.
 ********************************************************************/
package division2;
import java.util.Scanner;
public class Division2 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        double dividend = 0.0;
        int divisor = 0;
        boolean valid = false;      // first attempt to catch errors.
        do {
            System.out.print("Enter dividend: ");
            String numStr = stdIn.nextLine();
            try {
                dividend = Double.parseDouble(numStr);
                valid = true;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid entry.");
            }
        } while (!valid);
        do {
            valid = false;
            System.out.print("Enter divisor: ");
            String divStr = stdIn.nextLine();
            try {
                divisor = Integer.parseInt(divStr);
                valid = true;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid entry.");
            }
            if (valid && divisor == 0) {
                System.out.println("No dividing by zero!");
                valid = false;
            }
        } while (!valid);
        try {
            System.out.println(dividend / divisor);
        }
        catch (ArithmeticException ae) {
            System.out.println("Sorry, something went wrong.");
            System.out.println(ae.getClass());
            System.out.println(ae.getMessage());
        }
    }   // end main
    
}   // end Division2 class
