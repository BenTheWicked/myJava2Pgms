/********************************************************************
 * Ch18TicTacToe.java
 * Ben Davis
 * 
 * This program enhances the TicTacToe.java program from the text.
 * 1) Checking if the user clicks on a square that has already been
 * clicked.
 * 2) Checking if the game is over because there are no more moves
 * (cat's game). Then, resetting the board.
 * 3) Checking if the game is over because a player got 3 in a row.
 * Then, resetting the board
 ********************************************************************/
package ch18tictactoe;
import javax.swing.*;           // for JFrame and JButton
import java.awt.GridLayout;
import java.awt.event.*;        // for ActionListener and ActionEvent

public class Ch18TicTacToe extends JFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 220;
    private boolean xTurn = true;   // Is it X's turn?
    // Create a 2D Array for rows and columns
    private JButton[][] btns = new JButton[3][3];
    
    //****************************************************************
    
    public Ch18TicTacToe() {
        setTitle("Tic-Tac-Toe by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end TicTacToe constructor
    
    //****************************************************************
    
    // Create components and add to window.
    
    private void createContents() {
        //JButton button; // re-instantiate this button to fill board
        Listener listener = new Listener();
        
        setLayout(new GridLayout(3, 3));
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                btns[i][j] = new JButton();
                btns[i][j].addActionListener(listener);
                add(btns[i][j]);
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
                if (gameOver()) {
                    // print winning player
                    JOptionPane.showMessageDialog(null, 
                            "Congratulations, Player " +
                            (xTurn ? "X" : "O") + "! You win!");
                    // prepare for new game}
                    resetBoard();
                }
                else if (catsGame()) {
                    JOptionPane.showMessageDialog(null, "Cat's Game! " +
                            "No more moves.");
                    resetBoard();
                }
                else {
                    xTurn = !xTurn;
                }
            }
            else {
                // Dialog box says, "Player _, this spot is already
                // taken"
                JOptionPane.showMessageDialog(null,
                        "Player " + (xTurn ? "X" : "O") +
                        ", this spot is already taken");
            }
        }   // end actionPerformed
    }   // end class Listener
    
    //***************************************************************
    
    // Create win-condition helper method to check for winner.
    // How do you check for either X or O without duplicating
    // the method?
    public boolean gameOver() {
        // Checks rows, columns, and diagonals for a winning board.
        String player = xTurn ? "X" : "O";
        for (int i=0; i<3; i++) {
            if (btns[i][0].getText().equals(player) &&
                btns[i][1].getText().equals(player) &&
                btns[i][2].getText().equals(player)) {
                return true;
            }   
        }   // end rows
        for (int j=0; j<3; j++) {
            if (btns[0][j].getText().equals(player) &&
                btns[1][j].getText().equals(player) &&
                btns[2][j].getText().equals(player)) {
                return true;
            }   
        }   // end columns
        if ((btns[0][0].getText().equals(player) &&
             btns[1][1].getText().equals(player) &&
             btns[2][2].getText().equals(player)) ||
            (btns[0][2].getText().equals(player) &&
             btns[1][1].getText().equals(player) &&
             btns[2][0].getText().equals(player))) {
            return true;
        }   // end diagonal
        return false;
    }
    
    //***************************************************************
    
    // Cat's Game
    public boolean catsGame() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (btns[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }   // end cat's game
    
    //***************************************************************
    
    // Reset Board
    
    public void resetBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                btns[i][j].setText("");
                xTurn = true;
            }
        }
    }   // end resetBoard
    
    //****************************************************************
    
    public static void main(String[] args) {
        new Ch18TicTacToe();
    }   // end main
}   // end class Ch18TicTacToe