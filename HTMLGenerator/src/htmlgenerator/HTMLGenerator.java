/*******************************************************************
 * HTMLGenerator.java
 * Dean & Dean
 * 
 * This program copies the contents of a user-specified file and
 * pastes it into a newly generated HTML file. (pg. 712-713)
 *******************************************************************/
package htmlgenerator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Paths;
public class HTMLGenerator {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String filenameIn;          // original file's name
        int dotIndex;               // position of dot in filename
        String filenameOut;         // HTML file's name
        String line;                // a line from the input file
        
        System.out.print("Enter file's name: ");
        filenameIn = stdIn.nextLine();
        
        // Compose the new filename
        dotIndex = filenameIn.lastIndexOf("."); // file extension
        if (dotIndex == -1) {       // no dot found
            filenameOut = filenameIn + ".html";
        }
        else {                      // dot found
            filenameOut = filenameIn.substring(0, dotIndex) +
                    ".html";
        }
        
        try (Scanner fileIn = new Scanner(Paths.get(filenameIn));
                PrintWriter fileOut = new PrintWriter(filenameOut)) {
            // First line used for title and header elements
            line = fileIn.nextLine();
            if (line == null) {
                System.out.println(filenameIn + " is empty.");
            }
            else {
                // Write the top of the HTML page.
                fileOut.println("<!DOCTYPE html>");
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("<title>" + line + "</title>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println("<h1>" + line + "</h1>");
                
                while (fileIn.hasNextLine()) {
                    line = fileIn.nextLine();
                    
                    // Blank line generate p tags
                    if (line.isEmpty()) {
                        fileOut.println("<p>");
                    }
                    else {
                        fileOut.println(line);
                    }
                }   // end while
                // Write ending HTML code.
                fileOut.println("</body>");
                fileOut.println("</hemtl>");
            }   // end else
        }   // end try and close fileOut and fileIn automatically
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }   // end catch
    }   // end main
    
}   // end class HTMLGenerator
