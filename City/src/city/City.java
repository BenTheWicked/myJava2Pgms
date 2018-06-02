/*******************************************************************
 * City.java
 * Dean & Dean
 * 
 * This enumerated type provides location properties of cities.
 * (pg. 547 - 548)
 *******************************************************************/
package city;

public enum City {
    PARKVILLE (39.2, -94.7),        // USA
    HAVANA (23.1, -82.4),           // Cuba
    KINGSTON (18.0, -76.8),          // Jamaica
    NASSAU (25.1, -77.3),           // Bahamas
    SAINT_THOMAS (18.3, -64.9);     // Virgin Islands
    
    // location of the city in degrees
    public final double latitude;
    public final double longitude;
    
    private City(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    //**************************************************************
    
    // This method returns the distance in km between two cities.
    
    public double getDistance(City destination) {
        final double R = 6371;  // approximate mean radius of Earth in km
        
        double lat1, lon1;  // latitude and longitude of origin city
        double lat2, lon2;  // latitude and longitude of destination city
        double a;       // intermediate value used in haversine formula
        
        // upcoming trig functions work with radians, not degrees
        lat1 = Math.toRadians(this.latitude);
        lon1 = Math.toRadians(this.longitude);
        lat2 = Math.toRadians(destination.latitude);
        lon2 = Math.toRadians(destination.longitude);
        
        a = Math.pow(Math.sin((lat2 - lat1) / 2), 2) +
                Math.pow(Math.sin((lon2 = lon1) / 2), 2) *
                Math.cos(lat1) * Math.cos(lat2);
        
        return (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))) * R;
    }   // end getDistance
}   // end City
