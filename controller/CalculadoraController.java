package com.github.www.controller;
import com.github.www.view.Calculadora;
import javax.swing.*;
import java.text.DecimalFormat;

public class CalculadoraController {
    private Calculadora view;

    public CalculadoraController(Calculadora view) {
        this.view = view;
    }

    public void calcularMedia() {
        double soma = 0;
        double faixaMaxima = view.getFaixaNotasCheckBox().isSelected() ? 10 : 100;

        for (int i = 0; i < 4; i++) {
            try {
                double nota = Double.parseDouble(view.getNotaFields()[i].getText().replace(',', '.'));
                if (nota < 0 || nota > faixaMaxima) {
                    JOptionPane.showMessageDialog(view, "Digite uma nota válida entre 0 e " + faixaMaxima + " para a " + (i + 1) + "ª nota.");
                    view.getNotaFields()[i].setText("");
                    view.getNotaFields()[i].requestFocus();
                    return;
                }
                soma += nota;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Digite um número válido para a " + (i + 1) + "ª nota.");
                view.getNotaFields()[i].setText("");
                view.getNotaFields()[i].requestFocus();
                return;
            }
        }

        double media = soma / 4;
        DecimalFormat df = new DecimalFormat("#.##"); // Formatar para duas casas decimais
        JOptionPane.showMessageDialog(view, "A média das notas é: " + df.format(media));

        for (int i = 0; i < 4; i++) {
            view.getNotaFields()[i].setText("");
        }
    }
}
