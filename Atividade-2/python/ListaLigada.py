class No:
    def __init__(self, valor):
        self.valor = valor
        self.proximo = None

class ListaLigada:
    def __init__(self):
        self.cabeca = None

    def buscaElemento(self, valor):
        atual = self.cabeca
        while atual is not None:
            if atual.valor == valor:
                return True
            atual = atual.proximo
        return False

    def buscaIndice(self, indice):
        atual = self.cabeca
        posicao = 0
        while atual is not None:
            if posicao == indice:
                return atual.valor
            atual = atual.proximo
            posicao += 1
        return -1

    def minimo(self):
        if self.cabeca is None:
            return None
        atual = self.cabeca
        minimo = atual.valor
        while atual is not None:
            if atual.valor < minimo:
                minimo = atual.valor
            atual = atual.proximo
        return minimo

    def maximo(self):
        if self.cabeca is None:
            return None
        atual = self.cabeca
        maximo = atual.valor
        while atual is not None:
            if atual.valor > maximo:
                maximo = atual.valor
            atual = atual.proximo
        return maximo

    def predecessor(self, valor):
        atual = self.cabeca
        while atual is not None and atual.proximo is not None:
            if atual.proximo.valor == valor:
                return atual.valor
            atual = atual.proximo
        return -1

    def sucessor(self, valor):
        atual = self.cabeca
        while atual is not None and atual.proximo is not None:
            if atual.valor == valor:
                return atual.proximo.valor
            atual = atual.proximo
        return -1

    def insereElemento(self, valor):
        novo_no = No(valor)
        novo_no.proximo = self.cabeca
        self.cabeca = novo_no

    def insereElementoPosicao(self, valor, indice):
        novo_no = No(valor)
        if indice == 0:
            novo_no.proximo = self.cabeca
            self.cabeca = novo_no
        else:
            atual = self.cabeca
            posicao = 0
            while atual is not None:
                if posicao == indice - 1:
                    novo_no.proximo = atual.proximo
                    atual.proximo = novo_no
                    return
                atual = atual.proximo
                posicao += 1

    def insereInicio(self, valor):
        novo_no = No(valor)
        novo_no.proximo = self.cabeca
        self.cabeca = novo_no

    def insereFim(self, valor):
        novo_no = No(valor)
        if self.cabeca is None:
            self.cabeca = novo_no
        else:
            atual = self.cabeca
            while atual.proximo is not None:
                atual = atual.proximo
            atual.proximo = novo_no

    def remove(self, valor):
        if self.cabeca is None:
            return
        if self.cabeca.valor == valor:
            self.cabeca = self.cabeca.proximo
        else:
            atual = self.cabeca
            while atual.proximo is not None:
                if atual.proximo.valor == valor:
                    atual.proximo = atual.proximo.proximo
                    return
                atual = atual.proximo

    def removeIndice(self, indice):
        valor = self.buscar_indice(indice)
        if valor != -1:
            self.remover(valor)

    def removeInicio(self):
        if self.cabeca is not None:
            self.cabeca = self.cabeca.proximo

    def removeFim(self):
        if self.cabeca is None:
            return
        if self.cabeca.proximo is None:
            self.cabeca = None
        else:
            atual = self.cabeca
            while atual.proximo.proximo is not None:
                atual = atual.proximo
            atual.proximo = None

    def __str__(self):
        atual = self.cabeca
        elementos = []
        while atual is not None:
            elementos.append(str(atual.valor))
            atual = atual.proximo
        return ' '.join(elementos)