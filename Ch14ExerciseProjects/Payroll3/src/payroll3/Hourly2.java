/****************************************************
* Hourly2.java
* Dean & Dean
*
* This class implements an employee paid by the hour.
****************************************************/
package payroll3;
public class Hourly2 extends Employee3
{
  private double hourlyRate;
  private double hours = 0.0;

  //*************************************************

  public Hourly2(String name, double rate, double hours)
  {
    super(name);
    hourlyRate = rate;
    this.hours = hours;
  } // end constructor

  //*************************************************

  public double getPay()
  {
    double pay = hourlyRate * hours;
    pay -= getFICA(pay);
    hours = 0.0;
    return pay;
  } // end getPay

  //*************************************************

  public void addHours(double hours)
  {
    this.hours += hours;
  } // end addHours
} // end class Hourly2