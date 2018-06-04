/*********************************************************************
 * BoxProjectDriver.java
 * Ben Davis
 * 
 * Driver code for BoxProject.java
 *********************************************************************/
package boxproject;

public class BoxProjectDriver {
    public static void main(String[] args) {
        System.out.println("Ch 13 Box Project by Ben Davis");
        
        BoxProject r1 = new BoxProject(10.1,10.1);
        BoxProject r2 = new BoxProject();
        r2.setLength(3.2);
        r2.setWidth(7);
        
        System.out.println("\nObject 1:");
        System.out.println(r1.display());
        
        System.out.println("\nObject 2:");
        System.out.println(r2.display());
        
        BoxClass b1 = new BoxClass();
        BoxClass b2 = new BoxClass(7.7,7.7,7.7);
        b1.setLength(1.2);
        b1.setWidth(3.4);
        b1.setHeight(5.6);
        
        System.out.println("\nBox1:");
        System.out.println(b1.display());
        
        System.out.println("\nBox2:");
        System.out.println(b2.display());
    }
}
