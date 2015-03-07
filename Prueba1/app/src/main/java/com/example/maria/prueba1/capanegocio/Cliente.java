package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class Cliente extends Persona {

	private String descripcionHogar;
	private String direccion;
	private double fono;
	public Pedido m_Pedido;
	public Ruta m_Ruta;

	public Cliente(){

	}

    public Cliente(String nombre,String apellido, String rut, String descripcionHogar, String direccion, double fono)
    {

        this.setnombre(nombre);
        this.setapellido(apellido);
        this.setrut(rut);
        this.setdescripcionHogar(descripcionHogar);
        this.setdireccion(direccion);
        this.setfono(fono);

    }


	public String getdescripcionHogar(){
		return descripcionHogar;
	}

	public void setdescripcionHogar(String newVal){
		descripcionHogar = newVal;
	}

	public String getdireccion(){
		return direccion;
	}

	public void setdireccion(String newVal){
		direccion = newVal;
	}

	public double getfono(){
		return fono;
	}

	public void setfono(double newVal){
		fono = newVal;
	}


}//end Cliente