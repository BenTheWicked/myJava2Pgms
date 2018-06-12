/********************************************************************
 * GreetingAnonymous.java
 * Dean & Dean
 * 
 * This program demonstrates an anonymous inner class. (pg. 776-777)
 ********************************************************************/
package greetinganonymous;
import javax.swing.*;       // for JFrame, JLabel, JTextField
import java.awt.*;          // for FlowLayout
import java.awt.event.*;    // for ActionListener, ActionEvent

public class GreetingAnonymous extends JFrame {
    private static final int WIDTH = 325;
    private static final int HEIGHT = 100;
    private JTextField nameBox; // holds user's name
    private JLabel greeting;    // personalized greeting
    
    //***************************************************************
    
    public GreetingAnonymous() {
        setTitle("Greeting Anonymous");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end constructor
    
    //***************************************************************
    
    // Create components and add them to window.
    
    private void createContents() {
        JLabel namePrompt = new JLabel("What's your name?");
        nameBox = new JTextField(15);
        greeting = new JLabel();
        add(namePrompt);
        add(nameBox);
        add(greeting);
        nameBox.addActionListener(
        
            // anonymous inner class for event handling
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String message; // the personalized greeting
                    message = "Glad to meet you, " + nameBox.getText();
                    nameBox.setText("");
                    greeting.setText(message);
                }   // end actionPerformed
            }   // end anonymous inner class
        );  // end addActionListener call
    }   // end createContents
    
    //**************************************************************
    
    public static void main(String[] args) {
        new GreetingAnonymous();
    }   // end main
}   // end class GreetingAnonymous
