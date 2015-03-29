package com.example.maria.prueba1.capanegocio;

import com.example.maria.prueba1.capadatos.RutaDB;

import java.util.ArrayList;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Ruta {

	private String fechaSalida;
	private String HoraSalida;
	private String horaLlegada;
	private int idRuta;
	private IGoogleApiMaps m_IGoogleApiMaps;
    private ArrayList<Cliente> clientes;
    private RutaDB rutaDB;

	public Ruta(){
        clientes =  new ArrayList<Cliente>();
	}

	public void finalize() throws Throwable {

	}
	public String getfechaSalida(){
		return fechaSalida;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaSalida(String newVal){
		fechaSalida = newVal;
	}

	public String getHoraSalida(){
		return HoraSalida;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHoraSalida(String newVal){
		HoraSalida = newVal;
	}

	public String gethoraLlegada(){
		return horaLlegada;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethoraLlegada(String newVal){
		horaLlegada = newVal;
	}

	public int getidRuta(){
		return idRuta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setidRuta(int newVal){
		idRuta = newVal;
	}

	public void GenerarRuta(){

	}

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RutaDB getRutaDB() {
        return rutaDB;
    }

    public void setRutaDB(RutaDB rutaDB) {
        this.rutaDB = rutaDB;
    }
}//end Ruta