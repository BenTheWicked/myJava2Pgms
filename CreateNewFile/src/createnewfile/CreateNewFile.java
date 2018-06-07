/*******************************************************************
 * CreateNewFile.java
 * Dean & Dean
 * 
 * This attempts to create a new file. (pg. 676)
 *******************************************************************/
package createnewfile;
import java.util.Scanner;
import java.nio.file.*;         // Path, Paths, Files
import java.io.IOException;
public class CreateNewFile {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String filename;
        Path path;              // file location
        
        System.out.print("Enter name of file to create: ");
        filename = stdIn.nextLine();
        path = Paths.get(filename);
        if (Files.exists(path)) {
            System.out.println("Sorry, that file already exists.");
        }
        else {
            try {
                Files.createFile(path);
            }
            catch (IOException ioe) {
                System.out.println("File I/O error");
            }
            System.out.println(filename + " created.");
        }
    }   // end main
    
}   // end CreateNeFile class
