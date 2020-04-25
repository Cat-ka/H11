
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author kisel
 */
public class H11 {
        
    public ArrayList<Integer> loadWeight() throws FileNotFoundException {        
        ArrayList<Integer> weight = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader("H11_a.txt"))) {
            while (s.hasNext()) {
                weight.add(s.nextInt());
            }
            return weight;
        }
    }
   
    public ArrayList<Integer> loadPrice() throws FileNotFoundException {
        ArrayList<Integer> price = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader("H1_c.txt"))) {
            while (s.hasNext()) {
                price.add(s.nextInt());
            }
            return price;
        }
    }

    public int plnenieBatohu() throws FileNotFoundException {
        int K = 15000;
        int r = 4;
        int pocetVeciVBahotu = 0;
        int cenaPredmetovVBatohu = 0;
        int vahaBahotu = 0;

        while ((pocetVeciVBahotu != r) && (vahaBahotu != K)) {
            int temp = 0;
            for (int i = 0; i < loadWeight().size(); i++) {
                int current = loadWeight().get(i);
                if (current > temp) {
                    temp = current;
                }
            }
            int index = loadWeight().lastIndexOf(temp);
            cenaPredmetovVBatohu += loadPrice().get(index);
            vahaBahotu += loadWeight().get(index);
            loadWeight().remove(index);
            loadPrice().remove(index);
            pocetVeciVBahotu++;
        }
        System.out.println(cenaPredmetovVBatohu);
        return cenaPredmetovVBatohu;
    }

}
