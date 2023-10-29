
/**
 * The "CompletedTasks" class is a JPanel that contains all of the completed tasks
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */
package Components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * The "CompletedTasks" class is a JPanel that contains all of the completed
 * tasks
 */
public class CompletedTasks extends JPanel {
    /** CompletedTasks Constructor */
    CompletedTasks() {

        // set layout to BoxLayout with mode top to bottom
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
