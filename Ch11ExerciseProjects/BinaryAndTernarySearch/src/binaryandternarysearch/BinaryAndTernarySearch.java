/*******************************************************************
 * BinaryAndTernarySearch.java
 * Ben Davis
 * 
 * This project uses a copy of Sorting.java from Chater 11 Exercise
 * Projects #2. This version counts the number of searches performed
 * and prints it in the findPosition method. The array uses a wider
 * range of random numbers.
 *******************************************************************/
package binaryandternarysearch;
import java.util.*;             // Scanner and Random
public class BinaryAndTernarySearch {
    private static int search;      // number of searches.
    
    //***************************************************************
    
    public static int increment() {
        return search++;
    }
    
    public static int getSearch() {
        int temp = search;
        search = 0;
        return temp;
    }
    
    //***************************************************************
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
    
    //***********************************************************
    
    // Binary Search helper method
    public static int binarySearch(int[] array, int first,
            int last, int target) {
        int mid;                // holder for middle point
        int index;              // returned array position
        increment();
        if (first == last) {    // stopping condition
            if (array[first] == target) {
                index = first;
                //count.increment();
            }
            else {
                index = -1;
                //count.increment();
            }
            //count.increment();
        }
        else {
            mid = (last + first) / 2;
            if (target > array[mid]) {
                first = mid + 1;
                //count.increment();
            }
            else {
                last = mid;
                //count.increment();
            }
            index = binarySearch(array, first, last, target);
        }
        return index;
    }
    
    //***************************************************************
    
    // Ternary search
    
    public static int ternarySearch(int[] array, int first,
            int last, int target) {
        int mid1 = first + (last - first) / 3;
        int mid2 = last - (last - first) / 3;
        int index;
        increment();
        // Stopping condition
        if (first == last) {
            if (array[first] == target) {
                return index = first;
            }
            else {
                return index = -1;
            }
        }
        // Mid conditions
        if (array[mid1] == target) {
            return index = mid1;
        }
        else if (array[mid2] == target) {
            return index = mid2;
        }
        // Search conditions
        if (target < array[mid1]) {
            index = ternarySearch(array, first, mid1 - 1, target);
        }
        else if (target > array[mid2]) {
            index = ternarySearch(array, mid2 + 1, last, target);
        }
        else {
            index = ternarySearch(array, mid1 + 1, mid2 - 1, target);
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
            int index = binarySearch(array, 0, (array.length + 1), target);
            if (index >= 0) {
                System.out.println(target + " was found in position "
                    + index + " after " + getSearch() + " binary searches");
                index = ternarySearch(array, 0, (array.length + 1), target);
                System.out.println(target + " was found in position "
                    + index + " after " + getSearch() + " ternary searches");
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
        int count = 0;
        System.out.println(msg);
        for (int i : array) {
            System.out.printf("%5d", i);
            count++;
            if (count % 15 == 0) {
                System.out.println();
            }
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
            array[i] = random.nextInt(length) * 5 + 1;
        }
        // print initial array
        printArray("Initial array", array);
        // sort and name array
        array = mergeSort(array);
        // print sorted array
        printArray("Sorted array", array);
        // find position
        findPosition(array);
    }   // end main
    
}   // end BinaryAndTernarySearch class
