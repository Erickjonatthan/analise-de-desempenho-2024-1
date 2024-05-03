package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{
    private No cabeca;

    public ListaLigada() {
        
    }


    @Override
    public boolean buscaElemento(int valor) {
        No atual = this.cabeca;

        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }
            
            atual = atual.getProximo();
        }
        
        return false;
    }

    @Override
    public int buscaIndice(int indice) {
        No atual = this.cabeca;
        int posicao = 0;
        while(atual != null){
            if(posicao == indice){
                return atual.getValor();
            }
            atual = atual.getProximo();
            posicao++;
        }     
        return -1;

    }

    @Override
    public int minimo() {
        No atual = this.cabeca;
        int minimo = 0;
        while(atual != null){
            if(atual.getValor() < minimo){
                minimo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return minimo;
    }

    @Override
    public int maximo() {
        No atual = this.cabeca;
        int maximo = 0;
        while(atual != null){
            if(atual.getValor() > maximo){
                maximo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        No atual = this.cabeca;
  
        while(atual != null){
            if(atual.getProximo().getValor() == valor){
                return atual.getValor();
            }
            atual = atual.getProximo();
        }
        return -1;
       
    }

    @Override
    public int sucessor(int valor) {
        No atual = this.cabeca;
        while(atual != null){
            if(atual.getValor() == valor){
                return atual.getProximo().getValor();
            }
            atual = atual.getProximo();

        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
       if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
       }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No atual = this.cabeca;
        int indice = 0;
        if(buscaIndice == 0){
            insereInicio(valor);
            return;
        }
        else{
            while (atual != null) {
                if (indice == buscaIndice) {
                    No novo = new No(valor);
                    novo.setProximo(atual.getProximo());
                    atual.setProximo(novo);
                    return;
                }

                atual = atual.getProximo();
                indice++;
            }
    }
    }

    @Override
    public void insereInicio(int valor){

        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
       }
    }

    @Override
    public void insereFim(int valor) {
        No novo = new No(valor);

        if (this.cabeca == null) {
            this.cabeca = novo;
        } else {
            No atual = this.cabeca;

            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            atual.setProximo(novo);
        }
    }

    @Override
    public void remove(int valor) {
       No atual = this.cabeca;
       if(atual.getValor() == valor){
            this.cabeca = atual.getProximo();
       }
       else{
            while (atual.getProximo() != null) {
                if(atual.getProximo().getValor() == valor){
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
            }
                
            }
       }
    

    @Override
    public void removeIndice(int indice) {
       int valor = buscaIndice(indice);
       if(valor != -1)
       remove(valor);
    }
    @Override
    public void removeInicio() {
        if(this.cabeca != null){
            this.cabeca = this.cabeca.getProximo();
        }
        else{
            removeIndice(0);
        }
    }

    @Override
    public void removeFim() {
        No atual = this.cabeca;
        if(atual == null){
            removeIndice(0);
        }
        int indice = 0;
        while(atual != null){
            atual = atual.getProximo();
            indice++;
        }
        removeIndice(indice-1);
    } 
}
