package sellpotato.sellpotato.Model;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:26
 */
public class Ubicacion {

	private int fila;
	private int columna;
	private int nivel;
	public Paquete m_Paquete;
	public Camion m_Camion;

	public Ubicacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getfila(){
		return fila;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfila(int newVal){
		fila = newVal;
	}

	public int getcolumna(){
		return columna;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcolumna(int newVal){
		columna = newVal;
	}

	public int getnivel(){
		return nivel;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnivel(int newVal){
		nivel = newVal;
	}
}//end Ubicacion