package apiRick;
import java.net.HttpURLConnection; //Genera la conexion http
import java.net.URL; //Manejo de las urls
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			URL url1 = new URL("https://rickandmortyapi.com/api/character");
			URL url2 = new URL("https://rickandmortyapi.com/api/location");
			URL url3 = new URL("https://rickandmortyapi.com/api/episode");
			
			HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
			HttpURLConnection con2 = (HttpURLConnection) url1.openConnection();
			HttpURLConnection con3 = (HttpURLConnection) url1.openConnection();
			
			con1.connect();
			con2.connect();
			con3.connect();
			
			int timeDeRespuesta1 = con1.getResponseCode();
			int timeDeRespuesta2 = con2.getResponseCode();
			int timeDeRespuesta3 = con3.getResponseCode();
			
			if (timeDeRespuesta1!=200) {
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta1);
			}else if(timeDeRespuesta2!=200) {
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta2);
			}else if(timeDeRespuesta3!=200) {
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta3);
			}else {
				StringBuilder informacion = new StringBuilder();
				Scanner sc1 = new Scanner(url1.openStream());
				Scanner sc2 = new Scanner(url2.openStream());
				Scanner sc3 = new Scanner(url3.openStream());
				while (sc1.hasNext()) {
					informacion.append(sc1.nextLine());
				}
				while (sc2.hasNext()) {
					informacion.append(sc2.nextLine());
				}
				while (sc3.hasNext()) {
					informacion.append(sc3.nextLine());
				}
				System.out.println(informacion);
				sc1.close();
				sc2.close();
				sc3.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
