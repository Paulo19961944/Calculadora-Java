package com.github.www;
import javax.swing.*;
import com.github.www.view.Calculadora;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculadora(); // Use diretamente a classe Calculadora
        });
    }
}
