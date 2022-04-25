
package Mundo.Aplicacion;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Mundo.Actividades.Actividad;
import Mundo.Actividades.Participante;
import Mundo.Actividades.ReporteActividades;
import Mundo.Proyectos.Proyecto;


public class MenuActividades
{
    Participante participante;
    private ArrayList<String> tiposActividad;

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
	
	private void ejecutarCrearActividad()
	{
        /** Declara las variables que tiene una actividad */

		String titulo = input("Por favor ingrese el titulo de la actividad: ");
        String descripcion = input("Por favor ingrese la descripcion de la actividad: ");
        String tipo = input("Por favor ingrese el tipo de actividad que realizo: ");
        List<ArrayList<LocalTime>> listaTiempos = new ArrayList<ArrayList<LocalTime>>();
        List<ArrayList<LocalDate>> listaFechas = new ArrayList<ArrayList<LocalDate>>();

        /** Creacion inicio hora y fecha */

        int diaInicio = Integer.parseInt(input("Por favor ingrese el dia de inicio de la actividad: "));
		int mesInicio = Integer.parseInt(input("Por favor ingrese el mes de inicio de la actividad: "));
		int anioInicio = Integer.parseInt(input("Por favor ingrese el anio de inicio de la actividad: "));

        LocalDate fechaInicio = LocalDate.of(anioInicio, mesInicio, diaInicio);

        int segundoInicio = Integer.parseInt(input("Por favor ingrese los segundos de inicio de la actividad: "));
        int minutosInicio = Integer.parseInt(input("Por favor ingrese los minutos de inicio de la actividad: "));
		int horaInicio = Integer.parseInt(input("Por favor ingrese la hora de inicio de la actividad: "));

        LocalTime tiempoInicio = LocalTime.of(horaInicio, minutosInicio, segundoInicio);

        /** Condicional para default fecha */

        String defaultFecha = input("La fecha de finalizacion es la default? Escriba si o no");
        if ((defaultFecha.toLowerCase()).equals("no"))
        {
            /** Creacion terminacion hora y fecha */

            int diaFin = Integer.parseInt(input("Por favor ingrese el dia de fin de la actividad: "));
            int mesFin = Integer.parseInt(input("Por favor ingrese el numero del mes de fin de la actividad: "));
            int anioFin = Integer.parseInt(input("Por favor ingrese el anio de fin de la actividad: "));
            
            LocalDate fechaTerminacion = LocalDate.of(anioFin, mesFin, diaFin);
            
            int segundoTerminacion = Integer.parseInt(input("Por favor ingrese los segundos de terminacion de la actividad: "));
            int minutosTerminacion = Integer.parseInt(input("Por favor ingrese los minutos de terminacion de la actividad: "));
            int horaTerminacion = Integer.parseInt(input("Por favor ingrese la hora de terminacion de la actividad: "));

            LocalTime tiempoTerminacion = LocalTime.of(horaTerminacion, minutosTerminacion, segundoTerminacion);

            ArrayList<LocalDate> fecha0 = new ArrayList<LocalDate>();
            ArrayList<LocalTime> hora0 = new ArrayList<LocalTime>();

            fecha0.add(fechaInicio);
            fecha0.add(fechaTerminacion);

            hora0.add(tiempoInicio);
            hora0.add(tiempoTerminacion);

            listaFechas.add(fecha0);
            listaTiempos.add(hora0);
        }
        else
        {
            /** Creacion default hora y fecha */

            LocalDate fechaTerminacion = LocalDate.now();
            LocalTime tiempoTerminacion = LocalTime.now();

            ArrayList<LocalDate> fecha0 = new ArrayList<LocalDate>();
            ArrayList<LocalTime> hora0 = new ArrayList<LocalTime>();

            fecha0.add(fechaInicio);
            fecha0.add(fechaTerminacion);

            hora0.add(tiempoInicio);
            hora0.add(tiempoTerminacion);

            listaFechas.add(fecha0);
            listaTiempos.add(hora0);
        }

        String pauso = input("¿Ha realizado pausas? Escriba si o no: ");
        if ((pauso.toLowerCase()).equals("si"))
        {
            int pausas = Integer.parseInt(input(("Ingrese la cantidad de pausas realizadas")));
            int i = 1;
            while (i <= pausas)
            {   
                /** Creacion parada inicio fecha y hora */

                int diaParadaInicio = Integer.parseInt(input("Por favor ingrese el dia de inicio de la actividad: "));
                int mesParadaInicio = Integer.parseInt(input("Por favor ingrese el numero del mes de inicio de la actividad: "));
                int anioParadaInicio = Integer.parseInt(input("Por favor ingrese el anio de inicio de la actividad: "));

                LocalDate fechaParadaInicio = LocalDate.of(anioParadaInicio, mesParadaInicio, diaParadaInicio);

                int segundoParadaInicio = Integer.parseInt(input("Por favor ingrese los segundos de inicio de la actividad: "));
                int minutosParadaInicio = Integer.parseInt(input("Por favor ingrese los minutos de inicio de la actividad: "));
                int horaParadaInicio = Integer.parseInt(input("Por favor ingrese la hora de inicio de la actividad: "));

                LocalTime tiempoParadaInicio = LocalTime.of(horaParadaInicio, minutosParadaInicio, segundoParadaInicio);

                /** Creacion parada terminacion fecha y hora */

                int diaParadaFin = Integer.parseInt(input("Por favor ingrese el dia de fin del la actividad: "));
                int mesParadaFin = Integer.parseInt(input("Por favor ingrese el numero del mes de fin de la actividad: "));
                int anioParadaFin = Integer.parseInt(input("Por favor ingrese el anio de fin de la actividad: "));

                LocalDate fechaParadaFin = LocalDate.of(anioParadaFin, mesParadaFin, diaParadaFin);

                int segundoParadaFin = Integer.parseInt(input("Por favor ingrese los segundos de finalizacion de la actividad: "));
                int minutosParadFin = Integer.parseInt(input("Por favor ingrese los minutos de finalizacion de la actividad: "));
                int horaParadaFin = Integer.parseInt(input("Por favor ingrese la hora de finalizacion de la actividad: "));
    
                LocalTime tiempoParadaFin = LocalTime.of(horaParadaFin, minutosParadFin, segundoParadaFin);

                ArrayList<LocalDate> fechaParada = new ArrayList<LocalDate>();
                ArrayList<LocalTime> horaParada = new ArrayList<LocalTime>();

                fechaParada.add(fechaParadaInicio);
                fechaParada.add(fechaParadaFin);

                horaParada.add(tiempoParadaInicio);
                horaParada.add(tiempoParadaFin);

                listaFechas.add(fechaParada);
                listaTiempos.add(horaParada);
            }
        }
        Actividad nuevaActividad = new Actividad(titulo, descripcion, tipo, listaFechas, listaTiempos);
		System.out.println("La actividad se ha creado");
        this.participante.agregarActividad(nuevaActividad);
	}
    public Participante elegirParticipante(Proyecto proyecto)
    {   
        this.tiposActividad = proyecto.getTiposActividad();
        ArrayList<Participante> participantes = proyecto.getParticipantes();
        for(int i=0; i<participantes.size(); i++)
        {
            Participante participante = participantes.get(i);
            System.out.println((i+1) +". "+ participante.getNombre());
        }
        int numParticipante = Integer.parseInt(input("Por favor ingrese el numero del participante que desea gestionar "));
        Participante participante = participantes.get(numParticipante-1);
        setParticipante(participante);
        return participante;
        
    }
    
    private String input(String mensaje)
	{
        try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
    }

    void mostrarMenuActividades() {
		System.out.println("1. Crear una actividad");
		System.out.println("2. Consultar las estadisticas de un participante");
		System.out.println("3. Volver al menu proyecto\n");
    }

    private void mostrarEstadisticas(Participante participante, ArrayList<String> tiposActividad)
    {
        ReporteActividades Estadisticas = participante.getReporteActividades();
        System.out.println("El tiempo promedio por actividad es de "+Estadisticas.calcularTiempoPromedioPorActividad()+"s");
        System.out.println("El tiempo promedio por tipo de actividad es de \n");
        HashMap<String, Double> estadisticasPorTipo = Estadisticas.calcularTiempoPromedioPorTipo(tiposActividad);
        for (String tipo : tiposActividad)
        {
            System.out.println(tipo + "  "+ estadisticasPorTipo.get(tipo)+ " s");
        }
    }

    public void gestionarMenuActividades(Participante participante)
    {
        boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuActividades();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
                if (opcion_seleccionada == 1)
                    ejecutarCrearActividad();
				else if (opcion_seleccionada == 2)
                {
                    mostrarEstadisticas(participante, tiposActividad);
                }
                else if (opcion_seleccionada == 3)
                {
					System.out.println("Volviendo al menú principal ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}


    }
}


