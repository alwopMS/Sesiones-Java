package examModel3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.List;


public class Main {

	public static void main(String[] args) {
		try {
			
			List<String> stringPelis = new ArrayList<>();
			
			File doc = new File("C:\\Users\\amunizs\\CursoJava\\EjercicioModeloExam3\\infoPelis.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String linea;
			int i=0;
			while ((linea = obj.readLine()) != null) {
				if(i==0) {
					linea = obj.readLine();
					i++;
				}				
				stringPelis.add(linea);
			}
			
			
			
			obj.close();
			String informacion;
			Calculos calcular = new Calculos();
			informacion = calcular.calcularTotalPorAñoYMayorAño(stringPelis);
			informacion+= calcular.calcularPeliculasMayorRecaudacion(stringPelis);
			informacion+= calcular.ordenarPeliculas(stringPelis);
			
			String nombreFichero = "informePeliculas.txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\EjercicioModeloExam3\\";
			escribirFichero(informacion,ruta,nombreFichero);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void escribirFichero(String informacion, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write(informacion);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
