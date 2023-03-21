package listas2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> productos = new ArrayList<>();
		Set<String> dni = new HashSet<>();
		Map<String,Integer> usuarios = new HashMap<>();
		
		int id, numElementos;
		String user, numDNI, producto;
		do {
			System.out.println("Introduzca el numero de elementos que va introducir en las listas (al menos 3):");
			numElementos = sc.nextInt();
		}while(numElementos<3);
		System.out.println("Introduzca los elementos de la lista de supermercado");
		
		for (int i = 0; i < numElementos; i++) {
			producto = sc.next();
			productos.add(producto);
		}
		
		System.out.println("Introduzca los DNIs:");
		
		for (int i = 0; i < numElementos; i++) {
			numDNI = sc.next();
			dni.add(numDNI);
		}
		
		System.out.println("Introduzca los nombres de usuarios y sus IDs:");
		
		for (int i = 0; i < numElementos; i++) {
			System.out.println("Introduzca el nombre de ususario:");
			user = sc.next();
			System.out.println("Introduzca el id:");
			id = sc.nextInt();
			
			usuarios.put(user, id);
		}
		sc.close();
		
	}

}
