/********************************************************************
 * Person.java
 * Dean & Dean
 * 
 * This is a base class for an inheritance hierarchy. (pg. 577)
 ********************************************************************/
package person;

public class Person {
    private String name = "";
    
    //****************************************************************
    
    public Person() // zero-parameter default constructor
        { }
    
    public Person(String name) {
        this.name = name;
    }
    
    //****************************************************************
    
    public String getName() {
        return this.name;
    }
}   // end Person class
