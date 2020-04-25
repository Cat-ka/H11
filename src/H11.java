
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
        try (Scanner s = new Scanner(new FileReader("H1_a.txt"))) {
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
        int r = 300;
        int pocetVeciVBahotu = 0;
        int cenaPredmetovVBatohu = 0;
        int vahaBahotu = 0;

        ArrayList<Integer> weight = loadWeight();
        ArrayList<Integer> price = loadPrice();
        
        while ((pocetVeciVBahotu != r) && (vahaBahotu != K)) {
            int temp = 0;
            for (int i = 0; i < weight.size(); i++) {
                int current = weight.get(i);
                if (current > temp) {
                    temp = current;
                }
            }
            int index = weight.lastIndexOf(temp);
            cenaPredmetovVBatohu += price.get(index);
            vahaBahotu += weight.get(index);
            weight.remove(index);
            price.remove(index);
            pocetVeciVBahotu++;
        }
        System.out.println(cenaPredmetovVBatohu);
        return cenaPredmetovVBatohu;
    }

}
