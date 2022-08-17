package upm.aed.windowsexplorer;

public class NombreTipo {

	private String nombre;
	private int tipo;
	public NombreTipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NombreTipo(String nombre, int tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
