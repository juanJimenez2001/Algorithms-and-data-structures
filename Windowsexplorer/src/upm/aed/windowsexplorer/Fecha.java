package upm.aed.windowsexplorer;


public class Fecha implements Cloneable, Comparable<Fecha>
{
	// DECISION IMPORTANTE: �COMO REPRESENTO UNA FECHA?
	//  PARA MI UNA FECHA SON 3 NUMEROS ENTEROS QUE REPRESTENTAN DIA, MES Y A�O
	// ATRIBUTOS DE INSTANCIA LA CLASE PRIVADOS
	private int dia;   	// 0
	private int mes;		// 0
	private int anio;	// 0



	public Fecha() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	public Fecha(int dia, int mes) {
		super();
		this.dia = dia;
		this.mes = mes;
	}





	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}





	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		if (anio != other.anio)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}





	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
	}





	public int getDia() {
		return dia;
	}





	public void setDia(int dia) {
		this.dia = dia;
	}





	public int getMes() {
		return mes;
	}





	public void setMes(int mes) {
		this.mes = mes;
	}





	public int getAnio() {
		return anio;
	}





	public void setAnio(int anio) {
		this.anio = anio;
	}





	public Object clone()  {
		return new Fecha (dia, mes, anio);
	}


	@Override
	public int compareTo(Fecha o) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (LibFechas.esAnterior(this, o))
			return -1;
		else if (this.equals(o))
			return 0;
		else
			return 1;
	}


}