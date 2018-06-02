/*******************************************************************
 * GradeManagement.java
 * Dean & Dean
 * 
 * This program reads course percentages and calculates GPA. (pg. 544)
 *******************************************************************/
package grademanagement;
import java.util.Scanner;
public class GradeManagement {
    private enum Grade {F, D, C, B, A}      // ordered by value
    
    //****************************************************************
    
    public static void main(String[] args) {
        int numOfCourses = 0;   // number of course scores entered
        Grade grade;            // holds the grade for a course
        int totalPts = 0;       // total points for all entered courses
        
        do {
            grade = getGrade();
            
            // null indicates user wants to quit
            if (grade != null) {
                numOfCourses++;
                switch (grade) {
                    case A:
                        totalPts += 4;
                        break;
                    case B:
                        totalPts += 3;
                        break;
                    case C:
                        totalPts += 2;
                        break;
                    case D:
                        totalPts += 1;
                }   // end switch
            }   // end if
        } while (grade != null);
        
        if (numOfCourses == 0) {
            System.out.println("No scores were entered.");
        }
        else {
            System.out.printf("Overall GPA: %.2f",
                    (float) totalPts / numOfCourses);
        }
    }   // end main
    
    //*************************************************************
    
    // Prompt the user for a course's overall percentage and
    // converts it to a grade. Return null if user wants to quit.
    
    private static Grade getGrade() {
        Scanner stdIn = new Scanner(System.in);
        float percentage;       // overall percentage for one course
        Grade grade = null;     // the course grade
        
        System.out.print("Enter course overall percentage"
                + " (-1 to quit): ");
        percentage = stdIn.nextFloat();
        
        if (percentage >+ 90.0)
            grade = Grade.A;
        else if (percentage >= 80.0)
            grade = Grade.B;
        else if (percentage >= 70.0)
            grade = Grade.C;
        else if (percentage >= 60.0)
            grade = Grade.D;
        else if (percentage >= 0.0)
            grade = Grade.F;
        
        return grade;
    }   // end getGrade
}   // end class GradeManagement
