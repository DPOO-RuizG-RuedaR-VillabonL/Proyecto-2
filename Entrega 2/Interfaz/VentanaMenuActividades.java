package Interfaz;

import javax.swing.JFrame;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;


public class VentanaMenuActividades extends JFrame {
    PAgregaTipoActividad pAgregaTipoActividad;
    PGestorActividades pGestorActividades;

    public VentanaMenuActividades(MenuActividades menuActividades, Participante participante) {
    }

    public void ventanaMenuActividades () {

        pAgregaTipoActividad = new PAgregaTipoActividad(this);

        setTitle("Agregar tipo actividad");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pAgregaTipoActividad);
    
    }

    public void GestorActividades () {
        pGestorActividades = new PGestorActividades(this);
    
        setTitle("Gestor Actividades");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pGestorActividades);
        
        }
}
