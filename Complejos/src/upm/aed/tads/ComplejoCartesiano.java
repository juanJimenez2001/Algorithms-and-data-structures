package upm.aed.tads;

public class ComplejoCartesiano implements Complejo {
	private double real; 
	private double imaginaria;

	public ComplejoCartesiano(double re, double im) {
		this.real = re;
		this.imaginaria = im;
	}

	public ComplejoCartesiano(double re) {  // Real a complejo
		this.real = re;
		this.imaginaria = 0.0;
	}

	public ComplejoCartesiano(Complejo c) { // Constructor de copia
		real = c.getReal();
		imaginaria = c.getImaginaria();
	}

	public double getReal() { 
		return real; 
	}
	public double getImaginaria() { 
		return imaginaria;
	}
	public double getModulo() {
		return Math.pow(Math.pow(this.real, 2)+Math.pow(this.imaginaria, 2),1/2);
	} 
	public double getArgumento() { 
		return Math.atan(this.imaginaria/this.real);
	} 

	public Complejo suma(Complejo c) {  // ¡ "Complejo" es un interfaz !
		return new ComplejoCartesiano(this.real + c.getReal(), this.imaginaria + c.getImaginaria()) ;
	}

	@Override
	public Complejo resta(Complejo c) {
		return new ComplejoCartesiano(this.real - c.getReal(), this.imaginaria - c.getImaginaria());
	}

	@Override
	public Complejo conj(Complejo c) {
		return new ComplejoCartesiano(c.getReal()-c.getImaginaria());
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (o instanceof Complejo) {
			Complejo c = (Complejo) o;       // ¡downcasting al interfaz!
			return this.real == c.getReal() && this.imaginaria == c.getImaginaria();
		} 
		else {
			return false;
		}
	}

}

