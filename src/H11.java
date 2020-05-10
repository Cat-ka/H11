
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Katka Kiselová
 */
public final class H11 {

    private static final int K = 15000;
    private static final int r = 300;
    int numberOfThingsInBP = 0;
    int priceOfThingsInBP = 0;
    int weightOfBP = 0;

    ArrayList<Integer> weight;
    ArrayList<Integer> price;
    ArrayList<Integer> tempWeight;
    ArrayList<Integer> result;
    ArrayList<Integer> matica;

    public H11() throws FileNotFoundException {
        this.weight = loadWeight();
        this.price = loadPrice();
        this.tempWeight = loadWeight();
        this.result = new ArrayList<Integer>();
        this.matica = new ArrayList<Integer>();
    }

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
        while ((numberOfThingsInBP < r) || (weightOfBP < K)) {
            int temp = 0;
            for (int i = 0; i < weight.size(); i++) {
                int current = weight.get(i);
                if (current > temp) {
                    temp = current;
                }
            }
            int index = weight.lastIndexOf(temp);
            result.add(temp);
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

    public void writeResult() throws IOException {
        try (FileWriter myWriter = new FileWriter("result.txt")) {
            myWriter.write("Úloha po vykonaní duálnej vsúvacej heuristiky.\n");
            myWriter.write("***************************************************************\n");
            myWriter.write("Pocet veci v batohu: " + "\t\t" + numberOfThingsInBP + "\n");
            myWriter.write("Hmotnosť batohu je: " + "\t\t" + weightOfBP + "\n");
            myWriter.write("Hodnota účelovej funkcie je: " + "\t" + priceOfThingsInBP + "\n");
            myWriter.write("***************************************************************\n");
            myWriter.write("Jednotlivé hmotnosti predmetov v batohu sú: " + "\n");
            for (int i = 0; i < result.size(); i++) {
                myWriter.write(result.get(i) + ", ");
            }
            myWriter.write("\n***************************************************************\n");
            myWriter.write("Prípustné riešenie úlohy o batohu je: " + "\n" + "x = (");
            for (int j = 0; j < matica.size(); j++) {
                myWriter.write(matica.get(j) + ", ");
            }
            myWriter.write(")");
        }
    }

    public ArrayList<Integer> jednotkováMatica() throws FileNotFoundException {
        for (int i = 0; i < tempWeight.size(); i++) {
            matica.add(0);
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < tempWeight.size(); j++) {
                if (tempWeight.get(j) == result.get(i)) {
                    matica.set(j, 1);
                }
            }
        }
        
        for (int i = 0; i < matica.size(); i++) {
             System.out.print(matica.get(i) + ", ");
        }
       
        return matica;
    }
}
