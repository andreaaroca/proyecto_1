package interfaz.Estudiante;

import javax.swing.*;

import Controlador.Controlador;

import java.awt.*;
import Persistencias.persistenciaLP;

public class VentanaLpDisponibles extends JFrame {
	
	private JTextArea areaLearningPaths;
	
	public VentanaLpDisponibles(persistenciaLP lpControl) {
	setTitle("Learning Paths Disponibles");
    setSize(400, 300);
    setLayout(new BorderLayout());
    

    areaLearningPaths = new JTextArea();
    areaLearningPaths.setEditable(false); 
    add(new JScrollPane(areaLearningPaths), BorderLayout.CENTER);


    String learningPaths = Controlador.mostrarLearningPathsDesdeArchivo(lpControl);
    areaLearningPaths.setText(learningPaths);

    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
}
}