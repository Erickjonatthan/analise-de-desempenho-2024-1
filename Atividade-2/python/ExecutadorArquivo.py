import io

class ExecutadorArquivo:

    def executa(filePath, listaLigada):
        with io.open(filePath, 'r', encoding='utf8') as file:
            linha = file.readline().strip()

            numerosIniciais = linha.split(" ")
            
            for numero in numerosIniciais:
                listaLigada.insereFim(int(numero))

            quantidadeAcoes = int(file.readline().strip())

            for i in range(quantidadeAcoes):
                print("Ação " + str(i + 1) + ":")
                acao = file.readline().strip()
                
                acaoSplit = acao.split(" ")

                if acaoSplit[0] == "A":
                    
                    valor = int(acaoSplit[1])

                    try:
                        posicao = int(acaoSplit[2]) - 1
                        listaLigada.insereElementoPosicao(valor, posicao)
                        print("Valor " + str(valor) + " inserido na posição " + str(posicao + 1) + ".")
                    except Exception as e:
                        print("Posição para inserir inválida. Continuando para a próxima ação.")

                elif acaoSplit[0] == "R":

                    valor = int(acaoSplit[1])
                    
                    # quando a ação remover é passado a posição
                    if len(acaoSplit) == 3:
                        
                        posicao = int(acaoSplit[2]) - 1
                        valorPosicao = listaLigada.buscaIndice(posicao)
                        valorExiste = listaLigada.buscaElemento(valor)

                        if valorExiste and (valorPosicao == valor):
                            listaLigada.remove(valor)
                            print("Valor " + str(valor) + " removido.")
                        else:
                            print("O valor " + str(valor) + " não existe na posição "+ str(posicao+1) +". Continuando para a próxima ação.")
                    # quando a ação remover é passado somente o valor
                    elif listaLigada.buscaElemento(valor):
                        listaLigada.remove(valor)
                        print("Valor " + str(valor) + " removido.")
                    else:
                        print("O valor " + str(valor) + " não existe na lista. Continuando para a próxima ação.")
                
                elif acaoSplit[0] == "P":
                    
                    print(str(listaLigada))
                    print("-------")