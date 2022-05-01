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
    PDescripcion pDescripcion;
    Proyecto proyecto;
    Participante participante;
 
    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_PARTICIPANTES = "AGREGARPARTICIPANTES";
    public final String AGREGAR_TIPO = "AGREGARTIPO";
    public final String GESTIONAR = "GESTIONAR";
    public final String MODIFICAR_FIN = "MODIFICARFIN";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String PARTICIPANTES = "PARTICIPANTES";
    public final String FINICIO = "F_INICIO";
    public final String FFIN = "F_FIN";

    VentanaMenuProyectos(MenuProyectos menuProyectos, Proyecto proyecto) throws FileNotFoundException, IOException{
        this.menuProyectos = menuProyectos;
        this.proyecto = proyecto;
        pMenuProyectos = new PMenuProyectos(this, proyecto);
        pDescripcion = new PDescripcion(this, proyecto);
        pElegirParticipante = new PElegirParticipante(this, proyecto.getParticipantes());
        
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
            this.remove(pDescripcion);
            this.add(pMenuProyectos);

        }else if (comando == MENUPPAL){
            this.setVisible(false);

        }else if (comando == GESTIONAR){
            this.remove(pMenuProyectos);
            pElegirParticipante = new PElegirParticipante(this, proyecto.getParticipantes());
            this.add(pElegirParticipante);
            
        }else if (comando == DESCRIPCION){
            this.remove(pMenuProyectos);
            this.add(pDescripcion);

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
