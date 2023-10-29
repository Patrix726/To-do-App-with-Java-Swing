
/**
 * The LoadingScreen class creates a window with a logo and text, displays it for 2 seconds, and then
 * hides and disposes of the window. It displays a splash screen for the app.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */
package Components;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 * The LoadingScreen class creates a window with a logo and text, displays it
 * for 2 seconds, and then
 * hides and disposes of the window. It displays a splash screen for the app.
 */
public class LoadingScreen extends JWindow {
    /**
     * Constructor for the Loading Screen Class
     */
    public LoadingScreen() {
        // Set logo image

        // Create label with logo and text
        JLabel label = new JLabel("Todo App", AppFrame.logoImg, SwingConstants.CENTER);

        // Set label properties
        label.setBounds(0, 0, 650, 600);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("Monospace", Font.PLAIN, 24));

        // Set window properties
        this.setSize(650, 600);
        this.getContentPane().add(label);
        this.setLayout(null);
        this.setVisible(true);

        // Pause for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hide window and release resources
        this.setVisible(false);
        this.dispose();
    }
}