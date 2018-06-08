/********************************************************************
 * TestObject.java
 * Dean & Dean
 * 
 * A typical heterogeneous object. (pg. 718)
 ********************************************************************/
package testobject;
import java.io.Serializable;
public class TestObject implements Serializable {
    private int id;
    private String text;
    public double number;   // This variable's access is public!
    
    //****************************************************************
    
    public TestObject(int id, String text, double number) {
        this.id = id;
        this.text = text;
        this.number = number;
    }   // end constructor
    
    //****************************************************************
    
    public void display() {
        System.out.print(this.id + "\t");
        System.out.print(this.text + "\t");
        System.out.println(this.number);
    }   // end display
}   // end TestObject class
