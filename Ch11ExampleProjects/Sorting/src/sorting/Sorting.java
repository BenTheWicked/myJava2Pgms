/*******************************************************************
 * Sorting.java
 * Ben Davis
 * 
 * This program creates a randomly filled int array and then sorts
 * it using a merge sort. It uses a copy of BinarySearchProject.java.
 * A merge sort method (helper) needs to sort the random array and
 * return that array to the original. The binary search from the
 * copied project should not have to change.
 *******************************************************************/
package sorting;
import java.util.*;             // Scanner
public class Sorting {
    // mergeSort method from textbook
    public static int[] mergeSort(int[] array) {
        int half1 = array.length / 2;
        int half2 = array.length - half1;
        int[] sub1 = new int[half1];
        int[] sub2 = new int[half2];
        
        if (array.length <= 1) {
            return array;
        }
        else {
            System.arraycopy(array, 0, sub1, 0, half1);
            System.arraycopy(array, half1, sub2, 0, half2);
            sub1 = mergeSort(sub1);
            sub2 = mergeSort(sub2);
            array = merge(sub1, sub2);
            return array;
        }
    }   // end mergeSort
    
    //************************************************************
    
    // merge method from textbook
    public static int[] merge(int[] sub1, int[] sub2) {
        int[] array = new int[sub1.length + sub2.length];
        int i1 = 0, i2 = 0;
        
        for (int i=0; i<array.length; i++) {
            // both subgroups have elements
            if (i1 < sub1.length && i2 < sub2.length) {
                if (sub1[i1] <= sub2[i2]) {
                    array[i] = sub1[i1];
                    i1++;
                }
                else {              // sub2[i2] < sub1 [i1]
                    array[i] = sub2[i2];
                    i2++;
                }
            }   // end both subgroups have elements
            // only one subgroup has elements
            else {
                if (i1 < sub1.length) {
                    array[i] = sub1[i1];
                    i1++;
                }
                else {              // i2 < sub2.length
                    array[i] = sub2[i2];
                    i2++;
                }
            }   // end only one subgroup has elements
        }   // end for all array elements
        return array;
    }
    
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
    public static void findPosition(int[] array) {
        Scanner stdIn = new Scanner(System.in);
        int target = 0;
        
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
    // printing method
    public static void printArray(String msg, int[] array) {
        System.out.println(msg);
        for (int i : array) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }   // end printArray
    
    //***************************************************************
    
    public static void main(String[] args) {
        System.out.println("Sorting by Ben Davis\n");
        Random random = new Random();
        Scanner stdIn = new Scanner(System.in);
        System.out.print("How big is this array? ");
        int length = stdIn.nextInt();
        int[] array = new int[length];
        for (int i=0; i<length; i++) {
            array[i] = random.nextInt(length) + 1;
        }
        // print initial array
        printArray("Initial array", array);
        // sort and name array
        array = mergeSort(array);
        // print sorted array
        printArray("Sorted array", array);
    }   // end main
    
}   // end BinarySearchProject class
