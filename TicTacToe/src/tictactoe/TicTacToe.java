/********************************************************************
 * TicTacToe.java
 * Dean & Dean
 * 
 * This program implements a simplified version of tic-tac-toe. As a
 * user clicks blank buttons, the buttons' labels change to X and O
 * in alternating sequence. (pg. 831-832)
 ********************************************************************/
package tictactoe;
import javax.swing.*;       // for JFrame and JButton
import java.awt.GridLayout;
import java.awt.event.*;    // for ActionListener and ActionEvent

public class TicTacToe extends JFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 220;
    private boolean xTurn = true;   // Is it X's turn?
    // Create a 2D Array for rows and columns
    
    //****************************************************************
    
    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end TicTacToe constructor
    
    //****************************************************************
    
    // Create components and add to window.
    
    private void createContents() {
        JButton button; // re-instantiate this button to fill board
        Listener listener = new Listener();
        
        setLayout(new GridLayout(3, 3));
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                button = new JButton();
                button.addActionListener(listener);
                add(button);
            }   // end for j
        }   // end for i
    }   // end createContents
    
    //***************************************************************
    
    // If user clicks a button, change its label to "X" or "O".
    
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (btn.getText().isEmpty()) {
                btn.setText(xTurn ? "X" : "O");
                // if there's a win {
                    // print winning player
                    // prepare for new game}
                // else {
                xTurn = !xTurn;
                // }
            }
        }   // end actionPerformed
    }   // end class Listener
    
    //***************************************************************
    
    // Create win-condition helper method to check for winner.
    // How do you check for either X or O without duplicating
    // the method?
    
    //***************************************************************
    
    public static void main(String[] args) {
        new TicTacToe();
    }   // end main
}   // end class TicTacToe
