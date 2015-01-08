package sellpotato.sellpotato.Model;

/**
 * @author Freddy
 * @version 1.0
 * @created 08-ene-2015 19:29:24
 */
public class Camion {

	private String patente;
	private int Dimencion;
	private int tara;
	private String marca;
	private String modelo;
	public Repartidor m_Repartidor;

	public Camion(){

	}

	public void finalize() throws Throwable {

	}
	public String getpatente(){
		return patente;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpatente(String newVal){
		patente = newVal;
	}

	public int getDimencion(){
		return Dimencion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDimencion(int newVal){
		Dimencion = newVal;
	}

	public int gettara(){
		return tara;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settara(int newVal){
		tara = newVal;
	}

	public String getmarca(){
		return marca;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmarca(String newVal){
		marca = newVal;
	}

	public String getmodelo(){
		return modelo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmodelo(String newVal){
		modelo = newVal;
	}
}//end Camion