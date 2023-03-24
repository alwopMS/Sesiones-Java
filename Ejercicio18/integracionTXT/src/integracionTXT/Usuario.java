package integracionTXT;

import java.time.LocalDate;
import java.time.Period;

public class Usuario extends Persona implements CalculoAntiguedadUsusario,CalculoSegmento,CalculoStatus {
	
	
	private LocalDate fechaRegistro;
	private LocalDate fechaUltimoLogin;
	private int cantidadCompras;
	private String segmento;
	private String status;
	private int antiguedad;
	
	public Usuario(String nombre, LocalDate fechaNacimiento, String pais, LocalDate fechaRegistro, LocalDate fechaUltimoLogin, int cantidadCompras) {
		super(nombre, fechaNacimiento, pais);
		this.setFechaRegistro(fechaRegistro);
		this.setFechaUltimoLogin(fechaUltimoLogin);
		this.setCantidadCompras(cantidadCompras);
		this.setSegmento(calcularSegmento(cantidadCompras));
		this.setStatus(calcularStatus(fechaUltimoLogin));
		this.setAntiguedad(calcularAntiguedad(fechaRegistro));
	}
	
	@Override
	public String calcularStatus(LocalDate fechaUltimoRegistro) {
		LocalDate fecha = LocalDate.now();
	    int status = Period.between(fechaUltimoRegistro, fecha).getYears();
		if (status<2) {
			return "Activo";
		}else {
			return "Inactivo";
		}
	}
	@Override
	public String calcularSegmento(int numCompras) {
		if (numCompras>=1 && numCompras<=5) {
			return "Estandar User";
		}else if(numCompras>=6 && numCompras<=10) {
			return "Affiliate";
		}else if(numCompras>11) {
			return "Premier";
		}
		return "No tienes compras";
		
	}
	@Override
	public int calcularAntiguedad(LocalDate fechaRegistro) {
		LocalDate fecha = LocalDate.now();
	    int antiguedad = Period.between(fechaRegistro, fecha).getYears();
	    
	    return antiguedad;
		
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDate getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}

	public void setFechaUltimoLogin(LocalDate fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

	public int getCantidadCompras() {
		return cantidadCompras;
	}

	public void setCantidadCompras(int cantidadCompras) {
		this.cantidadCompras = cantidadCompras;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
}
