
/**
 * The InputField class is a custom JTextField component with a specific size, font style, and
 * background color.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */
package Components;

import java.awt.Font;
import javax.swing.JTextField;

/**
 * The InputField class is a custom JTextField component with a specific size
 * and font style
 */
public class InputField extends JTextField {
    /**
     * InputField constructor that creates a custom JTextField
     */
    public InputField() {
        // Set text field size
        super(34);

        // Set font style
        this.setFont(new Font("Monospace", Font.PLAIN, 20));
    }
}