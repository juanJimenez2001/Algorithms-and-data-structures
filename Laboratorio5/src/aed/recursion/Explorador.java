package aed.recursion;

import es.upm.aedlib.Pair;
import es.upm.aedlib.positionlist.*;


public class Explorador {

    public static Pair<Object,PositionList<Lugar>> explora(Lugar inicialLugar) {
        PositionList<Lugar> recorrido = new NodePositionList<Lugar>();
        recorrido.addFirst(inicialLugar);
        inicialLugar.marcaSueloConTiza();
        return recorrer(inicialLugar,inicialLugar, recorrido);
    }

    private static Pair<Object,PositionList<Lugar>> recorrer(Lugar lugar, Lugar inicialLugar, PositionList<Lugar> recorrido){
        if(!lugar.tieneTesoro()){
            if(recorrido.last().element().tieneTesoro()) 
            	return null;
            if(!inicialLugar.equals(lugar)) 
            	recorrido.addLast(lugar);
            sePuedeAcceder(recorrido);
            lugar.marcaSueloConTiza();
            Iterable<Lugar> caminos = lugar.caminos();
            for(Lugar sitio:caminos){
                if(sitio.tieneTesoro()) {
                    if(!recorrido.last().element().equals(sitio)) recorrido.addLast(sitio);
                    break;
                }
                if(sitio.sueloMarcadoConTiza()) 
                	continue;
                recorrer(sitio,inicialLugar, recorrido);
            }
            return new Pair<Object,PositionList<Lugar>>(recorrido.last().element().getTesoro(),recorrido);
        }else {
            return new Pair<Object,PositionList<Lugar>>(lugar.getTesoro(),recorrido);
        }

    }

    private static void sePuedeAcceder(PositionList<Lugar> recorrido) {
        boolean noTieneSalida = true;
        recorrido.last().element().marcaSueloConTiza();
        Iterable<Lugar>caminos = recorrido.last().element().caminos();
        for(Lugar sitio:caminos) {
            if(!(sitio.sueloMarcadoConTiza())) 
            	noTieneSalida = false;
        }
        if(noTieneSalida) {
        	recorrido.remove(recorrido.last());
        	sePuedeAcceder(recorrido);
        }
    }

}