package org.example;

public class ListaEncadeada {


    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio;
    private int tamanho;


    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }


    public void inserirInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }


    public void inserirFim(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }


    public void inserirPosicao(int valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (pos == 0) {
            inserirInicio(valor);
            return;
        }
        No novo = new No(valor);
        No anterior = inicio;
        for (int i = 0; i < pos - 1; i++) {
            anterior = anterior.proximo;
        }
        novo.proximo = anterior.proximo;
        anterior.proximo = novo;
        tamanho++;
    }


    public int removerInicio() {
        if (inicio == null) {
            throw new IllegalStateException("Lista vazia");
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;
        tamanho--;
        return valor;
    }


    public int removerFim() {
        if (inicio == null) {
            throw new IllegalStateException("Lista vazia");
        }
        if (inicio.proximo == null) {
            int valor = inicio.valor;
            inicio = null;
            tamanho--;
            return valor;
        }
        No atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        int valor = atual.proximo.valor;
        atual.proximo = null;
        tamanho--;
        return valor;
    }


    public int removerPosicao(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (pos == 0) {
            return removerInicio();
        }
        No anterior = inicio;
        for (int i = 0; i < pos - 1; i++) {
            anterior = anterior.proximo;
        }
        int valor = anterior.proximo.valor;
        anterior.proximo = anterior.proximo.proximo;
        tamanho--;
        return valor;
    }


    public boolean removerElemento(int valor) {
        int pos = pesquisar(valor);
        if (pos == -1) {
            return false;
        }
        removerPosicao(pos);
        return true;
    }


    public void exibir() {
        No atual = inicio;
        if (atual == null) {
            System.out.println("Lista vazia");
            return;
        }
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println();
    }


    public int pesquisar(int valor) {
        No atual = inicio;
        int indice = 0;
        while (atual != null) {
            if (atual.valor == valor) {
                return indice;
            }
            atual = atual.proximo;
            indice++;
        }
        return -1;
    }

    
    public int tamanho() {
        return tamanho;
    }
}

