/********************************************************************
 * BufferedReadFromFile.java
 * Dean & Dean
 * 
 * This reads strings through a buffer from a text file. (pg. 726)
 ********************************************************************/
package bufferedreadfromfile;
import java.util.Scanner;
import java.io.BufferedReader;
import java.nio.file.*;     // Paths, Files
import java.nio.charset.Charset;

public class BufferedReadFromFile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String fileName;
        
        System.out.print("Enter a filename: ");
        fileName = stdIn.nextLine();
        try (BufferedReader fileIn = Files.newBufferedReader(
                Paths.get(fileName),
                Charset.defaultCharset())) {
            while (fileIn.ready()) {
                System.out.println(fileIn.readLine());
            }
        }   // end try
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }   // end main
}   // end BufferedReadFromFile class
