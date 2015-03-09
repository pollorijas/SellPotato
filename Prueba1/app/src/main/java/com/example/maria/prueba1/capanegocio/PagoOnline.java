package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class PagoOnline extends Pago {

	private int numeroTransaccion;
	private int descripcionPago;
	public IPagoTransBank m_IPagoTransBank;

	public PagoOnline(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getnumeroTransaccion(){
		return numeroTransaccion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnumeroTransaccion(int newVal){
		numeroTransaccion = newVal;
	}

	public int getdescripcionPago(){
		return descripcionPago;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcionPago(int newVal){
		descripcionPago = newVal;
	}
}//end PagoOnline