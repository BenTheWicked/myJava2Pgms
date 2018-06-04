/**********************************************************************
 * EmployeeDriver.java
 * Ben Davis
 * 
 * The driver for the Employee.java superclass and its subclasses.
 **********************************************************************/
package employee;
import java.util.*;
public class EmployeeDriver {
    public static void main(String[] args) {
        System.out.println("Ch 13 Payroll Project by Ben Davis\n");
        
        Scanner stdIn = new Scanner(System.in);
        ArrayList<HourlyEmployees> staff = new ArrayList<>();
        ArrayList<SalariedEmployees> managers = new ArrayList<>();
        
        managers.add(new SalariedEmployees("Ann","Barrett",52000));
        managers.add(new SalariedEmployees("Frank","Greene",48000));
        staff.add(new HourlyEmployees("Barry","Johnson",12.5));
        staff.add(new HourlyEmployees("Cathy","Davidson",15));
        staff.add(new HourlyEmployees("Dan","Peters",10));
        
        for (HourlyEmployees person : staff) {
            System.out.print("How many hours for employee " + 
                    person.getFullName() + ": ");
            person.setHoursWorked(stdIn.nextDouble());
        }
        
        System.out.println("Payroll Results");
        for (SalariedEmployees person : managers) {
            System.out.printf("\nManager %16s :\t$%7.2f",
                    person.getFullName().toUpperCase(), 
                    person.weeklyPay());
        }
        for (HourlyEmployees person : staff) {
            System.out.printf("\nEmployee %15s :\t$%7.2f\t"
                    + "%2.2f hours,\t$%6.2f/hr",
                    person.getFullName().toUpperCase(),
                    person.grossPay(person.getPayRate(), 
                            person.getHoursWorked()),
                    person.getHoursWorked(), person.getPayRate());
        }
        System.out.println();
    }   // end main
}   // end EmployeeDriver class
