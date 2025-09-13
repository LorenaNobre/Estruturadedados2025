package org.example;

import java.util.*;

public class ComparacaoOrdenacao {
    public static void main(String[] args) {

        int[] vetorAleatorio = criarVetorAleatorio(100);
        int[] vetorDecrescente = criarVetorDecrescente(100);


        int[] copiaAleatorio1 = Arrays.copyOf(vetorAleatorio, vetorAleatorio.length);
        int[] copiaAleatorio2 = Arrays.copyOf(vetorAleatorio, vetorAleatorio.length);
        int[] copiaDecrescente1 = Arrays.copyOf(vetorDecrescente, vetorDecrescente.length);
        int[] copiaDecrescente2 = Arrays.copyOf(vetorDecrescente, vetorDecrescente.length);


        int trocasBubbleAleatorio = bubbleSort(copiaAleatorio1);
        int trocasBubbleDecrescente = bubbleSort(copiaDecrescente1);


        int trocasSelectionAleatorio = selectionSort(copiaAleatorio2);
        int trocasSelectionDecrescente = selectionSort(copiaDecrescente2);


        System.out.println("=== Resultados ===");
        System.out.println("Bubble Sort (aleatório): " + trocasBubbleAleatorio + " trocas");
        System.out.println("Bubble Sort (decrescente): " + trocasBubbleDecrescente + " trocas");
        System.out.println("Selection Sort (aleatório): " + trocasSelectionAleatorio + " trocas");
        System.out.println("Selection Sort (decrescente): " + trocasSelectionDecrescente + " trocas");
    }


    public static int[] criarVetorAleatorio(int n) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = lista.get(i);
        }
        return vetor;
    }


    public static int[] criarVetorDecrescente(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = n - i;
        }
        return vetor;
    }


    public static int bubbleSort(int[] vetor) {
        int trocas = 0;
        int n = vetor.length;
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < n - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocas++;
                    houveTroca = true;
                }
            }
            n--;
        } while (houveTroca);
        return trocas;
    }


    public static int selectionSort(int[] vetor) {
        int trocas = 0;
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
                trocas++;
            }
        }
        return trocas;
    }
}

