package ProfesorEvaluador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LearningPath.MonitoreoLearningPath;

public class VentanaTiempoActividad extends JFrame implements ActionListener {

    private JTextField tfIdActividad;
    private JTextField tfUsuarioEstudiante;
    private JButton btnCalcular;
    private MonitoreoLearningPath monitoreoLP;

    public VentanaTiempoActividad(JFrame ventanaPrincipal) {
        this.monitoreoLP = monitoreoLP;

        setTitle("Tiempo tomado por Actividad");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lblIdActividad = new JLabel("ID de la Actividad:");
        tfIdActividad = new JTextField();

        JLabel lblUsuarioEstudiante = new JLabel("Usuario del Estudiante:");
        tfUsuarioEstudiante = new JTextField();

        formPanel.add(lblIdActividad);
        formPanel.add(tfIdActividad);
        formPanel.add(lblUsuarioEstudiante);
        formPanel.add(tfUsuarioEstudiante);

        btnCalcular = new JButton("Calcular Tiempo");
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
                String usuarioEstudiante = tfUsuarioEstudiante.getText();

           
                String tiempoDedicado = monitoreoLP.getActividadesMonitoreadasEstudiante().stream()
                        .filter(a -> a.getIdActividad() == idActividad && a.getEstudiante().getNombreUsuario().equals(usuarioEstudiante))
                        .findFirst()
                        .map(a -> a.calcularTiempoDedicado(idActividad))
                        .orElse("No se encontró información para la actividad");

                JOptionPane.showMessageDialog(
                        this,
                        "Tiempo dedicado a la actividad: " + tiempoDedicado,
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
            }
        }
    }
}