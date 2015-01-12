package sellpotato.sellpotato.Model;

import java.io.Serializable;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public abstract class Persona implements Serializable {

	private String apellido;
	private String nombre;
	private String rut;
    private String pass;

    protected Persona(String rut, String pass) {
        this.rut = rut;
        this.pass = pass;
    }

    public void finalize() throws Throwable {

	}

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setapellido(String newVal){
		apellido = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombre(String newVal){
		nombre = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setrut(String newVal){
		rut = newVal;
	}
}//end Persona