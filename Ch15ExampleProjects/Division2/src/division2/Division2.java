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
        double dividend;
        int divisor;
        System.out.print("Enter dividend: ");
        dividend = stdIn.nextDouble();
        System.out.print("Enter divisor: ");
        divisor = stdIn.nextInt();
        System.out.println(dividend / divisor);
    }   // end main
    
}   // end Division2 class
