import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] arquivos = {
                "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        System.out.printf("%-20s %-20s %-10s\n", "Algoritmo", "Arquivo", "Tempo (ms)");
        System.out.println("-----------------------------------------------------------");

        for (String file : arquivos) {
            List<Integer> data = Leitorcsv.readCSV(file);

            List<Integer> dataCopy = new ArrayList<>(data);
            long start = System.nanoTime();
            Sorting.bubbleSort(dataCopy);
            long end = System.nanoTime();
            double bubbleTime = (end - start) / 1_000_000.0;
            System.out.printf("%-20s %-20s %-10.4f\n", "Bubble Sort", file, bubbleTime);

            dataCopy = new ArrayList<>(data);
            start = System.nanoTime();
            Sorting.insertSort(dataCopy);
            end = System.nanoTime();
            double insertionTime = (end - start) / 1_000_000.0;
            System.out.printf("%-20s %-20s %-10.4f\n", "Insertion Sort", file, insertionTime);

            dataCopy = new ArrayList<>(data);
            start = System.nanoTime();
            Sorting.quickSort(dataCopy, 0, dataCopy.size() - 1);
            end = System.nanoTime();
            double quickTime = (end - start) / 1_000_000.0;
            System.out.printf("%-20s %-20s %-10.4f\n", "Quick Sort", file, quickTime);

            System.out.println("-----------------------------------------------------------");
        }
    }
}
