import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TestaBubbleSort {
    public static void main(String[] args) throws IOException {
        // Caminho do arquivo de entrada
        String inputFile = "Atividade-3\\arq.txt";
        // Caminho do arquivo de saída
        String outputFile = "Atividade-3\\arq-ordenado.txt";

        BubbleSort bs = new BubbleSort();

        // Medir o uso de memória antes da execução
        long memBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Medir o tempo de início
        long startTime = System.nanoTime();

        // Ler números do arquivo
        List<Integer> list = bs.readNumbersFromFile(inputFile);
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        // Ordenar o array
        arr = bs.ordena(arr);

        // Escrever o array ordenado no arquivo
        bs.writeNumbersToFile(arr, outputFile);

        // Medir o tempo de fim e calcular a diferença
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000; // Convertendo para milissegundos

        // Medir o uso de memória após a execução e calcular a diferença
        long memAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memUsed = (memAfter - memBefore) / 1024; // Convertendo bytes para KB

        System.out.println("Array ordenado e salvo em: " + outputFile);
        System.out.println("Tempo de execução: " + elapsedTime + " ms");
        System.out.println("RAM utilizada: " + memUsed + " KB");

        try (FileWriter fw = new FileWriter("Atividade-3/resultado-bubble-java.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            // Escrever no arquivo o tempo de execução e a memória utilizada
            out.println("Tempo de execução: " + elapsedTime + " ms, RAM utilizada: " + memUsed + " KB");
        } catch (IOException e) {
            // Tratamento de exceção de I/O
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

    }
}
