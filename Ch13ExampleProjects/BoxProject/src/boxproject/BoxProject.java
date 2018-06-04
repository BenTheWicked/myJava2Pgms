/*********************************************************************
 * BoxProject.java
 * Ben Davis
 * 
 * This project copies Rectangle.java from Chapter 6 and creates an
 * subclass for boxes.
 *********************************************************************/
package boxproject;
import java.util.Scanner;
public class BoxProject {
    Scanner stdIn = new Scanner(System.in);
    private double length;         // Length instance variable
    private double width;          // Width instance variable
    
    //****************************************************************
    
    public BoxProject() {
        this.length = 1.0;
        this.width = 1.0;
    }
    
    public BoxProject(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    //******************************************************
    
    public void setLength(double length) {
        this.length = length;
    }   // end setLength
    
    //*******************************************************
    
    public void setWidth(double width) {
        this.width = width;
    }   // end setWidth
    
    //********************************************************
    
    public double getLength() {
        return this.length;
    }   // end getLength
    
    //*******************************************************
    
    public double getWidth() {
        return this.width;
    }   // end getWidth
    
    //*******************************************************
    
    public Boolean isSquare() {
        if (this.length == this.width) {
            return true;
        }   // end if
        return false;
    }   // end isSquare
    
    //********************************************************
    
    public double perimeter(double length, double width) {
        double perimeter = 2 * (length + width);
        //System.out.println("Perimeter: " + perimeter);
        return perimeter;
    }   // end perimeter
    
    //********************************************************
    
    public double area(double length, double width) {
        double area = length * width;
        //System.out.println("Area: " + area);
        return area;
    }   // end area
    
    //***************************************************************
    
    public String display() {
        String out = "Rectangle dimensions: " + this.length +
                " x " + this.width + "\n" +
                "This rectangle is " + 
                (this.isSquare() ? "a square" : "not a square") + "\n" +
                "Perimeter: " + this.perimeter(length, width) + "\n" +
                "Area: " + this.area(length, width) + "\n";
        return out;
    }
}   // end class Rectangle