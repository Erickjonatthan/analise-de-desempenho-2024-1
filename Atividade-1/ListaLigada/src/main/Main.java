import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import linked.ListaLigada;
import list.EstruturaElementar;

public class Main {
    public static void main(String[] args) throws IOException{

        String path = "Atividade-1/ListaLigada/src/main/arq.txt";
        
        EstruturaElementar listaLigada = new ListaLigada();
        
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        
        String linha = buffRead.readLine();

        String[] numerosIniciais = linha.split(" ");
        
        for (String numero : numerosIniciais) {
            listaLigada.insereFim(Integer.parseInt(numero));
        }

        int quantidadeAcoes = Integer.parseInt(buffRead.readLine());

        for (int i = 0; i < quantidadeAcoes; i++) {
            
            String acao = buffRead.readLine();
            
            String[] acaoSplit = acao.split(" ");

            if (acaoSplit[0].equals("A")) {
                int valor = Integer.parseInt(acaoSplit[1]);
                int posicao = Integer.parseInt(acaoSplit[2]);
                listaLigada.insereElementoPosicao(valor, posicao-1);

            } else if (acaoSplit[0].equals("R")) {
                int valor = Integer.parseInt(acaoSplit[1]);
                listaLigada.remove(valor);
            
            } else if (acaoSplit[0].equals("P")) {
                
                System.out.println(listaLigada.toString());
            
            }
        }

        buffRead.close();

     

    }
}
