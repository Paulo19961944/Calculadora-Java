package com.github.www.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.github.www.controller.CalculadoraController;

public class Calculadora extends JFrame {
    private JLabel[] notaLabels;
    private JTextField[] notaFields;
    private JButton calcularButton;
    private JCheckBox faixaNotasCheckBox;
    private CalculadoraController controller;

    public Calculadora() {
        controller = new CalculadoraController(this);

        // Configuração da janela
        setTitle("Calculadora de Nota");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(425, 800);
        setLocationRelativeTo(null);

        // Crie um JPanel para servir como o conteúdo principal
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Defina a cor de fundo do JPanel (pode ser ajustada conforme necessário)
                g.setColor(new Color(64, 64, 64));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Defina o layout do JPanel como nulo
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        // Adicione um JLabel para o título
        JLabel titleLabel = new JLabel("Calculadora de Média de Notas");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 24));
        titleLabel.setForeground(new Color(240, 240, 240));
        titleLabel.setBounds(20, 70, 400, 30);
        contentPanel.add(titleLabel);

        // Componentes da Calculadora
        notaLabels = new JLabel[4];
        notaFields = new JTextField[4];

        for (int i = 0; i < 4; i++) {
            notaLabels[i] = new JLabel("Digite a " + (i + 1) + "ª Nota:");
            notaLabels[i].setForeground(new Color(240, 240, 240));
            notaLabels[i].setFont(new Font("Open Sans", Font.PLAIN, 20));
            notaLabels[i].setBounds(20, 180 + i * 50, 200, 30);
            contentPanel.add(notaLabels[i]);

            notaFields[i] = new JTextField();
            notaFields[i].setBounds(220, 180 + i * 50, 150, 30);
            notaFields[i].setBackground(new Color(240, 240, 240));
            notaFields[i].setFont(new Font("Open Sans", Font.PLAIN, 20));
            contentPanel.add(notaFields[i]);
        }

        // Adicione um JCheckBox para escolher a faixa de notas
        faixaNotasCheckBox = new JCheckBox("Notas de 0 a 10");
        faixaNotasCheckBox.setBounds(20, 420, 150, 30);
        faixaNotasCheckBox.setBackground(new Color(64, 64, 64));
        faixaNotasCheckBox.setForeground(new Color(240, 240, 240));
        contentPanel.add(faixaNotasCheckBox);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(20, 530, 100, 30);
        calcularButton.setBackground(new Color(2, 117, 216));
        calcularButton.setForeground(new Color(250, 250, 250));
        contentPanel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.calcularMedia();
            }
        });

        // Mostra a janela
        setVisible(true);
    }

    // Métodos de acesso aos campos de texto e à caixa de seleção
    public JTextField[] getNotaFields() {
        return notaFields;
    }

    public JCheckBox getFaixaNotasCheckBox() {
        return faixaNotasCheckBox;
    }
}
