package listas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<String> productos = new ArrayList<>();
		Set<String> peliculas = new HashSet<>();
		Map<String,Integer> alumnos = new HashMap<>();
		
		//Introducir en List
		productos.add("Agua");
		productos.add("Huevos");
		productos.add("Leche");
		productos.add("Pañuelos");
		productos.add("Cereales");
		productos.add("Cerveza");
		productos.add("Pañuelos");
		productos.add("Detergente");
		productos.add("Folios");
		productos.add("Boligrafos");

		//introducir en Set
		peliculas.add("Avatar");
		peliculas.add("The Whale");
		peliculas.add("Last Night in Soho");
		peliculas.add("As Bestas");
		peliculas.add("Fall");
		peliculas.add("Modelo 77");
		peliculas.add("Un vencino gruñón");
		peliculas.add("El profigio");
		peliculas.add("Entre la vida y la muerte");
		peliculas.add("Bullet Train");
		
		//introducir en Map
		alumnos.put("Paula", 14);
		alumnos.put("Luis", 12);
		alumnos.put("Gabriel", 18);
		alumnos.put("Jaime", 20);
		alumnos.put("Carol", 11);
		alumnos.put("Pablo", 12);
		alumnos.put("Esther", 14);
		alumnos.put("María", 16);
		alumnos.put("Andres", 17);
		alumnos.put("Guzman", 12);
	}

}
