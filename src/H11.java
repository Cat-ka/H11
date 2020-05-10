
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
    ArrayList<Integer> vector;

    public H11() throws FileNotFoundException {
        this.weight = loadWeight();
        this.price = loadPrice();
        this.tempWeight = loadWeight();
        this.result = new ArrayList<Integer>();
        this.vector = new ArrayList<Integer>();
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

    public int backpackFilling() {
        while ((numberOfThingsInBP < r) || (weightOfBP < K)) {
            int tempWeight = 0;
            int tempIndex = -1;
            for (int i = 0; i < weight.size(); i++) {
                int currentWeight = weight.get(i);
                if (currentWeight > tempWeight) {
                    tempWeight = currentWeight;
                }
            }
            int lowestPrice = Integer.MAX_VALUE;
            for (int i = 0; i < weight.size(); i++) {
                int current = weight.get(i);
                if (current == tempWeight) {
                    int currentPrice = price.get(i);
                    if (currentPrice < lowestPrice) {
                        lowestPrice = currentPrice;
                        tempIndex = i;
                    }
                }
            }

            result.add(tempWeight);
            priceOfThingsInBP += lowestPrice;
            weightOfBP += weight.get(tempIndex);
            weight.remove(tempIndex);
            price.remove(tempIndex);
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
            for (int j = 0; j < vector.size(); j++) {
                myWriter.write(vector.get(j) + ", ");
            }
            myWriter.write(")");
        }
    }

    public ArrayList<Integer> vector() {
        for (int i = 0; i < tempWeight.size(); i++) {
            vector.add(0);
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < tempWeight.size(); j++) {
                if (tempWeight.get(j) == result.get(i)) {
                    vector.set(j, 1);
                }
            }
        }

        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + ", ");
        }

        return vector;
    }
}
