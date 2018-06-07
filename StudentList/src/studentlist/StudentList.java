/********************************************************************
 * StudentList.java
 * Dean & Dean
 * 
 * This class manages an ArrayList of students. (pg. 673)
 ********************************************************************/
package studentlist;
import java.util.ArrayList;
public class StudentList {
    ArrayList<String> students = new ArrayList<>();
    
    //*****************************************************************
    
    public StudentList(String[] names) {
        for (int i=0; i<names.length; i++) {
            students.add(names[i]);
        }
    }   // end constructor
    
    //****************************************************************
    
    public void display() {
        for (int i=0; i<students.size(); i++) {
            System.out.print(students.get(i) + " ");
        }
        System.out.println();
    }   // end display
    
    //****************************************************************
    
    // removeStudent method with try-catch mechanism
    /*
    public void removeStudent(int index) {
        try {
            students.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Can't remove studnet because " +
                    index + " is an invalid index position." );
        }
    }   // end removeStudent
    */
    
    public void removeStudent(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
        else {
            System.out.println("Can't remove student because " +
                    index + " is an invalid index position.");
        }
    }   // end removeStudent
    
}   // end StudentList
