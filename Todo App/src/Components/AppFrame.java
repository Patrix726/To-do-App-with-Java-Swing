package Components;

/**
 * The AppFrame class is a Java Swing JFrame that represents the main frame of the Todo App, including
 * input panel, task list, and about section.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import Utils.FileIO;

/**
 * The AppFrame class is a Java Swing JFrame that represents the main frame of
 * the Todo App, including
 * input panel, task list, and about section.
 */
public class AppFrame extends JFrame {
    /**
     * A Tasks object that holds all of the tasks in the app
     */
    public static Tasks taskList = new Tasks();
    /**
     * Logo Image for the app
     */
    public static ImageIcon logoImg = new ImageIcon("../resources/To-Do_icon_mini.png");

    /** AppFrame Constructor */
    public AppFrame() {
        // Create input panel and task list scroll pane
        InputPanel inputPanel = new InputPanel();
        JScrollPane taskScrollPane = new JScrollPane(taskList);

        // Configure task list scroll pane
        taskScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        taskScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        taskScrollPane.getVerticalScrollBar().setBlockIncrement(25);
        taskScrollPane.getVerticalScrollBar().setUnitIncrement(25);

        // Set up frame properties
        this.setSize(650, 600);
        this.setTitle("Todo App");
        this.setIconImage(logoImg.getImage());

        // Add components to frame
        this.getContentPane().add(inputPanel, BorderLayout.NORTH);
        this.getContentPane().add(taskScrollPane, BorderLayout.CENTER);
        this.getContentPane().add(new About(), BorderLayout.SOUTH);

        // Set minimum size and make frame visible
        this.setMinimumSize(new Dimension(650, 600));
        this.setVisible(true);

        // Add window listener for saving tasks
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    String tasksInText = "";
                    for (String task : Tasks.uncompletedTasksList) {
                        tasksInText = tasksInText.concat("0" + task + "\n");
                    }
                    for (String task : Tasks.completedTasksList) {
                        tasksInText = tasksInText.concat("1" + task + "\n");
                    }
                    FileIO.storeTasks(tasksInText);
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                }
                e.getWindow().dispose();
            }
        });
    }
}