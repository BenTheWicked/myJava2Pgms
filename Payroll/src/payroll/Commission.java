/*********************************************************************
 * Commission.java
 * Dean & Dean
 * 
 * This interface specifies a common attribute
 * and declares common behavior of commissioned employees. (pg. 640)
 *********************************************************************/
package payroll;

interface Commission {
    double COMMISSION_RATE = 0.10;
    
    void addSales(double sales);
}   // end interface Commission
