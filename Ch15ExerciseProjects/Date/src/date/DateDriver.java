/*********************************************************************
 * DateDriver.java
 * Ben Davis
 * 
 * This driver asks the user for a date and prints a valid date.
 *********************************************************************/
package date;
import java.util.*;
public class DateDriver {
    public static void main(String[] args) {
        System.out.println("Ch 15 Date Project by Ben Davis\n");
        Scanner stdIn = new Scanner(System.in);
        String dateStr = "";
        Date date;
        
        while (!dateStr.equalsIgnoreCase("q")) {
            System.out.print("Enter a date in the form mm/dd "
                    + "(\"q\" to quit): ");
            dateStr = stdIn.nextLine();
            date = new Date(dateStr);
            if (date.getError() == null) {
                date.printResults();
            }
            else {
                System.out.println(date.getError());
            }
        }
    }
}
