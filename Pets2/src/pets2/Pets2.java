/********************************************************************
 * Pets2.java
 * Dean & Dean
 * 
 * This illustrates use of the instanceof operator. (pg. 627)
 ********************************************************************/
package pets2;
import java.util.Scanner;
public class Pets2 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Object obj;
        
        System.out.print("Which type of pet do you prefer?\n" +
                "Enter d for dogs or c for cats: ");
        if (stdIn.next().equals("d")) {
            obj = new Dog();
        }
        else {
            obj = new Cat();
        }
        if (obj instanceof Dog) {
            System.out.println("Wag tail");
        }
    }   // end main
    
}   // end Pets2 class
