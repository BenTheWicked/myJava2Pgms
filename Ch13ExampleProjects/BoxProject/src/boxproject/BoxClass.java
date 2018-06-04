/*********************************************************************
 * BoxClass.java
 * Ben Davis
 * 
 * This class extends the BoxProject.java class
 *********************************************************************/
package boxproject;

public class BoxClass extends BoxProject {
    private double height;          // Height instance variable
    
    //*****************************************************************
    
    public BoxClass() {
        super();
        this.height = 1.0;
    }
    
    public BoxClass(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }
    
    //****************************************************************
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getHeight() {
        return this.height;
    }
    //****************************************************************
    public double volume(double length, double width, double height) {
        double volume = length * width * height;
        return volume;
    }
    
    //****************************************************************
    
    public boolean isCube(double length, double width, double height) {
        if (length == width && length == height) {
            return true;
        }
        return false;
    }
    
    //****************************************************************
    
    public String display() {
        String out = "Box dimensions: " + this.getLength() + " x " +
                this.getWidth() + " x " + this.getHeight() + "\n" +
                "This box is " + 
                (this.isCube(getLength(), getWidth(), getHeight())
                ? "a cube" : "not a cube") + "\n" +
                "Volume: " + this.volume(getLength(), getWidth(), 
                        getHeight());
        return out;
    }
}
