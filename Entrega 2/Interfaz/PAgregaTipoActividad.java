package Interfaz;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.*;


public class PAgregaTipoActividad extends JPanel{
    private JPanel panelNorte;
    private JPanel panelCentral;
    private JPanel panelAbajo;

    public PAgregaTipoActividad(VentanaMenuActividades ventanaMenuActividades2) {
    }

    public void PMenuActividades (VentanaMenuActividades ventanaMenuActividades){

        this.setBackground(new Color(02,28, 30) ); //fondo principal
        GridLayout grid = new GridLayout(3, 1, 5, 20);
        this.setLayout(grid);
        //crear panel norte
        panelNorte = new JPanel();
        panelNorte.setBackground(new Color(02,28, 30) ); //fondo principal
        //crear y agregar elementos de panel norte
        JLabel titulo = new JLabel("Introduzca los datos:", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 25));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        panelNorte.add(titulo);
        //crear panel central
        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo principal
        GridLayout grid1 = new GridLayout(1, 2, 0, 5); 
        panelCentral.setLayout(grid1);
        //crear y agregar elementos de panel central
        JLabel elemento = new JLabel("Seleccione una opción: ", SwingConstants.CENTER);
        elemento.setOpaque(true);
        elemento.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        elemento.setBackground(new Color(02,28, 30) ); //fondo principal
        elemento.setForeground( new Color(111,185, 143) ); //letra principal
        JTextField cuadroTexto = new JTextField();
        cuadroTexto.setOpaque(true);
        panelCentral.add(elemento);
        panelCentral.add(cuadroTexto);
        //crear panel sur
        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) ); //fondo principal
        GridLayout grid2 = new GridLayout(1, 2, 0, 5); 
        panelAbajo.setLayout(grid2);
        //crear y agregar elementos de panel sur
        JButton boton1 = (new JButton("Menu principal"));
        JButton boton2 = (new JButton("Agregar"));
        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        panelAbajo.add(boton1);
        panelAbajo.add(boton2);
        //agregar paneles secudarios a paneles principalesP
        this.add(panelNorte);
        this.add(panelCentral);
        this.add(panelAbajo);
    }


    
}
