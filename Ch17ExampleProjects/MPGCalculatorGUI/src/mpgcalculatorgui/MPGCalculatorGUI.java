/********************************************************************
 * MPGCalculatorGUI.java
 * Ben Davis
 * 
 * This program improves the EnhancedMPG.java and EnhancedMPG.java
 * programs by giving it a GUI.
 ********************************************************************/
package mpgcalculatorgui;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MPGCalculatorGUI extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 150;
    private JTextField milesBox;    // holds miles
    private JTextField gallonsBox;  // holds gallons
    private JTextField mpgBox;      // holds mpg
    
    public MPGCalculatorGUI() {
        setTitle("MPG Calculator by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
    }   // end constructor
    
    //***************************************************************
    
    // Create components and add them to window.
    private void createContents() {
        JLabel milesPrompt = new JLabel("How many miles?");
        milesBox = new JTextField(15);
        JLabel gallonsPrompt = new JLabel("How many gallons?");
        gallonsBox = new JTextField(15);
        JButton btn = new JButton("Calculate");
        btn.setBackground(Color.GREEN);
        mpgBox = new JTextField(15);
        Listener listener = new Listener();
        
        mpgBox.setEditable(false);
        add(milesPrompt);
        add(milesBox);
        add(gallonsPrompt);
        add(gallonsBox);
        add(btn);
        add(mpgBox);
        gallonsBox.addActionListener(listener);
        btn.addActionListener(listener);
    }   // end createContents
    
    //****************************************************************
    
    //Inner class for event handling.
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double miles, gallons, mpg;
            
            try {
                miles = Double.parseDouble(milesBox.getText());
            }
            catch (NumberFormatException nfe) {
                miles = -1;
            }
            try {
                gallons = Double.parseDouble(gallonsBox.getText());
            }
            catch (NumberFormatException nfe) {
                gallons = -1;
            }
            
            if (miles < 0.0 || gallons < 0.0) {
                mpgBox.setText("does not compute");
            }
            else {
                DecimalFormat mpgOut = new DecimalFormat("##.##");
                mpg = miles / gallons;
                mpgBox.setText("MPG=" + mpgOut.format(mpg));
            }
        }
    }
    public static void main(String[] args) {
        new MPGCalculatorGUI();
    }
}
