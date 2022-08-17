package upm.aed.windowsexplorer;
// import java.util.Comparator;

public class ComparadorPorTipo extends ComparadorInverso<FileDescriptor> {

	@Override
	public int compare(FileDescriptor o1, FileDescriptor o2) {
		// TODO Auto-generated method stub
		if (directo)
			return o1.getTipo().compareTo(o2.getTipo());
		else
			return (-1)*o1.getTipo().compareTo(o2.getTipo());
	}

}