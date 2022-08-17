package upm.aed.windowsexplorer;

public class Musica implements Cloneable{
	private String cancion;

	public Musica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musica(String cancion) {
		super();
		this.cancion = cancion;
	}

//	@Override
//	public String toString() {
//		return "Musica [cancion=" + cancion + "]";
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancion == null) ? 0 : cancion.hashCode());
		return result;
	}

	// COMPARA EL ESTA DE DOS OBJETOS
	// PORQUE o1 == o2 NO COMPARA EL ESTADO, COMPARA LA REFERENCIA
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (cancion == null) {
			if (other.cancion != null)
				return false;
		} else if (!cancion.equals(other.cancion))
			return false;
		return true;
	}

	public String getCancion() {
		return cancion;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	
	public Object clone()  {
		return new Musica(cancion);
	}
	
	
	
}
