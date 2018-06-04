/*******************************************************************
 * Employee.java
 * Ben Davis
 * 
 * This is the superclass for the payrolls project.
 *******************************************************************/
package employee;

public class Employee {
    private String firstName;
    private String lastName;
    
    //****************************************************************
    
    public Employee() 
        { }
    
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //****************************************************************
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    //***************************************************************
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //***************************************************************
    
    public String getFullName() {
        String fullName = getFirstName() + " " + getLastName();
        return fullName;
    }
}
