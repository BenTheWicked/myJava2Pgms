/********************************************************
* Commission.java
* Dean & Dean
*
* This inteface specifies a common attribute
* and declares common behavior of commissioned employees.
********************************************************/

interface Commission
{
  double COMMISSION_RATE = 0.10;

  void addSales(double sales);
} // end interface Commission