package upm.aed.windowsexplorer;
import javazoom.jl.*;
import javazoom.jl.player.Player;
import javazoom.jl.player.jlp;

import java.io.FileInputStream;
public class Reloj {

	// ATRIBUTOS O CAMPOS (FIELDS)
	// Define el estado de los objetos de esta clase
	// Es el molde con que voy a definir objetos de la clase Reloj
	private Horario h;
	private Fecha f;
	private Musica m;

	private Reloj alarma;
	private boolean hayAlarma = false;

	// CONSTRUCTORES !!!! 
	// SIRVEN PARA DESDE EL PROGRAMA PRINCIPAL O LA LIBRERIAS CONSTRUIR
	// OBJETOS DE ESTA CLASE
	// LOS CONSTRUCTORES SON LOS METODOS QUE TIENEN EL NOMBRE DE LA CLASE


	// CONSTRUCTOR POR DEFECTO (SIN PARAMETROS)
	public Reloj() {
		super();
		// TODO Auto-generated constructor stub
	}
	// CONSTRUCTORES POR CAMPOS/ATRIBUTOS
	// PUEDE HABER VARIOS
	public Reloj(Horario h, Fecha f, Musica m) {
		super();
		this.h = h;
		this.f = f;
		this.m = m;
	}
	public Reloj(Horario h, Fecha f) {
		super();
		this.h = h;
		this.f = f;
	}

	public Reloj(Fecha f, Horario h) {
		super();
		this.h = h;
		this.f = f;
	}


	public Horario getH() {
		return h;
	}


	public void setH(Horario h) {
		this.h = h;
	}


	public Fecha getF() {
		return f;
	}


	public void setF(Fecha f) {
		this.f = f;
	}


	public Musica getM() {
		return m;
	}
	public void setM(Musica m) {
		this.m = m;
	}
	public Reloj getAlarma() {
		return alarma;
	}
	public void setAlarma(Reloj alarma) {
		this.alarma = alarma;
		this.hayAlarma = true;
	}

	public void quitarAlarma()
	{
		this.hayAlarma = false;
	}





	public String toString() {
		return "Reloj [h=" + h + ", f=" + f + ", m=" + m + "]";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reloj other = (Reloj) obj;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (h == null) {
			if (other.h != null)
				return false;
		} else if (!h.equals(other.h))
			return false;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		return true;
	}


	public Object clone()  {
		// HAY QUE CLONAR LOS CAMPOS Y LUEGO CREAR EL NUEVO OBJETO
		Horario newH = (Horario) h.clone(); // HAY QUE HACER "CASTING"
		Fecha newF = (Fecha) f.clone();
		Musica newM = (Musica) m.clone();
		return new Reloj (newH,newF,newM);
	}


	public void play() {
		int retval = 0;
		try
		{
			String[] args = {m.getCancion()};
			jlp player = jlp.createInstance(args);
			if (player!=null)
				player.play();
		}
		catch (Exception ex)
		{
			System.err.println(ex);
			ex.printStackTrace(System.err);
			retval = 1;
		}
		System.exit(retval);
	}

	
	
	
	public void init()
	{
		int duracion = 10;
		while (true)
		{
			System.out.println (this);
			avanza1sg();
			
			if (hayAlarma && LibReloj.esAnterior(alarma,this))
			{
				play();
				duracion = 20;
				while (duracion > 0) 
					duracion--;
				hayAlarma = false;
			}

		}
	}

	public void avanza1sg ()
	{
		try  // deja que pase 1 segundo = 1000 milisegundos
		{
			Thread.sleep(1000);
		}catch (InterruptedException e){}

		Reloj r = LibReloj.siguienteHorario(this);
		setF(r.f);
		setH(r.h);
	}

}
