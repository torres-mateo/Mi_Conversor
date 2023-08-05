package Conversor;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class ConversorTemperaturas extends JPanel {

    private final JComboBox<String> fromUnitComboBox;
    private final JComboBox<String> toUnitComboBox;
    private final JTextField inputField;
    private final JLabel resultLabel;
    private PantallaPrincipal pantallaPrincipal;

    public ConversorTemperaturas(PantallaPrincipal pantallaPrincipal) {
        setLayout(new FlowLayout());
        setBackground(new Color(255, 116, 56));

        String[] temperatureUnits = {"Celsius", "Fahrenheit", "Kelvin"};

        fromUnitComboBox = new JComboBox<>(temperatureUnits);
        toUnitComboBox = new JComboBox<>(temperatureUnits);
        inputField = new JTextField(10);
        resultLabel = new JLabel("Resultado:");

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(e -> convertTemperature());


        add(new JLabel("Convertir de:"));
        add(fromUnitComboBox);
        add(new JLabel("a:"));
        add(toUnitComboBox);
        add(new JLabel("Ingrese la temperatura:"));
        add(inputField);
        add(convertButton);
        add(resultLabel);

        setVisible(false); // Escondemos el panel por defecto
    }

    /*public void setPantallaPrincipal(PantallaPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
    }*/

    private void regresarPantallaPrincipal() {
        pantallaPrincipal.mostrarPantallaPrincipal(); // Mostramos la pantalla principal nuevamente
        this.setVisible(false); // Escondemos el panel del conversor de temperaturas
    }



    private void convertTemperature() {
        String fromUnit = (String) fromUnitComboBox.getSelectedItem();
        String toUnit = (String) toUnitComboBox.getSelectedItem();
        double temperature;

        try {
            temperature = Double.parseDouble(inputField.getText());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Resultado: Entrada inválida");
            return;
        }

        double result;

        if (fromUnit.equals("Celsius")) {
            if (toUnit.equals("Fahrenheit")) {
                result = celsiusToFahrenheit(temperature);
            } else if (toUnit.equals("Kelvin")) {
                result = celsiusToKelvin(temperature);
            } else {
                result = temperature;
            }
        } else if (fromUnit.equals("Fahrenheit")) {
            if (toUnit.equals("Celsius")) {
                result = fahrenheitToCelsius(temperature);
            } else if (toUnit.equals("Kelvin")) {
                result = fahrenheitToKelvin(temperature);
            } else {
                result = temperature;
            }
        } else {
            if (toUnit.equals("Celsius")) {
                result = kelvinToCelsius(temperature);
            } else if (toUnit.equals("Fahrenheit")) {
                result = kelvinToFahrenheit(temperature);
            } else {
                result = temperature;
            }
        }

        resultLabel.setText("Resultado: " + result + " " + toUnit);
    }







    // Funciones de conversión de temperaturas
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return kelvin * 9 / 5 - 459.67;
    }
}
