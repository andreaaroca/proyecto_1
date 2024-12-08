package ProfesorEvaluador;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import LearningPath.MonitoreoLearningPath;
import LearningPath.MonitoreoActividad;

public class VentanaTasaExitoActividad extends JFrame implements ActionListener {
	
    private JTextField tfIdActividad;
    private JButton btnCalcular;
    private MonitoreoLearningPath monitoreoLP;

    public VentanaTasaExitoActividad(JFrame ventanaPrincipal) {
        this.monitoreoLP = monitoreoLP;

        setTitle("Calcular Tasa de Éxito de Actividad");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

  
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel lblIdActividad = new JLabel("ID de la Actividad:");
        tfIdActividad = new JTextField();

        formPanel.add(lblIdActividad);
        formPanel.add(tfIdActividad);

        btnCalcular = new JButton("Calcular Tasa");
        btnCalcular.addActionListener(this);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(btnCalcular, BorderLayout.SOUTH);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                int idActividad = Integer.parseInt(tfIdActividad.getText());

          
                List<MonitoreoActividad> actividadesMonitoreadasGeneral = monitoreoLP.getActividadesMonitoreadasGeneral();

                // Calcular la tasa de éxito 
                float tasaExito = monitoreoLP.tasaDeExitoActividad(actividadesMonitoreadasGeneral, idActividad);

        
                JOptionPane.showMessageDialog(
                        this,
                        "La tasa de éxito de la actividad con ID " + idActividad + " es: " + tasaExito + "%",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor, ingrese un ID válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ocurrió un error al calcular la tasa: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

}