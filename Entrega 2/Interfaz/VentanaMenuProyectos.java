package Interfaz;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;
import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;

public class VentanaMenuProyectos extends JFrame{
    MenuProyectos menuProyectos;
    MenuActividades menuActividades;
    PMenuProyectos pMenuProyectos;
    PElegirParticipante pElegirParticipante;
    Proyecto proyecto;
    Participante participante;
 
    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_PARTICIPANTES = "AGREGARPARTICIPANTES";
    public final String AGREGAR_TIPO = "AGREGARTIPO";
    public final String GESTIONAR = "GESTIONAR";
    public final String MODIFICAR_FIN = "MODIFICARFIN";

    VentanaMenuProyectos(MenuProyectos menuProyectos, Proyecto proyecto){
        this.menuProyectos = menuProyectos;
        pMenuProyectos = new PMenuProyectos(this, proyecto);
        this.proyecto = proyecto;
        setTitle("Menu Proyectos");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuProyectos, BorderLayout.CENTER);
    }

    public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
        if (comando == MENU){
            this.remove(pElegirParticipante);
            this.add(pMenuProyectos);

        }else if (comando == MENUPPAL){
            this.setVisible(false);

        }else if (comando == GESTIONAR){
            this.remove(pMenuProyectos);
            pElegirParticipante = new PElegirParticipante(this, proyecto.getParticipantes());
            this.add(pElegirParticipante);

        }else{
            ElegirParticipante(comando);
        }
        setSize(getWidth()-1, getHeight()-1);
    }

    public void cambiarFechaFinalizacion(Proyecto proyecto, String fecha) {
        menuProyectos.cambiarFechaFinalizacion(proyecto, fecha);

    }

    public void ElegirParticipante(String boton){
        int num = Integer.parseInt(boton.replace("PARTICIPANTE ", ""));
        menuActividades = new MenuActividades();
        participante = menuActividades.elegirParticipante(proyecto, num);
        this.setVisible(false);
        new VentanaMenuActividades(menuActividades, participante);
    }
    
}
