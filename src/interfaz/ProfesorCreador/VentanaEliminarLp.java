package interfaz.ProfesorCreador;

import javax.swing.*;

import Actividades.Actividad;
import Controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Profesor;


public class VentanaEliminarLp extends JFrame implements ActionListener {

	private static final String CANCELAR = "CANCELAR";
    private static final String ELIMINARLP = "ELIMINARLP";
    

    private JTextField txtCodigo;
    private JButton btnEliminar;
    private JButton btnCancelar;

    private persistenciaLP persistenciaLP;
    private Profesor profesorCreador;
    

    public VentanaEliminarLp(persistenciaLP persistenciaLP, Profesor profesorCreador) {
       
        this.persistenciaLP = persistenciaLP;
    	this.profesorCreador = profesorCreador;

        setTitle("Eliminar Learning Path");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel panelC = new JPanel();
        panelC.setLayout(new GridLayout(1,2));
        
        JPanel panelS = new JPanel();
        panelS.setLayout(new FlowLayout());

      
        panelC.add(new JLabel("Código del Learning Path a Eliminar:"));
        this.txtCodigo = new JTextField();
        panelC.add(txtCodigo);

        JButton btnEliminar = new JButton("Eliminar LP");
        btnEliminar.addActionListener(this);
        btnEliminar.setActionCommand(ELIMINARLP);
        panelS.add(btnEliminar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand(CANCELAR);
        panelS.add(btnCancelar);

        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( ELIMINARLP ))
        {
        	
        	Controlador.eliminarLp(Integer.parseInt(txtCodigo.getText()), profesorCreador);
        	JOptionPane.showMessageDialog(this, "Learning Path Eliminado Exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        	
        }
    
        else if( comando.equals( CANCELAR ))
        {
        	this.dispose();
        }
    }
    
}