
/**
 
 * @author 
 * @since 2023
 * @version 1.0
 * @see Java Doc
*/
import Components.AppFrame;
import Components.LoadingScreen;

/**
 * The App class contains the main method that initializes the LoadingScreen
 * and AppFrame components.
 */
public class App {

    /**
     * Main app that runs the loading screen and the app frame
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new LoadingScreen();
        new AppFrame();
    }
}
