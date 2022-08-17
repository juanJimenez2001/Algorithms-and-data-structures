package upm.aed.windowsexplorer;

public class Horario implements Comparable {

	private int hh;
	private int mm;
	private int ss;
	
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(int hh, int mm, int ss) {
		super();
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
	}

	public int getHh() {
		return hh;
	}

	public void setHh(int hh) {
		this.hh = hh;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}


	public String toString() {
		return "Horario [hh=" + hh + ", mm=" + mm + ", ss=" + ss + "]";
	}
	
	
	public Object clone()  {
	    return new Horario (hh, mm, ss);
	    }

	public int compareTo(Horario o) {
		int mismasHoras=this.getHh()-o.getHh();
		int mismosMinutos=this.getMm()-o.getMm();
		if(mismasHoras==0) {
			if(mismosMinutos==0)
				return this.getSs()-o.getSs();
			else
				return mismosMinutos;
		}
		else
			return mismasHoras;
	}
	
}
