/********************************************************************
 * BinarySearchDriver.java
 * Dean & Dean
 * 
 * This drives the BinarySearch class. (pg. 489)
 ********************************************************************/
package binarysearch;

public class BinarySearchDriver {
    public static void main(String[] args) {
        int [] array = new int[] {-7, 3, 5, 8, 12, 16, 23, 33, 55};
        
        System.out.println(BinarySearch.binarySearch(
            array, 0, (array.length - 1), 23));
        System.out.println(BinarySearch.binarySearch(
            array, 0, (array.length - 1), 4));
    }   // end main
}   // end BinarySearchDriver class
