/** ******************************************************************
 * ReverseWords.java
 * Ben Davis
 *
 * This program mirrors PrintReverseMessageIterative.java, but
 * instead of reversing all the characters, this program will
 * reverse the order of the words.
 ******************************************************************* */
package reversewords;

import java.util.Scanner;

public class ReverseWords {

    public static String getReverse(Scanner scan) {
        String nextWord, result;   // temporary string holder
        // code goes here
        if (scan.hasNext()) {
            nextWord = scan.next() + " ";
            result = getReverse(scan) + nextWord;
            return result;
        }
        else {
            return "";
        }
    }   // end getReverse

    //***************************************************************
    
    public static String getIterative(Scanner scan) {
        String nextWord, result = "";    // holds strings
        
        while (scan.hasNext()) {
            nextWord = scan.next() + " ";
            result = nextWord + result;
        }
        return result;
    }   // end getIterative
    
    //***************************************************************
    
    public static void main(String[] args) {
        System.out.println("Ch 11 Strings by Ben Davis\n");
        String message = new String("We Are Many");
        Scanner scan = new Scanner(message);
        String reversedMessage;

        // recursive method to reverse words in string
        System.out.println("Part 1, recursive method");
        reversedMessage = getReverse(scan);
        System.out.println(reversedMessage);
        System.out.println("\nPart 2, iterative processing");
        scan = new Scanner(message);
        reversedMessage = getIterative(scan);
        System.out.println(reversedMessage);
    }   // end main

}   // end ReverseWords class
