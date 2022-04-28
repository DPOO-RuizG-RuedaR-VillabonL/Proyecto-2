package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.JFrame;


public class VentanaMenuActividades extends JFrame {
    PAgregaTipoActividad pAgregaTipoActividad;

    public void ventanaMenuActividades () {

    pAgregaTipoActividad = new PAgregaTipoActividad(this);

    setTitle("Agregar tipo actividad");
    setSize(500, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    this.add(pAgregaTipoActividad);
    
    }



    
}
