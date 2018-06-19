/********************************************************************
 * AfricanCountries.java
 * Dean & Dean
 * 
 * This program shows component layout for BorderLayout manager. (pg.
 * 824)
 ********************************************************************/
package africancountries;
import javax.swing.*;   // for JFrame and JButton
import java.awt.BorderLayout;

public class AfricanCountries extends JFrame {
    private static final int WIDTH = 310;
    private static final int HEIGHT = 170;
    
    public AfricanCountries() {
        setTitle("African Countries");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JLabel("Tunisia", SwingConstants.CENTER),
                BorderLayout.NORTH);
        add(new JLabel("<html>South<br />Africa</html>",
                SwingConstants.CENTER), BorderLayout.SOUTH);
        add(new JLabel("Western Sahara", SwingConstants.CENTER),
                BorderLayout.WEST);
        add(new JLabel("Central African Republic"
                , SwingConstants.CENTER), BorderLayout.CENTER);
        add(new JLabel("Somalia", SwingConstants.CENTER), 
                BorderLayout.EAST);
        setVisible(true);
    }   // end AfricanCountries constructor
    
    //***************************************************************
    
    public static void main(String[] args) {
        new AfricanCountries();
    }   // end main
}   // end class AfricanCountries
