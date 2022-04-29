package Interfaz;

import javax.swing.JFrame;

import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;

public class VentanaMenuProyectos extends JFrame{
    MenuProyectos menuProyectos;

    VentanaMenuProyectos(MenuProyectos menuProyectos){
        this.menuProyectos = menuProyectos;
    }

    public void cambiarPanel(String comando) {
    }

    public void cambiarFechaFinalizacion(Proyecto proyecto, String fecha) {
        menuProyectos.cambiarFechaFinalizacion(proyecto, fecha);

    }
    
}
