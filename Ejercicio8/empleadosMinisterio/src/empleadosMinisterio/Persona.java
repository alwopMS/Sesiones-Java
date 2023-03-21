package empleadosMinisterio;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements PersonaInterface{
	private LocalDate fechaNacimiento;
	private String nombre, apellido, localidad, dni;
	int edad;
	public Persona(String nombre, String apellido, String localidad, String dni, LocalDate fechaNacimiento) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.localidad=localidad;
		this.dni=dni;
		this.fechaNacimiento=fechaNacimiento;
		this.edad=calcularEdad();
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String getApellido() {
		// TODO Auto-generated method stub
		return apellido;
	}

	@Override
	public String getDNI() {
		// TODO Auto-generated method stub
		return dni;
	}

	@Override
	public String getLocalidad() {
		// TODO Auto-generated method stub
		return localidad;
	}

	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return fechaNacimiento.toString();
	}

	@Override
	public int calcularEdad() {
		// TODO Auto-generated method stub
	    LocalDate fecha = LocalDate.now();
	    int edad = Period.between(fechaNacimiento, fecha).getYears();
	    
	    return edad;
	}
	@Override
	public int getEdad() {
		// TODO Auto-generated method stub
		return edad;
	}

}
