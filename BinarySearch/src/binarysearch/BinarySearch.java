/********************************************************************
 * BinarySearch.java
 * Dean & Dean
 * 
 * This uses recursion to find the index of a target value in an
 * ascending sorted array. If not found, the result is -1. (pg. 488)
 ********************************************************************/
package binarysearch;

public class BinarySearch {

    public static int binarySearch(int [] arr, int first,
            int last, int target) {
        int mid;
        int index;
        
        System.out.printf("first=%d, last=%d\n", first, last);
        if (first == last) {         // stopping condition
            if (arr[first] == target) {
                index = first;
                System.out.println("Found");
            }
            else {
                index = -1;
                System.out.println("not found");
            }
        }
        else {                       // continue recursion
            mid = (last + first) / 2;
            if (target > arr[mid]) {
                first = mid + 1;
            }
            else {
                last = mid;
            }
            index = binarySearch(arr, first, last, target);
            System.out.println("returnedValue=" + index);
        }
        return index;
    }   // end binarySearch
    
}   // end BinarySearch class
