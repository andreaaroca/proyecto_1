package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import co.edu.andes.usuarios.*;



public class VentanaIniciarActividad extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String CANCELAR = "CANCELAR";
    private static final String INICIAR = "INICIAR";
    
	private JTextField txtCodigoAct;
	private JTextField txtCodigoLp;
	private JPanel panel;
	private JButton btnIniciar;
	private JButton btnCancelar;
	private VentanaPrincipalMenuEstudiante vPrincipalEst;
	
    public VentanaIniciarActividad(VentanaPrincipalMenuEstudiante vPrincipalEst) {
    

		this.vPrincipalEst=vPrincipalEst;
		
		
		setTitle("Iniciar Actividad");
	    setSize(500, 400);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    setLayout(new BorderLayout());
	    
	    this.panel = new JPanel();
	    this.panel.setLayout(new GridLayout(10, 2, 5, 5));
	    this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    this.panel.add(new JLabel("Codigo de LP:"));
	    this.txtCodigoLp = new JTextField();
	    this.panel.add(txtCodigoLp);
	    
	    this.panel.add(new JLabel("Codigo de actividad:"));
	    this.txtCodigoAct = new JTextField();
	    this.panel.add(txtCodigoAct);
	    
	    btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        this.panel.add(btnCancelar);
        
        btnIniciar = new JButton("Calificar");
        btnIniciar.setActionCommand(INICIAR);
        btnIniciar.addActionListener(this);
        this.panel.add(btnIniciar);
        
        add(panel,BorderLayout.CENTER);
    }
        
        
        @Override
		public void actionPerformed(ActionEvent e) {
			
	        String comando = e.getActionCommand( );

	        if (comando.equals(INICIAR)) {
	            
	        	int idLp=Integer.parseInt(txtCodigoLp.getText());
	        	int idActividad=Integer.parseInt(txtCodigoAct.getText());
	        	Estudiante estudiante= vPrincipalEst.getEstudiante();
	        	estudiante.iniciarActividad(idLp, idActividad);
	            
	            }
	        
	        else if( comando.equals( CANCELAR ))
	        {
	        	this.dispose();
	        }

}

}