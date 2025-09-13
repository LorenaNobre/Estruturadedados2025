package org.example;

import java.util.Scanner;

public class VetorMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetorA = new int[10];
        int[] vetorB = new int[10];
        float[] vetorC = new float[10]; // precisa ser float/double para aceitar médias decimais

        // Ler valores do vetor A
        System.out.println("Digite 10 valores para o vetor A:");
        for (int i = 0; i < 10; i++) {
            vetorA[i] = sc.nextInt();
        }

        // Ler valores do vetor B
        System.out.println("Digite 10 valores para o vetor B:");
        for (int i = 0; i < 10; i++) {
            vetorB[i] = sc.nextInt();
        }

        // Calcular médias para o vetor C
        for (int i = 0; i < 10; i++) {
            vetorC[i] = (vetorA[i] + vetorB[i]) / 2.0f;
        }

        // Exibir vetor C
        System.out.println("Vetor C (médias):");
        for (int i = 0; i < 10; i++) {
            System.out.println("Posição " + i + ": " + vetorC[i]);
        }

        sc.close();
    }
}
