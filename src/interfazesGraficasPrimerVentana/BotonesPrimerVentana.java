package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BotonesPrimerVentana extends JPanel implements ActionListener{

    private static final String ESTUDIANTE = "Estudiante";
    private static final String PROFESORCREADOR = "Profesor Creador";
    private static final String PROFESOREVALUADOR = "Profesor Evaluador";

    private JButton butEstudiante;
    private JButton butCreador;
    private JButton butEvaluador;
    private PrimerVentana primerVentana;

    public  BotonesPrimerVentana(PrimerVentana primerVentana )
    {
        this.primerVentana = primerVentana;

        setLayout( new GridLayout(3,1) );

        butEstudiante = new JButton("Estudiante");
        butEstudiante.addActionListener(this);
        butEstudiante.setActionCommand(ESTUDIANTE);
        add(butEstudiante);

        butCreador = new JButton("Profesor Creador");
        butCreador.addActionListener(this);
        butCreador.setActionCommand(PROFESORCREADOR);
        add(butCreador);
        
        butEvaluador = new JButton("Profesor Evaluador");
        butEvaluador.addActionListener(this);
        butEvaluador.setActionCommand(PROFESOREVALUADOR);
        add(butEvaluador);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( ESTUDIANTE ))
        {
            primerVentana.mostrarVetanaLoginEstudiante( );
        }
        
    }
}
