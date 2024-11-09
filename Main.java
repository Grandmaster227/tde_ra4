import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

            SortingResult bubbleSortResult = new SortingResult("Bubble Sort", file);
            bubbleSortResult.measure(data, Sorting::bubbleSort);
            System.out.printf("%-20s %-20s %-10.4f\n", bubbleSortResult.getAlgorithm(), bubbleSortResult.getFileName(), bubbleSortResult.getExecutionTime());

            SortingResult insertionSortResult = new SortingResult("Insertion Sort", file);
            insertionSortResult.measure(data, Sorting::insertSort);
            System.out.printf("%-20s %-20s %-10.4f\n", insertionSortResult.getAlgorithm(), insertionSortResult.getFileName(), insertionSortResult.getExecutionTime());

            SortingResult quickSortResult = new SortingResult("Quick Sort", file);
            quickSortResult.measure(data, dataList -> Sorting.quickSort(dataList, 0, dataList.size() - 1));
            System.out.printf("%-20s %-20s %-10.4f\n", quickSortResult.getAlgorithm(), quickSortResult.getFileName(), quickSortResult.getExecutionTime());

            System.out.println("-----------------------------------------------------------");
        }
    }
}
