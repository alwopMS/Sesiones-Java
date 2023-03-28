package examModel1;

import java.time.LocalDate;
import java.time.Period;

public class Producto implements CalculosProductos{
	private int precioUnitario;
	private int cantidadVendida;
	private LocalDate fechaUltimaVenta;
	private int numDiasUltimaVenta;
	private double precioUnitarioIva;
	private double precioTotalIva;
	private int promedio;

	
	
	
	public Producto(int precioUnitario, int cantidadVendida, LocalDate fechaUltimaVenta, int cantidadTotal) {
		this.precioUnitario = precioUnitario;
		this.cantidadVendida = cantidadVendida;
		this.fechaUltimaVenta = fechaUltimaVenta;
		this.setNumDiasUltimaVenta(calcularNumDiasUltimaVenta(fechaUltimaVenta));
		this.setPrecioUnitarioIva(calcularPrecioFinalUnidad(precioUnitario));
		this.setPrecioTotalIva(calcularPrecioFinalTotal(precioUnitario, cantidadVendida));
		this.setPromedio(promedioVenta(cantidadTotal));
		
	}




	public int getPrecioUnitario() {
		return precioUnitario;
	}




	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}




	public int getCantidadVendida() {
		return cantidadVendida;
	}




	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}




	public LocalDate getFechaUltimaVenta() {
		return fechaUltimaVenta;
	}




	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		this.fechaUltimaVenta = fechaUltimaVenta;
	}




	




	public int getNumDiasUltimaVenta() {
		return numDiasUltimaVenta;
	}




	public void setNumDiasUltimaVenta(int numDiasUltimaVenta) {
		this.numDiasUltimaVenta = numDiasUltimaVenta;
	}




	public double getPrecioTotalIva() {
		return precioTotalIva;
	}




	public void setPrecioTotalIva(double precioTotalIva) {
		this.precioTotalIva = precioTotalIva;
	}




	public double getPrecioUnitarioIva() {
		return precioUnitarioIva;
	}




	public void setPrecioUnitarioIva(double precioUnitarioIva) {
		this.precioUnitarioIva = precioUnitarioIva;
	}




	public int getPromedio() {
		return promedio;
	}




	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	@Override
	public double calcularPrecioFinalTotal(int precioUnidad, int cantidad) {
		double precio;
		int iva=21;
		precio=(precioUnidad+(precioUnidad*iva/100))*cantidad;
		return precio;
	}




	@Override
	public double calcularPrecioFinalUnidad(int preciUnidad) {
		double precio;
		int iva=21;
		precio=preciUnidad+(preciUnidad*iva/100);
		return precio;
	}




	@Override
	public int calcularNumDiasUltimaVenta(LocalDate ultimaFecha) {
		LocalDate fecha = LocalDate.now();
	    int antiguedad = Period.between(ultimaFecha, fecha).getDays();
		return antiguedad;
	}




	@Override
	public int promedioVenta(int cantidadTotal) {
		int promedio;
		promedio=cantidadTotal/this.cantidadVendida;
		return promedio;
	}




	@Override
	public String toString() {
		return "precioUnitario=" + precioUnitario + ", cantidadVendida=" + cantidadVendida
				+ ", fechaUltimaVenta=" + fechaUltimaVenta + ", numDiasUltimaVenta=" + numDiasUltimaVenta
				+ ", precioUnitarioIva=" + precioUnitarioIva + ", precioTotalIva=" + precioTotalIva + ", promedio="
				+ promedio + "]";
	}


}
