package Interfaz;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mundo.Aplicacion.MenuProyectos;

@SuppressWarnings("serial")
public class VentanaMenuPrincipal extends JFrame {
    MenuProyectos menuProyectos;
    PCrearProyecto pCrearProyecto;
    PMenuPrincipal pMenuPrincipal;
    public final String CREAR = "CREAR";
    public final String GESTIONAR = "GESTIONAR"; 
    public final String MENU = "MENU";
    public final String ACEPTAR = "ACEPTAR";
    public final String GUARDAR = "GUARDAR"; 
    
    public VentanaMenuPrincipal(){
        menuProyectos = new MenuProyectos();
        pCrearProyecto = new PCrearProyecto(this);
        pMenuPrincipal = new PMenuPrincipal(this);

        setTitle("Menu principal");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPrincipal, BorderLayout.CENTER);
         
    }

    public static void main(String[] args)
	{
		new VentanaMenuPrincipal();
	}

    public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
        if (comando == CREAR){
            this.remove(pMenuPrincipal);
            this.add(pCrearProyecto);

        }else if (comando == GESTIONAR){

        }else if (comando == MENU){
            this.remove(pCrearProyecto);
            this.add(pMenuPrincipal);   
        }else if (comando == GUARDAR){
            menuProyectos.guardarProgreso();

        }else{

        }
        setSize(getWidth()+1, getHeight()+1);
    } 

    public void CrearProyecto(String nombre, String descripcion, String participante, String correo, String fecha, String tipos) throws FileNotFoundException, IOException{
        Boolean respuesta = menuProyectos.ejecutarCrearProyecto(nombre, descripcion, participante, correo, fecha, tipos);
        if (respuesta==true){
            JOptionPane.showMessageDialog(pCrearProyecto, "El proyecto fue creado exitosamente",
				"Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(pCrearProyecto, "No se pudo crear el proyecto",
				"Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }
}
