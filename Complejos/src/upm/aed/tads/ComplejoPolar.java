package upm.aed.tads;

public class ComplejoPolar implements Complejo {
	private double modulo; 
	private double argumento;


	public ComplejoPolar(double mod, double ang) {
		this.modulo = mod;
		this.argumento = ang;
	}

	public ComplejoPolar(Complejo c) { // Constructor de copia
		modulo = c.getModulo();
		argumento = c.getArgumento();
	}

	public double getReal() { 
		return this.modulo*Math.cos(this.argumento);
	} 
	public double getImaginaria() { 
		return this.modulo*Math.sin(this.argumento);
	} 
	public double getModulo() { 
		return modulo;
	} 
	public double getArgumento() { 
		return argumento;
	} 

	@Override
	public Complejo suma(Complejo c) {
		double x=this.getReal() + c.getReal(); 
		double y=this.getImaginaria() + c.getImaginaria();
		ComplejoCartesiano a= new ComplejoCartesiano(x,y);
		return new ComplejoPolar(a.getModulo(),a.getArgumento());
	}

	@Override
	public Complejo resta(Complejo c) {
		double x=this.getReal() - c.getReal(); 
		double y=this.getImaginaria() - c.getImaginaria();
		ComplejoCartesiano a= new ComplejoCartesiano(x,y);
		return new ComplejoPolar(a.getModulo(),a.getArgumento());
	}

	@Override
	public Complejo conj(Complejo c) {
		double i=c.getReal()-c.getImaginaria(); 
		ComplejoCartesiano a= new ComplejoCartesiano(i);
		return new ComplejoPolar(a.getModulo(),a.getArgumento());
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (o instanceof Complejo) {
			Complejo c = (Complejo) o;       // ¡downcasting al interfaz!
			return this.modulo == c.getModulo() && this.argumento== c.getArgumento();
		} 
		else { 
			return false;
		}
	}

}

