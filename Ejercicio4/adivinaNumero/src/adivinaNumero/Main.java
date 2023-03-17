package adivinaNumero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Adivine el número entre 1 y 100");
		Scanner sc = new Scanner(System.in);
		int numAdivinar,numUsuario;
		numAdivinar = (int)(Math.random()*100+1);
		for (int j = 0; j < 3; j++) {
			System.out.println("Introduzca su número:");
			numUsuario = sc.nextInt();
			
			if (numUsuario!=numAdivinar) {
				if(j<2) {
					System.out.println("No ha adivinado el numero, intentelo de nuevo");
				}else {
					System.out.println("Ha fallado en todos sus intentos, mala suerte.");
				}
				
			}else {
				System.out.println("Ha adivinado el numero, ¡Enhorabuena!");
				break;
			}
		}
			
		sc.close();
	}

}
