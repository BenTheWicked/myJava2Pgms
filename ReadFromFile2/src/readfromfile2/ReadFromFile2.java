/********************************************************************
 * ReadFromFile2.java
 * Dean & Dean
 * 
 * This opens an existing text file and prints its lines. (pg. 683)
 ********************************************************************/
package readfromfile2;
import java.util.Scanner;
import java.nio.file.*;     // Paths, specific exceptions
public class ReadFromFile2 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;     // file handler
        boolean makeEntry = true;
        
        while (makeEntry) {
            System.out.print("Enter a filename: ");
            try {
                fileIn = new Scanner(Paths.get(stdIn.nextLine()));
                makeEntry = false;  // because user entry is now OK
                while (fileIn.hasNext()) {
                    System.out.println(fileIn.nextLine());
                }
            }   // end try
            catch (InvalidPathException | NoSuchFileException e) {
                System.out.println("Filename invalid or not found.");
            }   // end catching exceptions user can handle
            catch (Exception e) {
                System.out.println(e.getClass());
                System.out.println(e.getMessage());
            }
        }   // end while makeEntry
    }   // end main
    
}   // end ReadFromFile2 class
