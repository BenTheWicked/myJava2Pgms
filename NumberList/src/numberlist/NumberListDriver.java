/********************************************************************
 * NumberListDriver.java
 * Dean & Dean
 * 
 * This is the driver for the NumberList class.
 ********************************************************************/
package numberlist;

public class NumberListDriver {
    public static void main(String[] args) {
        NumberList list = new NumberList();
        list.readNumbers();
        System.out.println("Mean = " + list.getMean());
    }   // end main
}   // end class NumberListDriver
