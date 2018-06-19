/*******************************************************************
 * MathCalculator.java
 * Dean & Dean
 * 
 * This program uses embedded layout managers to display the square
 * root and logarithm of a user-entered number. (pgs. 838-840)
 *******************************************************************/
package mathcalculator;
// for JFrame, JButton, JTextField, JLabel, and JPanel
import javax.swing.*;
import java.awt.*;          // for GridLayout and FlowLayout
import java.awt.event.*;    // for ActionListener and ActionEvent

public class MathCalculator extends JFrame {
    private static final int WIDTH = 380;
    private static final int HEIGHT = 110;
    
    private JTextField xBox;        // user's input value
    private JTextField xSqrtBox;    // generated square root
    private JTextField xLogBox;     // generated logarithm
    
    //***************************************************************
    
    public MathCalculator() {
        setTitle("Math Calculator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end MathCalculator constructor
    
    //***************************************************************
    
    // Create components and add to window.
    
    private void createContents() {
        JPanel xPanel;      // holds x label and its text box
        JPanel xSqrtPanel;  // holds "sqrt x" label and its text box
        JPanel xLogPanel;   // holds "log x" label and its text box
        JLabel xLabel;
        JButton xSqrtButton;
        JButton xLogButton;
        Listener listener;
        
        setLayout(new GridLayout(2, 2));
        
        // Create the x panel:
        xLabel = new JLabel("x:");
        xBox = new JTextField(8);
        xPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        xPanel.add(xLabel);
        xPanel.add(xBox);
        
        // Create the square-root panel:
        xSqrtButton = new JButton("sqrt x");
        xSqrtBox = new JTextField(8);
        xSqrtBox.setEditable(false);
        xSqrtPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        xSqrtPanel.add(xSqrtButton);
        xSqrtPanel.add(xSqrtBox);
        
        // Create the logarithm panel:
        xLogButton = new JButton("log10 x");
        xLogBox = new JTextField(8);
        xLogBox.setEditable(false);
        xLogPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        xLogPanel.add(xLogButton);
        xLogPanel.add(xLogBox);
        
        // Add panels to the windows:
        add(xPanel);
        add(xSqrtPanel);
        add(new JLabel());  // dummy component
        add(xLogPanel);
        
        listener = new Listener();
        xSqrtButton.addActionListener(listener);
        xLogButton.addActionListener(listener);
    }   // end createContents
    
    //***************************************************************
    
    // Inner class for math calculations.
    
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double x;       // numeric value for user entered x
            double result;  // calculated value
            
            try {
                x = Double.parseDouble(xBox.getText());
            }
            catch (NumberFormatException nfe) {
                x = -1;     // indicates an invalid x
            }
            
            if (e.getActionCommand().equals("sqrt x")) {
                if (x < 0) {
                    xSqrtBox.setText("undefined");
                }
                else {
                    result = Math.sqrt(x);
                    xSqrtBox.setText(String.format("%7.5f", result));
                }
            }   // end if
            
            else {
                if (x < 0) {
                    xLogBox.setText("undefined");
                }
                else {
                    result = Math.log10(x);
                    xLogBox.setText(String.format("%7.5f", result));
                }
            }   // end else
        }   // end actionPerformed
    }   // end class Listener
    
    //**************************************************************
    
    public static void main(String[] args) {
        new MathCalculator();
    }   // end main
}   // end class MathCalculator
