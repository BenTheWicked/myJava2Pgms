/********************************************************************
 * LuckyNumber.java
 * Dean & Dean
 * 
 * This program reads the user's lucky number as an int. (pg. 664)
 ********************************************************************/
package luckynumber;
import java.util.Scanner;
import java.util.InputMismatchException;
public class LuckyNumber {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num;        // lucky number
        try {
            System.out.print("Enter your lucky number (an integer): ");
            num = stdIn.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid entry. You'll be given a "
                    + "random lucky number.");
            num = (int) (Math.random() * 10) + 1;  // between 1-10
        }
        System.out.println("Your lucky number is " + num + ".");
    }   // end main
    
}   // end LuckyNumber class
