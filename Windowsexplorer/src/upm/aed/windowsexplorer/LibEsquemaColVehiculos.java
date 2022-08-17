package upm.aed.windowsexplorer;
//import java.util.List;
//
//
//public class LibEsquemasColVehiculos {
//
//	public static int sumaRuedasCol (Vehiculo [] col)
//	{
//		int suma = 0;
//		for (int i=0; i<col.length;i++)
//			suma += col[i].getRuedas();
//		return suma;
//	}
//	public static int sumaRuedasCol (List<Vehiculo>  col)
//	{
//		int suma = 0;
//		for (int i=0; i<col.size();i++)
//			suma += col.get(i).getRuedas();
//		return suma;
//	}
//
//
//	public static int multRuedasCol (Vehiculo [] col)
//	{
//		int mult = 1;
//		for (int i=0; i<col.length;i++)
//			mult *= col[i].getRuedas();
//		return mult;
//	}
//	public static int multRuedasCol (List<Vehiculo>  col)
//	{
//		int mult = 1;
//		for (int i=0; i<col.size();i++)
//			mult *= col.get(i).getRuedas();
//		return mult;
//	}
//
////
////	public static <E> E maxCol (List<E> col)
////	{
////		if (col.size() == 0)
////		{
////			return null;
////		}
////		else
////		{
////			E res = col.get(0);
////			for (int i=1; i < col.size(); i++)
////				if (res.compareTo(col.get(i)) < 0)
////					res = col.get(i);
////			return res;
////		}
////	}
////	public static Fecha maxCol2 (List<Fecha> col)
////	{
////		if (col.size() == 0)
////		{
////			return null;
////		}
////		else
////		{
////			Fecha res = col.get(0);
////			for (int i=1; i < col.size(); i++)
////				if (res.compareTo(col.get(i)) < 0)
////					res = col.get(i);
////			return res;
////		}
////	}
//	
//	public static <E extends Comparable<E>>  E maxCol (List<E> col)
//	{
//		if (col.size() == 0)
//		{
//			return null;
//		}
//		else
//		{
//			E res = col.get(0);
//			for (int i=1; i < col.size(); i++)
//				if (res.compareTo(col.get(i)) < 0)
//					res = col.get(i);
//			return res;
//		}
//	}
//
//	public static void anadirRuedas (List<Vehiculo> col, int n)
//	{
//		for (int i=0; i < col.size(); i++)
//			col.get(i).setRuedas(col.get(i).getRuedas()+n);
//	}
//	public static void anadirPrefijo (List<Vehiculo> col, String prefijo)
//	{
//		for (int i=0; i < col.size(); i++)
//			col.get(i).setNombre(prefijo + col.get(i).getNombre());
//	}
//	
//	
//	public static int sumarRuedasDeUnTipo (List<Vehiculo> col, int tipo)
//	{
//		return 0;
//	}
//
//
//}





import java.util.ArrayList;
import java.util.List;//Para usar listas y las listas array



public class LibEsquemaColVehiculos {

	//Dada una colecci�n de "col" (array o list) de Veh�culos,
	//calcular la suma de ruedas que tiene.

	public static int sumaRuedas(Vehiculo[] col) {

		int suma=0;//se acumula el valor
		for (int i=0;i<col.length;i++)
			suma += col[i].getRuedas();
		return suma;
	}

	public static int sumaRuedas(List <Vehiculo> col) {

		int suma=0;//se acumula el valor
		for (int i=0;i<col.size();i++)
			suma += col.get(i).getRuedas();
		return suma;
	}

	//Dada una colecci�n de "col" (array o list) de Veh�culos,
	//calcular la multiplicacion de ruedas que tiene.
	public static int multRuedas(Vehiculo[] col) {

		int mult=1;//se acumula el valor
		for (int i=0;i<col.length;i++)
			mult *= col[i].getRuedas();
		return mult;
	}

	public static int multRuedas(List <Vehiculo> col) {

		int mult=1;//se acumula el valor
		for (int i=0;i<col.size();i++)
			mult *= col.get(i).getRuedas();
		return mult;
	}
	//Contar cuantos son de Tierra dada una coleccion "col" Vehiculos
	public static int cuantosSonTierreaCol (Vehiculo[] col, int t)

	{
		int cuantos = 0;
		for (int i = 0; i< col.length; i++)
			if (col [i].getTipo()==t)
				cuantos ++;
		return cuantos;

	}
	public static int cuantosSonTierreaCol (List <Vehiculo> col, int t)

	{
		int cuantos = 0;
		for (int i = 0; i< col.size(); i++)
			if (col.get (i).getTipo()==t)
				cuantos ++;
		return cuantos;

	}
	//Sumar las ruedas de una colecci�n "col" de Veh�culos que son del 
	//mismo tipo.

	public static int sumarRuedasDeUnTipo(Vehiculo [] col, int t) {
		int suma=0;//se acumula el valor
		for (int i=0;i<col.length;i++)
			//Un filtro es una condici�n
			if (col [i].getTipo()==t)//Comparo mismo tipo
				suma += col[i].getRuedas();//Sumo los del mismo tipo sus ruedas
		return suma;
	}

	public static int sumarRuedasDeUnTipo(List<Vehiculo> col, int t) {
		int suma=0;//se acumula el valor
		for (int i=0;i<col.size();i++)
			//Un filtro es una condici�n
			if (col.get (i).getTipo()==t)//Comparo mismo tipo
				suma += col.get (i).getRuedas();//Sumo los del mismo tipo sus ruedas
		return suma;
	}
	//Hay alg�n (existe) Vehiculo de un determinado tipo que tenga n ruedas

	public static boolean hayAlgunTipo(Vehiculo[] col, int t,int n) {

		boolean esta=false;
		int i =0;
		while (i < col.length && !esta) {

			if (col[i].getTipo()==t && col[i].getRuedas() > n)
				esta=true;
			else
				i++;
		}

		return esta;
	}
	public static boolean hayAlgunTipo(Vehiculo[] col, int t) {

		boolean esta=false;
		int i =0;
		while (i < col.length && !esta) {

			if (col[i].getTipo()==t)
				esta=true;
			else
				i++;
		}

		return esta;
	}

	public static boolean hayAlgunTipo(List <Vehiculo> col, int t,int n) {

		boolean esta=false;
		int i =0;
		while (i < col.size() && !esta) {

			if (col.get(i).getTipo()==t && col.get(i).getRuedas() > n)
				esta=true;
			else
				i++;
		}

		return esta;
	}
	public static boolean hayAlgunTipo(List <Vehiculo> col, int t) {

		boolean esta=false;
		int i =0;
		//!esta quiere decir false es igual que en la iniciacion.
		while (i < col.size() && !esta) {

			if (col.get(i).getTipo()==t)
				esta=true;
			else
				i++;
		}

		return esta;
	}


	public static boolean todosMismoTipo(List <Vehiculo> col, int tipo) 
	{
		boolean todos=true;
		int i =0;
		//!esta quiere decir false es igual que en la iniciacion.
		while (i < col.size() && todos) {

			if (!(col.get(i).getTipo()==tipo))
				todos=false;
			else
				i++;
		}

		return todos;
	}


	//Cuantos cumplen que son del mismo tipo con n reudas
	public static int cuantosDeUnTipoNumRuedas (Vehiculo[] col, int t, int r)

	{
		int cuantos = 0;
		for (int i=0;i<col.length;i++)
			if (col[i].getTipo() ==t && col[i].getTipo() ==r)
				cuantos ++;
		return cuantos;

	}


	public static int cuantosDeUnTipoNumRuedas (List <Vehiculo> col, int t, int r)

	{
		int cuantos = 0;
		for (int i = 0; i< col.size(); i++)
			if (col.get (i).getTipo()==t && col.get (i).getTipo()==r)
				cuantos ++;
		return cuantos;

	}

	//Dada una colecci�n de Veh�culos saber si tiene de todos los tipos

	public static boolean todosTipos(Vehiculo[] col) {

		return hayAlgunTipo(col,LibVehiculo.aire) && 
		hayAlgunTipo(col,LibVehiculo.mar) &&
		hayAlgunTipo(col,LibVehiculo.tierra);

	}
	//Dada una colecci�n de Veh�culos calcular el m�ximo(par�metro solo
	// la colecci�n)
	public static  Vehiculo maxCol (List <Vehiculo> col) {
		if (col.size()==0)
			return null;
		else {
			Vehiculo res = col.get(0);//Coger el primer vehiculo
			for (int i = 1 ; i < col.size(); i++) 
				if(res.compareTo(col.get(i)) <0)
					res = col.get(i);
			return res;

		}
	}

	public static  Vehiculo maxCol (Vehiculo [] col) {
		if (col.length == 0)
			return null;
		else {
			Vehiculo res = col[0];//Coger el primer vehiculo
			for (int i = 1 ; i < col.length; i++)// 
				if(res.compareTo(col [i]) <0)
					res = col [i];
			return res;

		}
	}
	//-----------------------------------------------------------//
	public static  Fecha maxCol1 (List <Fecha> col) {
		if (col.size()==0)
			return null;
		else {
			Fecha res = col.get(0);//Coger el primer vehiculo
			for (int i = 1 ; i < col.size(); i++) 
				if(res.compareTo(col.get(i)) <0)
					res = col.get(i);
			return res;

		}
	}
	public static  Fecha maxCol2 (Fecha [] col) {
		if (col.length == 0)
			return null;
		else {
			Fecha res = col [0];//Coger el primer vehiculo
			for (int i = 1 ; i < col.length; i++) 
				if(res.compareTo(col [i]) <0)
					res = col [i];
			return res;

		}
	}

	//-GENERICA PARA CALCULAR LOS M�XIMOS DE CUALQUIER CLASE-//

	public static  <E extends Comparable <E>> E maxCol3 (List <E> col) {
		if (col.size()==0)
			return null;
		else {
			E res = col.get(0);//Coger el primer vehiculo
			for (int i = 1 ; i < col.size(); i++) 
				if(res.compareTo(col.get(i)) <0)
					res = col.get(i);
			return res;

		}
	}

	public static  <E extends Comparable <E>> E maxCol5 (List <E> col) {
		if (col.size()==0)
			return null;
		else {
			E res = col.get(0);//Coger el primer vehiculo
			for (int i = 1 ; i < col.size(); i++) 
				if(res.compareTo(col.get(i)) <0)
					res = col.get(i);
			return res;

		}
	}
	public static  <E extends Comparable <E>> E maxCol5 (E [] col) {
		if (col.length == 0)
			return null;
		else {
			E res = col [0];//Coger el primer vehiculo
			for (int i = 1 ; i < col.length; i++) 
				if(res.compareTo(col [i]) <0)
					res = col [i];
			return res;

		}
	}


	public static  <E extends Comparable <E>> E minCol (List <E> col) {
		if (col.size()==0)
			return null;
		else {
			E res = col.get(0);//Coger el primer vehiculo
			for (int i = 1 ; i < col.size(); i++) 
				if(res.compareTo(col.get(i)) > 0) // MINIMO
					res = col.get(i);
			return res;

		}
	}
	public static  <E extends Comparable <E>> E minCol (E [] col) {
		if (col.length == 0)
			return null;
		else {
			E res = col [0];//Coger el primer vehiculo
			for (int i = 1 ; i < col.length; i++) 
				if(res.compareTo(col [i]) > 0)
					res = col [i];
			return res;

		}
	}


	//hay alg�n =0, minimo>0

	//A�ADIR DATOS A UNA LISTA
	public static void anadirRuedas(List <Vehiculo> col, int n) {
		for(int i=0;i<col.size();i++) {
			col.get(i).setRuedas(col.get(i).getRuedas()+n);

		}

	}

	public static void anadirRuedas(Vehiculo []col, int n) {
		for(int i=0;i<col.length;i++) {
			col [i].setRuedas(col [i].getRuedas()+n);

		}

	}

	// MAP !!! DEVOLVEMOS UNA LISTA DEL MISMO TAMA�O
	// APLICANDO UNA "EXP" A CADA ELEMENTO DE LA "col"
	public static List<String> losNombres (List<Vehiculo> col)
	{
		List<String> colRes = new ArrayList<String>();
		for (int i=0; i<col.size();i++)
			colRes.add(col.get(i).getNombre());
		return colRes;
	}

	public static void losNombres (List<Vehiculo> col, List<String> colRes)
	{
		for (int i=0; i<col.size();i++)
			colRes.add(col.get(i).getNombre());
	}

	public static List<Integer> losTipos (List<Vehiculo> col)
	{
		List<Integer> colRes = new ArrayList<Integer>();
		for (int i=0; i<col.size();i++)
			colRes.add(col.get(i).getTipo());
		return colRes;
	}
	public static List<NombreTipo> losNombreTipos (List<Vehiculo> col)
	{
		List<NombreTipo> colRes = new ArrayList<NombreTipo>();
		for (int i=0; i<col.size();i++)
		{
			String nombre =col.get(i).getNombre();
			int tipo = col.get(i).getTipo();
			colRes.add(new NombreTipo(nombre,tipo));
		}
		return colRes;
	}

	// FILTROS !!! DEVOLVEMOS UNA LISTA DEL MISMO TAMA�O
	// APLICANDO UNA "EXP" A CADA ELEMENTO DE LA "col"
	// Write Once Run ForEver
	public static List<Vehiculo> filtrarPorNombre (List<Vehiculo> col, String nombre)
	{
		List<Vehiculo> colRes = new ArrayList<Vehiculo>();
		for (int i=0; i<col.size();i++)
			if (col.get(i).getNombre().equals(nombre))
				colRes.add(col.get(i));
		return colRes;
	}

	public static void filtrarPorNombre (
			List<Vehiculo> col, 
			List<Vehiculo> colRes,
			String nombre
	)
	{
		for (int i=0; i<col.size();i++)
			if (col.get(i).getNombre().equals(nombre))
				colRes.add(col.get(i));
	}
	public static List<Vehiculo> filtrarPorTipo2 (
			List<Vehiculo> col, 
			int tipo)
			{
		List<Vehiculo> colRes = new ArrayList<Vehiculo>();
		for (int i=0; i<col.size();i++)
			if (col.get(i).getTipo() == tipo)
				colRes.add(col.get(i));
		return colRes;
			}

	public static void filtrarPorTipo (
			List<Vehiculo> col, 
			List<Vehiculo> colRes,
			int tipo
	)
	{
		for (int i=0; i<col.size();i++)
			if (col.get(i).getTipo() == tipo)
				colRes.add(col.get(i));
	}

	public static void filtrarPorTipo (
			List<Vehiculo> col, 
			int tipo
	)
	{
		for (int i=0; i<col.size();i++)
			if (col.get(i).getTipo() != tipo)
				col.remove(i);
	}

	public static void filtrarPorTipo (
			List<Vehiculo> col, 
			List<Vehiculo> colRes,
			int tipo,
			String nombre
	)
	{
		for (int i=0; i<col.size();i++)
		{
			String n =col.get(i).getNombre();
			int t = col.get(i).getTipo();
			if (t == tipo && n.equals(nombre))
				colRes.add(col.get(i));
		}
	}

	public static void filtrar (
			List<Vehiculo> col, 
			List<Vehiculo> colRes,
			Predicado<Vehiculo> pred
	)
	{
		for (int i=0; i<col.size();i++)
			if (pred.test(col.get(i)))
				colRes.add(col.get(i));

	}
}
