def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr.pop()
        greater = []
        lower = []
        for i in arr:
            if i > pivot:
                greater.append(i)
            else:
                lower.append(i)
        return quick_sort(lower) + [pivot] + quick_sort(greater)

def read_and_sort_file(file_path):
    with open(file_path, 'r') as file:
        arr = [int(line.strip()) for line in file.readlines()]
    sorted_arr = quick_sort(arr)
    
    # Caminho do novo arquivo
    new_file_path = file_path.replace('arq-teste.txt', 'arq-teste-ordenado.txt')
    
    # Escrever a lista ordenada no novo arquivo
    with open(new_file_path, 'w') as file:
        for item in sorted_arr:
            file.write(f"{item}\n")
    
    return sorted_arr

# Caminho do arquivo
file_path = r'Atividade-3\arq-teste.txt'

# Ordenar e salvar a lista ordenada
sorted_arr = read_and_sort_file(file_path)
print(f"Arquivo ordenado salvo como: {file_path.replace('arq-teste.txt', 'arq-teste-ordenado.txt')}")