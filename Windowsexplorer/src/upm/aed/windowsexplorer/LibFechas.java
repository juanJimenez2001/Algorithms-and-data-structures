package upm.aed.windowsexplorer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

// Libería con clase Fecha

public class LibFechas {

	//  DECLARACIONES DE CONSTANTES  ------------------------------------ 

	static final int segundosHora = 3600;
	static final int segundosMinuto = 60;


	public static boolean anyoBisiesto (Fecha f)
	{
		return ((f.getAnio() % 4 == 0) && (f.getAnio() % 100 != 0)) || (f.getAnio() % 400 == 0);
	}

	public static int diasDelMes (Fecha f)
	{
		switch (f.getMes())
		{
		case 4: case 6 :
		case 9: case 11: return 30;
		case 2         : if (anyoBisiesto (f))
			return 29;
		else
			return 28;
		default        : return 31;
		}
	}
	
	public static Fecha siguienteFecha (Fecha fecha)
	  {
		int dia = fecha.getDia();
		int mes = fecha.getMes();
		int anio = fecha.getAnio();
	    if (dia < diasDelMes (fecha))
	      return new Fecha (dia+1, mes, anio);
	    else if (mes < 12)
	      return new Fecha (1,mes+1, anio);
	    else
	      return new Fecha (1,1,anio+1);
	  }
	public static Fecha fechaDentroDeNDias(Fecha fecha, int dias)
	{
		Fecha f = (Fecha)  fecha.clone();
		for ( int i=0; i< dias;i++)
			f = siguienteFecha(f);
		return f;
	}
	
	public static boolean anioCorrecto (Fecha f)
	{
		return f.getAnio() >= 1 && f.getAnio() < 3000;
	}

	public static boolean mesCorrecto (Fecha f)
	{
		return (f.getMes() >= 1) && (f.getMes() <= 12);
	}

	public static boolean diaCorrecto (Fecha f)
	{
		return (f.getDia() >= 1) && (f.getDia() <= diasDelMes (f));
	}

	public static boolean fechaCorrecta (Fecha f)
	{
		return anioCorrecto (f) && mesCorrecto (f) &&
				diaCorrecto (f);
	}

	public static boolean esAnterior (Fecha f1, Fecha f2)
	{
		final boolean mismoAnio = f1.getAnio() == f2.getAnio();
		final boolean mismoMes = f1.getMes() == f2.getMes();
		return (f1.getAnio()) < f2.getAnio() ||
				(mismoAnio && (f1.getMes() < f2.getMes())) ||
				(mismoAnio && mismoMes && (f1.getDia() < f2.getDia()));
	}
	

	public static boolean hayBisiesto (Fecha[] colF)
	{
		boolean hayBisiesto = false;
		int i = 0 ;
		while (i < colF.length && !hayBisiesto)
		{
			if (anyoBisiesto(colF[i]))
				hayBisiesto = true;
			else
				i++;
		}
		return hayBisiesto;
	}
	
	
	public static int sumaAnio (Fecha[] col)
	{
		int resultado = 0;
		
		for (int i = 0; i < col.length; i++)
		{
			resultado = resultado + col[i].getAnio();
		}
		return resultado;
	}
	
	public static int sumaSegundos (Horario[] col)
	{
		int resultado = 0;
		
		for (int i = 0; i < col.length; i++)
		{
			resultado += LibHorarios.aSegundos(col[i]);
		}
		return resultado;
	}
	
	public static int sumaSegundos (Reloj[] col)
	{
		int resultado = 0;
		
		for (int i = 0; i < col.length; i++)
		{
			resultado += LibHorarios.aSegundos(col[i].getH());
		}
		return resultado;
	}
	
	
	public static int cuantosDesfaseMenorQue (Reloj[] col, Reloj atomico, int desfase)
	{
		int cuantos = 0;
		int segsAtomico = LibHorarios.aSegundos (atomico.getH());
		
		for (int i = 0; i < col.length; i++)
		{
			int segsHorario = LibHorarios.aSegundos (col[i].getH());
			if (Math.abs(segsHorario-segsAtomico) < desfase)
  			    cuantos++;
		}
		return cuantos;
	}
	
	public static int cuantosMismoMes (Reloj[] col, int mes)
	{
		int cuantos = 0;
		
		for (int i = 0; i < col.length; i++)
		{
			if (col[i].getF().getMes() == mes)
  			    cuantos++;
		}
		return cuantos;
	}
	
	public static int cuantosSiglo21(Reloj[] col, int siglo)
	{
		int cuantos = 0;
		
		
		for (int i = 0; i < col.length; i++)
		{
			

			if (col[i].getF().getAnio() > (siglo-1)*100 && 
				col[i].getF().getAnio() <= siglo*100)
  			    cuantos++;
		}
		return cuantos;
	}
	
	
	
	public static boolean todosMayores (Fecha[] colF, Fecha f)
	{
		boolean todasMayores = true;
		int i = 0 ;
		while (i < colF.length && todasMayores)
		{
			if (esAnterior(colF[i],f))
				todasMayores = false;
			else
				i++;
		}
		return todasMayores;
	}
	
	public static boolean esMenor (Fecha f, Fecha g)
	{
		return esAnterior (f,g);
	}
	
	public static boolean algunaMayor (Fecha[] colF, Fecha f)
	{
		boolean hayMayor = false;
		int i = 0 ;
		while (i < colF.length && !hayMayor)
		{
			if (esMenor(f, colF[i]))  // es dir colF[i] es mayor !!!
				hayMayor = true;
			else
				i++;
		}
		return hayMayor;
	}
	
	public static Fecha unaMayor (Fecha[] colF, Fecha f)
	{
		boolean hayMayor = false;
		int i = 0 ;
		while (i < colF.length && !hayMayor)
		{
			if (esMenor(f, colF[i]))  // es dir colF[i] es mayor !!!
				hayMayor = true;
			else
				i++;
		}
		if (hayMayor)
			return (Fecha)colF[i].clone();
		else
			return null;
	}
	
	
	
	public static int cuantosBisiestos (Fecha[] col)
	{
		int cuantos = 0;
		
		for (int i = 0; i < col.length; i++)
		{
			if (anyoBisiesto(col[i]))
  			    cuantos++;
		}
		return cuantos;
	}
	
	
	public static boolean hayVariosBisiestos (Fecha[] col)
	{
		return cuantosBisiestos(col) > 1;
	}
	
	
	public static boolean esHK (Fecha f)
	{
		return true;
	}
	
	
	public static boolean hayHK (Fecha[] colF)
	{
		boolean hayHK = false;
		int i = 0 ;
		while (i < colF.length && !hayHK)
		{
			if (esHK(colF[i]))
				hayHK = true;
			else
				i++;
		}
		return hayHK;
	}
	
	
}