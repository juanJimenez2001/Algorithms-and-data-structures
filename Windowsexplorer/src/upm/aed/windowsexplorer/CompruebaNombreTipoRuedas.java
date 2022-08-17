package upm.aed.windowsexplorer;

public class CompruebaNombreTipoRuedas implements Predicado<Vehiculo> {
	private String nombre;
	private int tipo;
	private int ruedas;
	
	public CompruebaNombreTipoRuedas (String nombre, int tipo, int ruedas) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.ruedas = ruedas;
	}

	public boolean test(Vehiculo val) {
		// TODO Auto-generated method stub
		return val.getTipo()==this.tipo && 
		       val.getNombre().equals(this.nombre) &&
		       val.getRuedas() > this.ruedas;
	}

}
