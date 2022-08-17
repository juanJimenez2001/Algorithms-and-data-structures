package aed.individual6;

import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.map.HashTableMap;


public class Suma {
	
  public static <E> Map<Vertex<Integer>,Integer> sumVertices(DirectedGraph<Integer,E> g) {
	  Map<Vertex<Integer>,Integer> suma = new HashTableMap<Vertex<Integer>,Integer>();
	  for(Vertex<Integer> vertice: g.vertices()) {
		  Map<Vertex<Integer>,E> visitados=new HashTableMap<Vertex<Integer>,E>();
		  suma.put(vertice, sumVerticesAlcanzables(vertice, g, visitados));
	  }
	  return suma;
  }
  
  public static <E> Integer sumVerticesAlcanzables(Vertex<Integer> vertice, DirectedGraph<Integer,E> grafo,  Map<Vertex<Integer>,E> visitados) {
	 visitados.put(vertice, null);
	 int suma=vertice.element();
	 for(Edge<E> e: grafo.outgoingEdges(vertice)) {
		 Vertex<Integer> verticeFinal=grafo.endVertex(e);
		 if(!visitados.containsKey(verticeFinal)) {
			 suma= suma + sumVerticesAlcanzables(verticeFinal, grafo, visitados);
		 }
	 }
	 return suma; 
  }
  
}
