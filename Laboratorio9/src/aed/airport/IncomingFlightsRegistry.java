package aed.airport;


import es.upm.aedlib.Entry;
import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.priorityqueue.*;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;


/**
 * A registry which organizes information on airplane arrivals.
 */
public class IncomingFlightsRegistry {
	private Map<String,Long> registro;

	/**
	 * Constructs an class instance.
	 */
	public IncomingFlightsRegistry() {
		this.registro = new HashTableMap<String,Long>();
	}

	/**
	 * A flight is predicted to arrive at an arrival time (in seconds).
	 */
	public void arrivesAt(String flight, long time) {
		registro.put(flight, time);		
	}

	/**
	 * A flight has been diverted, i.e., will not arrive at the airport.
	 */
	public void flightDiverted(String flight) {
		registro.remove(flight);
	}

	/**
	 * Returns the arrival time of the flight.
	 * @return the arrival time for the flight, or null if the flight is not predicted
	 * to arrive.
	 */
	public Long arrivalTime(String flight) {
		return registro.get(flight);
	}

	/**
	 * Returns a list of "soon" arriving flights, i.e., if any 
	 * is predicted to arrive at the airport within nowTime+180
	 * then adds the predicted earliest arriving flight to the list to return, 
	 * and removes it from the registry.
	 * Moreover, also adds to the returned list, in order of arrival time, 
	 * any other flights arriving withinfirstArrivalTime+120; these flights are 
	 * also removed from the queue of incoming flights.
	 * @return a list of soon arriving flights.
	 */
	
	
	private PositionList<FlightArrival> buscar(long time){
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		for(String vuelo : registro.keys()) {
			if(registro.get(vuelo) <= time) {
				if(res.first() != null && res.first().element().arrivalTime() >= registro.get(vuelo))
					res.addFirst(new FlightArrival(vuelo,registro.get(vuelo)));
				else
					res.addLast(new FlightArrival(vuelo,registro.get(vuelo)));
			}			
		}
		return res;
	}	
	
	public PositionList<FlightArrival> arriving(long nowTime) {
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		PositionList<FlightArrival> primero = buscar(nowTime + 180);
		if(primero.first()!=null) {
			res.addFirst(primero.first().element());
			registro.remove(primero.first().element().getLeft());
			PositionList<FlightArrival> conflicto = buscar(primero.first().element().getRight() + 120);
			Position<FlightArrival> cursor = conflicto.first();
			while(cursor != null) {
				res.addLast(cursor.element());
				registro.remove(cursor.element().getLeft());
				cursor = conflicto.next(cursor);		
			}
		}
		return res;
	}

}
