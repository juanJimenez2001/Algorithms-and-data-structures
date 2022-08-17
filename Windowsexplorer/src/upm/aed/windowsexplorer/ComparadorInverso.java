package upm.aed.windowsexplorer;
import java.util.Comparator;

public abstract class ComparadorInverso<T> implements Comparator<T> {
	public boolean directo = true;
	
	public void inverso()
	{
		directo = !directo;
	}


	abstract public int compare(T arg0, T arg1);
//	{
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
