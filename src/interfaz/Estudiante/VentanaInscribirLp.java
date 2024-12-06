package interfaz.Estudiante;

import javax.swing.*;

import Controlador.Controlador;
import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Estudiante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaInscribirLp  extends JFrame implements ActionListener {
	
	private JTextField txtIdLp; // Campo para ingresar ID
    private JButton btnInscribir;
	
	private persistenciaLP lpControl;
    private Estudiante estudiante;

	public VentanaInscribirLp(persistenciaLP lpControl, Estudiante estudiante)
	
	{
		setTitle("Inscribir Learning Path");
	    setSize(400, 300);
	    setLayout(new BorderLayout());
	    
	    JPanel panelEntrada = new JPanel(new FlowLayout());
        JLabel lblIdLp = new JLabel("Ingrese ID del LearningPath a inscribir:");
        txtIdLp = new JTextField(10); // Campo de entrada
        panelEntrada.add(lblIdLp);
        panelEntrada.add(txtIdLp);
		
        
        btnInscribir = new JButton("Inscribir Learning Path");
        btnInscribir.addActionListener(this); // Asignar acción al botón
        add(panelEntrada, BorderLayout.CENTER);
        add(btnInscribir, BorderLayout.SOUTH);
 
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == btnInscribir) {
	            try {
	               
	                int idLp = Integer.parseInt(txtIdLp.getText());

	                Controlador.estudianteInscribirLearningPath(lpControl, estudiante, idLp);
	                JOptionPane.showMessageDialog(this, "Learning Path inscrito correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
	            
	        }
	    }
		
	}
}