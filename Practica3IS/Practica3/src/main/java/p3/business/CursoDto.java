package p3.business;

/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class CursoDto{
	
	/**
 	* Variables
 	*/
	protected String nombre;
	protected String descripcion;
	protected String coordinadorCurso;
	protected String coordinadorRecursos;
	protected Float nota;
	/**
	 * Constructor
	 */
	public CursoDto(){}
	
	/**
	 * 
	 * @param nombre El nombre del curso
	 * @param descripcion La descripcion del curso
	 * @param coordinadorCurso El coordinador  del curso
	 * @param coordinadorRecursos El coordinador de recurso
	 * @param nota La valoracion del curso
	 */
	public CursoDto(String nombre, String descripcion, String coordinadorCurso, String coordinadorRecursos, Float nota){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.coordinadorCurso=coordinadorCurso;
		this.coordinadorRecursos=coordinadorRecursos;
		this.nota=nota;
	}
	
	/**
	 * Get
	 * @return Devuelve el nombre del curso
	 */
	public String getNombre(){return this.nombre;}
	/**
	 * Get
	 * @return Devuelve la descripcion del curso
	 */
	public String getDescripcion(){return this.descripcion;}
	/**
	 * Get
	 * @return Devuelve el coordinador del curso
	 */
	public String getCoordinadorCurso(){return this.coordinadorCurso;}
	/**
	 * Get
	 * @return Devuelve el coordinador de recurso
	 */
	public String getCoordinadorRecursos(){return this.coordinadorRecursos;}
	/**
	 * Get
	 * @return Devuelve la  valoracion del curso
	 */
	public Float getNota(){return this.nota;}
	/**
	 * Set
	 * @param nombre El nombre del curso
	 */
	public void setNombre(String nombre){this.nombre=nombre;}
	/**
	 * Set
	 * @param descripcion La descripcion de un curso
	 */
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
	/**
	 * Set
	 * @param coordinadorCurso El coordinador de cursos
	 */
	public void setCoordinadorCurso(String coordinadorCurso){this.coordinadorCurso=coordinadorCurso;}
	/**
	 * Set
	 * @param coordinadorRecursos El coordinador de recursos 
	 */
	public void setCoordinadorRecursos(String coordinadorRecursos){this.coordinadorRecursos=coordinadorRecursos;}
	/**
	 * Set
	 * @param nota la valoracion de un curso
	 */
	public void setNota(Float nota){this.nota= nota;}

}