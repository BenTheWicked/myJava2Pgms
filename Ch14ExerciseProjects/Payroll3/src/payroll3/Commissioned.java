/****************************************************************
* Commissioned.java
* Dean & Dean
*
* This class represents employees on straight commission.
****************************************************************/
package payroll3;
public class Commissioned extends Employee3 implements Commission
{
  private double sales = 0.0;

  //*************************************************************

  public Commissioned(String name)
  {
    super(name);
    this.sales = sales;
  } // end constructor

  //*************************************************************

  public void addSales(double sales)
  {
    this.sales += sales;
  } // end addSales

  //*************************************************************

  // Postcondition: This resets sales to zero.

  @Override
  public double getPay()
  {
    double pay = COMMISSION_RATE * sales;
    pay -= getFICA(pay);
    //sales = 0.0;
    return pay;
  } // end getPay
} // end class Commissioned