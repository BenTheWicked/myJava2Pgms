/********************************************************************
 * Hourly.java
 * Dean & Dean
 * 
 * This class implements an employee paid by the hour. (pg. 635)
 ********************************************************************/
package payroll;

public class Hourly extends Employee2{
    private double hourlyRate;
    private double hours = 0.0;
    
    //****************************************************************
    
    public Hourly(String name, double rate) {
        super(name);
        hourlyRate = rate;
    }   // end constructor
    
    //****************************************************************
    
    // Postcondition: This resets hours to zero.
    
    @Override
    public double getPay() {
        double pay = hourlyRate * hours;
        hours = 0.0;
        return pay;
    }   // end getPay
    
    //***************************************************************
    
    public void addHours(double hours) {
        this.hours += hours;
    }   // end addHours
}   // end class Hourly
