package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class Bodeguero extends Persona {

	private String direccionLocal;
	private String nombreLocal;

	public Bodeguero(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getnombreLocal(){
		return nombreLocal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreLocal(String newVal){
		nombreLocal = newVal;
	}

	public String getdireccionLocal(){
		return direccionLocal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdireccionLocal(String newVal){
		direccionLocal = newVal;
	}
}//end Bodeguero