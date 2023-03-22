package claseJSON;
import java.net.HttpURLConnection; //Genera la conexion http
import java.net.URL; //Manejo de las urls
import java.util.Scanner;
public class Api {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://v2.jokeapi.dev/joke/Miscellaneous?lang=es&amount=3");
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
				System.out.println(informacion);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
