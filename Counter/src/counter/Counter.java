/*********************************************************************
 * Counter.java
 * Dean & Dean
 * 
 * This creates a counter and displays its count value. (pg. 621)
 *********************************************************************/
package counter;

public class Counter {
    private int count;
    
    //*****************************************************************
    
    public Counter(int count) {
        this.count = count;
    }   // end constructor
    
    //****************************************************************
    
    @Override
    public String toString() {
        return Integer.toString(count);
    }   // end toString
    
    //****************************************************************
    
    public static void main(String[] args) {
        Counter counter = new Counter(100);
        String message = "Current count = " + counter;
        System.out.println(message);
    }   // end main
    
}   // end class Counter
