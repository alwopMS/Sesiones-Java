package apiRickTXT;

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
			URL url = new URL("https://rickandmortyapi.com/api");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			
			int timeDeRespuesta = con.getResponseCode();
			
			if ( timeDeRespuesta != 200) { //200 codigo de respuesta correcto
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta);
			}else {
				
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}
				JSONObject apiInfo = new JSONObject(informacion.toString());
				sc.close();
				
				
				String infoCompleta ="Characters:\n";
				
				
				URL urlCharacteres = new URL(apiInfo.get("characters").toString());
				HttpURLConnection conCharCharacteres = (HttpURLConnection) urlCharacteres.openConnection();
				conCharCharacteres.connect();
				
				StringBuilder characters = new StringBuilder();
				Scanner sc1 = new Scanner(urlCharacteres.openStream());
				while(sc1.hasNext()) {
					characters.append(sc1.nextLine());
				}
				infoCompleta+=characters.toString();
				infoCompleta+="\n";
				sc1.close();
				
				infoCompleta+="Locations:\n";
				URL urlLocations = new URL(apiInfo.get("locations").toString());
				HttpURLConnection conLocations = (HttpURLConnection) urlLocations.openConnection();
				conLocations.connect();
				
				StringBuilder locations = new StringBuilder();
				Scanner sc2 = new Scanner(urlLocations.openStream());
				while(sc2.hasNext()) {
					locations.append(sc2.nextLine());
				}
				infoCompleta+=locations.toString();
				infoCompleta+="\n";
				sc1.close();
				
				infoCompleta+="Episodes:\n";
				URL urlEpisodes = new URL(apiInfo.get("episodes").toString());
				HttpURLConnection conEpisodes = (HttpURLConnection) urlEpisodes.openConnection();
				conEpisodes.connect();
				
				StringBuilder episodes = new StringBuilder();
				Scanner sc3 = new Scanner(urlEpisodes.openStream());
				while(sc3.hasNext()) {
					episodes.append(sc3.nextLine());
				}
				infoCompleta+=episodes.toString();
				sc3.close();
				
				String nombreFichero = "infoRickyMorty.txt";
				String ruta = "C:\\Users\\amunizs\\CursoJava\\Ejercicio12\\";
				escribirFichero(infoCompleta, ruta, nombreFichero);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void escribirFichero(String informacion, String ruta, String nombreFichero) {
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

