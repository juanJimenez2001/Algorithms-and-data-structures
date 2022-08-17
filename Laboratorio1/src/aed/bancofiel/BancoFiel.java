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
		  if(id.contentEquals(idCuentas)) {
			  existe=true;
			  n=i;
		  }
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
		  this.cuentas.get(n).ingresar(cantidad);
		  balance=this.cuentas.get(n).getSaldo();
	  }
	  else
		  throw new CuentaNoExisteExc();
	  return balance;
  }//ingresarDinero
  
  public int retirarDinero(String id, int cantidad) throws CuentaNoExisteExc, InsuficienteSaldoExc{//retirarDinero
	  int n=BuscarCuenta(id);
	  int balance=0;
	  if(n!=-1) {
		  if(this.cuentas.get(n).getSaldo()>=cantidad) {
			  this.cuentas.get(n).retirar(cantidad);
		      balance=this.cuentas.get(n).getSaldo();
		  }
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
	  int From=BuscarCuenta(idFrom);
	  int To=BuscarCuenta(idTo);
	  if(From!=-1) {
		  if(To!=-1) {
			  retirarDinero(idFrom,cantidad);
			  ingresarDinero(idTo,cantidad);
		  }
		  else
			  throw new CuentaNoExisteExc(); 
	  }
	  else
		  throw new CuentaNoExisteExc();
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
  
  public IndexedList<Cuenta> getCuentasOrdenadas(Comparator<Cuenta> cmp){//getCuentasOrdenadas
	 IndexedList<Cuenta> list = cuentas;
	 Cuenta aux=null;
	 for(int i=0; i<list.size();i++) {
		 for(int j=0; j<list.size()-1;j++) {
			 if(cmp.compare(list.get(j), list.get(j+1))>0) {
				 aux=list.get(j);
				 list.set(j, list.get(j+1));
				 list.set(j+1, aux);
			 }
		 }
	 }
	 return list;
  }//getCuentasOrdenadas
  
  public String toString() {
    return "banco";
  }
  
}



