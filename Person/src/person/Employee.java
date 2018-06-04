/**********************************************************************
 * Employee.java
 * Dean & Dean
 * 
 * This class describes an employee. (pg. 578)
 **********************************************************************/
package person;

public class Employee extends Person {      // note extends keyword
    private int id = 0;
    
    //******************************************************************
    
    public Employee()
        { }
    
    public Employee(String name, int id) {
        super(name);        // calls the one-parameter Person constructor
        this.id = id;
    }
    
    //*****************************************************************
    
    public void display() {
        System.out.println("name: " + getName());   // no referencing prefix
        System.out.println("id: " + id);
    }
}   // end Employee class
