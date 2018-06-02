/*********************************************************************
 * Ch12Checking.java
 * Ben Davis
 * 
 * Driver for CheckingWithInternalIntegers.java
 *********************************************************************/
package checkingwithinternalintegers;
import java.util.Scanner;
public class Ch12Checking {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        CheckingWithInternalIntegers checking 
                = new CheckingWithInternalIntegers();
        double amount = 0.0;            // Change amount
        double balance;                 // User-defined balance
        double fee;                     // user-defined fee
        String command = "";                 // User command
        
        System.out.println("Checking Account with Internal Integers"
                + " by Ben Davis\n");
        
        System.out.print("New Checking Account: what is the "
                + "starting balance? $");
        balance = stdIn.nextDouble();
        checking.setBalance(balance);
        System.out.print("What is the fee for this checking "
                + "account? $");
        fee = stdIn.nextDouble();
        checking.setFee(fee);
        
        do {
            System.out.print("\nPlease select deposit (d), "
                    + "withdrawal (w), quit (q): ");
            command = stdIn.next();
            if (command.equalsIgnoreCase("d")) {
                System.out.print("How much will you deposit? $");
                amount = stdIn.nextDouble();
                checking.deposit(checking.getBalance(), amount);
            }   // end if
            else if (command.equalsIgnoreCase("w")) {
                System.out.print("How much will you withdraw? $");
                amount = stdIn.nextDouble();
                checking.withdrawal(checking.getBalance(), amount);
            }   // end else if
        } while (!command.equalsIgnoreCase("q"));
    }   // end main
    
}   // end class Ch6Checking
