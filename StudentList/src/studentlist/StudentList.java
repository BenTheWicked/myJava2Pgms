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
    
    public void removeStudent(int index) {
        students.remove(index);
    }   // end removeStudent
}   // end StudentList
