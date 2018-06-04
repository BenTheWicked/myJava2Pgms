/*********************************************************************
 * SalesPerson.java
 * Dean & Dean
 * 
 * This class implements a car salesperson. (pg. 571)
 *********************************************************************/
package Dealership;
public class SalesPerson {
    private String name;
    private double sales = 0.0; // sales to date
    
    //*****************************************************************
    
    public SalesPerson(String name) {
        this.name = name;
    }
    
    //*****************************************************************
    
    public String getName() {
        return name;
    }
}   // end SalesPerson class
