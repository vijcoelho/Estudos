package com.project;

import javax.swing.*;

public class Somar {

    public static void main(String[] args) {
        int i, soma = 0;
        int[] vetSoma = new int[5];

        for (i = 0; i < 5; i++) {
            vetSoma[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro."));
            soma += vetSoma[i];
        }
        System.out.println("A soma dos numeros digitados eh1: " + soma);
        System.exit(0);
    }
}
