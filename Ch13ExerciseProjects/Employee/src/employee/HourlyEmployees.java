/********************************************************************
 * HourlyEmployees.java
 * Ben Davis
 * 
 * This subclass extends Employee.java
 ********************************************************************/
package employee;

public class HourlyEmployees extends Employee {
    private double payRate;
    private double hoursWorked;
    
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
    
    public double getHoursWorked() {
        return this.hoursWorked;
    }
    
    //***************************************************************
    
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    //****************************************************************
    
    public double grossPay(double payRate, double hoursWorked) {
        double grossPay = 0.0;
        
        // Calculate overtime
        if (hoursWorked > 40) {
            grossPay += (hoursWorked - 40) * (payRate * 1.5);
        }
        
        grossPay += hoursWorked * payRate;
        return grossPay;
    }
}
