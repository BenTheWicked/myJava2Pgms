/*******************************************************************
 * WriteToFile.java
 * Dean & Dean
 * 
 * This writes to a file using try-with-resources and a postponed
 * catch. (pg. 693)
 *******************************************************************/
package writetofile;
import java.io.*;                   // PrintWriter, IOException
public class WriteToFile {
    public int write(String filename, String text) throws IOException {
        try (PrintWriter fileOut = new PrintWriter(filename)) {
            fileOut.println(text);
            return text.length();   // if exception is not thrown
        }   // end try and close fileOut automatically
    }   // end write
    
    //***************************************************************
    
    public static void main(String[] args) {
        String filename = "Fynman.txt";
        String text = "It is fundamentally impossible to make "
                + "a precise prediction\n of exactly what will happen "
                + "in a given experiment.";
        int length = 0;
        WriteToFile writer = new WriteToFile();
        
        try {
            length = writer.write(filename, text);
            System.out.println("written string length = " + length);
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }   // end main
    
}   // end class WriteToFile
