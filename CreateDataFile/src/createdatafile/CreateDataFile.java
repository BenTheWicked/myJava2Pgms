/********************************************************************
 * CreateDataFile.java
 * Ben Davis
 * 
 * This program writes a file to the source folder. Copied from Ch
 * 16 supplemental reading material.
 ********************************************************************/
package createdatafile;
import java.io.*;
import java.util.Scanner;
public class CreateDataFile {
    public static void main(String[] args) {
        File outputFile = new File("newScores.txt");
        FileWriter out;
        BufferedWriter writeFile;
        Scanner stdIn = new Scanner(System.in);
        String name;
        double score;
        
        try {
            out = new FileWriter(outputFile);
            writeFile = new BufferedWriter(out);
            for (int k=0; k<5; k++) {
                System.out.print("Enter student name: ");
                name = stdIn.next();
                writeFile.write(name);
                writeFile.newLine();
                System.out.print("Enter test score: ");
                score = stdIn.nextDouble();
                writeFile.write(String.valueOf(score));
                writeFile.newLine();
            }
            writeFile.close();
            out.close();
            System.out.println("Data written to file");
        }
        catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
}
