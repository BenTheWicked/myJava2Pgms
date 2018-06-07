/********************************************************************
 * NumberList.java
 * Dean & Dean
 * 
 * This inputs numbers and calculates their mean value. (pg. 686)
 ********************************************************************/
package numberlist;
import java.util.Scanner;
public class NumberList {
    private int[] numList = new int[100];   // array of numbers
    private int size = 0;                   // number of numbers
    
    //***************************************************************
    
    public void readNumbers() {
        Scanner stdIn = new Scanner(System.in);
        String xStr;        // user-entered number (String form)
        int x;              // user-entered number
        
        System.out.print("Enter a whole number (q to quit): ");
        xStr = stdIn.next();
        
        while (!xStr.equalsIgnoreCase("q")) {
            x = Integer.parseInt(xStr);
            numList[size] = x;
            size++;
            System.out.print("Enter a while number (q to quit): ");
            xStr = stdIn.next();
        }   // end while
    }   // end readNumbers
    
    //**************************************************************
    
    public double getMean() {
        int sum = 0;
        
        for (int i=0; i<size; i++) {
            sum += numList[i];
        }
        return sum / size;
    }   // end getMean
}   // end class NumberList
