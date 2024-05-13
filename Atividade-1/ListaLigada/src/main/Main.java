import java.io.IOException;
import linked.ListaLigada;
import list.EstruturaElementar;

public class Main {
    public static void main(String[] args) throws IOException{

        String path = "Atividade-1/ListaLigada/src/main/arq-novo.txt";

        EstruturaElementar listaLigada = new ListaLigada();

        System.out.println("Resposta do arquivo (arq-novo.txt):");
        ExecutadorArquivo.executa(path, listaLigada);
    }
}