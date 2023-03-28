package productos;

import java.time.LocalDate;


import examModel1.Producto;

public class Camisa extends Producto{

	private String nombre;
	private String marca;
	public Camisa(int precioUnitario, int cantidadVendida, LocalDate fechaUltimaVenta, int cantidadTotal, String nombre, String algoMas) {
		super(precioUnitario, cantidadVendida, fechaUltimaVenta, cantidadTotal);
		this.nombre =nombre;
		this.marca =algoMas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Camisa [nombre=" + nombre + ", marca=" + marca + ", " + super.toString() + "]";
	}
	
}
