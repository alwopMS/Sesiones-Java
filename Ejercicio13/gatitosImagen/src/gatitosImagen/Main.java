package gatitosImagen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.json.JSONArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://api.thecatapi.com/v1/images/search");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			
			int timeDeRespuesta = con.getResponseCode();
			
			if ( timeDeRespuesta != 200) { //200 codigo de respuesta correcto
				throw new RuntimeException("HttpResponseCode "+timeDeRespuesta);
			}else {
				//Obtener el url de la imagen
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}
				JSONArray imagenes = new JSONArray(informacion.toString());
				sc.close();
				int indice=0;
				URL urlImg = new URL(imagenes.getJSONObject(indice).getString("url"));
				//System.out.println(imagenes.getJSONObject(indice));
				Image image = ImageIO.read(urlImg);
				ImageIcon imageIcon = new ImageIcon(image);
				
				//Creacion de la Ventana
				
				JFrame jFrame = new JFrame();
				jFrame.setBackground(Color.cyan);
				JLabel jLabel = new JLabel();
				
				
				jFrame.setLayout(new FlowLayout());
				jFrame.setSize(imagenes.getJSONObject(indice).getInt("width")+20, imagenes.getJSONObject(indice).getInt("height")+40);
				jLabel.setIcon(imageIcon);
				jFrame.add(jLabel);
				jFrame.setIconImage(image);
				jFrame.setVisible(true);
				jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
