package upm.aed.windowsexplorer;

public class CompruebaNombreTipo implements Predicado<Vehiculo> {
	private String nombre;
	private int tipo;
	
	public CompruebaNombreTipo(String nombre, int tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public boolean test(Vehiculo val) {
		// TODO Auto-generated method stub
		return val.getTipo()==this.tipo && 
		       val.getNombre().equals(this.nombre);
	}

}
