/********************************************************************
 * VehicleDriver.java
 * Ben Davis
 * 
 * Driver class for the Vehicle.java parent class and its subclasses.
 ********************************************************************/
package vehicle;
import java.util.*;
public class VehicleDriver {
    public static void main(String[] args) {
        System.out.println("Ch 13 Auto Lot by Ben Davis\n");
        
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<Van> vans = new ArrayList<>();
        Scanner stdIn = new Scanner(System.in);
        
        Car c1 = new Car("Honda","Civic",12345,"silver",2010,75000,2,true);
        Car c2 = new Car("BMW","316i", 12346,"blue",1997,126000,4,false);
        cars.add(c1);
        cars.add(c2);
        
        Truck t1 = new Truck("Ford","F150",12347,"red",2014,56000,12,true);
        Truck t2 = new Truck("Datsun","pickup",12348,"black",1995,250000,8,false);
        trucks.add(t1);
        trucks.add(t2);
        
        Van v1 = new Van("Honda","Odyssey",12349,"blue",2005,174000,2,true);
        Van v2 = new Van("Pontiac","Montana",12350,"white",1999,158000,1,false);
        vans.add(v1);
        vans.add(v2);
        System.out.print("Are you interested in cars (C), trucks (T),"
                + " or vans (V): ");
        String choice = stdIn.nextLine();
        switch (choice) {
            case "c": case "C":
                for (Car car : cars) {
                    System.out.println(car.display());
                }
                break;
            case "t": case "T":
                for (Truck truck : trucks) {
                    System.out.println(truck.display());
                }
                break;
            case "v": case "V":
                for (Van van : vans) {
                    System.out.println(van.display());
                }
                break;
            default:
                System.out.println("I did not understand. Goodbye.");
        }
    }
}
