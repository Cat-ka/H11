
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Katka Kiselová
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        H11 h11 = new H11();
        h11.loadWeight();
        h11.loadPrice();        
        h11.backpackFilling(); 
        h11.vector();
        h11.writeResult();      
    }
}
