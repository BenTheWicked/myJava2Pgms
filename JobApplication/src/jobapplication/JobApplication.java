/*******************************************************************
 * JobApplication.java
 * Dean & Dean
 * 
 * This program implements job application questions with check
 * boxes, radio buttons, and a combo box. (pgs. 853-855)
 *******************************************************************/
package jobapplication;
// for JFrame, JCheckBox, JRadioButton, JComboBox, JButton,
// ButtonGroup, JPanel, JLabel, & JOptionPane:
import javax.swing.*;
import java.awt.*;          // BorderLayout, GridLayout, FlowLayout
import java.awt.event.*;    // ActionListener, Action Event
import javax.swing.border.EmptyBorder;

public class JobApplication extends JFrame {
    private static final int WIDTH = 250;
    private static final int HEIGHT = 300;
    
    private JCheckBox java;     // java certified?
    private JCheckBox helpDesk; // help-desk experience?
    private JCheckBox coffee;   // good coffee maker?
    private JRadioButton goodCitizen, criminal;
    private JComboBox salary;
    private String[] salaryOptions =
        {"$20,000-$59,000", "60,000-$100,000", "above $100,000"};
    private JButton submit;     // submit the application
    
    //**************************************************************
    
    public JobApplication() {
        setTitle("Job Application Form");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }   // end JobApplication constructor
    
    //***************************************************************
    
    // Create components and add to window.
    
    private void createContents() {
        ButtonGroup radioGroup;
        // Note:
        // The most straightforward implementation is to use a
        // GridLayout manager for the JFrame and add all components
        // to its cells. That doesn't work well because:
        // 1) Can't apply a margin to JFrame.
        // 2) The button panel is taller than the other components.
        
        // Need windowPanel for south-panel separation & outer margin
        JPanel windowPanel = new JPanel(new BorderLayout(0, 10));
        windowPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // centerPanel holds all components except button
        JPanel centerPanel = new JPanel(new GridLayout(11, 1));
        
        // Need a panel for button so it can be center aligned
        JPanel southPanel = new JPanel(new FlowLayout());
        
        java = new JCheckBox("Oracle Certified Java SE Programmer");
        helpDesk = new JCheckBox("help-desk experience");
        coffee = new JCheckBox("able to make coffee");
        goodCitizen = new JRadioButton("law-abiding citizen");
        criminal = new JRadioButton("violent criminal");
        radioGroup = new ButtonGroup();
        radioGroup.add(goodCitizen);
        radioGroup.add(criminal);
        salary = new JComboBox(salaryOptions);
        submit = new JButton("Submit");
        submit.addActionListener(new ButtonListener());
        
        centerPanel.add(new JLabel("Skills (check all that apply):"));
        centerPanel.add(java);
        centerPanel.add(helpDesk);
        centerPanel.add(coffee);
        centerPanel.add(new JLabel());  // filler
        centerPanel.add(new JLabel("Community standing:"));
        centerPanel.add(goodCitizen);
        centerPanel.add(criminal);
        centerPanel.add(new JLabel());  // filler
        centerPanel.add(new JLabel("Salary requirements:"));
        centerPanel.add(salary);
        
        windowPanel.add(centerPanel, BorderLayout.CENTER);
        southPanel.add(submit);
        windowPanel.add(southPanel, BorderLayout.SOUTH);
        add(windowPanel);
    }   // end createContents
    
    //*************************************************************
    
    // Read entered values and display an appropriate message.
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (
                (java.isSelected() || helpDesk.isSelected()
                                   || coffee.isSelected()) &&
                (goodCitizen.isSelected()) &&
                (!salary.getSelectedItem().equals("above $100,000"))) {
                JOptionPane.showMessageDialog(null,
                    "Thank you for your application submission.\n" +
                    "We'll contact you after we process your information.");
                
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Sorry, no jobs at this time.");
            }
        }   // end actionPerformed
    }   // end class ButtonListener
    
    //************************************************************
    
    public static void main(String[] args) {
        new JobApplication();
    }   // end main
}   // end class JobApplication
