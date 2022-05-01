package Interfaz;
import javax.swing.JFrame;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;


public class VentanaMenuActividades extends JFrame {
    PAgregaTipoActividad pAgregaTipoActividad;

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



    
}
