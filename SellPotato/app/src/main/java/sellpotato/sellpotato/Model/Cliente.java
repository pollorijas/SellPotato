

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
}//end Cliente