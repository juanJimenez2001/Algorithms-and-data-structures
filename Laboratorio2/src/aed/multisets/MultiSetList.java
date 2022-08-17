package aed.multisets;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.positionlist.NodePositionList;


/**
 * An implementation of a multiset using a positionlist.
 */
public class MultiSetList<Element> implements MultiSet<Element> {

	/**
	 * Datastructure for storing the multiset.
	 */
	private PositionList<Pair<Element,Integer>> elements;

	private int size;


	/**
	 * Constructs an empty multiset.
	 */
	public MultiSetList() {
		this.elements = new NodePositionList<Pair<Element,Integer>>();
	}

	public boolean compare(Element str1, Element str2) {
		return (str1 == null ? str2 == null : str1.equals(str2));
	}

	private Pair<Element,Integer> BuscarElemento(Element elem){
		int i=0;
		int n=0;
		boolean aux = true;
		Position<Pair<Element,Integer>> posicion = this.elements.first();
		while(i<this.elements.size() && aux) {
			if(compare(elem,posicion.element().getLeft())) {
				n = posicion.element().getRight();
				aux = false;
			}
			posicion=this.elements.next(posicion);
			i++;
		}
		Pair<Element,Integer> elemento = new Pair<Element,Integer>(elem,n);
		return  elemento;
	}


	private Position<Pair<Element,Integer>> getPosition(Element elem){
		Position<Pair<Element,Integer>> posicion = elements.first();
		boolean encontrado = false;
		int i=0;
		while(i < elements.size() && !encontrado) {
			if(compare(elem,posicion.element().getLeft()))
				encontrado = true;
			else {
				i++;
				posicion = elements.next(posicion);
			}
		}
		return posicion;
	}

	public void add(Element elem, int n){
		if(n<0) {
			throw new IllegalArgumentException();
		}
		if(n > 0) {
			Pair<Element,Integer> elemento = BuscarElemento(elem);
			int count = elemento.getRight();
			size=size+n;
			if(count==0) {
				elemento.setRight(n);
				elements.addLast(elemento);
			}
			else {
				elemento.setRight(count + n);
				elements.set(getPosition(elem), elemento);
			}
		}
	}

	public void remove(Element elem, int n) {
		Position<Pair<Element,Integer>> elemento= getPosition(elem);
		int count=count(elem);
		if(n<0 || n>count) {
			throw new IllegalArgumentException();
		}
		if(count>n) {
			elemento.element().setRight(count-n);
			size=size-n;
		}
		if(count==n && count!=0) {
			elements.remove(elemento);
			size=size-n;
		}
	}

	public int count(Element elem) {
		return BuscarElemento(elem).getRight();
	}

	public int size() {
		return size;
	}


	public boolean isEmpty() {
		return size==0;
	}

	public PositionList<Element> allElements(){
		PositionList<Element> res = new NodePositionList<Element>();
		Position<Pair<Element,Integer>> cursor = elements.first();	
		while(cursor != null) {			
			int i = cursor.element().getRight();
			while(i > 0) {
				res.addLast(cursor.element().getLeft());
				i--;
			}
			cursor = elements.next(cursor);			
		}
		return res;
	}

	public MultiSet<Element> intersection(MultiSet<Element> s){
		MultiSet<Element> ans= new MultiSetList<Element>();
		Position<Pair<Element,Integer>> cursor1 = elements.first();
		PositionList<Element> aux= s.allElements();
		while(cursor1!=null) {
			Position <Element> cursor2=aux.first();
			boolean esta=false;
			while(cursor2!=null && !esta) {
				if(compare(cursor2.element(),cursor1.element().getLeft())) {
					ans.add(cursor1.element().getLeft(),Math.min(cursor1.element().getRight(), s.count(cursor2.element())));
					esta=true;
				}
				cursor2=aux.next(cursor2);
			}
			cursor1=elements.next(cursor1);
		}
		return ans;
	}

	public MultiSet<Element> sum(MultiSet<Element> s){
		MultiSet<Element>ans=new MultiSetList<Element>();
		Position<Pair<Element,Integer>> cursor1= elements.first();
		PositionList<Element> aux=s.allElements();
		Position<Element> cursor2=aux.first();
		while(cursor1!=null) {
			ans.add(cursor1.element().getLeft(), cursor1.element().getRight());
			cursor1=elements.next(cursor1);
		}
		while(cursor2!=null) {
			ans.add(cursor2.element(), 1);
			cursor2=aux.next(cursor2);
		}
		return ans;
	}

	public MultiSet<Element> minus(MultiSet<Element> s){
		MultiSet<Element> ans = new MultiSetList<>();
		Position<Pair<Element,Integer>> cursor1 = elements.first();
		PositionList<Element> aux = s.allElements();
		Position<Element> cursor2 = aux.first();
		boolean esta = false;
		while(cursor1!=null) {
			esta = false;
			cursor2=aux.first();
			while(cursor2!=null && !esta) {
				if(compare(cursor1.element().getLeft(),cursor2.element())) {
					ans.add(cursor1.element().getLeft(), cursor1.element().getRight()-s.count(cursor2.element()));
					esta = true;
				}
				cursor2 = aux.next(cursor2);
			}
			if(!esta) {
				ans.add(cursor1.element().getLeft(), cursor1.element().getRight());
			}
			cursor1 = elements.next(cursor1);
		}
		return ans;
	}
}
