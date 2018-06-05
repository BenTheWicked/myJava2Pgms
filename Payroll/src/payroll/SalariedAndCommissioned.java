/*********************************************************************
 * SalariedAndCommissioned.java
 * Dean & Dean
 * 
 * This class represents salaried and commissioned employees. (pg. 642)
 *********************************************************************/
package payroll;

public class SalariedAndCommissioned extends Salaried implements Commission {
    private double sales;
    
    //*****************************************************************
    
    public SalariedAndCommissioned(String name, double salary) {
        super(name,salary);
    }   // end constructor
    
    //***************************************************************
    
    public void addSales(double sales) {
        this.sales += sales;
    }   // end addSales
    
    //***************************************************************
    
    // Postcondition: This resets sales to zero.
    
    @Override
    public double getPay() {
        double pay = super.getPay() + COMMISSION_RATE * sales;
        
        sales = 0.0;        // reset for next pay period
        return pay;
    }   // end getPay
}   // end class SalariedAndCommissioned
