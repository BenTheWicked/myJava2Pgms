/********************************************************************
 * Ch15TestExceptions.java
 * Ben Davis
 * 
 * This program is copied from example code provided by the
 * instructors. The student must explain what happened and why.
 ********************************************************************/
package ch15testexceptions;

public class Ch15TestExceptions {
    private String[] value = new String[] {"A", "B", "C", "D", "E", "F"};
    private int num;
    
    public String eval(String n1, String n2) throws IndexOutOfBoundsException {
        System.out.println("in EVAL with " + n1 + " and " + n2);
        try {
            num = Integer.parseInt(n1) / Integer.parseInt(n2);
        }
        catch (NumberFormatException nfe) {
            num++;
            System.out.println("in first catch, nfe");
        }
        catch (ArithmeticException ae) {
            num++;
            System.out.println("in second catch, ae");
        }
        System.out.println("about to return, num = " + num);
        return value[num];
    }
    
    public static void main(String[] args) {
        Ch15TestExceptions te = new Ch15TestExceptions();
        try {
            System.out.println(te.eval("33", "5"));
            System.out.println(te.eval("5.0", "4"));
            System.out.println(te.eval("5", "0"));
            System.out.println(te.eval("22", "5"));
        }
        catch (Exception e) {
            System.out.println("in main's catch");
        }
        System.out.println("bye");
    }
    
}
