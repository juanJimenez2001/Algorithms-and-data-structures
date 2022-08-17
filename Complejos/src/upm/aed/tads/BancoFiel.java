package aed.bancofiel;

import java.util.Comparator;
import es.upm.aedlib.indexedlist.IndexedList;
import es.upm.aedlib.indexedlist.ArrayIndexedList;


/**
 * Implements the code for the bank application.
 * Implements the client and the "gestor" interfaces.
 */
public class BancoFiel implements ClienteBanco, GestorBanco {

  // NOTAD. No se deberia cambiar esta declaracion.
  public IndexedList<Cuenta> cuentas;

  // NOTAD. No se deberia cambiar esta constructor.
  public BancoFiel() {
    this.cuentas = new ArrayIndexedList<Cuenta>();
  }
  
  public String crearCuenta(String dni, int saldoIncial) {//Crear Cuenta
	 Cuenta cuenta=new Cuenta(dni,saldoIncial); 
	 this.cuentas.add(this.cuentas.size(), cuenta);
	 return cuenta.getId();
  }//Crear Cuenta
  
  private int BuscarCuenta(String id){//BuscarCuenta
	  int i=0;
	  int n=-1;
	  boolean existe=false;
	  while(i<this.cuentas.size() && !existe) {
		  String idCuentas=this.cuentas.get(i).getId();
	      existe=id.contentEquals(idCuentas);
	      n=i;
		  i++;
	  }
	  return n;
  }//BuscarCuenta
  
  public void borrarCuenta(String id) throws CuentaNoExisteExc, CuentaNoVaciaExc{//borrarCuenta
	  int n=BuscarCuenta(id);
	  if(n!=-1) {
		  if(this.cuentas.get(n).getSaldo()==0)
			  this.cuentas.remove(this.cuentas.get(n));
		  else
			  throw new CuentaNoVaciaExc();
	  }
	  else
		  throw new CuentaNoExisteExc();
  }//borrarCuenta

  public int ingresarDinero(String id, int cantidad) throws CuentaNoExisteExc{//ingresarDinero
	  int n=BuscarCuenta(id);
	  int balance=0;
	  if(n!=-1) {
		  balance=this.cuentas.get(n).getSaldo()+cantidad;
	  }
	  else
		  throw new CuentaNoExisteExc();
	  return balance;
  }//ingresarDinero
  
  public int retirarDinero(String id, int cantidad) throws CuentaNoExisteExc, InsuficienteSaldoExc{//retirarDinero
	  int n=BuscarCuenta(id);
	  int balance=0;
	  if(n!=-1) {
		  if(this.cuentas.get(n).getSaldo()>=cantidad)
			  balance=this.cuentas.get(n).getSaldo()-cantidad;
		  else
			  throw new InsuficienteSaldoExc();
	  }
	  else
		  throw new CuentaNoExisteExc();
	  return balance;
  }//retirarDinero
  
  public int consultarSaldo(String id) throws CuentaNoExisteExc{//consultarSaldo
	  int n=BuscarCuenta(id);
	  int balance=0;
	  if(n!=-1) {
		  balance=this.cuentas.get(n).getSaldo();
	  }
	  else
		  throw new CuentaNoExisteExc();
	  return balance;
  }//consultarSaldo
  
  public void hacerTransferencia(String idFrom, String idTo, int cantidad)throws CuentaNoExisteExc, InsuficienteSaldoExc{//hacerTransferencia
	  retirarDinero(idFrom,cantidad);
	  ingresarDinero(idTo,cantidad);
  }//hacerTransferencia
  
  private IndexedList<Integer> BuscarDNI(String dni){//BuscarDNI
	  int i=0;
	  int n=0;
	  IndexedList<Integer> list = new ArrayIndexedList<Integer>();
	  while(i<this.cuentas.size()) {
		  String dniCuentas=this.cuentas.get(i).getDNI();
		  if(dniCuentas.contentEquals(dni)) {
			  list.add(n, i);
			  n++;
		  }
		  i++;
	  }
	  return list;
  }//BuscarDNI
  
  public IndexedList<String> getIdCuentas(String dni){//getIdCuentas
	  IndexedList<Integer> list = BuscarDNI(dni);
	  IndexedList<String> listaCuentas = new ArrayIndexedList<String>();
	  int i=0;
	  while(i<list.size()) {
		  listaCuentas.add(i, this.cuentas.get(list.get(i)).getId());
		  i++;
	  }
	  return listaCuentas;
  }//getIdCuentas
  
  public int getSaldoCuentas(String dni){//getSaldoCuentas
	  IndexedList<String> list = getIdCuentas(dni);
	  int i=0;
	  int saldo=0;
	  while(i<list.size()) {
		  saldo=saldo+this.cuentas.get(BuscarCuenta(list.get(i))).getSaldo();
		  i++;
	  }
	  return saldo;
  }//getSaldoCuentas
  
  public IndexedList<Cuenta> getCuentasOrdenadas(Comparator<Cuenta> cmp){
	 IndexedList<Cuenta> list = new ArrayIndexedList<Cuenta>();
	 for(int i=0;i<this.cuentas.size();i++) {
		  int inicio=0;
		  int Final=list.size()-1;
		  int medio=(inicio+Final)/2;
		  boolean salir=false;
		  while(!salir) {
			  if(cmp.compare(cuentas.get(i),list.get(medio))==0) {
				  list.add(medio,cuentas.get(i));
				  salir=true;
			  }
			  else if(inicio==Final) {
				  salir=true;
				  list.add(Final,cuentas.get(i));
			  }
			  else if(cmp.compare(cuentas.get(i),list.get(medio))>0) {
				  inicio=medio+1;
				  medio=(inicio+Final)/2;
			  }
			  else {
				  Final=medio-1;
				  medio=(inicio+Final)/2; 
			  }
		  }	  
	 }
	 return list;
  }
  
  public String toString() {
    return "banco";
  }
  
}



