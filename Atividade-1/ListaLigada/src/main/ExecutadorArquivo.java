import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import list.EstruturaElementar;

public class ExecutadorArquivo {

    public static void executa(String filePath, EstruturaElementar listaLigada) throws IOException {
        
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        
        String linha = buffRead.readLine();

        String[] numerosIniciais = linha.split(" ");
        
        for (String numero : numerosIniciais) {
            listaLigada.insereFim(Integer.parseInt(numero));
        }

        int quantidadeAcoes = Integer.parseInt(buffRead.readLine());

        for (int i = 0; i < quantidadeAcoes; i++) {
            System.out.println("Ação " + (i + 1) + ":");
            String acao = buffRead.readLine();
            
            String[] acaoSplit = acao.split(" ");

            if (acaoSplit[0].equals("A")) {
                
                int valor = Integer.parseInt(acaoSplit[1]);

                try {
                    int posicao = Integer.parseInt(acaoSplit[2]) - 1;
                    listaLigada.insereElementoPosicao(valor, posicao);
                    System.out.println("Valor " + valor + " inserido na posição " + (posicao + 1) + ".");
                } catch (Exception e) {
                    System.out.println("Posição para inserir inválida. Continuando para a próxima ação.");
                }

            } else if (acaoSplit[0].equals("R")) {

                    int valor = Integer.parseInt(acaoSplit[1]);
                    
                    //quando a ação remover é passado a posição
                    if (acaoSplit.length == 3) {
                        
                        int posicao = Integer.parseInt(acaoSplit[2]) - 1;
                        int valorPosicao = listaLigada.buscaIndice(posicao);
                        boolean valorExiste = listaLigada.buscaElemento(valor);

                        if (valorExiste && (valorPosicao == valor)) {
                            listaLigada.remove(valor);
                            System.out.println("Valor " + valor + " removido.");
                        } else {
                            System.out.println("O valor " + valor + " não existe na posição "+(posicao+1)+". Continuando para a próxima ação.");
                        }
                    }
                    //quando a ação remover é passado somente o valor
                    else if (listaLigada.buscaElemento(valor)) {
                        listaLigada.remove(valor);
                        System.out.println("Valor " + valor + " removido.");
                    } else {
                        System.out.println("O valor " + valor + " não existe na lista. Continuando para a próxima ação.");
                    }
                
            
            } else if (acaoSplit[0].equals("P")) {
                
                System.out.println(listaLigada.toString());
                System.out.println("-------");
            
            }
        }

        buffRead.close();
    }
}
