package upm.aed.windowsexplorer;

public class LibReloj {

	public static boolean esAnterior (Reloj r1, Reloj r2){
		final boolean mismaFecha = r1.getF().equals(r2.getF());
		return 
			(LibFechas.esAnterior(r1.getF(),r2.getF()) ||
			(mismaFecha && LibHorarios.esAnterior(r1.getH(),r2.getH())));
	}
	
	public static boolean esRelojCorrecto (Reloj r)
	{
		Fecha f = r.getF();
		Horario h = r.getH();
		return LibFechas.fechaCorrecta(f) &&
				LibHorarios.horarioCorrecto(h);	}

	
	
	public static Reloj siguienteHorario (Reloj r)
	{
		Horario h = r.getH();
		Fecha f = r.getF();
		h = LibHorarios.siguienteHorario(h);
		if (h.getHh()==0 && h.getMm()==0&&h.getSs()==0)
			f = LibFechas.siguienteFecha(f);
		return new Reloj (h,f);
	}
}
