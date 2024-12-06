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


@SuppressWarnings("serial")
public class VentanaCrearLp extends JFrame implements ActionListener {

    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextArea txtDescripcion;
    private JTextArea txtObjetivos;
    private JTextField txtDificultad;
    private JTextField txtDuracion;

    private JButton btnCrear;
    private JButton btnCancelar;

    private persistenciaLP persistenciaLP;
    private Profesor profesorCreador;
    

    public VentanaCrearLp(persistenciaLP persistenciaLP, Profesor profesorCreador) {
       
        this.persistenciaLP = persistenciaLP;
    	this.profesorCreador = profesorCreador;

        setTitle("Crear Learning Path");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      
        panel.add(new JLabel("Código del Learning Path:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);

        panel.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panel.add(txtTitulo);

        panel.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea(3, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        panel.add(new JScrollPane(txtDescripcion));

        panel.add(new JLabel("Objetivos:"));
        txtObjetivos = new JTextArea(3, 20);
        txtObjetivos.setLineWrap(true);
        txtObjetivos.setWrapStyleWord(true);
        panel.add(new JScrollPane(txtObjetivos));

        panel.add(new JLabel("Dificultad:"));
        txtDificultad = new JTextField();
        panel.add(txtDificultad);

        panel.add(new JLabel("Duración:"));
        txtDuracion = new JTextField();
        panel.add(txtDuracion);

        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(this);
        panel.add(btnCrear);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        panel.add(btnCancelar);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrear) {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String titulo = txtTitulo.getText();
                String descripcion = txtDescripcion.getText();
                String objetivos = txtObjetivos.getText();
                String dificultad = txtDificultad.getText();
                String duracion = txtDuracion.getText();

               
                if (titulo.isEmpty() || descripcion.isEmpty() || objetivos.isEmpty() || dificultad.isEmpty() || duracion.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            
                Map<String, Actividad> actividades = new HashMap<>();

                Controlador.profesorCrearLearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, profesorCreador);

                JOptionPane.showMessageDialog(this, "Learning Path creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El código debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}