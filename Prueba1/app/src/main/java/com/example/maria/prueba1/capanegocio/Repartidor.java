package com.example.maria.prueba1.capanegocio;

import com.example.maria.prueba1.capadatos.RepartidorDB;

import java.util.ArrayList;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Repartidor extends Persona {

	private String estado;
	private String licenciaConducir;
	private Ruta m_Ruta;
    private RepartidorDB repartidorDB;
    private ArrayList<Camion> camions;

	public Repartidor(){

        camions = new ArrayList<Camion>();

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

    public Ruta getM_Ruta() {
        return m_Ruta;
    }

    public void setM_Ruta(Ruta m_Ruta) {
        this.m_Ruta = m_Ruta;
    }

    public RepartidorDB getRepartidorDB() {
        return repartidorDB;
    }

    public void setRepartidorDB(RepartidorDB repartidorDB) {
        this.repartidorDB = repartidorDB;
    }

    public ArrayList<Camion> getCamions() {
        return camions;
    }

    public void setCamions(ArrayList<Camion> camions) {
        this.camions = camions;
    }
}//end Repartidor