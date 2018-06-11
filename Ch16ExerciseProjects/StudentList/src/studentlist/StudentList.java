/********************************************************************
 * StudentList.java
 * Ben Davis
 * 
 * Starting with the StudentList class from Ch. 15.
 ********************************************************************/
package studentlist;
import java.util.*;
import java.io.*;

public class StudentList implements Serializable {
    ArrayList<String> students = new ArrayList<>();
    
    //****************************************************************
    
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
    
    public void addStudent(String name) {
        students.add(name);
    }   // end addStudent
}   // end StudentList
