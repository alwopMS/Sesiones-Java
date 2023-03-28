package productos;

import java.time.LocalDate;

import examModel1.Producto;

public class Ramera extends Producto {
	
	private String nombre;
	private String temporada;
	
	public Ramera(int precioUnitario, int cantidadVendida, LocalDate fechaUltimaVenta, int cantidadTotal, String nombre, String algoMas) {
		super(precioUnitario, cantidadVendida, fechaUltimaVenta, cantidadTotal);
		this.nombre =nombre;
		this.temporada =algoMas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "Ramera [nombre=" + nombre + ", temporada=" + temporada + ", " + super.toString() + "]";
	}
	
}
