/********************************************************************
 * SmileyPanel.java
 * Dean & Dean
 * 
 * This class contains a smiley image and listeners that enable image
 * dragging and image swapping. (pg. 801-803)
 ********************************************************************/
package dragsmiley;
import javax.swing.*;           // for JPanel and ImageIcon
import java.awt.*;              // for Point and Graphics
// for MouseAdapter, MouseEvent, and MouseMotionAdapter:
import java.awt.event.*;

public class SmileyPanel extends JPanel {
    private final ImageIcon SMILEY = new ImageIcon("smiley.png");
    private final ImageIcon SCARED = new ImageIcon("scared.png");
    private final int WIDTH = SMILEY.getIconWidth();
    private final int HEIGHT = SMILEY.getIconHeight();
    
    private Point imageCorner;  // image's top-left corner location
    private Point prevPt;       // mouse location for previous event
    private ImageIcon image;    // toggles between smiley and scared
    private boolean grabbed;    // mouse has a hold on the icon
    
    //***************************************************************
    
    public SmileyPanel() {
        image = SMILEY;
        imageCorner = new Point(0, 0);  // image starts at top left
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }   // end SmileyPanel constructor
    
    //***************************************************************
    
    // Draw the window, including the updated image.
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int) imageCorner.getX(), 
                (int) imageCorner.getY());
    }   // end paintComponent
    
    //***************************************************************
    
    private class ClickListener extends MouseAdapter {
        // When mouse pressed, change to scared image.
        
        @Override
        public void mousePressed(MouseEvent e) {
            image = SCARED;
            repaint();
            prevPt = e.getPoint();  // save current position
            
            // Make sure mouse was pressed within the image.
            if (prevPt.getX() >= imageCorner.getX() &&
                prevPt.getX() <= imageCorner.getX() + WIDTH &&
                prevPt.getY() >= imageCorner.getY() &&
                prevPt.getY() <= imageCorner.getY() + HEIGHT) {
                grabbed = true;
            }
        }   // end mousePressed
        
        // When mouse released, return to smiley image.
        
        @Override
        public void mouseReleased(MouseEvent e) {
            image = SMILEY;
            repaint();
            grabbed = false;
        }   // end mouseReleased
    }   // end class ClickLIstener
    
    //**************************************************************
    
    private class DragListener extends MouseMotionAdapter {
        // Enable an image to be dragged by a mouse.
        
        @Override
        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint(); // current position
            
            // Make sure mouse was pressed within the image.
            if (grabbed) {
                imageCorner.translate(
                        (int) (currentPt.getX() - prevPt.getX()),
                        (int) (currentPt.getY() - prevPt.getY()));
                prevPt = currentPt; // save current position
                repaint();
            }
        }   // end mouseDragged
    }   // end class DragListener
}   // end class SmileyPanel
