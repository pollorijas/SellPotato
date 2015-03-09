package com.example.maria.prueba1.capanegocio;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public abstract class Pago {

	private int total_pagar;
	private String fechadePago;
	private int id_Pago;
	private Pedido m_Pedido;

	public Pago(){

	}

	public void finalize() throws Throwable {

	}
	public int gettotal_pagar(){
		return total_pagar;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settotal_pagar(int newVal){
		total_pagar = newVal;
	}

	public String getfechadePago(){
		return fechadePago;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechadePago(String newVal){
		fechadePago = newVal;
	}

	public int getid_Pago(){
		return id_Pago;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setid_Pago(int newVal){
		id_Pago = newVal;
	}

    public Pedido getM_Pedido() {
        return m_Pedido;
    }

    public void setM_Pedido(Pedido m_Pedido) {
        this.m_Pedido = m_Pedido;
    }
}//end Pago