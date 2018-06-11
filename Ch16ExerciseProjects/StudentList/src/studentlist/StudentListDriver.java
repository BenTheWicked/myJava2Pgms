/********************************************************************
 * StudentListDriver.java
 * Ben Davis
 * 
 * Started from pg. 674 in text.
 ********************************************************************/
package studentlist;
import java.util.Scanner;
import java.io.*;
public class StudentListDriver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String[] names = {"Caleb", "Izumi", "Mary", "Usha"};
        String fileName;
        StudentList studentList = new StudentList(names);
        StudentList studentList2, studentList3;
        
        System.out.println("Chapter 16 Objects in Files by "
                + "Ben Davis\n");
        System.out.print("Enter filename: ");
        fileName = stdIn.nextLine();
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            fileName = fileName + ".txt";
        }
        
        // Set up IO
        try (ObjectOutputStream fileOut = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            System.out.println("List 1:");
            studentList.display();
            fileOut.writeObject(studentList);
            fileOut.reset();
            
            studentList2 = studentList;
            System.out.println("List 2: added some names");
            studentList2.addStudent("Anna");
            studentList2.addStudent("James");
            studentList2.addStudent("Noah");
            studentList2.display();
            fileOut.writeObject(studentList2);
            fileOut.reset();
            
            studentList3 = studentList2;
            System.out.println("List 3: removed some names");
            studentList3.removeStudent(1);
            studentList3.removeStudent(3);
            studentList3.display();
            fileOut.writeObject(studentList3);
            fileOut.reset();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream fileIn = new ObjectInputStream(
                new FileInputStream(fileName))) {
            System.out.println("\nResults of reading objects from file");
            studentList = (StudentList) fileIn.readObject();
            studentList.display();
            studentList2 = (StudentList) fileIn.readObject();
            studentList2.display();
            studentList3 = (StudentList) fileIn.readObject();
            studentList3.display();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
