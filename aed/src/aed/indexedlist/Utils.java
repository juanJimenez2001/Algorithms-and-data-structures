package aed.indexedlist;
import es.upm.aedlib.indexedlist.*;

public class Utils {
  public static <E> IndexedList<E> deleteRepeated(IndexedList<E> l) {
	  int i=0;
	  int e=0;
	  boolean esta=false;
	  IndexedList<E> b = new ArrayIndexedList<E>();
	  while(i<l.size()) {
		 esta=false;
		 e=0;
		 E elemento=l.get(i);
		 while(e<b.size() && esta==false) {
			 if(elemento.equals(b.get(e)))
				 esta=true;
			 e++;
		 }
		 if(esta==false)
			 b.add(e, elemento);
		 i++;
	  }	  
      return b;
  }
}
