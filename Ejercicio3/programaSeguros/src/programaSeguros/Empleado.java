package programaSeguros;

public class Empleado extends Persona implements EmpleadoInterface{
	
	private String posicion;
	private int sueldo;
	
	public Empleado(String nombre, String apellido, String localidad,String posicion, int sueldo) {
		super(nombre, apellido, localidad);
		this.posicion = posicion;
		this.sueldo = sueldo;
	}
	public String getPosicion() {
		return posicion;
	}
	public int getSueldo() {
		return sueldo;
	}
	
}
