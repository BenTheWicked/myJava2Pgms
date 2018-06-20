/********************************************************************
 * MuseumStoreOrderPage.java
 * Ben Davis
 * 
 * Based on the museum grab-bag project from Java I, this program
 * displays options for grab bags and calculates the total cost.
 ********************************************************************/
package museumstoreorderpage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MuseumStoreOrderPage extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    
    private JTextField numStudents;
    private JCheckBox pencil;
    private JCheckBox eraser;
    private JCheckBox waterBottle;
    private JCheckBox bouncyBall;
    private JCheckBox keyChain;
    private JRadioButton lrgDino, smlDino;
    private JButton calc;
    private JLabel total;
    
    //***************************************************************
    
    public MuseumStoreOrderPage() {
        setTitle("Meseum Store Order Page by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        createContents();
        setVisible(true);
    }   // end MuseumStoreOrderPage constructor
    
    //***************************************************************
    
    public void createContents() {
        ButtonListener listener = new ButtonListener();
        // Create top Panel
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel students = new JLabel("How many students?");
        numStudents = new JTextField(8);
        topPanel.add(students);
        topPanel.add(numStudents);
        
        // Create middle panel
        JPanel midPanel = new JPanel(new GridLayout(0, 1));
        midPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel contents = new JLabel("Please pick the contents "
                + "of the goody bags");
        pencil = new JCheckBox("Museum Pencil");
        eraser = new JCheckBox("Shuttle Eraser");
        waterBottle = new JCheckBox("Water Bottle");
        bouncyBall = new JCheckBox("Earth Bouncy Ball");
        keyChain = new JCheckBox("Key Chain");
        ButtonGroup radioGroup = new ButtonGroup();
        lrgDino = new JRadioButton("Large Dinosaur");
        smlDino = new JRadioButton("Two Small Dinosaurs");
        radioGroup.add(lrgDino);
        radioGroup.add(smlDino);
        midPanel.add(contents);
        midPanel.add(pencil);
        midPanel.add(eraser);
        midPanel.add(waterBottle);
        midPanel.add(bouncyBall);
        midPanel.add(keyChain);
        midPanel.add(lrgDino);
        midPanel.add(smlDino);
        
        // Create bottom panel
        JPanel btmPanel = new JPanel(new GridLayout(0, 1));
        btmPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel calcPanel = new JPanel(new FlowLayout());
        JPanel totalPanel = new JPanel(new FlowLayout());
        calc = new JButton("Calculate");
        calcPanel.add(calc);
        total = new JLabel("Cost:");
        totalPanel.add(total);
        btmPanel.add(calcPanel);
        btmPanel.add(totalPanel);
        
        // Populate window
        add(topPanel);
        add(new JPanel());
        add(midPanel);
        add(btmPanel);
        
        calc.addActionListener(listener);
    }   // end createContents
    
    //***************************************************************
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double totalCost = 0.0;
            int students = 0;
            try {
                students = Integer.parseInt(numStudents.getText());
            }
            catch (NumberFormatException nfe) {
                students = 1;
            }
            
            // Check boxes
            if (pencil.isSelected()) {
                totalCost += 0.25;
            }
            if (eraser.isSelected()) {
                totalCost += 1;
            }
            if (waterBottle.isSelected()) {
                totalCost += 5;
            }
            if (bouncyBall.isSelected()) {
                totalCost += 1.25;
            }
            if (keyChain.isSelected()) {
                totalCost += 1.5;
            }
            
            // Radio buttons
            if (lrgDino.isSelected()) {
                totalCost += 3;
            }
            else {
                totalCost += 1.5 * 2;
            }
            
            totalCost = totalCost * students;
            total.setText(String.format("Cost: $%3.2f", totalCost));
        }   // end actionPerformed
    }   // end ButtonListener
    
    //***************************************************************
    
    public static void main(String[] args) {
        new MuseumStoreOrderPage();
    }   // end main
}   // end class MuseumStoreOrderPage
