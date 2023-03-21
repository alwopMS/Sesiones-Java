package empleadosMinisterio;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona implements EmpleadoInterface{
	
	private LocalDate fechaIngreso;
	private String  posicion;
	private int salario,antiguedad;
	public Empleado(String nombre, String apellido, String localidad, String dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String posicion, int salario) {
		super(nombre, apellido, localidad, dni, fechaNacimiento);
		this.fechaIngreso=fechaIngreso;
		this.posicion=posicion;
		this.salario=salario;
		this.antiguedad=calcularAntiguedad();
	}
	@Override
	public String getFechaIngreso() {
		// TODO Auto-generated method stub
		return fechaIngreso.toString();
	}

	@Override
	public int getSalario() {
		// TODO Auto-generated method stub
		return salario;
	}

	@Override
	public String getPosicion() {
		// TODO Auto-generated method stub
		return posicion;
	}

	@Override
	public int getAntiguedad() {
		// TODO Auto-generated method stub
		return antiguedad;
	}

	@Override
	public int calcularAntiguedad() {
		LocalDate fecha = LocalDate.now();
	    int antiguedad = Period.between(fechaIngreso, fecha).getYears();
	    
	    return antiguedad;
		
	}
	
}
