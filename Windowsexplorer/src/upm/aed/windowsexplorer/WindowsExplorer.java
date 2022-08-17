package upm.aed.windowsexplorer;
import java.util.Collections;
// import java.util.Comparator;
import java.util.List;

public class WindowsExplorer {

	private List<FileDescriptor> files;
	private ComparadorInverso<FileDescriptor> comp;
	public WindowsExplorer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WindowsExplorer(List<FileDescriptor> files, ComparadorInverso<FileDescriptor> comp) {
		super();
		this.files = files;
		this.comp = comp;
	}
	@Override
	public String toString() {
		return "WindowsExplorer [files=" + files + ", comp=" + comp + "]";
	}
	
	public void draw()
	{
		System.out.println ("Nombre \t\t Fecha \t\t Tipo \t\t Tamaño\n\n");
		for (int i=0; i<files.size(); i++)
			System.out.println (files.get(i).getName() + "\t\t" + files.get(i).getFecha() +  "\t\t" + files.get(i).getTipo() 
					+ "\t\t" + files.get(i).getTamano());	
	}
	
	public void cambiaCriterio (int i)
	{
		switch (i)
		{
		case 1 : comp = new ComparadorPorNombre();
				 break;
		case 2 : comp = new ComparadorPorFecha();
		         break;
		case 3 : comp = new ComparadorPorTipo();
		         break;
		default : comp = new ComparadorPorTamano();
		}
		
		Collections.sort(this.files,this.comp); 
		draw();
	}
	
	public void contrario ()
	{
		comp.inverso();
		Collections.sort(this.files,this.comp); 
		draw();
	}
	
}
