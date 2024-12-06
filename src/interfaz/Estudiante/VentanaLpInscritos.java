package interfaz.Estudiante;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.Controlador;
import Persistencias.persistenciaEstudiante;
import co.edu.andes.usuarios.Estudiante;

public class VentanaLpInscritos extends JFrame {
	private JTextArea areaLearningPaths;
	
	public VentanaLpInscritos(persistenciaEstudiante persistenciaEstudiantes, Estudiante estudiante) {
	setTitle("Learning Paths Inscritos");
    setSize(400, 300);
    setLayout(new BorderLayout());
    

    areaLearningPaths = new JTextArea();
    areaLearningPaths.setEditable(false); 
    add(new JScrollPane(areaLearningPaths), BorderLayout.CENTER);


    String learningPathsInscritos = Controlador.obtenerLearningPathsInscritosComoTexto(persistenciaEstudiantes, estudiante);
    areaLearningPaths.setText(learningPathsInscritos);

    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
}

}