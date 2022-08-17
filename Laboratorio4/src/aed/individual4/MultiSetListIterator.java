package aed.individual4;

import java.util.Iterator;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import java.util.NoSuchElementException;

public class MultiSetListIterator<E> implements Iterator<E> {

	PositionList<Pair<E,Integer>> list;
	Position<Pair<E,Integer>> cursor;
	int counter;
	Position<Pair<E,Integer>> prevCursor;

	public MultiSetListIterator(PositionList<Pair<E,Integer>> list) {
		this.list = list;
		if(list!=null && this.list.first()!=null) {
			this.cursor=this.list.first();
			this.prevCursor=this.list.prev(cursor);
			this.counter=cursor.element().getRight();
		}
		else {
			this.counter=-1;
			this.cursor=null;
			this.prevCursor=null;
		}
	}

	public boolean hasNext() {
		return this.cursor!=null;
	}

	public E next() {
		if(hasNext()) {
			if(this.counter>1) {
				this.prevCursor=this.cursor;
				this.counter--;
				return this.cursor.element().getLeft();
			}
			else {
				this.prevCursor=this.cursor;
				this.cursor=this.list.next(cursor);
				if(hasNext()) {
					this.counter=this.cursor.element().getRight();
				}
				return this.prevCursor.element().getLeft();
			}
		}
		else
			throw new NoSuchElementException();
	}

	public void remove() {
		if (prevCursor!=null) {
			if(prevCursor.element().getRight()>1) {
				this.prevCursor.element().setRight(prevCursor.element().getRight()-1);
				this.prevCursor=null;
			}
			else {
				list.remove(prevCursor);
				this.prevCursor=null;
			} 
		}
		else{
			throw new IllegalStateException();
		} 
	}
}
