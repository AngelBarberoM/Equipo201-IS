package p3.javabean;


/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class CursoBean implements java.io.Serializable{
	
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private String nombreCurso="";
	private String descripcionCurso="";
	private String coordinadorCurso="";
	private String coordinadorRecurso="";
	
	/**
	 * Get
	 * @return nombreCurso Devuelve el nombre de un curso
	 */
	public String getnombreCurso(){return nombreCurso;}
	/**
	 * Get
	 * @return descripcionCurso Devuelve la descripcion de un curso
	 */
	public String getdescripcionCurso(){return descripcionCurso;}
	/**
	 * Get
	 * @return coordinadorCurso Devuelve el coordinador de un curso de un curso
	 */
	public String getcoordinadorCurso(){return coordinadorCurso;}
	/**
	 * Get
	 * @return coordinadorRecurso Devuelve el coordinador de un recurso de un curso
	 */
	public String getcoordinadorRecurso(){return coordinadorRecurso;}

	/**
	 * Set
	 * @param titleCurse El nombre del curso
	 */
	public void setnombreCurso(String titleCurse){this.nombreCurso=titleCurse;}
	/**
	 * Set
	 * @param descriptionCurse La descripcion de un curso
	 */
	public void setdescripcionCurso(String descriptionCurse){this.descripcionCurso=descriptionCurse;}
	/**
	 * Set
	 * @param coordinatorCurse El coordinador del curso
	 */
	public void setcoordinadorCurso(String coordinatorCurse){this.coordinadorCurso=coordinatorCurse;}
	/**
	 * Set
	 * @param coordinatorResource El coordinador del recursos
	 */
	public void setcoordinadorRecurso(String coordinatorResource){this.coordinadorRecurso=coordinatorResource;}


}