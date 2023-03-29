package examModel3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Calculos {
	public String calcularTotalPorAñoYMayorAño(List<String> stringPelis) {
		Map<String, Integer> recaudacion = new HashMap<>();
		for (String string : stringPelis) {
			String datos[]=string.split("\t");
			if (recaudacion.containsKey(datos[7])) {
				int oldvalue=recaudacion.get(datos[7]);
				int newValue= oldvalue + Integer.parseInt(datos[2]);
				recaudacion.replace(datos[7], oldvalue, newValue);
			} else {
				recaudacion.put(datos[7], Integer.parseInt(datos[2]));
			}
		}
		String contenido = "Dinero recaudado por año:\n";
		for (Map.Entry<String, Integer> entry : recaudacion.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			String parcial = "Año: "+key+"\tRecaudacion: "+val+"\n";
			contenido+=parcial;
		}
		contenido+="Año de mayor recaudacion: ";
		LinkedHashMap<String, Integer> sortedRecaudacion = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : recaudacion.entrySet()) {
            list.add(entry.getValue());
        }
		Collections.sort(list,Collections.reverseOrder());
		for (int num : list) {
			for (Entry<String, Integer> entry : recaudacion.entrySet()) {
				if (entry.getValue().equals(num)) {
					sortedRecaudacion.put(entry.getKey(), num);
				}
			}
		}
		
		for (Map.Entry<String, Integer> entry : sortedRecaudacion.entrySet()) {
			contenido+=entry.getKey();
			contenido+="\n";
			break;
		}
		return contenido;
	}
	public String calcularPeliculasMayorRecaudacion(List<String> stringPelis) {
		Map<String, Integer> peliculas = new HashMap<>();
		LinkedHashMap<String, Integer> sortedPeliculas = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        String contenido= " Las 3 peliculas con mayor recaudacion de mayor a menor son:\n";
		for (String string : stringPelis) {
			String datos[]=string.split("\t");
			peliculas.put(datos[1], Integer.parseInt(datos[2]));
		}
		for (Map.Entry<String, Integer> entry : peliculas.entrySet()) {
            list.add(entry.getValue());
        }
		Collections.sort(list,Collections.reverseOrder());
		for (int num : list) {
			for (Entry<String, Integer> entry : peliculas.entrySet()) {
				if (entry.getValue().equals(num)) {
					sortedPeliculas.put(entry.getKey(), num);
				}
			}
		}
		int salida=0;
		String parcial; 
		for (Map.Entry<String, Integer> entry : sortedPeliculas.entrySet()) {
			parcial= entry.getKey()+"\t"+entry.getValue()+"\n";
			contenido+=parcial;
			salida++;
			if(salida>=3) {
				break;
			}
		}
		return contenido;
	}
	
	public String ordenarPeliculas(List<String> stringPelis) {
		List<String> peliculas = new ArrayList<>();
		String contenido = "El listado de peliculas ordenado alfabeticamente es:\n";
		for (String string : stringPelis) {
			String datos[]=string.split("\t");
			peliculas.add(datos[1]);
		}
		Collections.sort(peliculas);
		String parcial;
		for (String string : peliculas) {
			parcial=string+"\n";
			contenido+=parcial;
		}
		return contenido;
	}
}
