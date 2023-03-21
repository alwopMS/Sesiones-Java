package empleadosMinisterio;

public interface PersonaInterface {
	public String getNombre();
	public String getApellido();
	public String getDNI();
	public String getLocalidad();
	public String getFechaNacimiento();
	public int getEdad();
	
	public int calcularEdad();
	
}
