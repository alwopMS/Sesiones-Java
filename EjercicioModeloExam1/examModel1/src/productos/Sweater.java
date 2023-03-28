package productos;

import java.time.LocalDate;

import examModel1.Producto;

public class Sweater extends Producto{

	private String nombre;
	private String lana;
	
	public Sweater(int precioUnitario, int cantidadVendida, LocalDate fechaUltimaVenta, int cantidadTotal, String nombre, String algoMas) {
		super(precioUnitario, cantidadVendida, fechaUltimaVenta, cantidadTotal);
		this.nombre =nombre;
		this.lana= algoMas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLana() {
		return lana;
	}

	public void setLana(String lana) {
		this.lana = lana;
	}

	@Override
	public String toString() {
		return "Sweater [nombre=" + nombre + ", lana=" + lana + ", " + super.toString() + "]";
	}
	
}
