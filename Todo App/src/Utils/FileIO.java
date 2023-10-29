package Utils;

/**
 * The FileIO class provides methods for storing and reading tasks from a file.
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
import java.io.FileReader;
import java.io.FileWriter;

/**
 * The FileIO class provides methods for storing and reading tasks from a file.
 */
public class FileIO {

    /**
     * Stores tasks in a file
     * 
     * @param text Input tasks that are to be stored
     * @throws Exception Possible exception thrown by filewriter
     */
    public static void storeTasks(String text) throws Exception {
        FileWriter file = new FileWriter("./output.txt", false);
        file.write(text);
        file.close();
    }

    /**
     * Reads tasks from a file
     * 
     * @return text - Tasks read from file as string format
     * @throws Exception Possible exception thrown by filereader
     */
    public static String readTasks() throws Exception {
        FileReader file = new FileReader("./output.txt");
        String text = "";
        int i;
        while ((i = file.read()) != -1) {
            char ch = (char) i;
            text = text.concat(Character.toString(ch));
        }
        file.close();
        return text;
    }
}