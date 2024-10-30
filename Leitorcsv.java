import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitorcsv {
    public static List<Integer> readCSV(String filePath) {
        List<Integer> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Adiciona uma variável para verificar a primeira linha
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Pula a primeira linha
                    continue;
                }
                try {
                    data.add(Integer.parseInt(line.trim())); // Tenta converter cada linha para Integer
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter para Integer: " + line); // Mensagem de erro
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + filePath);
        }
        return data;
    }

}
