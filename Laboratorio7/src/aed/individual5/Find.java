package aed.individual5;

import es.upm.aedlib.tree.Tree;
import es.upm.aedlib.Position;


public class Find {

	public static <String> boolean compare(String str1, String str2) {
		return (str1 == null ? str2 == null : str1.equals(str2));
	}

	public static void FindRec(String fileName, Tree<String> directory, Position<String> cursor, String path) {
		if (compare(fileName,cursor.element())) {
			Printer.println(path+"/"+ cursor.element());
		}
		else {
			path= path+ "/"+ cursor.element();
			for(Position<String> fichero: directory.children(cursor)) {
				FindRec(fileName, directory, fichero, path);
			}
		}
	}

	/**
	 * Busca ficheros con nombre igual que fileName dentro el arbol directory,
	 * y devuelve un PositionList con el nombre completo de los ficheros
	 * (incluyendo el camino).
	 */
	public static void find(String fileName, Tree<String> directory) {  
		String path="";
		FindRec(fileName, directory, directory.root(), path);
	}
}
