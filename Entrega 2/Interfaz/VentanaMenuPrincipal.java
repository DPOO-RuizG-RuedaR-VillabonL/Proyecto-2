package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Mundo.Aplicacion.MenuProyectos;

@SuppressWarnings("serial")
public class VentanaMenuPrincipal extends JFrame {
    MenuProyectos menuProyectos;
    PCrearProyecto pCrearProyecto;

    public VentanaMenuPrincipal(){
        menuProyectos = new MenuProyectos();
        pCrearProyecto = new PCrearProyecto(this);
        add(pCrearProyecto, BorderLayout.CENTER);

        setTitle("Gestor de Proyectos");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
	{
		new VentanaMenuPrincipal();
	} 
}
