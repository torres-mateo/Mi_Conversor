package Conversor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {

    private JComboBox<String> opcionesComboBox;
    private JPanel mainPanel;
    private ConversorTemperaturas conversorTemperaturasPanel;
    private ConversorDivisas conversorDivisasPanel;
    private ConversorMedidas conversorMedidasPanel;

    public PantallaPrincipal() {
        setTitle("Pantalla Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] opciones = {"Conversor de Temperaturas", "Conversor de Divisas", "Conversor de Medidas"};
        opcionesComboBox = new JComboBox<>(opciones);
        opcionesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNuevaPantalla(opcionesComboBox.getSelectedItem().toString());
            }
        });

        JPanel optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.add(new JLabel("Selecciona una opción:"));
        optionsPanel.add(opcionesComboBox);

        mainPanel = new JPanel(new CardLayout());
        add(optionsPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void abrirNuevaPantalla(String opcion) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        if (opcion.equals("Conversor de Temperaturas")) {
            if (conversorTemperaturasPanel == null) {
                conversorTemperaturasPanel = new ConversorTemperaturas(this); // Pasamos la referencia de la PantallaPrincipal al panel ConversorTemperaturas
                mainPanel.add(conversorTemperaturasPanel, "conversorTemperaturas");
            }
            cardLayout.show(mainPanel, "conversorTemperaturas");
        } else if (opcion.equals("Conversor de Divisas")) {
            if (conversorDivisasPanel == null) {
                conversorDivisasPanel = new ConversorDivisas(this); // Pasamos la referencia de la PantallaPrincipal al panel ConversorDivisas
                mainPanel.add(conversorDivisasPanel, "conversorDivisas");
            }
            cardLayout.show(mainPanel, "conversorDivisas");
        } else if (opcion.equals("Conversor de Medidas")) {
            if (conversorMedidasPanel == null) {
                conversorMedidasPanel = new ConversorMedidas(this); // Pasamos la referencia de la PantallaPrincipal al panel ConversorMedidas
                mainPanel.add(conversorMedidasPanel, "conversorMedidas");
            }
            cardLayout.show(mainPanel, "conversorMedidas");
        }
    }

    public void mostrarPantallaPrincipal() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                pantallaPrincipal.setVisible(true);
                pantallaPrincipal.setSize(500,180);
                pantallaPrincipal.setLocationRelativeTo(null);
            }
        });
    }
}



