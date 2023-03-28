package examModel1;

import java.time.LocalDate;

public interface CalculosProductos {
	public double calcularPrecioFinalTotal(int precioUnidad, int cantidad);
	public double calcularPrecioFinalUnidad(int preciUnidad);
	public int calcularNumDiasUltimaVenta(LocalDate ultimaFecha);
	public int promedioVenta(int cantidadTotal);
}
