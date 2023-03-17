package programaSeguros;

public class Persona implements PersonaInterface{
	private String nombre;
	private String apellido;
	private String localidad;
	
	public Persona(String nombre, String apellido, String localidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.localidad = localidad;
	}	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getLocalidad() {
		return localidad;
	}
}
