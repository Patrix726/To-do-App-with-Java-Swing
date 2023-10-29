
/**
 * The AboutFrame class is a JFrame that displays a list of group members in a GUI application.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
 */
package Components;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

/**
 * The AboutFrame class is a JFrame that displays a list of group members in a
 * GUI application.
 */
public class AboutFrame extends JFrame {
    /**
     * Array of group members' names
     */
    String[] groupMembers = { "Nebil Rahmeto", "Tekliye Tamiru", "Solomon Dugasa", "Samuel Tadesse",
            "Yabets Workaferahu" };

    /**
     * A constructor for the `AboutFrame` class responsible for
     * setting up the frame and its components.
     */
    AboutFrame() {
        // Set frame title and icon
        this.setTitle("About");
        this.setIconImage(AppFrame.logoImg.getImage());

        // Set frame size and layout
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());

        // Create title label and set font
        JLabel title = new JLabel("Group Members", SwingConstants.CENTER);
        title.setFont(new Font("Monospace", Font.BOLD, 24));

        // Create list model and populate with group members
        DefaultListModel<String> list = new DefaultListModel<>();
        for (String i : groupMembers) {
            list.addElement(i);
        }

        // Create JList and set font and border
        JList<String> membersList = new JList<>(list);
        membersList.setFont(new Font("Monospace", Font.PLAIN, 20));
        membersList.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

        // Add title label and members list to frame
        this.add(title, BorderLayout.NORTH);
        this.add(membersList);

        // Set frame visibility, resizability, and close operation
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}