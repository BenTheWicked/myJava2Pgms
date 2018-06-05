/********************************************************************
 * Pets.java
 * Dean & Dean
 * 
 * This illustrates simple polymorphism. (pg. 626)
 ********************************************************************/
package pets;
import java.util.Scanner;
public class Pets {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Object obj;
        
        System.out.print("Which type of pet do you prefer?\n" +
                "Enter d for dogs and c for cats: ");
        if (stdIn.next().equals("d")) {
            obj = new Dog();
        }
        else {
            obj = new Cat();
        }
        System.out.println(obj.toString());
        System.out.println(obj);
    }   // end main
    
}   // end Pets class
