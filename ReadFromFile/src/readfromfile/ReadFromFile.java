/********************************************************************
 * ReadFromFile.java
 * Dean & Dean
 * 
 * This opens an existing text file and prints its lines. (pg. 680)
 ********************************************************************/
package readfromfile;
import java.util.Scanner;
import java.nio.file.Paths;
public class ReadFromFile {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;     // file handler
        String filename;    // user-specified file name
        String line;        // line of text
        
        System.out.print("Enter a filename: ");
        try {
            filename = stdIn.nextLine();
            fileIn = new Scanner(Paths.get(filename));
            while (fileIn.hasNext()) {
                line = fileIn.nextLine();
                System.out.println(line);
            }
        }   // end try
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }   // end main
    
}   // end ReadFromFile class
