/**
 * The Task class is a JPanel component that represents a task with a checkbox, text, and functionality
 * to remove the task when it is completed.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */

package Components;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * The Task class is a JPanel component that represents a task with a checkbox,
 * text, button and functionality to remove the task when it is completed.
 */
public class Task extends JPanel {
    /**
     * Task Constructor that creates a single task object with a checkbox and button
     * 
     * @param text    Input task's text
     * @param checked status of the task as completed or uncompleted
     */

    public Task(String text, boolean checked) {
        // Create a checkbox with the task text
        JCheckBox checkBox = new JCheckBox(text, checked);
        JButton removeTaskBtn = new JButton("X");

        // Set the font to Monospace, size 18
        checkBox.setFont(new Font("Monospace", Font.PLAIN, 18));
        removeTaskBtn.setFont(new Font("Monospace", Font.ITALIC, 16));

        // Set the gap between the icon and text to 10
        checkBox.setIconTextGap(10);

        // Set the cursor to hand icon
        checkBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeTaskBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add an item listener to handle checkbox state changes
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // If the checkbox is selected
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // If the task is completed, remove it from the task list
                    if (checkBox.isSelected())
                        AppFrame.taskList.addCompletedTask(checkBox);
                }
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (!checkBox.isSelected())
                        AppFrame.taskList.addUncompletedTask(checkBox);
                }
            }
        });
        // Add an action listener to handle button clicks
        removeTaskBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppFrame.taskList.removeTask(checkBox);
            }
        });
        // set layout to BorderLayout
        this.setLayout(new BorderLayout());

        // Add the checkbox to the panel
        this.add(checkBox, BorderLayout.CENTER);
        this.add(removeTaskBtn, BorderLayout.EAST);
        // set Maximumsize for the task panel
        this.setMaximumSize(new Dimension(getMaximumSize().width, 40));
    }
}