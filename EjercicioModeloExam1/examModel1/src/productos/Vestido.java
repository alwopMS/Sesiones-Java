package productos;

import java.time.LocalDate;

import examModel1.Producto;

public class Vestido extends Producto{
	
	private String nombre;
	private String tipo;
	
	public Vestido(int precioUnitario, int cantidadVendida, LocalDate fechaUltimaVenta, int cantidadTotal, String nombre, String algoMas) {
		super(precioUnitario, cantidadVendida, fechaUltimaVenta, cantidadTotal);
		this.nombre =nombre;
		this.tipo =algoMas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Vestido [nombre=" + nombre + ", tipo=" + tipo + ", " + super.toString() + "]";
	}
	
}
