import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String[] arquivos = {"aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                          "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                          "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"};
        for (String file : arquivos) {
            System.out.println("Processando o arquivo: " + file);
            List<Integer> data = Leitorcsv.readCSV(file);

            List<Integer> dataCopy = new ArrayList<>(data);
            long comeco = System.nanoTime();
            Sorting.bubbleSort(dataCopy);
            long fim = System.nanoTime();

            System.out.println("Bubble sort usado em " + file + ": " + (fim - comeco) / 1_000_000.0 + " ms");


            dataCopy = new ArrayList<>(data);
            comeco = System.nanoTime();
            Sorting.insertSort(dataCopy);
            fim = System.nanoTime();

            System.out.println("Insertion usado em " + file + ": " + (fim - comeco) / 1_000_000.0 + " ms");

            dataCopy = new ArrayList<>(data);
            comeco = System.nanoTime();
            Sorting.quickSort(dataCopy, 0, dataCopy.size() - 1);
            fim = System.nanoTime();
            System.out.println("Quick sort usado em " + file + ": " + (fim - comeco) / 1_000_000.0 + " ms");


            System.out.println("\n--------------THE END-------------------\n");
        }
    }
}