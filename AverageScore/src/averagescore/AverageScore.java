/*******************************************************************
 * AverageScore.java
 * Dean & Dean
 * 
 * This program averages input scores. (pg 530)
 *******************************************************************/
package averagescore;
import java.util.Scanner;
public class AverageScore {

    public static void main(String[] args) {
        double score;
        double count = 0;
        double totalScore = 0;
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("Enter a score (or -1 to quit): ");
        while ((score = stdIn.nextDouble()) != -1) {
            count++;
            totalScore += score;
            System.out.print("Enter a score (or -1 to quit): ");
        }
        if (count > 0) {
            System.out.println("Average score = " + totalScore / count);
        }
    }   // end main
    
}   // end AverageScore class
