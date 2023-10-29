/**
 * The Tasks class is a JPanel that displays a list of tasks and allows users to add and remove tasks.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
package Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Utils.FileIO;

/**
 * The Tasks class is a JPanel that displays a list of tasks and allows users to
 * add and remove tasks.
 */
public class Tasks extends JPanel {
    /** An array list that contains all of the tasks as strings */
    public static ArrayList<String> tasks = new ArrayList<String>();

    /** An array list that contains all of the uncompleted tasks as strings */
    public static ArrayList<String> uncompletedTasksList = new ArrayList<String>();

    /** An array list that contains all of the completed tasks as strings */
    public static ArrayList<String> completedTasksList = new ArrayList<String>();

    /** UncompletedTasks Object instance */
    UncompletedTasks uncompletedTasks = new UncompletedTasks();

    /** CompletedTasks Object instance */
    CompletedTasks completedTasks = new CompletedTasks();

    /**
     * Tasks Constructor that creates a container for all tasks
     */
    Tasks() {
        // call inputTasks that reads tasks from file
        inputTasks();
        // Labels for task categories
        JLabel taskCategoryOne = new JLabel("> Uncompleted Tasks");
        JLabel taskCategoryTwo = new JLabel("> Completed Tasks");

        // Set Label font and size
        taskCategoryOne.setFont(new Font("Monospace", Font.BOLD, 20));
        taskCategoryOne.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        taskCategoryTwo.setFont(new Font("Monospace", Font.BOLD, 20));
        taskCategoryTwo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // set layout to BoxLayout with mode top to bottom
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // add components to this panel
        this.add(taskCategoryOne);
        this.add(uncompletedTasks);
        this.add(taskCategoryTwo);
        this.add(completedTasks);
    }

    /**
     * Calls readTasks from Class FileIO and adds tasks by calling the addTask
     * method
     */
    public void inputTasks() {
        try {
            String tasksInText = FileIO.readTasks();
            for (String task : tasksInText.split("\n")) {
                if (task.startsWith("0"))
                    addUncompletedTask(task.replaceFirst("0", ""));
                else if (task.startsWith("1")) {
                    addCompletedTask(task.replaceFirst("1", ""));
                }
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Adds a new task by calling the Task constructor
     * 
     * @param text task to be added
     */
    public void addUncompletedTask(String text) {
        if (!text.isBlank() && !tasks.contains(text)) {
            tasks.add(text);
            uncompletedTasksList.add(text);
            // this.add(new Task(text));
            uncompletedTasks.add(new Task(text, false));
            setPanelColor(uncompletedTasks);
            uncompletedTasks.updateUI();
            this.updateUI();
        }
    }

    /**
     * Adds a completed task by calling the Task constructor
     * 
     * @param text task to be added
     */
    public void addCompletedTask(String text) {
        if (!text.isBlank() && !tasks.contains(text)) {
            tasks.add(text);
            completedTasksList.add(text);
            // this.add(new Task(text));
            completedTasks.add(new Task(text, true));
            setPanelColor(completedTasks);
            completedTasks.updateUI();
            this.updateUI();
        }

    }

    /**
     * Sets a task from the completed task list as incompleted
     * 
     * @param checkBox the checkbox that was clicked
     */
    public void addUncompletedTask(JCheckBox checkBox) {
        completedTasksList.remove(checkBox.getText());
        uncompletedTasksList.add(checkBox.getText());
        completedTasks.remove(checkBox.getParent());
        uncompletedTasks.add(checkBox.getParent());
        setPanelColor(uncompletedTasks);
        setPanelColor(completedTasks);

        this.updateUI();
        uncompletedTasks.updateUI();
        completedTasks.updateUI();
    }

    /**
     * Sets a task from the uncompleted task list as completed
     * 
     * @param checkBox the checkbox that was clicked
     */
    public void addCompletedTask(JCheckBox checkBox) {
        uncompletedTasksList.remove(checkBox.getText());
        completedTasksList.add(checkBox.getText());
        uncompletedTasks.remove(checkBox.getParent());
        completedTasks.add(checkBox.getParent());
        setPanelColor(uncompletedTasks);
        setPanelColor(completedTasks);
        this.updateUI();
        uncompletedTasks.updateUI();
        completedTasks.updateUI();
    }

    /**
     * Removes a task permanently from the list
     * 
     * @param checkBox the checkbox with the task to be removed
     */
    public void removeTask(JCheckBox checkBox) {
        String task = checkBox.getText();
        tasks.remove(task);
        if (uncompletedTasksList.contains(task)) {
            uncompletedTasksList.remove(task);
            uncompletedTasks.remove(checkBox.getParent());
            setPanelColor(uncompletedTasks);
            uncompletedTasks.updateUI();
        } else if (completedTasksList.contains(task)) {
            completedTasksList.remove(task);
            completedTasks.remove(checkBox.getParent());
            setPanelColor(completedTasks);
            completedTasks.updateUI();
        }
        this.updateUI();

    }

    /**
     * Sets the background color to all children components of a container
     * 
     * @param Parent parent containers
     */
    public void setPanelColor(Container Parent) {
        int i = 0;
        for (Component c : Parent.getComponents()) {
            Task taskC = (Task) c;
            if (i % 2 == 0)
                taskC.getComponent(0).setBackground(new Color(173, 196, 206));
            else
                taskC.getComponent(0).setBackground(new Color(238, 224, 201));
            i++;
        }
    }

}
