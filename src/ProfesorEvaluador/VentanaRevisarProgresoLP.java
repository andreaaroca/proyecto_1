package ProfesorEvaluador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRevisarProgresoLP extends JFrame {
	private JTextField tfCodigoLearningPath;
    private JTextField tfUsuarioEstudiante;
    private JButton btnRevisarProgreso;

    public VentanaRevisarProgresoLP(JFrame ventanaPrincipal) {
        
        setTitle("Revisar Progreso Learning Path");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10)); 

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(3, 2, 10, 10));  

        JLabel lblCodigoLearningPath = new JLabel("Código Learning Path:");
        JLabel lblUsuarioEstudiante = new JLabel("Usuario del Estudiante:");

        tfCodigoLearningPath = new JTextField();
        tfUsuarioEstudiante = new JTextField();

        panelForm.add(lblCodigoLearningPath);
        panelForm.add(tfCodigoLearningPath);
        panelForm.add(lblUsuarioEstudiante);
        panelForm.add(tfUsuarioEstudiante);

        
        btnRevisarProgreso = new JButton("Revisar Progreso");

        panel.add(panelForm, BorderLayout.CENTER);
        panel.add(btnRevisarProgreso, BorderLayout.SOUTH);  

     
        add(panel);

        btnRevisarProgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigoLP = Integer.parseInt(tfCodigoLearningPath.getText());
                    String usuarioEstudiante = tfUsuarioEstudiante.getText(); 

                    // Aquí iría la lógica para revisar el progreso del Learning Path

                   
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un código de Learning Path válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}