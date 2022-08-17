package upm.aed.windowsexplorer;

public class LibHorarios {

	static final int segundosHora = 3600;
	static final int segundosMinuto = 60;

	public static int aSegundos (Horario h)
	{
		return h.getHh() * segundosHora + h.getMm() * segundosMinuto + h.getSs();
	}


	public static boolean esAnterior (Horario h1, Horario h2)
	{
		boolean mismaHora = h1.getHh() == h2.getHh();
		boolean mismoMinuto = h1.getMm() == h2.getMm();
		if ((h1.getHh() < h2.getHh()) ||
				(mismaHora && (h1.getMm() < h2.getMm())) ||
				(mismaHora && mismoMinuto && (h1.getSs() < h2.getSs())))
			return true;
		else
			return false;
	}

	public static boolean horarioCorrecto (Horario h)
	{
		int hh = h.getHh();
		int mm = h.getMm();
		int ss = h.getSs();
		return (0<=hh && hh < 24) &&
				(0<=mm && mm < 60) &&
				(0<=ss && ss < 60);
	}

	
	public static Horario siguienteHorario (Horario h)
	  {
		int hh = h.getHh();
		int mm = h.getMm();
		int ss = h.getSs();
	    if (ss < 59)
	      return new Horario (hh,mm, ss+1);
	    else if (mm < 59)
	      return new Horario (hh,mm+1,0);
	    else if (hh < 23)
	      return new Horario (hh+1,0,0);
	    else
	    	  return new Horario (0,0,0);	
	  }
	
	
	public static boolean en60Minutos (Horario h1, Horario h2)
	{
		
		if (!LibHorarios.esAnterior(h1, h2))
			return false;
		else
			return (aSegundos(h2)-aSegundos(h1) <= 3600);
	}
	
	public static int segEntreHorarios (Horario h1, Horario h2)
	{
		return Math.abs(aSegundos(h2)-aSegundos(h1));
	}

}
