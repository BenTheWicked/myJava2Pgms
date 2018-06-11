/********************************************************************
 * ReadObject.java
 * Dean & Dean
 * 
 * This reads all objects in an object file. (pg. 720)
 ********************************************************************/
package testobject;
import java.util.Scanner;
// for ObjectInputStream, FileInputStream, and EOFException
import java.io.*;
public class ReadObject {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        TestObject testObject;
        
        System.out.print("Enter filename: ");
        try (ObjectInputStream fileIn = new ObjectInputStream(
            new FileInputStream(stdIn.nextLine()))) {
            while (true) {
                testObject = (TestObject) fileIn.readObject();
                testObject.display();
            }
        }   // end try and close fileIn automatically
        catch (EOFException e)
        {}  // end-of-file exception terminates infinite while loop
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }   // end main
}   // end ReadObject class
