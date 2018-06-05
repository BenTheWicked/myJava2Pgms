/*********************************************************************
 * Employee2.java
 * Dean & Dean
 * 
 * This abstract class describes employees. (pg. 636)
 *********************************************************************/
package payroll;

public abstract class Employee2 {
    private String name;
    public abstract double getPay();
    
    //*****************************************************************

    public Employee2(String name) {
        this.name = name;
    }

    //****************************************************************

    public void printPay(int date) {
        System.out.printf("%2d %10s: %8.2f\n", date, name, getPay());
    }   // end printPay
}   // end class Employee2
