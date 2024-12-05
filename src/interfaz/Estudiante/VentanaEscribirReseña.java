package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Controlador;
import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Estudiante;

@SuppressWarnings("serial")
public class VentanaEscribirReseña extends JFrame implements ActionListener {
	
	private JTextField txtIdLp; 
	private JTextField txtIdActividad;
	private JTextField txtRatingLp;
	private JTextField txtRatingActividad;
	private JTextField txtOpinionActividad;
    private JButton btnCrearReseña;
	
    private Estudiante estudiante;
    
public VentanaEscribirReseña(persistenciaLP lpControl, Estudiante estudiante)
	
	{
		setTitle("Escribir Reseña");
	    setSize(400, 300);
	    setLayout(new BorderLayout());
	    
	    JPanel panelEntrada = new JPanel(new FlowLayout());
	    
	 
        panelEntrada.add(new JLabel("ID del LearningPath:"));
        txtIdLp = new JTextField(10);
        panelEntrada.add(txtIdLp);

        panelEntrada.add(new JLabel("ID de la Actividad:"));
        txtIdActividad = new JTextField(10);
        panelEntrada.add(txtIdActividad);

        panelEntrada.add(new JLabel("Rating del LearningPath:"));
        txtRatingLp = new JTextField(10);
        panelEntrada.add(txtRatingLp);

        panelEntrada.add(new JLabel("Rating de la Actividad:"));
        txtRatingActividad = new JTextField(10);
        panelEntrada.add(txtRatingActividad);

        panelEntrada.add(new JLabel("Opinión sobre la Actividad:"));
        txtOpinionActividad = new JTextField(20);
        panelEntrada.add(txtOpinionActividad);
        
        btnCrearReseña = new JButton("Enviar reseña");
        btnCrearReseña.addActionListener(this); 
        add(panelEntrada, BorderLayout.CENTER);
        add(btnCrearReseña, BorderLayout.SOUTH);
 
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
     

	}

	
	public Estudiante getEstudiante() {
	    return estudiante;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == btnCrearReseña) {
	            try {
	               
	            	int idLp = Integer.parseInt(txtIdLp.getText());
	                int idActividad = Integer.parseInt(txtIdActividad.getText());
	                int ratingLp = Integer.parseInt(txtRatingLp.getText());
	                int ratingActividad = Integer.parseInt(txtRatingActividad.getText());
	                String opinionActividad = txtOpinionActividad.getText();
	                
	                if (opinionActividad.isEmpty() || ratingLp < 0 || ratingActividad < 0) {
	                    throw new IllegalArgumentException("Todos los campos deben ser completados correctamente.");
	                }

	                Controlador.estudianteCrearResenaLearningPath(idLp, opinionActividad, ratingLp, idActividad, estudiante);
	                JOptionPane.showMessageDialog(this, "Reseña enviada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                dispose();
	            } catch (IllegalArgumentException ex) {
	                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	    }
		
	}
}





