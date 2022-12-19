package p3.business;

/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class IdentificadorDto{
	
	/**
 	* Variables
 	*/
	protected String identificador;

	/**
	 * Constructor
	 */
	public IdentificadorDto(){}
	
	/**
	 * 
	 * @param identificador El identificador del curso
	 */
	public IdentificadorDto(String identificador){
		this.identificador=identificador;

	}
	
	/**
	 * Get
	 * @return Devuelve el identificador del curso
	 */
	public String getIdentificador(){return this.identificador;}

	/**
	 * Set
	 * @param Identificadro El identificador del curso
	 */
	public void setIdentificador(String identificador){this.identificador=identificador;}


}