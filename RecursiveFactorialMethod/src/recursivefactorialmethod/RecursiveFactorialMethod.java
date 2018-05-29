/******************************************************************
 * RecursiveFactorialMethod.java
 * Dean & Dean
 * 
 * Example from Introduction to Programming with Java: A Problem
 * Solving Approach on pg. 477.
 ******************************************************************/
package recursivefactorialmethod;
import java.util.Scanner;
public class RecursiveFactorialMethod {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num;
        
        System.out.print("Enter a non-negative number: ");
        num = stdIn.nextInt();
        if (num >= 0) {
            System.out.println(factorial(num));
        }
    }   // end main
    
    //*************************************************************
    
    private static int factorial(int n) {
        int nF;                     // n factorial
        
        if (n == 1 || n == 0) {     // stopping condition
            nF = 1;
        }
        else {                      // recursive method call
            nF = n * factorial(n-1);
        }
        return nF;
    }   // end factorial
}   // end RecursiveFactorialMethod class
