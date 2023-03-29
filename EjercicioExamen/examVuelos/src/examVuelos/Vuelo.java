package examVuelos;

import java.time.LocalDate;
import java.time.Period;

public class Vuelo extends Aerolinea implements CalculosVuelosInterface{
	
	private String nombreVuelo;
	private int cantidaPasajeros;
	private String tipoPasaje;
	private int valorUnitarioPasaje;
	private LocalDate fechaVuelo;
	private int valorFinalVuelo;
	private int diasDiferencia;
	private String segmento;
	
	public Vuelo(String nombre, String nombreVuelo, int cantidaPasajeros, String tipoPasaje, int valorUnitarioPasaje,
			LocalDate fechaVuelo) {
		super(nombre);
		this.nombreVuelo = nombreVuelo;
		this.cantidaPasajeros = cantidaPasajeros;
		this.tipoPasaje = tipoPasaje;
		this.valorUnitarioPasaje = valorUnitarioPasaje;
		this.fechaVuelo = fechaVuelo;
		this.valorFinalVuelo = calcularValorFinalVuelo(valorUnitarioPasaje, cantidaPasajeros);
		this.diasDiferencia = calcularDiasDiferencia(fechaVuelo);
		this.segmento = calcularSegmento(tipoPasaje, this.valorFinalVuelo);
	}
	
	
	
	public String getNombreVuelo() {
		return nombreVuelo;
	}



	public void setNombreVuelo(String nombreVuelo) {
		this.nombreVuelo = nombreVuelo;
	}



	public int getCantidaPasajeros() {
		return cantidaPasajeros;
	}



	public void setCantidaPasajeros(int cantidaPasajeros) {
		this.cantidaPasajeros = cantidaPasajeros;
	}



	public String getTipoPasaje() {
		return tipoPasaje;
	}



	public void setTipoPasaje(String tipoPasaje) {
		this.tipoPasaje = tipoPasaje;
	}



	public int getValorUnitarioPasaje() {
		return valorUnitarioPasaje;
	}



	public void setValorUnitarioPasaje(int valorUnitarioPasaje) {
		this.valorUnitarioPasaje = valorUnitarioPasaje;
	}



	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}



	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}



	public int getValorFinalVuelo() {
		return valorFinalVuelo;
	}



	public void setValorFinalVuelo(int valorFinalVuelo) {
		this.valorFinalVuelo = valorFinalVuelo;
	}



	public int getDiasDiferencia() {
		return diasDiferencia;
	}



	public void setDiasDiferencia(int diasDiferencia) {
		this.diasDiferencia = diasDiferencia;
	}



	public String getSegmento() {
		return segmento;
	}



	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}



	@Override
	public int calcularValorFinalVuelo(int valorUnitario, int cantidadPasajeros) {
		int valorFinal = valorUnitario*cantidadPasajeros;
		return valorFinal;
	}

	@Override
	public int calcularDiasDiferencia(LocalDate fechaVuelo) {
		LocalDate fecha = LocalDate.now();
	    int diasDiferencia = Period.between(fechaVuelo, fecha).getDays();
	    if(Period.between(fechaVuelo, fecha).getYears()!=0) {
	    	diasDiferencia+=(Period.between(fechaVuelo, fecha).getYears()*365);
	    }
	    if(Period.between(fechaVuelo, fecha).getMonths()!=0) {
	    	diasDiferencia+=(Period.between(fechaVuelo, fecha).getMonths()*30);
	    }
		return diasDiferencia;
	}

	@Override
	public String calcularSegmento(String tipoPasaje, int valorFinalVuelo) {
		if (tipoPasaje.equals("ECONOMICO") && valorFinalVuelo>=100) {
			return "RENTABLE";
		}else if (tipoPasaje.equals("ECONOMICO") && valorFinalVuelo<100) {
			return "NO RENTABLE";
		}else if (tipoPasaje.equals("PREMIER") && valorFinalVuelo>=1500) {
			return "RENTABLE";
		}else if(tipoPasaje.equals("PREMIER") && valorFinalVuelo<1500) {
			return "NO RENTABLE";
		}
		return "Error en alguna de las variables introducidas";
		
	}
	
	
	
	
}
