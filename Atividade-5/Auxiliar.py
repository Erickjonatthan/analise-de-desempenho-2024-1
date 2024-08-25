import re

def extrair_numeros(arquivo):
    tempos = []
    memorias = []
    
    try:
        with open(arquivo, 'r') as file:
            linhas = file.readlines()
            
            for linha in linhas:
                numeros = re.findall(r'\d+', linha)
                if len(numeros) >= 3:
                    tempos.append(int(numeros[1]))
                    memorias.append(int(numeros[2]))
    except FileNotFoundError:
        print(f"Arquivo {arquivo} não encontrado.")
    
    return tempos, memorias

def formatar_para_excel(tempos, memorias):
    linhas = ["Tempo de execução"]
    for tempo in tempos:
        linhas.append(str(tempo))
    
    linhas.append("RAM utilizada")
    for memoria in memorias:
        linhas.append(str(memoria))
    
    return "\n".join(linhas)

# Exemplo de uso
arquivo = 'resultado-quick-java.txt'
tempos, memorias = extrair_numeros(arquivo)
resultado_formatado = formatar_para_excel(tempos, memorias)
print(resultado_formatado)
