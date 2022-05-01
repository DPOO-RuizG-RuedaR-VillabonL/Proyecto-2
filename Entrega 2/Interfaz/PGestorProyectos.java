package Interfaz;


import java.awt.*;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;
import javax.swing.*;

public class PGestorProyectos extends JPanel{
    private VentanaMenuProyectos ventanaMenuProyectos;
    private JPanel panelCentral;
    private JPanel panelAbajo;

    public PGestorProyectos (VentanaMenuProyectos ventanaMenuProyectos) {
        this.ventanaMenuActividades= ventanaMenuActividades;
    
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        GridLayout grid = new GridLayout(1, 1, 0, 0);
        this.setLayout(grid);
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(3, 1, 0, 5);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal
        //Se crea y se añade el titulo en el panel principal
        JLabel titulo = new JLabel("Seleccione una opcion", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);
        //se crea texto instrucción, boton1 y boton2 y se añaden al panel central
        JLabel instruccion = new JLabel("Seleccione una opción: ", SwingConstants.CENTER);
        instruccion.setOpaque(true);
        instruccion.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        instruccion.setBackground(new Color(02,28, 30) ); //fondo principal
        instruccion.setForeground( new Color(111,185, 143) ); //letra principal
        JButton boton1 = (new JButton("Consultar descripción del proyecto"));
        JButton boton2 = (new JButton("Consultar participantes"));
        JButton boton3 = (new JButton("Consultar fecha inicio"));
        JButton boton4 = (new JButton("Consultar fecha finalización"));
        JButton boton5 = (new JButton("Agregar participantes"));
        JButton boton6 = (new JButton("Agregar tipo actividad admitida "));
        JButton boton7 = (new JButton("gestionar actividades"));
        JButton boton8 = (new JButton("Agregar fecha finalización proyecto"));
        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        boton3.setBackground(new Color(111,185, 143)  );
        boton3.setForeground(new Color(02,28, 30) );
        boton4.setBackground(new Color(111,185, 143)  );
        boton4.setForeground(new Color(02,28, 30) );
        boton5.setBackground(new Color(111,185, 143)  );
        boton5.setForeground(new Color(02,28, 30) );
        boton6.setBackground(new Color(111,185, 143)  );
        boton6.setForeground(new Color(02,28, 30) );
        boton7.setBackground(new Color(111,185, 143)  );
        boton7.setForeground(new Color(02,28, 30) );
        boton8.setBackground(new Color(111,185, 143)  );
        boton8.setForeground(new Color(02,28, 30) );
        panelCentral.add(instruccion, BorderLayout.CENTER);
        panelCentral.add (boton1, BorderLayout.CENTER);      
        panelCentral.add (boton2, BorderLayout.CENTER);
        panelCentral.add (boton3, BorderLayout.CENTER);
        panelCentral.add (boton4, BorderLayout.CENTER);
        panelCentral.add (boton5, BorderLayout.CENTER);
        panelCentral.add (boton6, BorderLayout.CENTER);
        panelCentral.add (boton7, BorderLayout.CENTER);
        panelCentral.add (boton8, BorderLayout.CENTER);
        
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 120 , 0, 120 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        panelAbajo.add(new JButton("Menu principal"), BorderLayout.SOUTH);
        panelAbajo.add(new JButton("Guardar"), BorderLayout.SOUTH);
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

        this.add(panelAbajo, BorderLayout.SOUTH);

    }

 
    
}

