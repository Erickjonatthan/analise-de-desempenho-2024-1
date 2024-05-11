import java.io.IOException;
import linked.ListaLigada;
import list.EstruturaElementar;

public class Main {
    public static void main(String[] args) throws IOException{

        String path1 = "Atividade-1/ListaLigada/src/main/arq.txt";
        String path2 = "Atividade-1/ListaLigada/src/main/arq1.txt";
        String path3 = "Atividade-2/python/arq-novo.txt";

        EstruturaElementar listaLigada = new ListaLigada();

        System.out.println("Resposta do arquivo (arq.txt):");
        ExecutadorArquivo.executa(path1, listaLigada);
        
        System.out.println("Resposta do arquivo (arq1.txt):");
        ExecutadorArquivo.executa(path2, listaLigada);

        System.out.println("Resposta do arquivo (arq-novo.txt):");
        ExecutadorArquivo.executa(path3, listaLigada);
    }
}