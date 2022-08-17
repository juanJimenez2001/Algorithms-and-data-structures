package aed.individual3;

import java.util.Iterator;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class OperacionCompactar {
	
	public static <E> boolean compare(E str1, E str2) {
		return (str1 == null ? str2 == null : str1.equals(str2));
	}
	
	/**
	 * Metodo que reduce los elementos iguales consecutivos de una lista a una 
	 * unica repeticion
	 * @param lista Lista de entrada
	 * @return Lista nueva compactada sin elementos iguales consecutivos
	 */
	public static <E> PositionList<E> compactar (Iterable<E> lista) {
		if(lista==null)
			throw new IllegalArgumentException();
		Iterator <E> it1 = lista.iterator();
		Iterator <E> it2 = lista.iterator();
		NodePositionList<E> ans = new NodePositionList<E>();
		ans.addLast(it1.next());
		Position<E> cursor1 = ans.first();
		E elemento2=it2.next();
		while (it1.hasNext()) {
			E elemento1=it1.next();
			if(!compare(cursor1.element(),elemento1)) {
				ans.addLast(it2.next());
				cursor1=ans.next(cursor1);
			}
			else
				elemento2 = it2.next();
		}
		return ans;
	}
	

}
