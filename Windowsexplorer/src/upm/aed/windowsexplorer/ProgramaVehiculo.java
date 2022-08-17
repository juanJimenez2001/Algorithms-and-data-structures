package upm.aed.windowsexplorer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class ProgramaVehiculo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println (LibVehiculo.aire);
		
		Fecha f = new Fecha (31,12,2000);
		Horario h = new Horario (23,59,20);
		Musica m = new Musica ("cancion.mp3");
		Reloj r = new Reloj (h,f,m);
		
		Fecha f2 = new Fecha (31,12,2000);
		Horario h2 = new Horario (23,59,40);
		Reloj alarma = new Reloj(h2,f,m);
		Vehiculo v1 = new Vehiculo("Car",LibVehiculo.aire, f,5 );
		Vehiculo v2 = new Vehiculo ("Coche",LibVehiculo.tierra, f2,3 );
		Vehiculo v3 = new Vehiculo ("Moto",LibVehiculo.mar, f2,2 );
		System.out.println (v1);
		System.out.println (v2);
		System.out.println (v3);
	
	

	
//		
//		Vehiculo [] col2 = {v1,v2,v3};
//		
//
		List<Vehiculo> col1 = new ArrayList<Vehiculo> ();
		System.out.println (
				LibEsquemaColVehiculos.cuantosSonTierreaCol(col1,LibVehiculo.tierra));
		
		System.out.println ("suma ruedas " + 
				LibEsquemaColVehiculos.sumaRuedas (col1));
		System.out.println ("Multi ruedas " + 
				LibEsquemaColVehiculos.multRuedas (col1));
		System.out.println ("Ruedas de un tipo " + 
				LibEsquemaColVehiculos.sumarRuedasDeUnTipo (col1,LibVehiculo.tierra));
		System.out.println ("Hay algun " + 
				LibEsquemaColVehiculos.hayAlgunTipo (col1,LibVehiculo.tierra,2));
		System.out.println ("Todos mimso tipo " + 
				LibEsquemaColVehiculos.todosMismoTipo (col1,LibVehiculo.tierra));
		System.out.println ("Maximo " + 
				LibEsquemaColVehiculos.maxCol3 (col1));
		Vehiculo vMax = LibEsquemaColVehiculos.maxCol3 (col1);
		if (vMax != null)
			System.out.println (vMax.getRuedas());
		else
			System.out.println ("Es una full");
		
		System.out.println ("Min " + 
				LibEsquemaColVehiculos.minCol (col1));
		Vehiculo vMin = LibEsquemaColVehiculos.minCol (col1);
		if (vMin != null)
			System.out.println (vMin.getRuedas());
		else
			System.out.println ("Es una full");
		
		col1.add (v1);
		col1.add ((Vehiculo)v1.clone());
		col1.add (v2);
		col1.add(v3);
		
		System.out.println (
				LibEsquemaColVehiculos.cuantosSonTierreaCol(col1,LibVehiculo.tierra));
		System.out.println ("suma ruedas " + 
				LibEsquemaColVehiculos.sumaRuedas (col1));
		System.out.println ("Ruedas de un tipo " + 
				LibEsquemaColVehiculos.sumarRuedasDeUnTipo (col1,LibVehiculo.tierra));
		System.out.println ("Hay  de un tipo " + 
				LibEsquemaColVehiculos.hayAlgunTipo (col1,LibVehiculo.tierra,2));
		System.out.println ("Todos mismo " + 
				LibEsquemaColVehiculos.todosMismoTipo (col1,LibVehiculo.tierra));
		System.out.println ("Maximo " + 
				LibEsquemaColVehiculos.maxCol3 (col1));
		Vehiculo vMax2 = LibEsquemaColVehiculos.maxCol3 (col1);
		System.out.println (vMax2.getRuedas());
		
		System.out.println ("Minimo " + 
				LibEsquemaColVehiculos.minCol (col1));
		Vehiculo vMin2 = LibEsquemaColVehiculos.minCol (col1);
		System.out.println (vMin2.getRuedas());

		System.out.println ("Los Nombres " + 
				LibEsquemaColVehiculos.losNombres(col1));

		
		List<String> colRes = LibEsquemaColVehiculos.losNombres(col1);
		List<String> colRes2 = new ArrayList<String>();
		List<String> colRes3 = new Vector<String>();
		List<Vehiculo> colResVeh = new ArrayList<Vehiculo>();
		
		LibEsquemaColVehiculos.losNombres(col1,colRes2);

		
		System.out.println ("El nombre menor " +
				LibEsquemaColVehiculos.minCol(
						LibEsquemaColVehiculos.losNombres(col1)));
		
		System.out.println ("Los Nombres " + 
				LibEsquemaColVehiculos.filtrarPorNombre(col1,"Car"));
		
		LibEsquemaColVehiculos.filtrarPorNombre(col1, colResVeh, "Car");
		System.out.println (colResVeh);
		
		
		LibEsquemaColVehiculos.filtrarPorTipo(col1, LibVehiculo.aire);
		System.out.println (col1);
		
		Predicado<Vehiculo> pred = new CompruebaNombreTipo("Car",LibVehiculo.aire);
		Predicado<Vehiculo> pred2 = new CompruebaNombreTipoRuedas("Car",LibVehiculo.tierra,2);
		LibEsquemaColVehiculos.filtrar(col1, colResVeh, pred);
		LibEsquemaColVehiculos.filtrar(col1, colResVeh, pred2);
		System.out.println (col1);
		System.out.println (LibEsquemaColVehiculos.minCol(col1));
		
		//			
//	    v2.setNombre("Car");		
//		v1.setNombre("Avion");
//		col1.add (v1);
//		col1.add (v2);
	}

}
