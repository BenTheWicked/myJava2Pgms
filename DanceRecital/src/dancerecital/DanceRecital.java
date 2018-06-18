/************************************************************
 * DanceRecital.java
 * Dean & Dean
 * 
 * This program stores and prints dance recital information.
 * (pg. 819)
 ************************************************************/
package dancerecital;
import javax.swing.*;   // JFrame, JLabel, BoxLayout, ImageIcon
import java.awt.*;      // Font, Componenet

public class DanceRecital {
    private String performance;     // name of the performance
    private String image;           // promotional image
    private String date;            // dance recital's date
    private String time;            // dance recital's time
    private String venue;           // dance recital's location
    
    //*******************************************************
    
    public void setPerformance(String performance) {
        this.performance = performance;
    }   // end setPerformance
    
    public void setImage(String imageFile) {
        this.image = imageFile;
    }   // end setImage
    
    public void setDate(String date) {
        this.date = date;
    }   // end setDate
    
    public void setTime(String time) {
        this.time = time;
    }   // end setTime
    
    public void setVenue(String venue) {
        this.venue = venue;
    }   // end setVenue
    
    //******************************************************
    
    // This method prints a poster for a dance recital.
    
    public void displayPoster() {
        JFrame frame = new JFrame("Dance Recital"); // the window
        JLabel pictureLabel;    // container for dancer picture
        
        frame.setSize(480, 640);    // pixel width, height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        addLabel(frame, this.performance, Font.ITALIC, 75);
        
        pictureLabel = new JLabel(new ImageIcon(image));
        pictureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(pictureLabel);
        
        addLabel(frame, this.date, Font.BOLD, 25);
        addLabel(frame, this.time, Font.BOLD, 25);
        addLabel(frame, this.venue, Font.BOLD, 25);
        frame.setVisible(true);
    }   // end displayPoster
    
    //******************************************************
    
    // This method instantiates a label and adds it to the window.
    
    private void addLabel(JFrame frame, String labelText, int style,
            int size) {
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Serif", style, size));
        frame.add(label);
    }   // end addLabel
}   // end class DanceRecital
