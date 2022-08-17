package aed.treesearch;


import es.upm.aedlib.Position;
import es.upm.aedlib.set.*;
import es.upm.aedlib.positionlist.*;
import es.upm.aedlib.tree.*;


public class TreeSearch {

	public static <String> boolean compare(String str1, String str2) {
		return (str1 == null ? str2 == null : str1.equals(str2)) || str1.equals("*");
	}

	public static Set<Position<String>> search(Tree<String> t, PositionList<String> searchExprs) {
		Set<Position<String>> res = new PositionListSet<Position<String>>();
		if (!searchExprs.isEmpty() && !t.isEmpty())
			search(t, searchExprs, t.root(), searchExprs.first(), res);
		return res;
	}

	private static void search(Tree<String> t, PositionList<String> searchExprs, Position<String> cursorArbol,  Position<String> cursorExpresion, Set<Position<String>> res) {
		String elementoArbol = cursorArbol.element();
		String elementoExpresion = cursorExpresion.element();
		cursorExpresion = searchExprs.next(cursorExpresion);
		if (compare(elementoExpresion,elementoArbol)) {
			if (cursorExpresion == null) {
				res.add(cursorArbol);
			} 
			else {
				for (Position<String> cursor : t.children(cursorArbol)) {
					search(t, searchExprs, cursor, cursorExpresion, res);
				}
			}
		}
	}

	public static <E> Tree<E> constructDeterministicTree(Set<PositionList<E>> paths) {
		GeneralTree<E> arbol = new LinkedGeneralTree<E>();
		for (PositionList<E> camino : paths) {
			if (arbol.isEmpty()) {
				arbol.addRoot(camino.first().element());
			}
			if (!camino.isEmpty()) {
				recorrer(arbol,arbol.root(), camino, camino.next(camino.first()));
			}
		}
		return arbol;
	}

	private static <E> void recorrer(GeneralTree<E> arbol, Position<E> cursorArbol, PositionList<E> camino, Position<E> cursorCamino) {		
		if (cursorCamino != null) {
			E elementoCamino = cursorCamino.element();
			cursorCamino = camino.next(cursorCamino);
			for (Position<E> cursor : arbol.children(cursorArbol)) {
				if (cursor.element().equals(elementoCamino)) {
					recorrer(arbol, cursor, camino, cursorCamino);
					return;
				}
			}
			recorrer(arbol, arbol.addChildLast(cursorArbol, elementoCamino), camino, cursorCamino);
		}
	}
}
