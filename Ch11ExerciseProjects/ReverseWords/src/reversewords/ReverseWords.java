/********************************************************************
 * ReverseWords.java
 * Ben Davis
 * 
 * This program mirrors PrintReverseMessageIterative.java, but
 * instead of reversing all the characters, this program will
 * reverse the order of the words.
 ********************************************************************/
package reversewords;
import java.util.Scanner;
public class ReverseWords {
    public static String getReverse(Scanner scan) {
        String nextWord, oldWord;   // temporary string holder
        int index;                  // whitespace finder
        // code goes here
        oldWord = scan.toString();
        if (oldWord == null || oldWord.length() == 0) {
            return "";
        }
        for (int i=oldWord.length(); i>=0; i--) {
            
        }
        /*
        if (scan.hasNext()) {
            nextWord = oldWord.substring(0, index);
            Scanner scan1 = new Scanner(oldWord.substring(index));
        }
        */
    }   // end getReverse
    
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
    }   // end main
    
}   // end ReverseWords class
