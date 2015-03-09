package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class DetallePedido {

	private int cantidadVedida;
	private int precioVenta;
    private int id_detalle;
	private Producto m_Producto;
    private Pedido m_Pedido;

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
	public void setrecioVenta(int newVal){
		precioVenta = newVal;
	}

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Producto getM_Producto() {
        return m_Producto;
    }

    public void setM_Producto(Producto m_Producto) {
        this.m_Producto = m_Producto;
    }

    public Pedido getM_Pedido() {
        return m_Pedido;
    }

    public void setM_Pedido(Pedido m_Pedido) {
        this.m_Pedido = m_Pedido;
    }
}//end DetallePedido