/*********************************************************************
 * FullTime.java
 * Dean & Dean
 * 
 * This class describes a full-time employee. (pg 581)
 *********************************************************************/
package person;

public class FullTime extends Employee {
    private double salary = 0.0;
    
    //*****************************************************************
    
    public FullTime(String name, int id, double salary) {
        super(name, id);    // calls the two-parameter Employee constructor
        this.salary = salary;
    }
    
    //*****************************************************************
    
    @Override
    public void display() {
        super.display();
        System.out.printf("salary: $%,.0f\n", salary);
    }
}   // end FullTime class
