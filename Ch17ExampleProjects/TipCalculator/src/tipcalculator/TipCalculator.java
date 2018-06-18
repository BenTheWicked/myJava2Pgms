/********************************************************************
 * TipCalculator.java
 * Ben Davis
 * 
 * This program calculates the tip values for the cost of a meal.
 ********************************************************************/
package tipcalculator;
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TipCalculator extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 150;
    private JTextField mealBox;
    private JTextField tipBox;
    private JButton btn10, btn15, btn20;
    
    //***************************************************************
    
    public TipCalculator() {
        setTitle("Tip Calculator by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }   // end constructor
    
    //***************************************************************
    
    // Create components and add them to window.
    private void createContents() {
        JLabel mealPrompt = new JLabel("How much did the meal cost?");
        mealBox = new JTextField(15);
        btn10 = new JButton("10% tip");
        btn10.setBackground(Color.CYAN);
        btn15 = new JButton("15% tip");
        btn15.setBackground(Color.CYAN);
        btn20 = new JButton("20% tip");
        btn20.setBackground(Color.CYAN);
        tipBox = new JTextField(15);
        Listener listener = new Listener();
        tipBox.setEditable(false);
        
        add(mealPrompt);
        add(mealBox);
        add(btn10);
        add(btn15);
        add(btn20);
        add(tipBox);
        btn10.addActionListener(listener);
        btn15.addActionListener(listener);
        btn20.addActionListener(listener);
    }   // end createContents
    
    //***************************************************************
    
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double meal, tip;
            NumberFormat money = NumberFormat.getCurrencyInstance();
            try {
                meal = Double.parseDouble(mealBox.getText());
                if (e.getSource() == btn10) {
                    tip = meal * .10;
                    tipBox.setText("Tip=" + money.format(tip));
                }
                else if (e.getSource() == btn15) {
                    tip = meal * .15;
                    tipBox.setText("Tip=" + money.format(tip));
                }
                else {
                    tip = meal * .2;
                    tipBox.setText("Tip=" + money.format(tip));
                }
            }
            catch (NumberFormatException nfe) {
                tipBox.setText("Please enter a valid amount.");
            }   // end try-catch
        }   // end actionPerformed
    }   // end Listener
    
    //**************************************************************
    
    public static void main(String[] args) {
        new TipCalculator();
    }   // end main
}   // end class TipCalculator
