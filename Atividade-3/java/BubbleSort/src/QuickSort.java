import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    
    public int[] ordena(int[] array) {
        quickParticio(array, 0, array.length - 1);
        return array;
    }

    public int quickParticio(int[] array, int inicio, int fim) {
        int i = inicio;
        if (inicio < fim) {
            int pivo = array[inicio];

            for (int j = inicio + 1; j <= fim; j++) {
                if (array[j] <= pivo) {
                    i += 1;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i];
            array[i] = array[inicio];
            array[inicio] = temp;

            quickParticio(array, inicio, i - 1);
            quickParticio(array, i + 1, fim);

        }
        return i;
    }

    public List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        }
        return numbers;
    }

    public void writeNumbersToFile(int[] arr, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int number : arr) {
                writer.write(number + "\n");
            }
        }
    }

}