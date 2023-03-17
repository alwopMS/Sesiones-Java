package programaSeguros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main implements FicherosInterface{

	public static void main(String[] args) {
		
		Empleado [] empleados = {new Empleado("Pablo","Lopez","Albacete","Programador",1300),new Empleado("Guzman","Rodriguez","Santander","Físico",1600),new Empleado("Luis","Sánchez","León","Programador Senior",1900)};
		
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		String fechaHoy = fecha.format(dateTimeFormatter);
		String nombreFichero = "info_empleados_"+fechaHoy+".txt";
		String ruta = "C:\\Users\\amunizs\\CursoJava\\Ejercicio3\\";
		
		escribirFichero(empleados,ruta,nombreFichero);
		
	}

	public static void escribirFichero(Empleado[] empleados, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			String contenido1 = "Empleado: "+empleados[0].getNombre()+ " " + empleados[0].getApellido()+" "+empleados[0].getLocalidad()+" "+empleados[0].getPosicion()+" "+empleados[0].getSueldo()+"€";
			String contenido2 = "Empleado: "+empleados[1].getNombre()+ " " + empleados[1].getApellido()+" "+empleados[1].getLocalidad()+" "+empleados[1].getPosicion()+" "+empleados[1].getSueldo()+"€";
			String contenido3 = "Empleado: "+empleados[2].getNombre()+ " " + empleados[2].getApellido()+" "+empleados[2].getLocalidad()+" "+empleados[2].getPosicion()+" "+empleados[2].getSueldo()+"€";
			String contenidoCompleto = contenido1 +"\n"+contenido2+"\n"+contenido3;
			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}

