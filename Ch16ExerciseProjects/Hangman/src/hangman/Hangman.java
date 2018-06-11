/********************************************************************
 * Hangman.java
 * Ben Davis
 * 
 * Copied from Ch. 9's WheelOfFortune project.
 ********************************************************************/
package hangman;
import java.io.*;

public class Hangman implements Serializable {
    private String[][] secretWord;
    
    //****************************************************************
    
    public Hangman(String word) {
        secretWord = new String[2][word.length()];
        for (int i=0;i<word.length(); i++) {
            String letter = word.substring(i, i+1);
            this.secretWord[0][i] = letter;
            this.secretWord[1][i] = "=";
        }
    }
    
    //****************************************************************
    
    public void gameBoard() {
        for (int i=0; i<secretWord[1].length; i++) {
            System.out.print(" " + secretWord[1][i] + " ");
        }
        System.out.println();
    }
    
    //****************************************************************
    
    public void guess(String guess) {
        int count = 0;
        boolean found = false;
        for (int i=0; i<secretWord[0].length; i++) {
            if (secretWord[0][i].equalsIgnoreCase(guess)) {
                secretWord[1][i] = secretWord[0][i];
                count++;
                found = true;
            }
        }
        if (found) {
            System.out.println("Found it " + count +
                    " times");
        }
        else {
            System.out.println("Letter was not found!");
        }
        this.gameBoard();
    }   // end guess
    
    //***************************************************************
    
    public boolean gameOver(Hangman game) {
        for (int i=0; i<secretWord[1].length; i++) {
            if (secretWord[1][i].equals("=")) {
                return false;
            }
        }
        return true;
    }
}
