package interfaz.ProfesorCreador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import Controlador.Controlador;
import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Profesor;

	public class VentanaCrearAcividad extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String CANCELAR = "CANCELAR";
    private static final String CTAREA = "CTAREA";
    private static final String CENCUESTA = "CENCUESTA";
    private static final String CRECURSO = "CRECURSO";
    private static final String CEXAMEN = "CEXAMEN";
    private static final String CQUIZ = "CQUIZ";
	
	private JTextField txtCodigo;
	private JTextField txtCodigoLP;
	private JTextArea txtDescripcion;
	private JTextArea txtObjetivos;
	private JTextField txtDificultad;
	private JTextField txtDuracion;
	private JPanel panel;
	private JButton btnCrear;
	private JButton btnCancelar;
	private String strEjersicio;
	private String strRecurso;
	private String dblNota;
	
	private persistenciaLP persistenciaLP;
	private Profesor profesorCreador;
	
	
	public VentanaCrearAcividad(persistenciaLP persistenciaLP, Profesor profesorCreador) {
	   
	    this.persistenciaLP = persistenciaLP;
		this.profesorCreador = profesorCreador;
		
	
	    setTitle("Crear Actividad");
	    setSize(700, 700);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    setLayout(new BorderLayout());
	    
	    // Panel principal
	    this.panel = new JPanel();
	    this.panel.setLayout(new GridLayout(10, 2, 5, 5));
	    this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	  
	    this.panel.add(new JLabel("Código de Actividad:"));
	    this.txtCodigo = new JTextField();
	    this.panel.add(txtCodigo);
	    
	    this.panel.add(new JLabel("Código de LP:"));
	    this.txtCodigoLP = new JTextField();
	    this.panel.add(txtCodigoLP);
	
	    this.panel.add(new JLabel("Descripción:"));
	    this.txtDescripcion = new JTextArea(3, 20);
	    this.txtDescripcion.setLineWrap(true);
	    this.txtDescripcion.setWrapStyleWord(true);
	    this.panel.add(new JScrollPane(txtDescripcion));
	
	    this.panel.add(new JLabel("Objetivos:"));
	    this.txtObjetivos = new JTextArea(3, 20);
	    this.txtObjetivos.setLineWrap(true);
	    this.txtObjetivos.setWrapStyleWord(true);
	    this.panel.add(new JScrollPane(txtObjetivos));
	
	    this.panel.add(new JLabel("Dificultad:"));
	    this.txtDificultad = new JTextField();
	    this.panel.add(txtDificultad);
	
	    this.panel.add(new JLabel("Duración:"));
	    this.txtDuracion = new JTextField();
	    this.panel.add(txtDuracion);
	   
	
	    
	    
	
	    btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
	    
	
	    add(this.panel);
	}	
	
	public void anadirTarea(JLabel ejercisio, JTextField txtEjercisio) {
        this.panel.add(ejercisio);
        this.panel.add(txtEjercisio);
        this.strEjersicio=txtEjercisio.getText();
        btnCrear = new JButton("Crear Tarea");
        btnCrear.setActionCommand(CTAREA);
        btnCrear.addActionListener(this);
        this.panel.add(btnCrear);
        this.panel.add(btnCancelar);
        revalidate();
        repaint();
        
    }
	
	public void anadirEncuesta() {
		btnCrear = new JButton("Crear Encuesta");
        btnCrear.setActionCommand(CENCUESTA);
        btnCrear.addActionListener(this);
        this.panel.add(btnCrear);
        this.panel.add(btnCancelar);
		revalidate();
        repaint();
    }
	
	public void anadirRecurso(JLabel Enlace, JTextField txtEnlace) {
		this.panel.add(Enlace);
		this.panel.add(txtEnlace);
		this.strRecurso=txtEnlace.getText();
		btnCrear = new JButton("Crear Recurso");
        btnCrear.setActionCommand(CRECURSO);
        btnCrear.addActionListener(this);
        this.panel.add(btnCrear);
        this.panel.add(btnCancelar);
        revalidate();
        repaint();
    }
	
	public void anadirExamen(JLabel nota, JTextField txtNota) {
		this.panel.add(nota);
		this.panel.add(txtNota);
		this.dblNota=txtNota.getText();
		btnCrear = new JButton("Crear Examen");
        btnCrear.setActionCommand(CEXAMEN);
        btnCrear.addActionListener(this);
        this.panel.add(btnCrear);
        this.panel.add(btnCancelar);
        revalidate();
        repaint();
    }
	public void anadirQuiz(JLabel nota, JTextField txtNota) {
		this.panel.add(nota);
		this.panel.add(txtNota);
		this.dblNota=txtNota.getText();
		btnCrear = new JButton("Crear Quiz");
        btnCrear.setActionCommand(CQUIZ);
        btnCrear.addActionListener(this);
        this.panel.add(btnCrear);
        this.panel.add(btnCancelar);
        revalidate();
        repaint();
	}
	
	public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CTAREA ))
        {
        	
        	Controlador.crearActividad(Integer.parseInt(txtCodigo.getText()), txtDescripcion.getText(), txtObjetivos.getText(), txtDificultad.getText(), txtDuracion.getText(), "Tarea", 
        			null,  null, strEjersicio, Integer.parseInt(txtCodigoLP.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Tarea creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        	
        }
        
        else if( comando.equals( CENCUESTA ))
        {
        	Controlador.crearActividad(Integer.parseInt(txtCodigo.getText()), txtDescripcion.getText(), txtObjetivos.getText(), txtDificultad.getText(), txtDuracion.getText(), "Encuesta", 
        			null,  null, null, Integer.parseInt(txtCodigoLP.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Encuesta creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        }
        
        else if( comando.equals( CRECURSO ))
        {
        	Controlador.crearActividad(Integer.parseInt(txtCodigo.getText()), txtDescripcion.getText(), txtObjetivos.getText(), txtDificultad.getText(), txtDuracion.getText(), "Revisar Recurso", 
        			null,  strRecurso, null, Integer.parseInt(txtCodigoLP.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Revision de recurso creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        }
        
        else if( comando.equals( CEXAMEN ))
        {
        	Controlador.crearActividad(Integer.parseInt(txtCodigo.getText()), txtDescripcion.getText(), txtObjetivos.getText(), txtDificultad.getText(), txtDuracion.getText(), "Examen", 
        			Double.valueOf(dblNota),  null, null, Integer.parseInt(txtCodigoLP.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Examen creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        }
        
        else if( comando.equals( CQUIZ ))
        {
        	Controlador.crearActividad(Integer.parseInt(txtCodigo.getText()), txtDescripcion.getText(), txtObjetivos.getText(), txtDificultad.getText(), txtDuracion.getText(), "Quiz", 
        			Double.valueOf(dblNota),  null, null, Integer.parseInt(txtCodigoLP.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Quiz creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        }
        
        else if( comando.equals( CANCELAR ))
        {
        	this.dispose();
        }
    }
	
	
	
}