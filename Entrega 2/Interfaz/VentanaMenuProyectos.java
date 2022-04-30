package Interfaz;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;

public class VentanaMenuProyectos extends JFrame{
    MenuProyectos menuProyectos;
    PMenuProyectos pMenuProyectos;

    VentanaMenuProyectos(MenuProyectos menuProyectos, Proyecto proyecto){
        this.menuProyectos = menuProyectos;
        setTitle("Menu Proyectos");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuProyectos, BorderLayout.CENTER);
    }

    public void cambiarPanel(String comando) {
    }

    public void cambiarFechaFinalizacion(Proyecto proyecto, String fecha) {
        menuProyectos.cambiarFechaFinalizacion(proyecto, fecha);

    }
    
}
