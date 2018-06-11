/********************************************************************
 * StudentScores.java
 * Ben Davis
 * 
 * Using the java.io.* package, this program asks the user for input
 * of names and scores, writes that data to a file (name on one line,
 * score on the next), reads that data file and prints the data, and
 * finds the low, high, and average of the scores.
 ********************************************************************/
package studentscores;
import java.io.*;
import java.util.*;
public class StudentScores {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        File outputFile = new File("newScores.txt");
        FileWriter out;
        BufferedWriter writeFile;
        String name;
        double score;
        
        System.out.println("Chapter 16 Student Scores by Ben Davis\n");
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
        
        FileReader in;
        BufferedReader readFile;
        String lineOfText;
        double low = 1000.0;
        double high = 0.0;
        double average = 0.0;
        int count = 1;
        try {
            in = new FileReader(outputFile);
            readFile = new BufferedReader(in);
            List<String> listLines = new ArrayList<String>();
            while ((lineOfText = readFile.readLine()) != null) {
                listLines.add(lineOfText);
                System.out.println(lineOfText);
            }
            // do work
            average += Double.parseDouble(listLines.get(1));
            for (int i=1; i<listLines.size()-1; i+=2) {
                double a = Double.parseDouble(listLines.get(i));
                double b = Double.parseDouble(listLines.get(i+2));
                // get low
                if (low < a && low < b) {
                    low = low;
                }
                else if (a < b) {
                    low = a;
                }
                else {
                    low = b;
                }
                // get high
                if (high > a && high > b) {
                    high = high;
                }
                else if (a > b) {
                    high = a;
                }
                else {
                    high = b;
                }
                // get average
                average += b;
                count++;
            }
            System.out.println("Low score: " + low);
            System.out.println("High Score: " + high);
            System.out.println("Average score: " + (average/count));
            readFile.close();
            in.close();
        }
        catch (IOException e) {
            System.out.println("Problem reading file.");
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
    
}
