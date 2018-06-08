/********************************************************************
 * WriteObject.java
 * Dean & Dean
 * 
 * This writes two distinct objects to an object file. (pg. 719)
 ********************************************************************/
package testobject;
import java.util.Scanner;
import java.io.*;           // ObjectOutputStream, FileOutputStream
public class WriteObject {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        TestObject testObject;
        
        System.out.print("Enter filename: ");
        try (ObjectOutputStream fileOut = new ObjectOutputStream(
            new FileOutputStream(stdIn.nextLine()))) {
            testObject = new TestObject(1, "first", 1.0);
            fileOut.writeObject(testObject);
            testObject = new TestObject(2, "second", 2.0);
            fileOut.writeObject(testObject);
        }   // end try and close fileOut automatically
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }   // end catch
    }   // end main
}   // end WriteObject class
