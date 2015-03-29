package com.example.maria.prueba1.capanegocio;

import com.example.maria.prueba1.capadatos.CamionDB;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class Camion {

	private String patente;
	private int Dimencion;
	private int tara;
	private String marca;
	private String modelo;
	private Repartidor m_Repartidor;
    private CamionDB data;

	public Camion(){
        data = new CamionDB();
	}

	public void finalize() throws Throwable {

	}
	public String getpatente(){
		return patente;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpatente(String newVal){
		patente = newVal;
	}

	public int getDimencion(){
		return Dimencion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDimencion(int newVal){
		Dimencion = newVal;
	}

	public int getcarga(){
		return tara;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcarga(int newVal){
		tara = newVal;
	}

	public String getmarca(){
		return marca;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmarca(String newVal){
		marca = newVal;
	}

	public String getmodelo(){
		return modelo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmodelo(String newVal){
		modelo = newVal;
	}

    public Repartidor getM_Repartidor() {
        return m_Repartidor;
    }

    public void setM_Repartidor(Repartidor m_Repartidor) {
        this.m_Repartidor = m_Repartidor;
    }

    public CamionDB getData() {
        return data;
    }

    public void setData(CamionDB data) {
        this.data = data;
    }
}//end Camion