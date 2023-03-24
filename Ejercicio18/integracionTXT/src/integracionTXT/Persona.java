package integracionTXT;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements CalculoEdad{
	private String nombre;
	private LocalDate fechaNacimiento;
	private String pais;
	private int edad;
	public Persona(String nombre, LocalDate fechaNacimiento, String pais) {
		this.setNombre(nombre);
		this.setFechaNacimiento(fechaNacimiento);
		this.setPais(pais);
		this.setEdad(calcularEdad(fechaNacimiento));
	}
	@Override
	public int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fecha = LocalDate.now();
	    int edad = Period.between(fechaNacimiento, fecha).getYears();
	    
	    return edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
