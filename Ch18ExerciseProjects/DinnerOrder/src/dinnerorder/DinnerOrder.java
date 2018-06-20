/********************************************************************
 * DinnerOrder.java
 * Ben Davis
 * 
 * The user selects an appetizer, main dish, and dessert. Then, they
 * click a button to calculate the total.
 ********************************************************************/
package dinnerorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class DinnerOrder extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    
    private String[] apps =
        {"Potato Skins", "Nachos", "Buffalo Wings"};
    private JComboBox appBox = new JComboBox(apps);
    private String[] mains =
        {"Cheeseburger", "Pasta", "Fish 'n' Chips"};
    private JComboBox mainBox = new JComboBox(mains);
    private String[] desserts =
        {"Brownie", "Apple Pie", "Ice Cream"};
    private JComboBox dessertBox = new JComboBox(desserts);
    private JButton submit;
    private JLabel total;
    
    //**************************************************************
    
    public DinnerOrder() {
        setTitle("Dinner Order by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        createContents();
        setVisible(true);
    }   // end DinnerOrder constructor
    
    //***************************************************************
    
    public void createContents() {
        ButtonListener listener = new ButtonListener();
        
        // Create top panel
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.add(new JLabel("Welcome to Ben Davis' Diner"));
        
        // Create middle panel (grid)
        JPanel midPanel = new JPanel(new GridLayout(3, 2));
        midPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        midPanel.add(new JLabel("Appetizers:"));
        midPanel.add(appBox);
        midPanel.add(new JLabel("Main Dishes:"));
        midPanel.add(mainBox);
        midPanel.add(new JLabel("Desserts:"));
        midPanel.add(dessertBox);
        
        // Create bottom panel
        JPanel btmPanel = new JPanel(new FlowLayout());
        btmPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        submit = new JButton("Submit");
        submit.addActionListener(listener);
        btmPanel.add(new JLabel("Order complete?"));
        btmPanel.add(submit);
        
        // Create total panel
        JPanel totalPanel = new JPanel(new FlowLayout());
        totalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        total = new JLabel("Welcome to Ben Davis' Diner");
        totalPanel.add(total);
        
        // Add all to page
        add(topPanel);
        add(new JPanel());
        add(midPanel);
        add(new JPanel());
        add(btmPanel);
        add(new JPanel());
        add(totalPanel);
    }   // end createContents
    
    //***************************************************************
    
    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double totalCost = 0.0;
            
            // total apps
            if (appBox.getSelectedItem().equals("Potato Skins")) {
                totalCost += 3.5;
            }
            else if (appBox.getSelectedItem().equals("Nachos")) {
                totalCost += 2.75;
            }
            else {
                totalCost += 3;
            }
            
            // total mains
            if (mainBox.getSelectedItem().equals("Cheeseburger")) {
                totalCost += 4.25;
            }
            else if (mainBox.getSelectedItem().equals("Pasta")) {
                totalCost += 4;
            }
            else {
                totalCost += 3.75;
            }
            
            // total desserts
            if (dessertBox.getSelectedItem().equals("Brownie")) {
                totalCost += 2.5;
            }
            else if (dessertBox.getSelectedItem().equals("Apple Pie")) {
                totalCost += 2.5;
            }
            else {
                totalCost += 2.5;
            }
            
            // display total (money format)
            total.setText(String.format("Total Cost: $%2.2f", 
                    totalCost));
        }
    }
    
    //***************************************************************
    
    public static void main(String[] args) {
        new DinnerOrder();
    }   // end main
}   // end class DinnerOrder
