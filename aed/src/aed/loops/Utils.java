package aed.loops;

public class Utils {
  public static int maxNumRepeated(Integer[] a, Integer elem)  {
	  int maximo=0;
	  int i=0;
	  int e=0;
	  int[] repeticiones = new int [a.length];
	  while(i<=a.length-1) {
		  if(a[i].equals(elem)){
			  repeticiones[e]=repeticiones[e]+1;
			  if(i+1<a.length && !a[i+1].equals(elem))
				  e++;
		  }  
		  i++;
	  }
	  e=0;		
      while(repeticiones[e] != 0 && e<repeticiones.length) {
		  if(repeticiones[e]>maximo) 
			  maximo=repeticiones[e]; 
		  e++; 
		  }
	  return maximo;  
  }
}
