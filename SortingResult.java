import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class SortingResult {
    private String algorithm;
    private String fileName;
    private double executionTime; // Tempo em milissegundos

    public SortingResult(String algorithm, String fileName) {
        this.algorithm = algorithm;
        this.fileName = fileName;
    }

    public void measure(List<Integer> originalData, Consumer<List<Integer>> sortingAlgorithm) {
        List<Integer> dataCopy = new ArrayList<>(originalData);

        long startTime = System.nanoTime();
        sortingAlgorithm.accept(dataCopy);
        long endTime = System.nanoTime();

        this.executionTime = (endTime - startTime) / 1_000_000.0;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getFileName() {
        return fileName;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %.4f ms", algorithm, fileName, executionTime);
    }

}
