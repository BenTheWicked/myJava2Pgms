/** *******************************************************************
 * WinterOlympics.java
 * Ben Davis
 *
 * This program has two elements. First, a user can read the winners
 * one of four events after reading from a file. Second, a user can
 * create a new event, list the winners and scores, and write their
 * addition to the file.
 ******************************************************************** */
package winterolympics;
// Imports

import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class WinterOlympics extends JFrame {
    // variables
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private static final String FILENAME = "WinterOlympics.txt";
    private JComboBox eventBox;
    private ArrayList<EventObject> objs = new ArrayList<>();
    private String[] eventList;
    private JLabel lblGold, lblSilver, lblBronze;   // holds winners
    private JTextField eventName;
    private JRadioButton timedBtn, scoredBtn;
    private JButton newEvent, saveEvent;
    
    private JTextField n0In, n1In, n2In, n3In, n4In;    // name inputs
    private JTextField s0In, s1In, s2In, s3In, s4In;    // score inputs
    
    private String newSport;
    private Boolean newType;
    private String[] winners = new String[3];
    private double[] points = new double[3];
    private EventObject newObj;

    //****************************************************************
    
    // constructor
    public WinterOlympics() {
        setTitle("Winter Olympics by Ben Davis");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createContents();
        setVisible(true);
    }   // end WinterOlympics constructor

    //***************************************************************
    
    // createContents
    public void createContents() {
        // Build Listener
        Listener listener = new Listener();
        // Get File info (event name) to populate JComboBox.
        String eN = "";                     // event name
        Boolean isTimed = true;             // timed vs scored
        String[] athletes = new String[5];  // list of athletes
        double[] scores = new double[5];    // list of scores
        
        try (BufferedReader fileIn = new BufferedReader(
        new FileReader(FILENAME))) {
            while (true) {
                String[] lines = new String[5];
                for (int i=0; i<5; i++) {
                    lines[i] = fileIn.readLine();
                    String[] elem = lines[i].split(",");
                    eN = elem[0];
                    isTimed = Boolean.parseBoolean(elem[1].trim());
                    athletes[i] = elem[2].trim();
                    scores[i] = Double.parseDouble(elem[3].trim());
                }
                objs.add(new EventObject(eN, isTimed, 
                        athletes, scores));
            }
        }   // end try
        catch (EOFException e)
        {}  // end EOFException
        catch (Exception e) {
            System.out.println("File Load: " +
                    e.getClass());
            System.out.println(e.getMessage());
        }
        eventList = new String[objs.size()];
        for (int i=0; i<objs.size(); i++) {
            eventList[i] = objs.get(i).getEventName();
        }
        
        // Construct NORTH region:
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, 
                BoxLayout.Y_AXIS));
        northPanel.setBorder(new EmptyBorder(35, 35, 10, 35));
        // title
        JLabel title = new JLabel("Winter Olympics");
        setFont(northPanel, title, Font.BOLD, 20);
        northPanel.add(new JPanel());
        // instructions
        JLabel instructions = new JLabel(
            "<html>Welcome to the Winter Olympics!<br/>"
            + "The left side allows you to choose a sport and then "
            + "see the winners of that event<br/>"
            + "If you want to create a sport, enter the title, "
            + "and select the win condition.</html>");
        setFont(northPanel, instructions, Font.PLAIN, 14);
        
        // Construct WEST region:
        // Grid:
        JPanel centerPanel = new JPanel(new GridLayout(5,2));
        centerPanel.setBorder(new EmptyBorder(10, 10, 35, 10));
        // 0,0 - "Select an Event"
        JLabel select = new JLabel("Select an event:");
        setFont(centerPanel, select, Font.PLAIN, 14);
        // 0,1 - ComboBox(action handler) - displays winners + scores
        eventBox = new JComboBox(eventList);
        eventBox.setSelectedIndex(-1);
        eventBox.addActionListener(listener);
        centerPanel.add(eventBox);
        // 1,0 - dummy
        centerPanel.add(new JPanel());
        // 1,1 - dummy
        centerPanel.add(new JPanel());
        // 2,0 - "Gold:"
        JLabel gold = new JLabel("Gold:");
        setFont(centerPanel, gold, Font.BOLD, 18);
        // 2,1 - lblGold
        lblGold = new JLabel();
        centerPanel.add(lblGold);
        // 3,0 - "Silver:"
        JLabel silver = new JLabel("Silver:");
        setFont(centerPanel, silver, Font.BOLD, 16);
        // 3,1 - lblSilver
        lblSilver = new JLabel();
        centerPanel.add(lblSilver);
        // 4,0 - "Bronze:"
        JLabel bronze = new JLabel("Bronze:");
        setFont(centerPanel, bronze, Font.BOLD, 14);
        // 4,1 - lblBronze
        lblBronze = new JLabel();
        centerPanel.add(lblBronze);
        
        //Construct CENTER region:
        // Box:
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, 
                BoxLayout.Y_AXIS));
        eastPanel.setBorder(new EmptyBorder(10, 10, 35, 10));
        // Flow JPanel:
        JPanel input = new JPanel(new FlowLayout());
        // JLabel - "Enter new event"
        JLabel enter = new JLabel("Enter new event");
        setFont(input, enter, Font.PLAIN, 14);
        // JTextBox (verify input!)
        eventName = new JTextField(8);
        input.add(eventName);
        eastPanel.add(input);
        // event(action handler - open new JPanel for CENTER region
        ButtonGroup radioGroup = new ButtonGroup();
        timedBtn = new JRadioButton("Timed Event");
        timedBtn.setSelected(true);
        scoredBtn = new JRadioButton("Scored Event");
        radioGroup.add(timedBtn);
        radioGroup.add(scoredBtn);
        eastPanel.add(timedBtn);
        eastPanel.add(scoredBtn);
        eastPanel.add(new JPanel());
        eastPanel.add(new JPanel());
        newEvent = new JButton("Create Event");
        newEvent.addActionListener(listener);
        eastPanel.add(newEvent);
        
        // add north
        add(northPanel, BorderLayout.NORTH);
        // add west
        add(centerPanel, BorderLayout.CENTER);
        // add center
        add(eastPanel, BorderLayout.EAST);
    }   // end createContens

    //***************************************************************
    // Listener class
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Scanner stdIn = new Scanner(System.in);
                        
            // if e.getSource is JComboBox
            if (e.getSource() == eventBox) {
                for (int i=0; i<objs.size(); i++) {
                    if (objs.get(i).getEventName().equals(
                    eventBox.getSelectedItem())) {
                        for (int j=0; j<3; j++) {
                            winners[j] = objs.get(i).getAthlete(j);
                            points[j] = objs.get(i).getScore(j);
                        }
                        String[] format = new String[3];
                        for (int j=0; j<3; j++) {
                            if (objs.get(i).getType()) {
                                format[j] = String.format(
                                "<html>%s<br/>%.2f seconds</html>",
                                winners[j], points[j]);
                            }
                            else {
                                format[j] = String.format(
                                "<html>%s<br/>%.1f points</html>",
                                winners[j], points[j]);
                            }
                        }
                        lblGold.setText(format[0]);
                        lblSilver.setText(format[1]);
                        lblBronze.setText(format[2]);
                    }   // end find item
                }   // end for
            }   // end JComboBox
            
            // else if e.getSource is event button
            else if (e.getSource() == newEvent) {
                try {
                    String[] newNames = new String[5];
                    double[] newScores = new double[5];
                    
                    // check text input
                    if (eventName.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, 
                                "You must type an event name.");
                    }
                    else {
                        newSport = eventName.getText();
                        if (timedBtn.isSelected()) {
                            newType = true;
                        }
                        else {
                            newType = false;
                        }
                        JOptionPane.showMessageDialog(null, 
                                "Enter names and scores for a " +
                                (newType ? "timed " : "scored ") +
                                "event in the command console.");
                        System.out.println("Please pay close attention "
                                + "as you add names and scores!");
                        try {
                            for (int i=0; i<5; i++) {
                                System.out.print("Name " + (i+1) + ": ");
                                newNames[i] = stdIn.nextLine();
                                System.out.print("Score " + (i+1) + ": ");
                                newScores[i] = stdIn.nextDouble();
                                stdIn.nextLine();
                            }
                            for (int j=0; j<5; j++) {
                                for (int k=0; k<4; k++) {
                                    if (newType) {
                                        if (newScores[k+1] < newScores[k]) {
                                            String tS = newNames[k];
                                            double tD = newScores[k];
                                            newNames[k] = newNames[k+1];
                                            newScores[k] = newScores[k+1];
                                            newNames[k+1] = tS;
                                            newScores[k+1] = tD;
                                        }
                                    }
                                    else {
                                        if (newScores[k+1] > newScores[k]) {
                                            String tS = newNames[k];
                                            double tD = newScores[k];
                                            newNames[k] = newNames[k+1];
                                            newScores[k] = newScores[k+1];
                                            newNames[k+1] = tS;
                                            newScores[k+1] = tD;
                                        }
                                    }
                                }
                            }   // end sort
                            newObj = new EventObject(newSport, newType,
                                newNames, newScores);
                            objs.add(newObj);
                            eventBox.addItem(newObj.getEventName());
                            try (BufferedWriter fileOut = new BufferedWriter(
                            new FileWriter(FILENAME, true))) {
                                for (int i=0; i<5; i++) {
                                    fileOut.newLine();
                                    fileOut.write(
                                        ((String) newObj.getEventName()) + ", " +
                                        String.valueOf(newObj.getType()) + ", " +
                                        ((String) newObj.getAthlete(i)) + ", " +
                                        String.valueOf(newObj.getScore(i)));
                                }
                                System.out.println("File successfully written");
                            }
                            catch (Exception h) {
                                System.out.println("Saving File: " + h.getClass());
                                System.out.println(h.getMessage());
                            }
                        }
                        catch (Exception g) {
                            System.out.println("Input: " + g.getClass());
                            System.out.println(g.getMessage());
                        }
                    }
                }   // end newEvent button
                catch (Exception f) {
                    System.out.println("Button press: " +
                            f.getClass());
                    System.out.println(f.getMessage());
                }   // end catch
            }   // end JButton event
        }   // end actionPerformed
    }   // end Listener class
    
    //***************************************************************
    
    // helper methods
    private void setFont(JPanel panel, JLabel labelText, 
            int style, int size) {
        JLabel label = new JLabel(labelText.getText());
        label.setFont(new Font("Serif", style, size));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(label);
    }   // end setFont
    

    //***************************************************************
    
    // Inner File Class
    private class EventObject {
    // The file must hold 4 elements per line:
        private String eventName;
        private boolean timed;
        private String[] athlete = new String[5];
        private double[] score = new double[5];
        
        //**********************************************************
        
        public EventObject(String eventName, boolean timed,
                String[] athlete, double[] score) {
            this.eventName = eventName;
            this.timed = timed;
            for (int i=0; i<5; i++) {
                this.athlete[i] = athlete[i];
                this.score[i] = score[i];
            }
        }   // end eventObject constructor
        
        //**********************************************************
        
        public String getEventName() {
            return this.eventName;
        }   // end getEventName
        
        public Boolean getType() {
            return this.timed;
        }   // end getType
        
        public String getAthlete(int i) {
            return this.athlete[i];
        }   // end getAthlete
        
        public double getScore(int i) {
            return this.score[i];
        }   // end getScore
        
        //**********************************************************
    
        // writeFile method
        public void writeFile(EventObject obj) {
            
        }
    }   // end class eventObject
    
    //***************************************************************
    
    public static void main(String[] args) {
        new WinterOlympics();
    }   // end main
}   // end class WinterOlympics
