/*********************************************
* Salaried3.java
* Dean & Dean
*
* This class represents salaried employees.
*********************************************/
package payroll3;
public class Salaried3 extends Employee3
{
  protected double salary;

  //******************************************

  public Salaried3(String name, double salary)
  {
    super(name);
    this.salary = salary;
  } // end constructor

  //******************************************

  @Override
  public double getPay()
  {
    double pay = salary / 26;

    pay -= getFICA(pay);
    return pay;
  } // end getPay
} // end class Salaried3