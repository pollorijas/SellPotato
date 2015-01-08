package sellpotato.sellpotato.Model;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class Producto {

	private int idProducto;
	private String descripcion;
	private String nombreProducto;
	private int stock;
	private int precio;

	public Producto(){

	}

	public void finalize() throws Throwable {

	}
	public int getidProducto(){
		return idProducto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setidProducto(int newVal){
		idProducto = newVal;
	}

	public String getdescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

	public String getnombreProducto(){
		return nombreProducto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreProducto(String newVal){
		nombreProducto = newVal;
	}

	public int getstock(){
		return stock;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstock(int newVal){
		stock = newVal;
	}

	public int getprecio(){
		return precio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setprecio(int newVal){
		precio = newVal;
	}
}//end Producto