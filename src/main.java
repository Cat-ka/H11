
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kisel
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        H11 h11 = new H11();
        ArrayList<Integer> weight = h11.loadWeight();
        ArrayList<Integer> price = h11.loadPrice();        
        h11.backpackFilling(); 
        h11.jednotkováMatica();
        h11.writeResult();
        
       
    }

}
