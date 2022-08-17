package aed.recursion;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.positionlist.NodePositionList;


public class Crypto {

	public static <Character> boolean compare(Character str1, Character str2) {
		return (str1 == null ? str2 == null : str1.equals(str2));
	}

	public static int [] buscarSiguiente(PositionList<Character> key, PositionList<Character> text, Position<Character> cursor, int posicion, int i, int numeros []){	  		  
		if(cursor!=null) {
			Position<Character> cursor2=key.first();
			numeros [i]= buscar(key, cursor.element(), cursor2, posicion);
			i=i+1;
			cursor=text.next(cursor);
			return buscarSiguiente(key, text, cursor, posicion, i, numeros);
		}
		else
			return numeros;
	}

	public static int buscar(PositionList<Character> key, Character a,  Position<Character> cursor, int posicion){	  		  
		if(cursor!=null) {
			if(!compare(a, cursor.element())) {
				posicion++;
				return buscar(key, a, key.next(cursor), posicion);
			}
			else {
				return posicion;
			}
		}
		return 0; 
	}

	public static PositionList<Integer> posicionReal(int [] numeros, int i, PositionList<Integer> ans, Position<Integer> cursor) {
		if(i==0) {
			ans.addLast(numeros[i]);
			i++;
			cursor=ans.first();
			return posicionReal(numeros, i, ans, cursor);
		}
		else if(i<numeros.length){
			int suma=0;
			ans.addLast(numeros[i]- sum(ans, ans.first(), suma));
			i++;
			cursor=ans.next(cursor);
			return posicionReal(numeros, i, ans, cursor);  
		}  
		else
			return ans;
	}

	public static int sum (PositionList<Integer> ans, Position<Integer> cursor, int suma) {
		if(compare(cursor, ans.first())){
			suma=cursor.element();
			return sum(ans, ans.next(cursor), suma);
		}
		else if (cursor!=null && !compare(cursor, ans.first())) {
			suma= suma + cursor.element();
			return sum(ans, ans.next(cursor), suma);
		}
		else
			return suma;
	}

	public static PositionList<Integer> encrypt(PositionList<Character> key, PositionList<Character> text) {
		PositionList<Integer> ans = new NodePositionList<Integer>();
		Position<Character> cursor= text.first();
		if(cursor!=null) {
			int i=0;
			int posicion=0;
			int numeros []= new int [text.size()];
			int [] posiciones= buscarSiguiente(key, text, cursor, posicion, i, numeros);
			int e=0;
			Position<Integer> cursor2= ans.first();
			return posicionReal(posiciones, e, ans, cursor2);
		}
		else
			return ans;
	}	  






	public static Position<Character> desplazar(Integer j, PositionList<Character> key, Position<Character> cursor){
		if(j!=0 && cursor!=null) {
			if(j<0) {
				j++;
				return desplazar(j, key, key.prev(cursor));
			}
			else{
				j--;
				return desplazar(j, key,key.next(cursor)); 
			}
		}
		return cursor;
	}


	public static PositionList<Character> decryptRec(PositionList<Character> key, PositionList<Integer> encodedText, PositionList<Character> ans, Position<Integer> cursor, Position<Character> cursor2) {
		if(cursor!=null && key.first()!=null) {
			ans.addLast(desplazar(cursor.element(), key, cursor2).element());
			return decryptRec(key, encodedText, ans, encodedText.next(cursor), desplazar(cursor.element(), key, cursor2));
		}
		else
			return ans;
	}

	public static PositionList<Character> decrypt(PositionList<Character> key, PositionList<Integer> encodedText) {
		PositionList<Character> ans = new NodePositionList<Character>();
		Position<Integer> cursor=encodedText.first();
		return decryptRec(key, encodedText, ans, cursor, key.first());
	}
}
