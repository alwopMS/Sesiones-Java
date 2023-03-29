package examVuelos;

import java.time.LocalDate;

public interface CalculosVuelosInterface {
	public int calcularValorFinalVuelo(int valorUnitario, int cantidadPasajeros);
	public int calcularDiasDiferencia(LocalDate fechaVuelo);
	public String calcularSegmento(String tipoPasaje, int valorFinalVuelo);
}
