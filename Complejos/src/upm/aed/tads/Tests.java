package aed.airport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import es.upm.aedlib.positionlist.*;


public class Tests {
	
	@Test
	public void Propiedad1() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",1050);
		airport.arrivesAt("IBE3835",1200);
		airport.arrivalTime("IBE3835");
		assertEquals(1200, airport.arrivalTime("IBE3835"));
	}

	@Test
	public void Propiedad2() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",20);
		airport.arrivesAt("KLM2319",10);
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		res.addLast(new FlightArrival("KLM2319",10));
		res.addLast(new FlightArrival("IBE3835",20));
		assertEquals(res, airport.arriving(0));
	}
	
	@Test
	public void testRegistry1() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",3600);
		airport.flightDiverted("IBE3835");
		assertEquals(null, airport.arrivalTime("IBE3835"));
	}

	@Test
	public void testRegistry2() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",360);
		airport.arrivesAt("KLM2319",140);
		airport.arrivesAt("IBE789",180);
		airport.flightDiverted("KLM2319");
		airport.arrivesAt("KLM111",40);
		airport.arrivesAt("IBE3835",160);
		assertEquals(null, airport.arrivalTime("KLM2319"));
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		res.addLast(new FlightArrival("KLM111",40));
		res.addLast(new FlightArrival("IBE3835",160));
		assertEquals(res, airport.arriving(0));
	}

	@Test
	public void testRegistry3() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",360);
		airport.arrivesAt("KLM2319",1450);
		airport.arrivesAt("IBE789",185);
		airport.arrivesAt("KLM111",190);
		airport.arrivesAt("IBE3835",1630);
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		assertEquals(res, airport.arriving(0));
	}

	@Test
	public void testRegistry4() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		assertEquals(res, airport.arriving(0));
		airport.arrivesAt("IBE3835",120);
		airport.arrivesAt("KLM2319",30);
		airport.arrivesAt("IBE789",12);
		airport.arrivesAt("KLM111",75);
		airport.arrivesAt("IBE3835",180);
		res.addLast(new FlightArrival("KLM111",75));
		res.addFirst(new FlightArrival("KLM2319",30));
		res.addFirst(new FlightArrival("IBE789",12));
		assertEquals(res, airport.arriving(0));
	}

	@Test
	public void testRegistry5() {
		IncomingFlightsRegistry airport = new IncomingFlightsRegistry();
		airport.arrivesAt("IBE3835",360);
		airport.arrivesAt("KLM2319",1450);
		airport.arrivesAt("IBE5252",355);
		airport.arrivesAt("KLM1331",155);
		airport.arrivalTime("KLM2319");
		assertEquals(1450, airport.arrivalTime("KLM2319"));
		airport.flightDiverted("KLM2319");
		assertEquals(null, airport.arrivalTime("KLM2319"));
		airport.arrivalTime("KLM2319");
		assertEquals(null, airport.arrivalTime("KLM2319"));
		airport.arrivesAt("IBE789",185);
		airport.arrivesAt("KLM111",190);
		airport.arrivalTime("IBE3835");
		assertEquals(360, airport.arrivalTime("IBE3835"));
		airport.arrivesAt("IBE3835",1630);
		PositionList<FlightArrival> res = new NodePositionList<FlightArrival>();
		res.addFirst(new FlightArrival("KLM111",190));
		res.addFirst(new FlightArrival("IBE789",185));
		res.addFirst(new FlightArrival("KLM1331",155));
		assertEquals(res, airport.arriving(150));
	}
}

