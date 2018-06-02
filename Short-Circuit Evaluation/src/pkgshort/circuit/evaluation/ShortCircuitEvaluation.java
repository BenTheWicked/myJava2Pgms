/*******************************************************************
 * ShootingPercentage.java
 * Dean & Dean
 * 
 * This program processes a basketball player's shooting percentage.
 * (pg. 536)
 *******************************************************************/
package pkgshort.circuit.evaluation;
import java.util.Scanner;
public class ShortCircuitEvaluation {

    public static void main(String[] args) {
        int attempted;      // number of shots attempted
        int made;           // numer of shots made
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Number of shots attempted: ");
        attempted = stdIn.nextInt();
        System.out.print("Number of shots made: ");
        made = stdIn.nextInt();
        
        if ((attempted > 0) && ((double) made / attempted) >= .5) {
            System.out.printf("Excellent shooting percentage - %.1f%%\n",
                    100.0 * made / attempted);
        }
        else {
            System.out.println("Practice your shot more.");
        }
    }   // end main
    
}   // end class ShootingPercentage
