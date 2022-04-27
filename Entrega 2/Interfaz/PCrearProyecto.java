package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PCrearProyecto extends JPanel
{
    private VentanaMenuPrincipal ventanaMenuPrincipal;
    private JLabel label;
    private JPanel panelCentral;
    private JPanel panelAbajo;

    public PCrearProyecto(VentanaMenuPrincipal ventanaMenuPrincipal){

        this.ventanaMenuPrincipal = ventanaMenuPrincipal;
        this.setLayout(new BorderLayout());
        label = new JLabel("Crear Proyecto", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 30));
        label.setBorder(new EmptyBorder(50, 0, 100, 0));
        this.add(label, BorderLayout.NORTH);

        panelCentral = new JPanel();
        GridLayout grid = new GridLayout(4, 2, 50, 20);
        panelCentral.setLayout(grid);
        JTextField textoNombre = new JTextField(SwingConstants.CENTER);
        JTextField textoDescripcion = new JTextField();
        JTextField textoParticipante = new JTextField();
        JTextField textoCorreo = new JTextField();
        panelCentral.setBorder(new EmptyBorder(50, 100, 50, 50));

        panelCentral.add(new JLabel("Ingrese el nombre del proyecto", SwingConstants.LEFT));
        panelCentral.add(textoNombre);
        panelCentral.add(new JLabel("Ingrese la descripción del proyecto", SwingConstants.LEFT));
        panelCentral.add(textoDescripcion);
        panelCentral.add(new JLabel("Ingrese el nombre completo del participante", SwingConstants.LEFT));
        panelCentral.add(textoParticipante);
        panelCentral.add(new JLabel("Ingrese el correo del participante", SwingConstants.LEFT));
        panelCentral.add(textoCorreo);
 
        this.add(panelCentral, BorderLayout.CENTER);

        panelAbajo = new JPanel();
        panelAbajo.setBorder(new EmptyBorder(120, 0, 30, 0));
        panelAbajo.add(new JButton("Menú Principal"));
        panelAbajo.add(new JButton("Aceptar"));
        this.add(panelAbajo, BorderLayout.SOUTH);

    }
    
}
