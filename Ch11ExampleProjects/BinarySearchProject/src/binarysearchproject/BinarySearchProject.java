/********************************************************************
 * BinarySearchProject.java
 * Ben Davis
 * 
 * After creating a sorted array, this program uses a recursive
 * binary search (helper method) to find a user-specified element
 * and report its position. A printing method (helper method) uses 
 * a loop to display the array, ask the user for a value, search for
 * the value, and return its position. The program must be able to
 * find a value near the beginning or end of the array or to return
 * a if the number was not found.
 ********************************************************************/
package binarysearchproject;
import java.util.*;             // Scanner
public class BinarySearchProject {
    // Binary Search helper method
    public static int binarySearch(int[] array, int first,
            int last, int target) {
        int mid;                // holder for middle point
        int index;              // returned array position
        
        if (first == last) {    // stopping condition
            if (array[first] == target) {
                index = first;
            }
            else {
                index = -1;
            }
        }
        else {
            mid = (last + first) / 2;
            if (target > array[mid]) {
                first = mid + 1;
            }
            else {
                last = mid;
            }
            index = binarySearch(array, first, last, target);
        }
        return index;
    }
    
    //***************************************************************
    
    // Print helper method
    public static void printArray(int[] array) {
        Scanner stdIn = new Scanner(System.in);
        int target = 0;
        System.out.print("Array contains: ");
        for (int i : array) {
            System.out.printf("%3d", i);
        }
        do {
            System.out.print("\nWhich number should I search for? "
                + "(-1 to stop) ");
            target = stdIn.nextInt();
            if (binarySearch(array, 0, (array.length + 1), target)
                    >= 0) {
                System.out.println(target + " was found in position "
                    + (binarySearch(array, 0, (array.length + 1), target) + 1));
            }
            else if (target == -1) {
                System.out.println("Good bye.");
            }
            else {
                System.out.println("That number was not found.");
            }
        } while (target != -1);
    }
    
    //***************************************************************
    
    public static void main(String[] args) {
        System.out.println("Binary Search by Ben Davis\n");
        int[] array = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45,
            50, 55, 60, 65, 70, 75, 80, 85, 90};
        
        printArray(array);
    }   // end main
    
}   // end BinarySearchProject class
