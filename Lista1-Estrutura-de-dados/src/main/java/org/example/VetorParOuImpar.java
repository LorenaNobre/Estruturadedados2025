package org.example;

import java.util.Scanner;

public class VetorParOuImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] pares = new int [5];
        int [] impares = new int [5];

        int indicePares = 0;
        int indiceImpares = 0;

        System.out.println("Digite 5 números inteiros:");
        for (int i = 0; i < 5; i++){
            int numero = sc.nextInt();

            if (numero % 2 ==0){
                pares[indicePares] = numero;
                indicePares++;

            } else{
                impares[indiceImpares] = numero;
                indiceImpares++;

            }
        }

        System.out.println("\nNúmeros pares digitados:");
        for (int i = 0; i < indicePares; i++){
            System.out.print(pares[i] + " ");
        }

        System.out.println("\nNúmeros ímpares digitados");
        for (int i = 0; i < indiceImpares; i++){
            System.out.print(impares[i] + " ");
        }

        sc.close();

    }
}
