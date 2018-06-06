/**************************************************************
* Payroll3.java
* Dean & Dean
*
* This class hires and pays four different types of employees.
**************************************************************/
package payroll3;
public class Payroll3
{
  public static void main(String[] args)
  {
    Employee3[] employees = new Employee3[100];
    Hourly2 hourly;
    employees[0] = new Hourly2("Anna", 25.0, 80);
    employees[1] = new Hourly2("Robert", 24.0, 80);
    employees[2] = new Hourly2("Donovan", 20.0, 80);
    employees[3] = new Salaried3("Simon", 48000);
    employees[4] = new Salaried3("Joan", 44000);
    employees[5] = new Commissioned("Glen");
    employees[6] = new Commissioned("Mary");
    employees[7] = new SalariedAndCommissioned("Carol", 24000);
    employees[8] = new SalariedAndCommissioned("Mark", 20000);
    double totalPay = 0.0;      // catches totalPay
    double pay = 0.0;           // catches one person's pay

    ((Commission) employees[5]).addSales(15000);
    ((Commission) employees[6]).addSales(15000);
    ((Commission) employees[7]).addSales(8000);
    ((Commission) employees[8]).addSales(8000);
    
    System.out.println("Chapter 14 Payroll by Ben Davis\n");

    for (int i=0;
        i<employees.length && employees[i] != null; i++)
        {
            totalPay += pay = employees[i].getPay();
            employees[i].printPay(pay);
        } // end for i
    System.out.printf("%10s : $%,10.2f\n",
            "Total pay", totalPay);
  } // end main
} // end class Payroll3