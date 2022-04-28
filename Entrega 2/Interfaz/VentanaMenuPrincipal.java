package Interfaz;


import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.JFrame;

import Mundo.Aplicacion.MenuProyectos;

@SuppressWarnings("serial")
public class VentanaMenuPrincipal extends JFrame {
    MenuProyectos menuProyectos;
    PCrearProyecto pCrearProyecto;
    PMenuPrincipal pMenuPrincipal;
    


    //this.getContentPane().add(panel); //agregar panel
    public VentanaMenuPrincipal(){
        menuProyectos = new MenuProyectos();
        pCrearProyecto = new PCrearProyecto(this);
        pMenuPrincipal = new PMenuPrincipal(this);

        

        setTitle("Menu principal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPrincipal);
         
    }

    public static void main(String[] args)
	{
		new VentanaMenuPrincipal();
	} 
}
