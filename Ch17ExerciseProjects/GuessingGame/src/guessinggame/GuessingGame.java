/********************************************************************
 * GuessingGame.java
 * Ben Davis
 * 
 * This project has the computer select a random number and then asks
 * the user to guess that number, changing the background color to
 * show if a user's guess is too low (red) or high (cyan) or if the
 * guess is correct (green). The program must use an anonymous
 * action listener!
 ********************************************************************/
package guessinggame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 150;
    private int count = 0;
    private int number = (int)(Math.random() * 100) + 1;
    private JTextField guessBox;
    private JButton btn;
    
    //***************************************************************
    
    public GuessingGame() {
        setTitle("Guessing Game by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.YELLOW);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end constructor
    
    //***************************************************************
    
    // Create components and add them to window
    private void createContents() {
        JLabel start = new JLabel("Guess a number between 1 and 100");
        guessBox = new JTextField(15);
        JLabel feedback = new JLabel("Result and Feedback");
        btn = new JButton("Reset");
        
        add(start);
        add(guessBox);
        add(feedback);
        add(btn);
        guessBox.addActionListener(
            // anonymous inner class for event handling
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int guess;
                    try {
                        guess = Integer.parseInt(guessBox.getText());
                        if (guess < number) {
                            count++;
                            feedback.setText("Too low");
                            getContentPane().setBackground(Color.RED);
                        }
                        else if (guess > number) {
                            count++;
                            feedback.setText("Too high");
                            getContentPane().setBackground(Color.CYAN);
                        }
                        else if (guess == number) {
                            count++;
                            feedback.setText("You guess it!!" +
                                    " It took you " + count +
                                    " tries");
                            getContentPane().setBackground(Color.GREEN);
                            guessBox.setEditable(false);
                        }
                    }   // end try
                    catch (NumberFormatException nfe) {
                        count++;
                        feedback.setText("Guess a whole number");
                    }   // end catch
                }   // end actionPerformed
            }   // end ActionListener
        );  // end guessBox
        btn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    guessBox.setText("");
                    guessBox.setEditable(true);
                    feedback.setText("Result and Feedback");
                    count = 0;
                    getContentPane().setBackground(Color.YELLOW);
                    number = (int)(Math.random() * 100) + 1;
                }   // end actionPerformed
            }   // end ActionListener
        );  // end btn
    }   // end createContents
    
    //****************************************************************
    
    public static void main(String[] args) {
        new GuessingGame();
    }   // end main
}   // end class GuessingGame
