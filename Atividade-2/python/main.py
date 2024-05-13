from ListaLigada import ListaLigada
from ExecutadorArquivo import ExecutadorArquivo

def main():
   
    path = "Atividade-2/python/arq-novo.txt"

    listaLigada = ListaLigada()

    print("Resposta do arquivo (arq-novo.txt):")
    ExecutadorArquivo.executa(path, listaLigada)

if __name__ == "__main__":
    main()




