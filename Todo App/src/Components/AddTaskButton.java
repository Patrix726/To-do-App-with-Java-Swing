
/**
 * The AddTaskButton class is a custom JButton component that is used to add tasks in the graphical user
 * interface.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
package Components;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 * The AddTaskButton class is a custom JButton component that is used to add
 * tasks in the graphical user
 * interface.
 */
public class AddTaskButton extends JButton {
    /**
     * AddTaskButton Constructor
     */
    public AddTaskButton() {

        // Set button text and font
        super("Add Task");
        this.setFont(new Font("Monospace", Font.BOLD, 16));

        // Set button size
        this.setPreferredSize(new Dimension(getPreferredSize().width, 30));

        // Set button cursor
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
}