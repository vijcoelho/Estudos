package org.example;

import org.example.generator.QrCode;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        final QrCode qrCode = new QrCode();
        var image = qrCode.generate("Testando o qr code funciona!");

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }

}