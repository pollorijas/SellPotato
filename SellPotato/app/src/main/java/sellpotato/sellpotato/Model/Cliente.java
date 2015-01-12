package sellpotato.sellpotato.Model;

import java.io.Serializable;

import sellpotato.sellpotato.Data.ClienteDB;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class Cliente extends Persona implements Serializable {

	private String descripcionHogar;
	private String direccion;
	private double fono;
	public Pedido m_Pedido;
	public Ruta m_Ruta;
    private ClienteDB clienteDB;
    private String userType;

    public Cliente(String rut, String pass) {
        super(rut, pass);
    }

    public void finalize() throws Throwable {
		super.finalize();
	}
	public String getdescripcionHogar(){
		return descripcionHogar;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcionHogar(String newVal){
		descripcionHogar = newVal;
	}

	public String getdireccion(){
		return direccion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdireccion(String newVal){
		direccion = newVal;
	}

	public double getfono(){
		return fono;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfono(double newVal){
		fono = newVal;
	}

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void GetCliente()
    {
        this.clienteDB.getCliente(this);
    }

}//end Cliente