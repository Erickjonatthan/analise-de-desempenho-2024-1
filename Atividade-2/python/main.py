path = "analise-de-desempenho-2024-1/Atividade-2/python/arq-novo.txt"

from ListaLigada import ListaLigada
from ExecutadorArquivo import ExecutadorArquivo

def main():
    path1 = "Atividade-2/python/arq.txt"
    path2 = "Atividade-2/python/arq1.txt"
    path3 = "Atividade-2/python/arq-novo.txt"

    listaLigada = ListaLigada()

    print("Resposta do arquivo (arq.txt):")
    ExecutadorArquivo.executa(path1, listaLigada)
    
    print("Resposta do arquivo (arq1.txt):")
    ExecutadorArquivo.executa(path2, listaLigada)

    print("Resposta do arquivo (arq-novo.txt):")
    ExecutadorArquivo.executa(path3, listaLigada)

if __name__ == "__main__":
    main()



