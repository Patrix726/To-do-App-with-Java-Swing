/**
 * The "UncompletedTasks" class is a JPanel that contains all of the uncompleted tasks
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
package Components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * The "UncompletedTasks" class is a JPanel that contains all of the uncompleted
 * tasks
 */
public class UncompletedTasks extends JPanel {
    /** UncompletedTasks Constructor */
    UncompletedTasks() {
        // set layout to BoxLayout with mode top to bottom
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

}
