package empleadosMinisterio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main implements FicherosInterface{

	public static void main(String[] args) {
		//Creacion de empleados
		Empleado emp1 = new Empleado("Juan", "Topillo", "Lois", "1234238R", LocalDate.of(1989, 5, 12), LocalDate.of(2021, 3, 2), "Contable", 1400);
		Empleado emp2 = new Empleado("Luis", "Cotillo", "Madrid", "2341761T", LocalDate.of(1979, 1, 4), LocalDate.of(2002, 5, 4), "Psicologo", 1500);
		Empleado emp3 = new Empleado("Laura", "Alvares", "Barcelona", "1256678F", LocalDate.of(1979, 5, 6), LocalDate.of(2010, 3, 2), "Programador", 1700);		
		Empleado emp4 = new Empleado("Juan", "Topillo", "Lois", "1234238R", LocalDate.of(1989, 5, 12), LocalDate.of(2021, 3, 2), "Contable", 1400);
		Empleado emp5 = new Empleado("Maria", "Sanchez", "Valencia", "2374712E", LocalDate.of(1990, 5, 9), LocalDate.of(2020, 10, 1), "Contable", 1450);
		
		Set<Empleado> empleados = new HashSet<>();
		empleados.add(emp1);
		empleados.add(emp2);
		empleados.add(emp3);
		empleados.add(emp4);
		empleados.add(emp5);
		
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		String fechaHoy = fecha.format(dateTimeFormatter);
		String nombreFichero = "info_empleados_"+fechaHoy+".txt";
		String ruta = "C:\\Users\\amunizs\\CursoJava\\Ejercicio8\\";
		
		Main.escribirFichero(empleados,ruta,nombreFichero);
	}
	
	public static void escribirFichero(Set<Empleado> empleados, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			String contenidoCompleto = "",contenidoparcial;
			for (Empleado empleado : empleados) {
				contenidoparcial = "Empleado: "+empleado.getNombre()+ " " + empleado.getApellido()+" "+empleado.getLocalidad()+" DNI: "+empleado.getDNI()+" Nacimiento: "+empleado.getFechaNacimiento()+" Edad: "+empleado.getEdad()+" Ingreso: "+empleado.getFechaIngreso()+" Sueldo: "+empleado.getSalario()+"€ "+empleado.getPosicion()+" Antiguedad: "+empleado.getAntiguedad()+"\n";
				contenidoCompleto+=contenidoparcial;
			}
			 
			
			
			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
