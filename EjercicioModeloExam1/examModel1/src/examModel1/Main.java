package examModel1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import productos.Camisa;
import productos.Pantalon;
import productos.Ramera;
import productos.Sweater;
import productos.Vestido;

public class Main implements CalculosTotales{

	public static void main(String[] args) {
		try {
			
			Set<String> stringProductos = new HashSet<>();
			
			File doc = new File("C:\\Users\\amunizs\\CursoJava\\EjercicioModeloExam1\\info_Productos.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String linea;
			int i=0;
			while ((linea = obj.readLine()) != null) {
				stringProductos.add(linea);
			}
			
			
			obj.close();
			List<Integer> cantidadesProductos = new ArrayList<>();
			for (String string : stringProductos) {
				String[]datos=string.split(" ");
				cantidadesProductos.add(Integer.parseInt(datos[2]));
			}
			Main calculos = new Main();
			int cantidadTotalProductos = calculos.calcularCantidadesTotales(cantidadesProductos); 
			int productoConcreto=0;
			Ramera ram = null;
			Camisa cam = null;
			Vestido ves = null;
			Pantalon pan = null;
			Sweater swe = null;
			for (String string : stringProductos) {
				String[]datos=string.split(" ");
				String[] fUltimaVenta = datos[3].split("/");
				
				if (productoConcreto==0) {
					productoConcreto++;
					ves = new Vestido(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), LocalDate.of(Integer.parseInt(fUltimaVenta[2]), Integer.parseInt(fUltimaVenta[1]), Integer.parseInt(fUltimaVenta[0])), cantidadTotalProductos, datos[0], "Noche");
					
				}else if(productoConcreto==1) {
					productoConcreto++;
					swe =new Sweater(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), LocalDate.of(Integer.parseInt(fUltimaVenta[2]), Integer.parseInt(fUltimaVenta[1]), Integer.parseInt(fUltimaVenta[0])), cantidadTotalProductos, datos[0], "Oveja");
					 
				}else if(productoConcreto==2) {
					ram = new Ramera(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), LocalDate.of(Integer.parseInt(fUltimaVenta[2]), Integer.parseInt(fUltimaVenta[1]), Integer.parseInt(fUltimaVenta[0])), cantidadTotalProductos, datos[0], "Verano");
					productoConcreto++;
					  
				}else if(productoConcreto==3) {
					productoConcreto++;
					cam = new Camisa(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), LocalDate.of(Integer.parseInt(fUltimaVenta[2]), Integer.parseInt(fUltimaVenta[1]), Integer.parseInt(fUltimaVenta[0])), cantidadTotalProductos, datos[0], "Blanca");
					
				}else if(productoConcreto==4) {
					productoConcreto++;
					pan =new Pantalon(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), LocalDate.of(Integer.parseInt(fUltimaVenta[2]), Integer.parseInt(fUltimaVenta[1]), Integer.parseInt(fUltimaVenta[0])), cantidadTotalProductos, datos[0], "Vaquero");
					 
				}
			}
			
			LocalDate fecha = LocalDate.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			String fechaHoy = fecha.format(dateTimeFormatter);
			String nombreFichero = "informeProductos_"+fechaHoy+".txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\EjercicioModeloExam1\\";
			
			String contenidoCompleto = ram.toString()+"\n";
			contenidoCompleto += cam.toString()+"\n";
			contenidoCompleto+= ves.toString()+"\n";
			contenidoCompleto+=pan.toString()+"\n";
			contenidoCompleto+=swe.toString();
			escribirFichero(contenidoCompleto,ruta,nombreFichero);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void escribirFichero(String contenidoCompleto,String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int calcularCantidadesTotales(List<Integer> cantidades) {

		int total=0;
		for (Integer integer : cantidades) {
			total+=integer;
		}
		return total;
	}

}
