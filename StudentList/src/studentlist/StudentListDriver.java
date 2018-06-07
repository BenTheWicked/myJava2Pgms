/********************************************************************
 * StudentListDriver.java
 * Dean & Dean
 * 
 * This is the driver for the StudentList class. (pg. 674)
 ********************************************************************/
package studentlist;

public class StudentListDriver {
    public static void main(String[] args) {
        String[] names = {"Caleb", "Izumi", "Mary", "Usha"};
        StudentList2 studentList = new StudentList2(names);
        
        studentList.display();
        studentList.removeStudent(6);
        studentList.display();
    }   // end main
}   // end StudentListDriver
