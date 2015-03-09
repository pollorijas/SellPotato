package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Paquete {

	private int idPaquete;
	private String fechaArmado;
	private String fechaEmbarque;
	public Bodeguero m_Bodeguero;
	public Producto m_Producto;

	public Paquete(){

	}

	public void finalize() throws Throwable {

	}
	public int getidPaquete(){
		return idPaquete;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setidPaquete(int newVal){
		idPaquete = newVal;
	}

	public String getfechaArmado(){
		return fechaArmado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaArmado(String newVal){
		fechaArmado = newVal;
	}

	public String getfechaEmbarque(){
		return fechaEmbarque;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaEmbarque(String newVal){
		fechaEmbarque = newVal;
	}
}//end Paquete