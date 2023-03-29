package examVuelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;




public class Main implements CalculosTotalesInterface{

	public static void main(String[] args) {
		try {
			List<String> stringVuelos = new ArrayList<>();
			
			File doc = new File("C:\\Users\\amunizs\\CursoJava\\EjercicioExamen\\TXT_VUELOS.txt");
			BufferedReader obj = new BufferedReader(new FileReader(doc));
			String linea;
			int i=0;
			while ((linea = obj.readLine()) != null) {
				if(i==0) {
					linea = obj.readLine();
					i++;
				}				
				stringVuelos.add(linea);
			}
			
			obj.close();
			List<Vuelo> listadoVuelos = new ArrayList<>();
			for (String string : stringVuelos) {
				String[]datos=string.split(" ");
				String[]fecha=datos[4].split("/");
				Vuelo vue = new Vuelo("Iberia", datos[0], Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]),
						LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0])));
				listadoVuelos.add(vue);
			}
			
			LocalDate fecha = LocalDate.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			String fechaHoy = fecha.format(dateTimeFormatter);
			String nombreFichero = "info_vuelos_"+fechaHoy+".txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\EjercicioExamen\\";
			
			escribirFichero(listadoVuelos, ruta, nombreFichero);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void escribirFichero(List<Vuelo> listaVuelos, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			String contenidoCompleto = "NOMBRE_VUELO\tCANT_PASAJEROS\tTIPO_PASAJE\tVALOR_UNITARIO\tFECHA_VUELO\tVALOR_FINAL\tDIAS_DIFERENCIA\tSEGEMENTO\n",contenidoparcial;
			for (Vuelo vuelo : listaVuelos) {
				contenidoparcial=vuelo.getNombre()+"\t"+vuelo.getCantidaPasajeros()+"\t"+vuelo.getTipoPasaje()+"\t"+vuelo.getValorUnitarioPasaje()+"\t"+
						vuelo.getFechaVuelo().format(dateTimeFormatter)+"\t"+vuelo.getValorFinalVuelo()+"\t"+vuelo.getDiasDiferencia()+"\t"+vuelo.getSegmento()+"\n";
			
				contenidoCompleto+=contenidoparcial;
			}
			contenidoCompleto+="\nEl monto total obtenido es: ";
			Main mc = new Main();
			int monto = mc.calcularMotoTotal(listaVuelos);
			contenidoCompleto+=monto;
			 
			
			
			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int calcularMotoTotal(List<Vuelo> listadoVuelos) {
		int sumatorio=0;
		for (Vuelo vuelo : listadoVuelos) {
			sumatorio+=vuelo.getValorFinalVuelo();
		}
		return sumatorio;
	}
}
