
/**
 * The InputPanel class is a custom JPanel component that contains an input field and a button for
 * adding tasks.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 * 
 */
package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The InputPanel class is a custom JPanel component that contains an input
 * field and a button for
 * adding tasks.
 */
public class InputPanel extends JPanel {
    /** Custom color for the panel */
    Color customColor = new Color(122, 143, 156);

    /**
     * Input Panel Constructor
     */
    InputPanel() {
        // Create input field and button
        InputField inputBox = new InputField();
        AddTaskButton addTaskButton = new AddTaskButton();

        JLabel desc = new JLabel("     Enter task here:  ");
        desc.setFont(new Font("Monospace", Font.PLAIN, 16));

        // Add action listener to input field and button
        inputBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AppFrame.taskList.addUncompletedTask(inputBox.getText());
                inputBox.setText("");
            }
        });

        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppFrame.taskList.addUncompletedTask(inputBox.getText());
                inputBox.setText("");
            }
        });

        // Set layout and add components to the panel
        this.setLayout(new GridBagLayout());
        this.add(desc);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(inputBox, c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.03;
        this.add(addTaskButton, c);

        // set size and color of the panel
        this.setPreferredSize(new Dimension(getPreferredSize().width, 150));
        this.setBackground(customColor);
    }
}