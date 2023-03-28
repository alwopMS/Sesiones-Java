package examModel2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		try {
			String contenidoCompleto="";
			// ----------Berlin--------------
			URL url1 = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&forecast_days=1");
			HttpURLConnection conBerlin = (HttpURLConnection) url1.openConnection();
			conBerlin.connect();
			int timeDeRespuesta = conBerlin.getResponseCode();
			
			if ( timeDeRespuesta != 200) { //200 codigo de respuesta correcto
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta);
			}else {
				
				StringBuilder informacionBerlin = new StringBuilder();
				Scanner sc = new Scanner(url1.openStream());
				while (sc.hasNext()) {
					informacionBerlin.append(sc.nextLine());
				}
				JSONObject apiInfoBerlin = new JSONObject(informacionBerlin.toString());
				JSONObject berlinWeather = apiInfoBerlin.getJSONObject("current_weather");
				
				String recomendacionBerlin;
				if (berlinWeather.getFloat("temperature")>=20) {
					recomendacionBerlin="Berlin: Se recomienda realizar las tareas de producción";
				}else {
					recomendacionBerlin="Berlin: Se recomienda realizar tareas de mantenimiento";
				}
				contenidoCompleto+=recomendacionBerlin+"\n";
				System.out.println(recomendacionBerlin);
				
				sc.close();	
			}
			//--------------------Madrid---------------------
			URL url2 = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&forecast_days=1");
			HttpURLConnection conMadrid = (HttpURLConnection) url2.openConnection();
			conMadrid.connect();
			
			
			timeDeRespuesta = conBerlin.getResponseCode();
			
			if ( timeDeRespuesta != 200) { //200 codigo de respuesta correcto
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta);
			}else {
				
				StringBuilder informacionMadrid = new StringBuilder();
				Scanner sc1 = new Scanner(url1.openStream());
				while (sc1.hasNext()) {
					informacionMadrid.append(sc1.nextLine());
				}
				JSONObject apiInfoMadrid = new JSONObject(informacionMadrid.toString());
				JSONObject madridWeather = apiInfoMadrid.getJSONObject("current_weather");
				
				String recomendacionMadrid;
				if (madridWeather.getFloat("temperature")<15) {
					recomendacionMadrid="Madrid: Se recomienda realizar las tareas de producción y siembra";
				}else {
					recomendacionMadrid="Madrid: no se recomienda realizar tareas de sembrado, solo tareas de producción";
				}
				contenidoCompleto+=recomendacionMadrid;
				System.out.println(recomendacionMadrid);
				
				sc1.close();	
			}
			String nombreFichero = "recomendacion_diaria.txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\EjercicioModeloExam2\\";
			escribirFichero(contenidoCompleto, ruta, nombreFichero);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void escribirFichero(String infoCompleta, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);			
			
			bw.write(infoCompleta);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
