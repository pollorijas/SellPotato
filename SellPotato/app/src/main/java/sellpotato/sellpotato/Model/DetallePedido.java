package sellpotato.sellpotato.Model;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class DetallePedido {

	private int cantidadVedida;
	private int precioVenta;
	public Producto m_Producto;
	public Pedido m_Pedido;

	public DetallePedido(){

	}

	public void finalize() throws Throwable {

	}
	public int getcantidadVedida(){
		return cantidadVedida;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcantidadVedida(int newVal){
		cantidadVedida = newVal;
	}

	public int getrecioVenta(){
		return precioVenta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setprecioVenta(int newVal){
		precioVenta = newVal;
	}
}//end DetallePedido