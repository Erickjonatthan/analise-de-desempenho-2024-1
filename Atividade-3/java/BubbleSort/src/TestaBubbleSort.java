import java.io.IOException;
import java.util.List;

public class TestaBubbleSort {
    public static void main(String[] args) throws IOException {
        // Caminho do arquivo de entrada
        String inputFile = "Atividade-3\\arq-teste.txt";
        // Caminho do arquivo de saída
        String outputFile = "Atividade-3\\arq-teste-ordenado.txt";

        BubbleSort bs = new BubbleSort();
        // Ler números do arquivo
        List<Integer> list = bs.readNumbersFromFile(inputFile);
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        // Ordenar o array
        arr = bs.ordena(arr);

        // Escrever o array ordenado no arquivo
        bs.writeNumbersToFile(arr, outputFile);

        System.out.println("Array ordenado e salvo em: " + outputFile);

    }
}
