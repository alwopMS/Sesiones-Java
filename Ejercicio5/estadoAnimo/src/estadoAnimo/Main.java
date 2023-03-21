package estadoAnimo;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nombre;
		int edad, opcion;
		DateFormat dateFormat = new SimpleDateFormat("EEEEEEEE, d MMM yyyy, HH:mm:ss");
		String fecha = dateFormat.format(new Date());
		
		System.out.println("Bienvenido usuario a "+fecha);
		System.out.println("Por favor indique su nombre:");
		nombre = sc.next();
		System.out.println("Por favor indique su edad:");
		edad = sc.nextInt();
		
		Persona usuario = new Persona(nombre, edad);
		System.out.println("Indique su estado de animo:");
		System.out.println("1-Enojado");
		System.out.println("2-Triste");
		System.out.println("3-Feliz");
		System.out.println("4-Preocupado");
		System.out.println("5-Aburrido");
		System.out.println("6-Somnoliento");
		boolean salir=false;
		do {
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1: 
					usuario.enojado();
					salir=true;
					break;
				case 2:
					usuario.triste();
					salir=true;
					break;
				case 3:
					usuario.feliz();
					salir=true;
					break;
				case 4:
					usuario.preocupado();
					salir=true;
					break;
				case 5:
					usuario.aburrido();
					salir=true;
					break;
				case 6:
					usuario.somnoliento();
					salir=true;
					break;
				default:
					System.out.println("No ha elegido una opcion valida, vuelva a introducir la opcion:");
			}
		}while(salir==false);
		sc.close();
		
	}

	

}
