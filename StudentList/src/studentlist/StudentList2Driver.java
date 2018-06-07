/********************************************************************
 * StudentList2Driver.java
 * Dean & Dean
 * 
 * This drives the StudentList2 class. (pg. 691)
 ********************************************************************/
package studentlist;
import java.util.Scanner;
public class StudentList2Driver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String[] names = {"Caleb", "Izumi", "Mary", "Usha"};
        StudentList2 studentList = new StudentList2(names);
        int index;
        boolean reenter;
        
        studentList.display();
        
        do {
            System.out.print("Enter index of student to remove: ");
            index = stdIn.nextInt();
            try {
                System.out.println("removed " +
                        studentList.removeStudent(index));
                reenter = false;
            }
            catch (IndexOutOfBoundsException e) {
                System.out.print("Invalid entry. ");
                reenter = true;
            }
        } while (reenter);
        
        studentList.display();
    }   // end main
}   // end StudentList2Driver