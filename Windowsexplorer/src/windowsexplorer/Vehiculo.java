package upm.aed.windowsexplorer;

public class Vehiculo implements Comparable<Vehiculo>,Cloneable {
	//Atributos
	private String nombre;
	private int tipo;
	private Fecha itv;
	private int ruedas;
	
	
	//Programacion defensiva. Se inicializa en 0 para cuando se use el copareTo
	// no de error.
	public Vehiculo() {
		super();
		nombre= "";
		tipo=0;
		itv= new Fecha (0,0,0);
		// TODO Auto-generated constructor stub
	}
	public Vehiculo(String nombre, int tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Vehiculo(String nombre, int tipo, Fecha itv) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.itv = itv;
	}
	
	public Vehiculo(String nombre, int tipo, Fecha itv, int ruedas) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.itv = itv;
		this.ruedas = ruedas;
	}
	

	@Override
	public String toString() {
		return "Vehiculo [nombre=" + nombre + ", tipo=" + tipo + ", itv=" + itv + ", ruedas=" + ruedas + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itv == null) ? 0 : itv.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ruedas;
		result = prime * result + tipo;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (itv == null) {
			if (other.itv != null)
				return false;
		} else if (!itv.equals(other.itv))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ruedas != other.ruedas)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getRuedas() {
		return ruedas;
	}
	public void setRuedas(int tipo) {
		this.ruedas = tipo;
	}
	
	public Fecha getItv() {
		return itv;
	}
	public void setItv(Fecha itv) {
		this.itv = itv;
	}
	//Pertenece a la clase que implemento no a programa,no a Lib,
	// hay que implementarlo es decir hacelo tuuuuuuuuuuuuuu!

	public Object clone() {
		return new Vehiculo (nombre,tipo,(Fecha)itv.clone(),ruedas);
	}
	public int compareTo(Vehiculo v) {
		if(this.nombre.compareTo(v.nombre)<0)
			return -1;
		else if (this.nombre.compareTo(v.nombre) == 0 && this.tipo < v.tipo )
			return -1;
		
		else if (this.nombre.compareTo(v.nombre) == 0 &&  this.tipo == v.tipo && (this.itv.compareTo(v.itv)<0))
			return -1;
		else if (this.equals(itv))
			return 0;
		else 	
			return 1;
		// TODO Auto-generated method stub
	}


}
