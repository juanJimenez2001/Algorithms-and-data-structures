package upm.aed.windowsexplorer;
// import java.util.Comparator;

public class ComparadorPorFecha extends ComparadorInverso<FileDescriptor> {

	@Override
	public int compare(FileDescriptor o1, FileDescriptor o2) {
		// TODO Auto-generated method stub
		if (directo)
			return o1.getFecha().compareTo(o2.getFecha());
		else
			return (-1)*o1.getFecha().compareTo(o2.getFecha());
	}

}

