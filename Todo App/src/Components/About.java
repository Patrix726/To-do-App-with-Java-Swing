
/**
 * The "About" class is a JPanel that contains a button to display an
 * "AboutFrame" when clicked.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */

package Components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The "About" class is a JPanel that contains a button to display an
 * "AboutFrame" when clicked.
 */
public class About extends JPanel {
    /**
     * About Panel Constructor
     */
    About() {
        // Set background and foreground colors
        this.setBackground(Color.black);
        this.setForeground(Color.white);

        // Create About button
        JButton aboutButton = new JButton("About");

        // Add action listener to About button
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and display AboutFrame
                new AboutFrame();
            }
        });

        // Add About button to About panel
        this.add(aboutButton);
    }
}