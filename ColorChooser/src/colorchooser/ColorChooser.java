/********************************************************************
 * ColorChooser.java
 * Dean & Dean
 * 
 * This program's buttons allow the user to set the window's background
 * color to gray or blue. (pg. 794-796)
 ********************************************************************/
package colorchooser;
import javax.swing.*;           // for JFrame & JButton
import java.awt.*;              // for FlowLayout, Color, & Container
import java.awt.event.*;        // for ActionListener & ActionEvent

public class ColorChooser extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 100;
    
    private JButton grayButton; // changes background to gray
    private JButton blueButton; // changes background to blue
    
    //****************************************************************
    
    public ColorChooser() {
        setTitle("Background Color Chooser");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end ColorChooser constructor
    
    //***************************************************************
    
    private void createContents() {
        grayButton = new JButton("Gray");
        grayButton.setBackground(Color.LIGHT_GRAY);
        grayButton.addActionListener(new ButtonListener());
        add(grayButton);
        
        blueButton = new JButton("Blue");
        blueButton.setBackground(new Color(135, 206, 250));
        blueButton.addActionListener(new ButtonListener());
        add(blueButton);
    }   // end createContents
    
    //***************************************************************
    
    // Inner class for event handling.
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Container contentPane = getContentPane();
            if (e.getSource() == grayButton) {
                // Change the window background color to gray.
                contentPane.setBackground(Color.GRAY);
            }
            else {
                // Change the window background color to blue.
                contentPane.setBackground(Color.BLUE);
            }
        }   // end actionPerformed
    }   // end class ButtonListener
    
    //**************************************************************
    
    public static void main(String[] args) {
        new ColorChooser();
    }   // end main
}   // end class ColorChooser
