package upm.aed.windowsexplorer;
import java.util.ArrayList;
import java.util.List;

public class PruebaWindowsExplorer {
	public static void main(String[] args) {
		
		final int porNombre = 1;
		final int porFecha = 2;
		final int porTipo = 3;
		final int porTamano = 4;
		
		List<FileDescriptor> files = new ArrayList<FileDescriptor>();
		 FileDescriptor f;
		for (int i=0; i< 10; i ++)
		{
			if (i%2 == 0)
  		        f = new FileDescriptor ("Operadores" + i +"txt", new Fecha (i,2,2020-i), "Archivo PDF" + 2*i, true, 10000-i);
			else
				f = new FileDescriptor ("Operadores" + 2*i +"txt", new Fecha (i,2,2020+3*i), "Archivo PDF" + i, true, 10000+10*i);
			
	        files.add(f);  		        
		}
		WindowsExplorer iexplorer = new WindowsExplorer (files, new ComparadorPorNombre());
		iexplorer.draw();
		iexplorer.cambiaCriterio(porFecha);
		iexplorer.contrario();
		iexplorer.cambiaCriterio(porTamano);
		iexplorer.contrario();
		iexplorer.cambiaCriterio(porTipo);
		iexplorer.contrario();
		
		
	}
}
