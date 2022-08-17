package upm.aed.windowsexplorer;
// import java.util.Comparator;

public class ComparadorPorNombre extends ComparadorInverso<FileDescriptor> {

	@Override
	public int compare(FileDescriptor o1, FileDescriptor o2) {
		// TODO Auto-generated method stub
		if (directo)
			return o1.getName().compareTo(o2.getName());
		else
			return (-1)*o1.getName().compareTo(o2.getName());
	}

}
