package org.example;

import java.util.Random;

public class VetorPosições {
    public static void main(String[] args) {
        Random random = new Random();

        int[] original = new int[100];   // vetor original com 100 posições
        int[] novo = new int[50];        // novo vetor com metade do tamanho

        int menorValor = Integer.MAX_VALUE; // começa com o maior inteiro possível
        int posicaoMenor = -1;              // posição do menor valor
        int soma = 0;                       // soma de todos os elementos

        // Percorrer o vetor original uma única vez
        for (int i = 0; i < original.length; i++) {
            // Preencher o vetor com valores aleatórios entre 0 e 100
            original[i] = random.nextInt(101);

            // Atualizar soma
            soma += original[i];

            // Verificar menor valor
            if (original[i] < menorValor) {
                menorValor = original[i];
                posicaoMenor = i;
            }

            // Preencher o novo vetor (só até metade)
            if (i < novo.length) {
                novo[i] = original[i] + original[original.length - 1 - i];
            }
        }

        // Mostrar resultados
        System.out.println("Menor valor encontrado: " + menorValor + " na posição " + posicaoMenor);
        System.out.println("Soma de todos os elementos: " + soma);

        System.out.println("Novo vetor (somas espelhadas):");
        for (int i = 0; i < novo.length; i++) {
            System.out.println("Posição " + i + ": " + novo[i]);
        }
    }
}
