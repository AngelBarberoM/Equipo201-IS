package p3.business;

/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class UsuarioDto{
	
	/**
	 * Variables
	 */
	protected String nombre;
	protected String apellidos;
	protected String nick;
	protected String password;
	protected String correo;
	protected String permisos;
	protected String direccion;
	
	/**
	 * Constructores
	 */
	public UsuarioDto(){}
	/**
	 * 
	 * @param nombre El nombre del usuario
	 * @param apellidos Los apellidos del usuario
	 * @param nick El nombre de usuario 
	 * @param password La password del usuario
	 * @param correo El  correo de un usuario
	 * @param permisos Los permisos de un usuario
	 * @param direccion La direccion de un usuario 
	 */
	public UsuarioDto(String nombre, String apellidos, String nick, String password, String correo, String permisos, String direccion){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.nick=nick;
		this.password=password;
		this.correo=correo;
		this.permisos=permisos;
		this.direccion=direccion;
	}
	/**
	 * Get
	 * @return nombre Devuelve el nombre del usuario
	 *
	 */
	public String getNombre(){return this.nombre;}
	/**
	 * Get
	 * @return apellidos Devuelve los apellidos del usuario
	 *
	 */
	public String getApellidos(){return this.apellidos;}
	/**
	 * Get
	 * @return nick Devuelve el nick de usuario 
	 *
	 */
	public String getNick(){return this.nick;}
	/**
	 * Get
	 * @return password Devuelve La contraseÃ±a del usuario
	 *
	 */
	public String getPassword(){return this.password;}
	/**
	 * Get
	 * @return correo Devuelve el correo de un usuario
	 *
	 */
	public String getCorreo(){return this.correo;}
	/**
	 * Get
	 * @return permisos Devuelve los permisos de un usuario
	 *
	 */
	public String getPermisos(){return this.permisos;}
	
	/**
	 * Get
	 * @return direccion Devuelve la direccion de un usuario
	 *
	 */
	public String getDireccion(){return this.direccion;}
	
	/**
	 * Set
	 * @param nombre El nombre del usuario 
	 */
	public void setNombre(String nombre){this.nombre=nombre;}
	/**
	 * Set
	 * @param apellidos Los apellidos del usuario 
	 */
	public void setApellidos(String apellidos){this.apellidos=apellidos;}
	/**
	 * Set
	 * @param nick Nombre de usuario de la persona 
	 */
	public void setNick(String nick){this.nick=nick;}
	/**
	 * Set
	 * @param password Password del usuario 
	 */
	public void setPassword(String password){this.password=password;}
	/**
	 * Set
	 * @param correo El correo de un usuario
	 */
	public void setCorreo(String correo){this.correo=correo;}
	/**
	 * Set
	 * @param permisos Los permisos de un usuario
	 */
	public void setPermisos(String permisos){this.permisos=permisos;}
	/**
	 * Set
	 * @param direccion La direccion de un usuario
	 */
	public void setDireccion(String direccion){this.direccion=direccion;}

}
