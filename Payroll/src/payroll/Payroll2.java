/*********************************************************************
 * Payroll2.java
 * Dean & Dean
 * 
 * This class hires and pays four different types of employees. (pg. 643)
 *********************************************************************/
package payroll;

public class Payroll2 {
    public static void main(String[] args) {
        Employee2[] employees = new Employee2[100];
        Hourly hourly;
        employees[0] = new Hourly("Anna", 25.0);
        employees[1] = new Salaried("Simon", 48000);
        employees[2] = new Hourly("Donovan", 20.0);
        employees[3] = new Commissioned("Glen");
        employees[4] = new SalariedAndCommissioned("Carol", 24000);
        
        ((Commission) employees[3]).addSales(15000);
        ((Commission) employees[4]).addSales(15000);
        
        // This arbitarily assumes that the payroll's month
        // starts on a Tuesday (day = 2), and it contains 30 days.
        for (int date=1,day=2; date<=30; date++,day++,day%=7) {
            for (int i=0; i<employees.length && employees[i] != null;
                    i++) {
                if (day > 0 && day < 6
                        && employees[i] instanceof Hourly) {
                    hourly = (Hourly) employees[i];
                    hourly.addHours(8);
                }
                if ((day == 5 && employees[i] instanceof Hourly) ||
                        (date%15 == 0 &&
                        (employees[i] instanceof Salaried ||
                                employees[i] instanceof Commissioned))) {
                    employees[i].printPay(date);
                }
            }   // end for i
        }   // end for date
    }   // end main
}   // end class Payroll2
