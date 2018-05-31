/*******************************************************************
 * PrintReverseMessageIterative.java
 * Dean & Dean
 * 
 * This program prints a given message in reverse order. (pg. 482)
 *******************************************************************/
package printreversemessageiterative;
import java.util.Scanner;
public class PrintReverseMessageIterative {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String msg;         // user-entered message
        
        System.out.print("Enter a message: ");
        msg = stdIn.nextLine();
        printReverseMessage(msg);
        System.out.println();
    }   // end main
    
    //**************************************************************
    
    private static void printReverseMessage(String msg) {
        int index;      // position of character that is to be printed
        /*
        index = msg.length() - 1;
        while (index >= 0) {
            System.out.print(msg.charAt(index));
            index--;
        }
        */
        if (!msg.isEmpty()) {
            index = msg.length() - 1;
            System.out.print(msg.charAt(index));
            printReverseMessage(msg.substring(0, index));
        }
    }   // end printReverseMessage
}   // end PrintReverseMessageIterative class
