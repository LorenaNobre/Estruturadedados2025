package org.example;

class ListaEncadeada {
    private int[] elementos;
    private int tamanho;
    private int capacidade;


    public ListaEncadeada(int capacidadeMaxima) {
        this.capacidade = capacidadeMaxima;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }


    public void inserirInicio(int valor) {
        if (tamanho == capacidade) {
            System.out.println("Lista cheia!");
            return;
        }
        for (int i = tamanho; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = valor;
        tamanho++;
    }


    public void inserirFim(int valor) {
        if (tamanho == capacidade) {
            System.out.println("Lista cheia!");
            return;
        }
        elementos[tamanho] = valor;
        tamanho++;
    }


    public void inserirPosicao(int valor, int pos) {
        if (tamanho == capacidade || pos < 0 || pos > tamanho) {
            System.out.println("Posição inválida ou lista cheia!");
            return;
        }
        for (int i = tamanho; i > pos; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[pos] = valor;
        tamanho++;
    }


    public void removerInicio() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }


    public void removerFim() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        tamanho--;
    }


    public void removerPosicao(int pos) {
        if (tamanho == 0 || pos < 0 || pos >= tamanho) {
            System.out.println("Posição inválida ou lista vazia!");
            return;
        }
        for (int i = pos; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }


    public void removerElemento(int valor) {
        int pos = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            removerPosicao(pos);
        } else {
            System.out.println("Elemento não encontrado!");
        }
    }


    public void exibir() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }


    public int pesquisar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }


    public int tamanho() {
        return tamanho;
    }
}

