package es.empleados.aop.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.empleados.aop.CerrarPrograma;
import es.empleados.aop.Configuracion;

public class Main implements EscribirInterface{
	public static void main (String [] args)
	{
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		CerrarPrograma cierre = contexto.getBean("cierre", CerrarPrograma.class);		
		
		cierre.cierraPrograma();
		Main m = new Main();
		m.generaTXT();
		contexto.close();
	}

	@Override
	public void generaTXT() {
		try {
			String nombreFichero = "info_empleados.txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\Ejercicio19\\";
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			Empleado emp1 = new Empleado("Pablo", "Carbajo", 24);
			Empleado emp2 = new Empleado("Luis", "Castelo", 30);
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			String contenidoCompleto=emp1.toString()+"\n";
			contenidoCompleto+=emp2.toString();

			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}