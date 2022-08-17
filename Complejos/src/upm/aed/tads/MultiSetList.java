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
    
    public Pair<Element,Integer> BuscarElemento(Element elem){
    	int i=0;
    	int n=0;
    	Position<Pair<Element,Integer>> posicion = this.elements.first();
    	while(i<this.elements.size()) {
    		if(elem.equals(posicion.element().getLeft())) {
    			n++;
    		}
    		posicion=this.elements.next(posicion);
    		i++;
    	}
    	Pair<Element,Integer> elemento = new Pair<Element,Integer>(elem,n);
    	return  elemento;
    }
    
    public Position<Pair<Element,Integer>> getPosition(Element elem){
        Position<Pair<Element,Integer>> posicion = elements.first();
        boolean encontrado = false;
        int i=0;
        while(i < elements.size() && !encontrado) {
            if(elem.equals(posicion.element().getLeft()))
                encontrado = true;
            else {
               i++;
               posicion = elements.next(posicion);
            }
        }
        return posicion;
    }
    
    public void add(Element elem, int n){
    	Pair<Element,Integer> elemento = BuscarElemento(elem);
        Integer count = elemento.getRight();
        if(count.equals(0)) {
            elemento.setRight(n);
            elements.addLast(elemento);
        }
        else {
            elemento.setRight(count + n);
            elements.set(elements.last(), elemento);
        }
    	if(n<0) {
    		throw new IllegalArgumentException();
    	}
    }
    
    public void remove(Element elem, int n) {
    	
    }
    
    public int count(Element elem) {
    	return BuscarElemento(elem).getRight();
    }
    
    public int size() {
    	return this.elements.size();
    }
    
    public boolean isEmpty() {
    	return this.elements.isEmpty();
    }
    
    public PositionList<Element> allElements(){
    	return null;
    }
    
    public MultiSet<Element> intersection(MultiSet<Element> s){
    	return null;
    }
    
    public MultiSet<Element> sum(MultiSet<Element> s){
    	return null;
    }
    
    public MultiSet<Element> minus(MultiSet<Element> s){
    	return null;
    }
}
