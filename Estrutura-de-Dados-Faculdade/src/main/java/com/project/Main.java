package com.project;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] vetor = {10, 1, 4, 6, 2, 3, 5, 9, 7, 8};

        System.out.println(Arrays.toString(bubbleSort(vetor)));

        quickSort(0, 9, vetor);
    }


    public static int[] bubbleSort(final int[] numeros) {
        final int n = numeros.length;
        
        int aux;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }
        return numeros;
    }

    public static void quickSort(int p, int q, int[] vetor) {
        int x;

        if (p < q) {
            x = particao(p, q, vetor);
            quickSort(p, x - 1, vetor);
            quickSort(x + 1, q, vetor);
        }
    }

    public static int particao(int p, int q, int[] vetor) {
        int j = p - 1;
        int temp, aux = vetor[q];

        for (int i = p; i <= q; i++) {
            if (vetor[i] <= aux) {
                j++;
                temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        return j;
    }
}