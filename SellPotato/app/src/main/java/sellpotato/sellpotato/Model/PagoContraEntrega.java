

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:25
 */
public class PagoContraEntrega extends Pago {

	private int numeroboleta;

	public PagoContraEntrega(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getnumeroboleta(){
		return numeroboleta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnumeroboleta(int newVal){
		numeroboleta = newVal;
	}
}//end PagoContraEntrega