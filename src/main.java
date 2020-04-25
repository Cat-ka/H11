
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author kisel
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException {
        H11 h11 = new H11();
        ArrayList<Integer> weight = h11.loadWeight();
        ArrayList<Integer> price = h11.loadPrice();
        //h11.plnenieBatohu();       

        System.out.println(h11.loadWeight());
      
    }

}
