/********************************************************************
 * HourlyEmployees.java
 * Ben Davis
 * 
 * This subclass extends Employee.java
 ********************************************************************/
package employee;

public class HourlyEmployees extends Employee {
    private double payRate;
    private int hoursWorked;
    
    //****************************************************************
    
    public HourlyEmployees()
        { }
    
    public HourlyEmployees(String firstName, String lastName,
            double payRate) {
        super(firstName,lastName);
        this.payRate = payRate;
    }
    
    //***************************************************************
    
    public double getPayRate() {
        return this.payRate;
    }
    
    public int getHoursWorked() {
        return this.hoursWorked;
    }
    
    //***************************************************************
    
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    //****************************************************************
    
    
}
