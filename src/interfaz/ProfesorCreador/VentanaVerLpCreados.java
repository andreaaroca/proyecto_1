package interfaz.ProfesorCreador;

import javax.swing.*;

import java.awt.*;
import java.util.List;

import co.edu.andes.sistema.*;
import interfazesGraficasPrimerVentana.VentanaLogin;
import Persistencias.*;

import Controlador.Controlador;

public class VentanaVerLpCreados extends JFrame {

	private JTextArea areaLp;
	private persistenciaLP lpControl;
	private VentanaPrincipalMenuProfesorCreador vPrincipal;
	
	public VentanaVerLpCreados(VentanaPrincipalMenuProfesorCreador vPrincipal, persistenciaLP lpControl) {
		
		this.vPrincipal=vPrincipal;
		this.lpControl = lpControl;
		
			
		setTitle("Learning Paths creados");
	    setSize(400, 300);
	    setLayout(new BorderLayout());
	    
	
	    areaLp = new JTextArea();
	    areaLp.setEditable(false); 
	    add(new JScrollPane(areaLp), BorderLayout.CENTER);
	
	    String lpCreados = Controlador.obtenerLearningPathsCreadosComoTexto(lpControl, vPrincipal.getProfesorCreador());
	    areaLp.setText(lpCreados);


	
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	}
}
	
	