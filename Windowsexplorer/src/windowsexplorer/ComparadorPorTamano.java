package upm.aed.windowsexplorer;
// import java.util.Comparator;

public class ComparadorPorTamano extends ComparadorInverso<FileDescriptor> {

	@Override
	public int compare(FileDescriptor o1, FileDescriptor o2) {
		// TODO Auto-generated method stub
		if (directo)
			return o1.getTamano() - o2.getTamano();
		else
			return o2.getTamano() - o1.getTamano();
	}

}
