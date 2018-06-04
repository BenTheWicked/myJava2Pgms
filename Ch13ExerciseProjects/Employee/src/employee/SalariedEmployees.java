/********************************************************************
 * SalariedEmployees.java
 * Ben Davis
 * 
 * This is a subclass to Employee.java.
 ********************************************************************/
package employee;

public class SalariedEmployees extends Employee {
    private double annualPay;
    
    //****************************************************************
    
    public SalariedEmployees()
        { }
    
    public SalariedEmployees(String firstName, String lastName,
            double annualPay) {
        super(firstName,lastName);
        this.annualPay = annualPay;
    }
    
    //****************************************************************
    
    public double getAnnualPay() {
        return this.annualPay;
    }
    
    public void setAnnualPay(double annualPay) {
        this.annualPay = annualPay;
    }
    
    public double weeklyPay() {
        double week = getAnnualPay() / 52;
        return week;
    }
}
