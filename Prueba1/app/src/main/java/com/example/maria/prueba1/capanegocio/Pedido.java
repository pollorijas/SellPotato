package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Pedido {

	private String fechaAnulacion;
	private String fechaEntrega;
	private int idPedido;
	private String fechaSolicitud;
	private int monto;
	private String estadoPedido;
	public Paquete m_Paquete;

	public Pedido(){

	}

	public void finalize() throws Throwable {

	}
	public int getidPedido(){
		return idPedido;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setidPedido(int newVal){
		idPedido = newVal;
	}

	public String getFechaSolicitud(){
		return fechaSolicitud;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaSolicitud(String newVal){
		fechaSolicitud = newVal;
	}

	public String getfechaEntrega(){
		return fechaEntrega;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaEntrega(String newVal){
		fechaEntrega = newVal;
	}

	public int getmonto(){
		return monto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmonto(int newVal){
		monto = newVal;
	}

	public String getfechaAnulacion(){
		return fechaAnulacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaAnulacion(String newVal){
		fechaAnulacion = newVal;
	}

	public String getestadoPedido(){
		return estadoPedido;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setestadoPedido(String newVal){
		estadoPedido = newVal;
	}
}//end Pedido