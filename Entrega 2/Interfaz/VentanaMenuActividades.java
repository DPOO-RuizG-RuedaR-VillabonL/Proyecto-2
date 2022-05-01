package Interfaz;
import java.awt.Component;

import javax.swing.JFrame;


public class VentanaMenuActividades extends JFrame {
    PAgregaTipoActividad pAgregaTipoActividad;
    PGestorActividades pGestorActividades;

    public void AgregarTipoActividad () {

        pAgregaTipoActividad = new PAgregaTipoActividad(this);

        setTitle("Agregar tipo actividad");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pAgregaTipoActividad);
    
    }

    public void GestorActividades () {
        pGestorActividades = new pGestorActividades(this);
    
        setTitle("Gestor Actividades");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pGestorActividades);
        
        }
}
