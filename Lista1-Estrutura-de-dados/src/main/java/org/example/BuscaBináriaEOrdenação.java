package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaBináriaEOrdenação {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        int tamanho = 10;
        int[] vetor = new int[tamanho];


        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100);
        }


        Arrays.sort(vetor);


        System.out.println("Vetor ordenado:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }


        System.out.println("\n\nDigite um número para buscar:");
        int valor = sc.nextInt();


        int resultado = buscaBinaria(vetor, valor);


        if (resultado == -1) {
            System.out.println("O valor " + valor + " não foi encontrado no vetor.");
        } else {
            System.out.println("O valor " + valor + " foi encontrado na posição " + resultado + ".");
        }

        sc.close();
    }


    public static int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) {
                return meio;
            } else if (valor < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }
}
