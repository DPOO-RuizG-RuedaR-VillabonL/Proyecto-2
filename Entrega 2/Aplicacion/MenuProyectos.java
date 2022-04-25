package Aplicacion;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import Actividades.Participante;
import Proyectos.Proyecto;

public class MenuProyectos
{
    ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
    File fichero = new File("proyectos.txt");
	
	public void ejecutarCrearProyecto()
	{
		String nombre = input("Por favor ingrese el nombre del proyecto ");
        String descripcion = input("Por favor ingrese la descripcion del proyecto ");
        String nombreP = input("Por favor ingrese el nombre completo del participante que comenzó el proyecto ");
        String correo = input("Por favor ingrese el correo del participante que comenzó el proyecto ");

        int anioInicio = Integer.parseInt(input("Por favor ingrese el año de inicio del proyecto "));
        int mesInicio = Integer.parseInt(input("Por favor ingrese el número del mes de inicio del proyecto"));
		int diaInicio = Integer.parseInt(input("Por favor ingrese el día de inicio del proyecto "));

        String[] tipos = ((input("Por favor ingrese los tipos de actividad permitidos separados por comas ")).toLowerCase()).split(", ");
        ArrayList<String> tiposActividad = new ArrayList<String>();
        for (String tipo : tipos)
        {tiposActividad.add(tipo);}
		
        LocalDate fechaInicio = LocalDate.of(anioInicio, mesInicio, diaInicio);

		Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, nombreP, correo, fechaInicio, tiposActividad);

        String respuesta = input("¿Tiene una fecha de finalización estimada? Escriba sí o no: ");
        if ((respuesta.toLowerCase()).equals("si") | (respuesta.toLowerCase()).equals("sí"))
        {
            int anioFin = Integer.parseInt(input("Por favor ingrese el año de fin del proyecto:"));
            int mesFin = Integer.parseInt(input("Por favor ingrese el número del mes de fin del proyecto:"));
            int diaFin = Integer.parseInt(input("Por favor ingrese el día de fin del proyecto:"));
		    
            nuevoProyecto.setFechaFinal(diaFin, mesFin, anioFin);
        }
        else
        {
            nuevoProyecto.setFechaFinal(31, 12, 3022);
        }

		proyectos.add(nuevoProyecto);

		System.out.println("El proyecto se ha creado");
	}

    public ArrayList<Proyecto> getProyectos() 
    {
        return proyectos;
    }

    public Proyecto elegirProyecto()
    {
        if (proyectos.size()==0){
            System.out.println("Todavia no ha creado proyectos para gestionar");
            return null;
        }
        else {
        for(int i=0; i<proyectos.size(); i++)
        {
            Proyecto proyecto = proyectos.get(i);
            System.out.println((i+1) +". "+ proyecto.getNombre());
        }

        int numProyecto = Integer.parseInt(input("Por favor ingrese el numero del proyecto que desea gestionar "));
        Proyecto proyecto = proyectos.get(numProyecto-1);
        return proyecto;
        }
    }

    public void gestionarProyecto(Proyecto proyecto)
    {
        MenuActividades menuActividades = new MenuActividades();
        boolean continuar = true;
		while (continuar && proyecto!=null)
		{
			try
			{
				mostrarMenuProyectos(proyecto);
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

                if (opcion_seleccionada == 1)
                    System.out.println(proyecto.getDescripcion());

				else if (opcion_seleccionada == 2)
                    ejecutarConsultarParticipantes(proyecto);

                else if (opcion_seleccionada == 3)
                    ejecutarConsultarFechaInicio(proyecto);

                else if (opcion_seleccionada == 4)
                    ejecutarConsultarFechaFin(proyecto);

                else if (opcion_seleccionada == 5)
                    ejecutarAgregarParticipante(proyecto);
                
                else if (opcion_seleccionada == 6)
                    ejecutarAgregarTipo(proyecto);
                
                else if (opcion_seleccionada == 7)
                {
                    Participante participante = menuActividades.elegirParticipante(proyecto);
                    menuActividades.gestionarMenuActividades(participante);
                }
                else if (opcion_seleccionada == 8)
					cambiarFechaFinalizacion(proyecto);
				else if (opcion_seleccionada == 9) {
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

    private void ejecutarAgregarTipo(Proyecto proyecto) 
    {
        System.out.println("Los tipos de actividades disponibles para este proyecto son: ");
        ArrayList<String> tipos = proyecto.getTiposActividad();
        for(int i=0; i<tipos.size(); i++)
        {
            String tipo = tipos.get(i);
            System.out.println((i+1) +". "+ tipo);
        }
        String nuevoTipo = (input("Por favor escriba el nombre del tipo de actividad que desea agregar ")).toLowerCase();
        (proyecto.getTiposActividad()).add(nuevoTipo);
    }

    private void ejecutarAgregarParticipante(Proyecto proyecto) 
    {
        String nombre = input("Por favor escriba el nombre completo del participante que desea agregar ");
        String correo = input("Por favor escriba el correo del participante que desea agregar ");
        Participante nuevoParticipante = new Participante(nombre, correo);
        proyecto.agregarParticipante(nuevoParticipante);
    }

    private void ejecutarConsultarParticipantes(Proyecto proyecto) 
    {
        ArrayList<Participante> participantes = proyecto.getParticipantes();
        for(int i=0; i<participantes.size(); i++)
            {
                Participante participante = participantes.get(i);
                System.out.println((i+1) +". "+ participante.getNombre()+ "\t" + participante.getCorreo());
            }
    }

    private void ejecutarConsultarFechaInicio (Proyecto proyecto) 
    {                
        LocalDate rta = proyecto.getFechaInicial();
        System.out.println(rta);
            
    }
    private void ejecutarConsultarFechaFin (Proyecto proyecto) 
    {
        LocalDate rta = proyecto.getFechaFinal();
        LocalDate fechaEstandar = LocalDate.parse("3022-12-31");
        if (fechaEstandar.equals(rta))
            System.out.println("Todavía no tiene fecha de finalización");
        else
            System.out.println(rta);

    }

    private void cambiarFechaFinalizacion(Proyecto proyecto) 
    {
        LocalDate fechaFin = proyecto.getFechaFinal();
        LocalDate fechaEstandar = LocalDate.parse("3022-12-31");
        int anioFin = Integer.parseInt(input("Por favor ingrese el año de fin del proyecto"));
        int mesFin = Integer.parseInt(input("Por favor ingrese el número del mes de fin del proyecto"));
        int diaFin = Integer.parseInt(input("Por favor ingrese el día de fin del proyecto"));

        System.out.println(fechaFin);
        System.out.println(fechaEstandar);

        if (fechaFin.equals(fechaEstandar)) // comprobar que no hay fecha asignada 
        {
            proyecto.setFechaFinal(diaFin, mesFin, anioFin);
            System.out.println("La fecha ya fue modificada");

        }
        else //tiene fecha de modificación asignada
        {
            String respuesta = input("El proyecto ya tiene una fecha de modificación asignada, ¿Quiere modificarlo igualmente? Escriba si o no: ");
            if ((respuesta.toLowerCase()).equals("si") | (respuesta.toLowerCase()).equals("sí")) {
                proyecto.setFechaFinal(diaFin, mesFin, anioFin);
                System.out.println("La fecha ya fue modificada");
            }
        }



    }

    public void mostrarMenuProyectos(Proyecto proyecto)
	{
		System.out.println("\nGestionar Proyecto "+proyecto.getNombre()+"\n");
		System.out.println("1. Consultar descripcion del proyecto");
		System.out.println("2. Consultar participantes");
        System.out.println("3. Consultar fecha de inicio");
        System.out.println("4. Consultar fecha de finalización");
        System.out.println("5. Agregar participante");
        System.out.println("6. Agregar tipo de actividad admitida");
        System.out.println("7. Gestionar Actividades");
        System.out.println("8. Agregar o Modificar la fecha de finalización del proyecto");
		System.out.println("9. Volver al menu principal\n");
	}

	public String input(String mensaje)
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

    public void guardarProgreso() throws FileNotFoundException, IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Proyecto proyecto: proyectos)
            {
                oos.writeObject(proyecto);
            }
        }
    }

    public void cargarProyectos() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (fichero.exists()){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                while(true){
                    try{
                        Proyecto proyecto = (Proyecto) ois.readObject();
                        proyectos.add(proyecto);
                    }
                    catch (EOFException eofException)
                    {
                        break;
                    }
                }
            }
        }}
    

}
