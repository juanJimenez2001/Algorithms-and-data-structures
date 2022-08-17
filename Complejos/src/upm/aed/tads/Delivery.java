package aed.delivery;

import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.graph.DirectedAdjacencyListGraph;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.map.HashTableMap;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.set.HashTableMapSet;
import es.upm.aedlib.set.PositionListSet;
import es.upm.aedlib.set.Set;
import java.util.Iterator;

public class Delivery<V> {

	DirectedGraph<V, Integer> grafo;

	// Construct a graph out of a series of vertices and an adjacency matrix.
	// There are 'len' vertices. A negative number means no connection. A non-negative
	// number represents distance between nodes.
	public Delivery(V[] places, Integer[][] gmat) {
		grafo= new DirectedAdjacencyListGraph<V, Integer>();
		int i=0;
		int j=0;
		while(i<places.length) {
			grafo.insertVertex(places[i]);
			i++;
		}
		i=0;
		while(i<places.length) {
			j=0;
			while(j<places.length) {
				if(gmat[i][j]!=null) {
					grafo.insertDirectedEdge(crearVertice(places[i]), crearVertice(places[j]), gmat[i][j]);
				}
				j++;
			}
			i++;
		}
	}

	private Vertex<V> crearVertice(V ver){
		Vertex<V> vertice=null;
		for(Vertex<V> vertex : grafo.vertices()) {
			if(vertex.element().equals(ver)) {
				vertice=vertex;
				break;
			}
		}
		return vertice;
	}

	// Just return the graph that was constructed
	public DirectedGraph<V, Integer> getGraph() {
		return this.grafo;
	}

	// Return a Hamiltonian path for the stored graph, or null if there is noe.
	// The list containts a series of vertices, with no repetitions (even if the path
	// can be expanded to a cycle).
	public PositionList <Vertex<V>> tour() {
		PositionList <Vertex<V>> lista=new NodePositionList<Vertex<V>>();
		for(Vertex<V> vertice: grafo.vertices()) {
			Map<Vertex<V>,Integer> visitados=new HashTableMap<Vertex<V>,Integer>();
			lista=camino(vertice, visitados, lista);
		}
		return lista;
	}

	private PositionList<Vertex<V>> camino(Vertex<V> vertice, Map<Vertex<V>, Integer> visitados, PositionList<Vertex<V>> lista) {
		visitados.put(vertice, 0);
		lista.addLast(vertice);
		for(Edge<Integer> e: grafo.outgoingEdges(vertice)) {
			Vertex<V> verticeFinal=grafo.endVertex(e);
			if(!visitados.containsKey(verticeFinal)) {
				camino(verticeFinal, visitados, lista);
			}
		}
		return lista;
	}


	public int length(PositionList<Vertex<V>> path) {
		Position <Vertex<V>> cursor=path.first();
		Position <Vertex<V>> cursor2=path.first();
		int suma=0;
		while(path.next(cursor)!=null && path.next(cursor2)!=null) {
			cursor2=path.next(cursor2);
			for(Edge<Integer> arista : grafo.outgoingEdges(cursor.element())) {
				if(grafo.endVertex(arista)==cursor2.element()) {
					suma=suma+arista.element();
					break;
				}
			}
			cursor=path.next(cursor);
		}
		return suma;
	}

	public String toString() {
		return "Delivery";
	}
}
