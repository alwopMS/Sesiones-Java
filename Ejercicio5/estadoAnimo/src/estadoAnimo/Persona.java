package estadoAnimo;

public class Persona implements PersonaInterface{
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public void enojado() {
		System.out.println("Haz yoga");
		
	}

	public void triste() {
		System.out.println("Vate a terapia o tomate unas birras");
		
	}

	public void feliz() {
		System.out.println("Sigues asi campeon");		
	}

	public void preocupado() {
		System.out.println("Olvidate de tus problemas");
		
	}

	public void aburrido() {
		int num = (int)(Math.random()*3+1);
		switch (num) {
		case 1:
			System.out.println("¿Cuál es el último animal que subió al arca de Noé? El del-fin.");
			break;
		case 2:
			System.out.println("¿Qué le dice un gusano a otro gusano? Voy a dar una vuelta a la manzana.");
			break;
		case 3:
			System.out.println("El doctor le dice al paciente: respire profundo que lo voy a auscultar. El paciente le responde: doctor, ¿de quién me va a ocultar si no le debo a nadie?");
			break;
		}
		
	}

	public void somnoliento() {
		System.out.println("Te recomiendo que te tomes un cafetito");
		
	}
}
