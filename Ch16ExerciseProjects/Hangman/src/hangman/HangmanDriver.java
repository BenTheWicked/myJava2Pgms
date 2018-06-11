/********************************************************************
 * HangmanDriver.java
 * Ben Davis
 * 
 * Program to open/create a text file with a selection of words. The
 * program then populates the game with a randomly selected word.
 ********************************************************************/
package hangman;
import java.util.*;
import java.io.*;
public class HangmanDriver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Hangman game;
        String[] gameWords = new String[6];
        int count = 0;
        String letter = "", answer = "";
        // First, check for the words.txt file
        
        System.out.println("Ch 16 Hangman with Files by Ben Davis\n");
        try (ObjectInputStream fileIn = new ObjectInputStream(
                new FileInputStream("words.txt"))) {
            // loop
            for (int i=0; i<6; i++) {
                gameWords[count] = (String) fileIn.readObject();
                count++;
            }
        }
        catch (FileNotFoundException fnf) {
            // Create file?
            try (ObjectOutputStream fileOut = new ObjectOutputStream(
                    new FileOutputStream("words.txt"))) {
                for (int i=0; i<6; i++) {
                    System.out.print("Enter new word: ");
                    gameWords[i] = stdIn.nextLine();
                    fileOut.writeObject(gameWords[i]);
                }
                System.out.println("Data written to file");
            }
            catch (Exception e) {
                System.out.println(e.getClass());
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        
        System.out.println("Ready to play!");
        // If so, select a word randomly
        do {
            int number = (int)(Math.random() * 6);
            String word = gameWords[number];
            // Play game
            game = new Hangman(word);
            game.gameBoard();
            while (!game.gameOver(game)) {
                System.out.print("Guess a letter: ");
                letter = stdIn.nextLine();
                game.guess(letter);
            }
            System.out.print("Do you want to play again? (y or n) ");
            answer = stdIn.nextLine();
        } while (answer.equalsIgnoreCase("y"));
    }
}
