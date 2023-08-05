package Conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMedidas extends JPanel {

    private final JComboBox<String> fromUnitComboBox;
    private final JComboBox<String> toUnitComboBox;
    private final JTextField inputField;
    private final JLabel resultLabel;
    private final PantallaPrincipal pantallaPrincipal;

    public ConversorMedidas(PantallaPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal; // Guardamos la referencia de la PantallaPrincipal
        setLayout(new FlowLayout());
        setBackground(new Color(105, 255, 82));

        String[] lengthUnits = {"Metros", "Kilómetros", "Centímetros", "Pies", "Pulgadas"};

        fromUnitComboBox = new JComboBox<>(lengthUnits);
        toUnitComboBox = new JComboBox<>(lengthUnits);
        inputField = new JTextField(10);
        resultLabel = new JLabel("Resultado:");

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(e -> convertLength());



        add(new JLabel("Convertir de:"));
        add(fromUnitComboBox);
        add(new JLabel("a:"));
        add(toUnitComboBox);
        add(new JLabel("Ingrese la longitud:"));
        add(inputField);
        add(convertButton);
        add(resultLabel);

    }

    private void regresarPantallaPrincipal() {
        pantallaPrincipal.mostrarPantallaPrincipal(); // Mostramos la pantalla principal nuevamente
        // Escondemos el panel del conversor de medidas
        this.setVisible(false);
    }

    private void convertLength() {
        String fromUnit = (String) fromUnitComboBox.getSelectedItem();
        String toUnit = (String) toUnitComboBox.getSelectedItem();
        double length;

        try {
            length = Double.parseDouble(inputField.getText());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Resultado: Entrada inválida");
            return;
        }

        double result;

        assert fromUnit != null;
        if (fromUnit.equals("Metros")) {
            assert toUnit != null;
            if (toUnit.equals("Kilómetros")) {
                result = metrosToKilometros(length);
            } else if (toUnit.equals("Centímetros")) {
                result = metrosToCentimetros(length);
            } else if (toUnit.equals("Pies")) {
                result = metrosToPies(length);
            } else if (toUnit.equals("Pulgadas")) {
                result = metrosToPulgadas(length);
            } else {
                result = length;
            }
        } else if (fromUnit.equals("Kilómetros")) {
            if (toUnit.equals("Metros")) {
                result = kilometrosToMetros(length);
            } else if (toUnit.equals("Centímetros")) {
                result = kilometrosToCentimetros(length);
            } else if (toUnit.equals("Pies")) {
                result = kilometrosToPies(length);
            } else if (toUnit.equals("Pulgadas")) {
                result = kilometrosToPulgadas(length);
            } else {
                result = length;
            }
        } else if (fromUnit.equals("Centímetros")) {
            if (toUnit.equals("Metros")) {
                result = centimetrosToMetros(length);
            } else if (toUnit.equals("Kilómetros")) {
                result = centimetrosToKilometros(length);
            } else if (toUnit.equals("Pies")) {
                result = centimetrosToPies(length);
            } else if (toUnit.equals("Pulgadas")) {
                result = centimetrosToPulgadas(length);
            } else {
                result = length;
            }
        } else if (fromUnit.equals("Pies")) {
            if (toUnit.equals("Metros")) {
                result = piesToMetros(length);
            } else if (toUnit.equals("Kilómetros")) {
                result = piesToKilometros(length);
            } else if (toUnit.equals("Centímetros")) {
                result = piesToCentimetros(length);
            } else if (toUnit.equals("Pulgadas")) {
                result = piesToPulgadas(length);
            } else {
                result = length;
            }
        } else {
            if (toUnit.equals("Metros")) {
                result = pulgadasToMetros(length);
            } else if (toUnit.equals("Kilómetros")) {
                result = pulgadasToKilometros(length);
            } else if (toUnit.equals("Centímetros")) {
                result = pulgadasToCentimetros(length);
            } else if (toUnit.equals("Pies")) {
                result = pulgadasToPies(length);
            } else {
                result = length;
            }
        }

        resultLabel.setText("Resultado: " + result + " " + toUnit);
    }

    // Funciones de conversión de longitud
    public static double metrosToKilometros(double metros) {
        return metros / 1000;
    }

    public static double metrosToCentimetros(double metros) {
        return metros * 100;
    }

    public static double metrosToPies(double metros) {
        return metros * 3.28084;
    }

    public static double metrosToPulgadas(double metros) {
        return metros * 39.3701;
    }

    public static double kilometrosToMetros(double kilometros) {
        return kilometros * 1000;
    }

    public static double kilometrosToCentimetros(double kilometros) {
        return kilometros * 100000;
    }

    public static double kilometrosToPies(double kilometros) {
        return kilometros * 3280.84;
    }

    public static double kilometrosToPulgadas(double kilometros) {
        return kilometros * 39370.1;
    }

    public static double centimetrosToMetros(double centimetros) {
        return centimetros / 100;
    }

    public static double centimetrosToKilometros(double centimetros) {
        return centimetros / 100000;
    }

    public static double centimetrosToPies(double centimetros) {
        return centimetros * 0.0328084;
    }

    public static double centimetrosToPulgadas(double centimetros) {
        return centimetros * 0.393701;
    }

    public static double piesToMetros(double pies) {
        return pies * 0.3048;
    }

    public static double piesToKilometros(double pies) {
        return pies * 0.0003048;
    }

    public static double piesToCentimetros(double pies) {
        return pies / 0.0328084;
    }

    public static double piesToPulgadas(double pies) {
        return pies * 12;
    }

    public static double pulgadasToMetros(double pulgadas) {
        return pulgadas * 0.0254;
    }

    public static double pulgadasToKilometros(double pulgadas) {
        return pulgadas * 0.0000254;
    }

    public static double pulgadasToCentimetros(double pulgadas) {
        return pulgadas * 2.54;
    }

    public static double pulgadasToPies(double pulgadas) {
        return pulgadas * 0.0833333;
    }


}

