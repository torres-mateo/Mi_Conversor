
package Conversor;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorDivisas extends JPanel {

    private final JComboBox<String> fromCurrencyComboBox;
    private final JComboBox<String> toCurrencyComboBox;
    private final JTextField inputField;
    private final JLabel resultLabel;
    private final PantallaPrincipal pantallaPrincipal;

    // Tasa fija de conversión (1 unidad de divisa "from" a unidades de divisa "to")
    private final double[][] conversionRates = {
            {1.0, 0.85, 110.27, 4202.50, 20.07, 7.0}, // Euro
            {1.18, 1.0, 129.65, 3932.90, 23.58, 8.27}, // Dólar
            {0.0091, 0.0077, 1.0, 38.10, 0.18, 0.062}, // Yen
            {0.00024, 0.00020, 0.026, 1.0, 0.0048, 0.0017}, // Peso Colombiano
            {0.049, 0.041, 5.38, 204.32, 1.0, 0.35}, // Peso Mexicano
            {0.14, 0.12, 16.22, 617.23, 2.95, 1.0} // Yuan
    };

    public ConversorDivisas(PantallaPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal; // Guardamos la referencia de la PantallaPrincipal
        setLayout(new FlowLayout());
        setBackground(new Color(30,146,247));

        String[] currencyNames = {"Euro", "Dólar", "Yen", "Peso Colombiano", "Peso Mexicano", "Yuan"};

        fromCurrencyComboBox = new JComboBox<>(currencyNames);
        toCurrencyComboBox = new JComboBox<>(currencyNames);
        inputField = new JTextField(10);
        resultLabel = new JLabel("Resultado:");

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(e -> convertCurrency());



        add(new JLabel("Convertir de:"));
        add(fromCurrencyComboBox);
        add(new JLabel("a:"));
        add(toCurrencyComboBox);
        add(new JLabel("Ingrese la cantidad:"));
        add(inputField);
        add(convertButton);
        add(resultLabel);

    }

    private void regresarPantallaPrincipal() {
        pantallaPrincipal.mostrarPantallaPrincipal(); // Mostramos la pantalla principal nuevamente
        // Escondemos el panel del conversor de divisas
        this.setVisible(false);
    }

    private void convertCurrency() {
        int fromIndex = fromCurrencyComboBox.getSelectedIndex();
        int toIndex = toCurrencyComboBox.getSelectedIndex();
        double amount;

        try {
            amount = Double.parseDouble(inputField.getText());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Resultado: Cantidad inválida");
            return;
        }

        double result = amount * conversionRates[fromIndex][toIndex];

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        resultLabel.setText("Resultado: " + decimalFormat.format(result) + " " + toCurrencyComboBox.getSelectedItem());
    }


}
