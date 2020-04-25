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

    public int backpackFilling() throws FileNotFoundException {
        int K = 15000;
        int r = 300;
        int numberOfThingsInBP = 0;
        int priceOfThingsInBP = 0;
        int weightOfBP = 0;

        ArrayList<Integer> weight = loadWeight();
        ArrayList<Integer> price = loadPrice();
        
        while ((numberOfThingsInBP < r) || (weightOfBP < K)) {
            int temp = 0;
            for (int i = 0; i < weight.size(); i++) {
                int current = weight.get(i);
                if (current > temp) {
                    temp = current;
                }
            }
            int index = weight.lastIndexOf(temp);
            priceOfThingsInBP += price.get(index);
            weightOfBP += weight.get(index);
            weight.remove(index);
            price.remove(index);
            numberOfThingsInBP++;
        }        
        System.out.println("Pocet veci v batohu: " + numberOfThingsInBP);
        System.out.println("Hmotnosť batohu je: " + weightOfBP);
        System.out.println("Hodnota účelovej funkcie je: " + priceOfThingsInBP);
                
        return priceOfThingsInBP;
    }
}
