package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Repartidor extends Persona {

	private String estado;
	private String licenciaConducir;
	public Ruta m_Ruta;

	public Repartidor(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getlicenciaConducir(){
		return licenciaConducir;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setlicenciaConducir(String newVal){
		licenciaConducir = newVal;
	}

	public String getestado(){
		return estado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setestado(String newVal){
		estado = newVal;
	}
}//end Repartidor