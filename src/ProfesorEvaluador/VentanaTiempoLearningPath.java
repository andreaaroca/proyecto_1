package ProfesorEvaluador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LearningPath.MonitoreoLearningPath;

public class VentanaTiempoLearningPath extends JFrame implements ActionListener {

    private JTextField tfIdLearningPath;
    private JTextField tfUsuarioEstudiante;
    private JButton btnCalcular;
    private MonitoreoLearningPath monitoreoLP;

    public VentanaTiempoLearningPath(JFrame ventanaPrincipal) {
        this.monitoreoLP = monitoreoLP;

        setTitle("Tiempo tomado por Learning Path");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lblIdLearningPath = new JLabel("ID del Learning Path:");
        tfIdLearningPath = new JTextField();

        JLabel lblUsuarioEstudiante = new JLabel("Usuario del Estudiante:");
        tfUsuarioEstudiante = new JTextField();

        formPanel.add(lblIdLearningPath);
        formPanel.add(tfIdLearningPath);
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
                int idLearningPath = Integer.parseInt(tfIdLearningPath.getText());
                String usuarioEstudiante = tfUsuarioEstudiante.getText();

             
                String tiempoDedicado = monitoreoLP.calcularTiempoDedicadoLp(monitoreoLP.getEstudiante(), idLearningPath);

                JOptionPane.showMessageDialog(
                        this,
                        "Tiempo dedicado al Learning Path: " + tiempoDedicado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error",JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}

