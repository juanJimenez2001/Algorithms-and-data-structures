package upm.aed.windowsexplorer;

public class FileDescriptor {
	
	private String name = "";
	private Fecha fecha = new Fecha();
	private String tipo;
	private boolean oculto;
	private int tamano;
	public FileDescriptor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDescriptor(String name, Fecha f, String tipo, boolean oculto, int tamano) {
		super();
		this.name = name;
		this.fecha = f;
		this.tipo = tipo;
		this.oculto = oculto;
		this.tamano = tamano;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (oculto ? 1231 : 1237);
		result = prime * result + tamano;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		FileDescriptor other = (FileDescriptor) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oculto != other.oculto)
			return false;
		if (tamano != other.tamano)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FileDescriptor [name=" + name + ", f=" + fecha + ", tipo=" + tipo + ", oculto=" + oculto + ", tamano="
				+ tamano + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha f) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isOculto() {
		return oculto;
	}
	public void setOculto(boolean oculto) {
		this.oculto = oculto;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	
	
}
