package calculadora;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cifra1, cifra2, resultado, opcion;
		System.out.println("Calculadora Java");
		System.out.println("En caso de que quiera realizar una division la primera cifra sera el Dividedo"
				+" y la segunda sera el Divisor");
		System.out.println("Introduzca la primera cifra:");
		
		Scanner scanner = new Scanner(System.in);
		
		cifra1=scanner.nextInt();

		System.out.println("Introduzca la segunda cifra:");
		
		cifra2 = scanner.nextInt();
		
		System.out.println("Decida la opcion a realizar introduciendo el numero de la opcion:");
		System.out.println("1-Suma");
		System.out.println("2-Resta");
		System.out.println("3-Multiplicacion");
		System.out.println("4-Division");
		
		opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			resultado = suma(cifra1,cifra2);
			System.out.println("El resultado obtenido es: "+resultado);
			break;
		case 2:
			resultado = resta(cifra1, cifra2);
			System.out.println("El resultado obtenido es: "+resultado);
			break;
		case 3:
			resultado = multiplicacion(cifra1, cifra2);
			System.out.println("El resultado obtenido es: "+resultado);
			break;
		case 4:
			if(cifra2==0) {
				while(cifra2==0) {
					System.out.println("Esta calculadora no puede dividir entre 0");
					System.out.println("Sustituya el divisor por otra cifra:");
					cifra2=scanner.nextInt();
				}
			}
			resultado = division(cifra1, cifra2);
			
			System.out.println("El resultado obtenido es: "+resultado);
			break;
		default:
			System.out.println("Opcion elegida no encontrada, vuelva a ejecutar la calculadora y eliga una opcion valida.");;
			break;
		}
		
		
	}
	
	public static int suma(int cifra1, int cifra2) {		
		return cifra1+cifra2;
	}
	
	public static int resta(int cifra1, int cifra2) {		
		return cifra1-cifra2;
	}
	
	public static int multiplicacion(int cifra1, int cifra2) {		
		return cifra1*cifra2;
	}
	public static int division(int cifra1, int cifra2) {		
		return cifra1/cifra2;
	}

}
