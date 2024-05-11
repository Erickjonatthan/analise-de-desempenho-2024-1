class No {
    constructor(valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaLigada {
    constructor() {
        this.cabeca = null;
    }

    buscaElemento(valor) {
        let atual = this.cabeca;
        while (atual) {
            if (atual.valor === valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    buscaIndice(indice) {
        let atual = this.cabeca;
        let posicao = 0;
        while (atual) {
            if (posicao === indice) {
                return atual.valor;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }

    minimo() {
        let atual = this.cabeca;
        let minimo = Infinity;
        while (atual) {
            if (atual.valor < minimo) {
                minimo = atual.valor;
            }
            atual = atual.proximo;
        }
        return minimo;
    }

    maximo() {
        let atual = this.cabeca;
        let maximo = -Infinity;
        while (atual) {
            if (atual.valor > maximo) {
                maximo = atual.valor;
            }
            atual = atual.proximo;
        }
        return maximo;
    }

    predecessor(valor) {
        let atual = this.cabeca;
        while (atual && atual.proximo) {
            if (atual.proximo.valor === valor) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    sucessor(valor) {
        let atual = this.cabeca;
        while (atual) {
            if (atual.valor === valor) {
                return atual.proximo ? atual.proximo.valor : -1;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    insereElemento(valor) {
        const novoNo = new No(valor);
        novoNo.proximo = this.cabeca;
        this.cabeca = novoNo;
    }

    insereElementoPosicao(valor, indice) {
        const novoNo = new No(valor);
        if (indice === 0) {
            novoNo.proximo = this.cabeca;
            this.cabeca = novoNo;
        } else {
            let atual = this.cabeca;
            let anterior = null;
            let posicao = 0;
            while (atual && posicao !== indice) {
                anterior = atual;
                atual = atual.proximo;
                posicao++;
            }
            novoNo.proximo = atual;
            if (anterior) {
                anterior.proximo = novoNo;
            }
        }
    }

    insereInicio(valor) {
        const novoNo = new No(valor);
        novoNo.proximo = this.cabeca;
        this.cabeca = novoNo;
    }

    insereFim(valor) {
        const novoNo = new No(valor);
        if (!this.cabeca) {
            this.cabeca = novoNo;
        } else {
            let atual = this.cabeca;
            while (atual.proximo) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    remove(valor) {
        let atual = this.cabeca;
        if (atual.valor === valor) {
            this.cabeca = atual.proximo;
        } else {
            while (atual.proximo) {
                if (atual.proximo.valor === valor) {
                    atual.proximo = atual.proximo.proximo;
                    return;
                }
                atual = atual.proximo;
            }
        }
    }

    removeIndice(indice) {
        const valor = this.buscaIndice(indice);
        if (valor !== -1) {
            this.remove(valor);
        }
    }

    removeInicio() {
        if (this.cabeca) {
            this.cabeca = this.cabeca.proximo;
        }
    }

    removeFim() {
        let atual = this.cabeca;
        if (!atual || !atual.proximo) {
            this.cabeca = null;
        } else {
            while (atual.proximo.proximo) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
    }

    toString() {
        let atual = this.cabeca;
        let lista = '';
        while (atual) {
            lista += atual.valor + ' ';
            atual = atual.proximo;
        }
        return lista;
    }
}
module.exports = ListaLigada;