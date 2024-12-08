package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.andes.usuarios.Estudiante;

import java.awt.event.*;
import java.util.HashMap;

public class VentanaCasoPruebaGrafica extends JFrame implements ActionListener {
	
	private JTextField Enero;
	private JTextField Feb;
	private JTextField Mar;
	private JTextField Abr;
	private JTextField Mayo;
	private JTextField Jun;
	private JTextField Jul;
	private JTextField Ago;
	private JTextField Sep;
	private JTextField Oct;
	private JTextField Nov;
	private JTextField Dic;
	private JPanel panel;
	private static final String CANCELAR = "CANCELAR";
    private static final String GRAFICAR = "GRAFICAR";
	private JButton btnCancelar;
	private JButton btnGraficar;
	

	public VentanaCasoPruebaGrafica() {
		setTitle("Caso de Prueba Grafica");
	    setSize(1500, 1500);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    setLayout(new BorderLayout());
	    
	    this.panel = new JPanel();
	    this.panel.setLayout(new GridLayout(13, 2, 5, 5));
	    this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    this.panel.add(new JLabel("# de actividades enviadas en Enero:"));
	    this.Enero = new JTextField();
	    this.panel.add(Enero);
	    
	    this.panel.add(new JLabel("en Febrero:"));
	    this.Feb = new JTextField();
	    this.panel.add(Feb);
	    
	    this.panel.add(new JLabel("en Marzo:"));
	    this.Mar = new JTextField();
	    this.panel.add(Mar);
	    
	    this.panel.add(new JLabel("en Abril:"));
	    this.Abr = new JTextField();
	    this.panel.add(Abr);
	    
	    this.panel.add(new JLabel("en Mayo:"));
	    this.Mayo = new JTextField();
	    this.panel.add(Mayo);
	    
	    this.panel.add(new JLabel("en Junio:"));
	    this.Jun = new JTextField();
	    this.panel.add(Jun);
	    
	    this.panel.add(new JLabel("en Julio:"));
	    this.Jul = new JTextField();
	    this.panel.add(Jul);
	    
	    this.panel.add(new JLabel("en Agosto:"));
	    this.Ago = new JTextField();
	    this.panel.add(Ago);
	    
	    this.panel.add(new JLabel("en Septiembre:"));
	    this.Sep = new JTextField();
	    this.panel.add(Sep);
	    
	    this.panel.add(new JLabel("en Octubre:"));
	    this.Oct = new JTextField();
	    this.panel.add(Oct);
	    
	    this.panel.add(new JLabel("en Noviembre:"));
	    this.Nov = new JTextField();
	    this.panel.add(Nov);
	    
	    this.panel.add(new JLabel("en Diciembre:"));
	    this.Dic = new JTextField();
	    this.panel.add(Dic);
	    
	    btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        this.panel.add(btnCancelar);
        
        btnGraficar = new JButton("Graficar");
        btnGraficar.setActionCommand(GRAFICAR);
        btnGraficar.addActionListener(this);
        this.panel.add(btnGraficar);
        
        add(this.panel,BorderLayout.CENTER);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
        String comando = e.getActionCommand( );

        if (comando.equals(GRAFICAR)) {
        	HashMap<String, Integer> mesCantidad=new HashMap<String, Integer>();
        	mesCantidad.put("Enero", (Integer.parseInt(Enero.getText())));
    		mesCantidad.put("Febrero", (Integer.parseInt(Feb.getText())));
    		mesCantidad.put("Marzo", (Integer.parseInt(Mar.getText())));
    		mesCantidad.put("Abril", (Integer.parseInt(Abr.getText())));
    		mesCantidad.put("Mayo", (Integer.parseInt(Mayo.getText())));
    		mesCantidad.put("Junio", (Integer.parseInt(Jun.getText())));
    		mesCantidad.put("Julio", (Integer.parseInt(Jul.getText())));
    		mesCantidad.put("Agosto", (Integer.parseInt(Ago.getText())));
    		mesCantidad.put("Septiembre", (Integer.parseInt(Sep.getText())));
    		mesCantidad.put("Octubre", (Integer.parseInt(Oct.getText())));
    		mesCantidad.put("Noviembre", (Integer.parseInt(Nov.getText())));
    		mesCantidad.put("Diciembre", (Integer.parseInt(Dic.getText())));
    		VentanaGrafica vGraficar=new VentanaGrafica(mesCantidad);
    		vGraficar.setVisible(true);
    		
            
            }
        
        else if( comando.equals( CANCELAR ))
        {
        	this.dispose();
        }

	}
	public static void main( String[] args )
    {
        new VentanaCasoPruebaGrafica();
    }
	
}
