/*********************************************************************
 * CityTravel.java
 * Dean & Dean
 * 
 * This class prints the distance between two cities. (pg. 549)
 *********************************************************************/
package city;

public class CityTravel {
    public static void main(String[] args) {
        final double KM_TO_MILES = 0.62137; // conversion factor
        City origin = City.PARKVILLE;
        City destination = City.KINGSTON;
        double distance = origin.getDistance(destination);  // in km
        
        System.out.printf("%s to %s: %.1f km, or %.1f miles",
                origin, destination, distance, distance * KM_TO_MILES);
        System.out.println();
    }   // end main
}   // end CityTravel
