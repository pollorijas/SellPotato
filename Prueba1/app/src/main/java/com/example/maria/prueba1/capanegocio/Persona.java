package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public abstract class Persona {

	private String apellido;
	private String nombre;
	private String rut;
    private String password;

	public Persona(){

	}

	public String getapellido(){
		return apellido;
	}

	public String getnombre(){
		return nombre;
	}

	public String getrut(){
		return rut;
	}

	public void setapellido(String newVal){
		apellido = newVal;
	}

	public void setnombre(String newVal){
		nombre = newVal;
	}

	public void setrut(String newVal){
		rut = newVal;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}//end Persona