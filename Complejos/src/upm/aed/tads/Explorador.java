package aed.recursion;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;


public class Explorador {
	
	public static PositionList<Lugar> recorrido(Lugar lugar, PositionList<Lugar> recorrer){
		if(!lugar.tieneTesoro()) {
			boolean sinMarcar=true;
			boolean tieneTesoro=false;
			Lugar sitio=lugar.caminos().iterator().next();
			while (sitio.caminos().iterator().hasNext() && sinMarcar && !tieneTesoro) {
				if(!sitio.sueloMarcadoConTiza()) {
					recorrer.addLast(sitio);
					if (sitio.tieneTesoro())
						tieneTesoro=true;
				}
				else
					sinMarcar=false;
				sitio=lugar.caminos().iterator().next();
			}
			if(tieneTesoro) {
				return recorrer;
			}
			return recorrido(sitio, recorrer);			
		}
		else {
			recorrer.addLast(lugar);
			return recorrer;
		}
	}


	public static Pair<Object,PositionList<Lugar>> explora(Lugar inicialLugar) {
		PositionList<Lugar> recorrer= new NodePositionList<Lugar>();
		recorrer= recorrido(inicialLugar, recorrer);
		Pair<Object,PositionList<Lugar>> sol= new Pair<>(recorrer.last().element().getTesoro(),recorrer);
		return sol;
	}
}
