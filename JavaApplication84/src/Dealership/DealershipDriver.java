/**********************************************************************
 * DealershipDriver.java
 * Dean & Dean
 * 
 * This class demonstrates the car dealership composition. (pg. 572)
 **********************************************************************/
package Dealership;

public class DealershipDriver {
    public static void main(String[] args) {
        Manager ryne = new Manager("Ryne Mendez");
        SalesPerson nicole = new SalesPerson("Nicole Betz");
        SalesPerson vince = new SalesPerson("Vince Sola");
        Dealership dealership = new Dealership("OK Used Cars", ryne);
        
        dealership.addPerson(nicole);
        dealership.addPerson(vince);
        dealership.addCar(new Car("GMC"));
        dealership.addCar(new Car("Yugo"));
        dealership.addCar(new Car("Dodge"));
        dealership.printStatus();
    }   // end main
}   // end DealershipDriver class
