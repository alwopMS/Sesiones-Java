package leerTXT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try {
			File doc = new File("C:\\Users\\amunizs\\CursoJava\\Ejercicio9\\TXTnombres.txt");
			BufferedReader obj = new BufferedReader (new FileReader(doc));
			String nombresTXT;
			Set<String> listaNombres = new HashSet<>();
			while((nombresTXT = obj.readLine()) != null)
				listaNombres.add(nombresTXT);
			for (String nombre : listaNombres) {
				System.out.println(nombre);
			}
			obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
