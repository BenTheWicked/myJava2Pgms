/**********************************************************************
 * Employee.java
 * Dean & Dean
 * 
 * This is a generic description of an employee. (pg. 633)
 **********************************************************************/
package payroll;

public class Employee {
    private String name;
    
    //******************************************************************
    
    public Employee(String name) {
        this.name = name;
    }
    
    //****************************************************************
    
    public void printPay(int date) {
        System.out.printf("%2d %10s: %8.2f\n", date, name, getPay());
    }   // end printPay
    
    //****************************************************************
    
    // This dummy method satisfies the compiler.
    
    public double getPay() {
        System.out.println("error! in dummy");
        return 0.0;
    }   // end getPay
}   // end class Employee
