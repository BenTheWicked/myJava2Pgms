/************************************************************
* SalariedAndCommissioned.java
* Dean & Dean
*
* This class represents salaried and commissioned employees.
************************************************************/
package payroll3;
public class SalariedAndCommissioned
  extends Salaried3 implements Commission
{

  private double sales;

  //*********************************************************

  public SalariedAndCommissioned(String name, double salary)
  {
    super(name, salary);
  } // end constructor

  //*********************************************************

  public void addSales(double sales)
  {
    this.sales += sales;
  } // end addSales

  //*********************************************************

  // Postcondition: This resets sales to zero.

  @Override
  public double getPay()
  {
	// get pay for salary portion, includes FICA tax  
    double pay = super.getPay();  
	// get pay for commission portion
	double commPay = COMMISSION_RATE * sales;
	// need to calculate FICA tax on commPay
	double commTax = getFICA(commPay);
	// remove FICA tax from commPay
	commPay -= commTax;
	// add the salary pay and the commission pay
	pay += commPay;
	sales = 0.0; // reset for next pay period
    return pay;
  } // end getPay
} // end class SalariedAndCommissioned