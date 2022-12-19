package p3.javabean;

/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class UsuarioBean implements java.io.Serializable{
	
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario="";
	private String apellidosUsuario="";
	private String correoUsuario="";
	private String nickUsuario="";
	private String passwordUsuario="";
	private String permisosUsuario="";
	private String direccionUsuario="";
	
	/**
	 * Get
	 * @return nombreUsuario Devuelve el nombre de un usuario
	 */
	public String getNombreUsuario(){return nombreUsuario;}
	/**
	 * Get
	 * @return apellidosUsuario Devuelve los apellidos de un usuario
	 */
	public String getApellidosUsuario(){return apellidosUsuario;}
	/**
	 * Get
	 * @return correoUsuario Devuelve el correo de un usuario
	 */
	public String getCorreoUsuario(){return correoUsuario;}
	/**
	 * Get
	 * @return nickUsuario Devuelve el nick de un usuario
	 */
	public String getNickUsuario(){return nickUsuario;}
	/**
	 * Get
	 * @return passwordUsuario Devuelve la contraseÃ±a de un usuario
	 */
	public String getPasswordUsuario(){return passwordUsuario;}
	/**
	 * Get
	 * @return permisosUsuario Devuelve los permisos de un usuario
	 */
	public String getPermisosUsuario(){return permisosUsuario;}
	/**
	 * Get
	 * @return direccionUsuario Devuelve la direccion de un usuario
	 */
	public String getdireccionUsuario(){return direccionUsuario;}

	/**
	 * Set
	 * @param nameUser El nombre de un usuario
	 */
	public void setNombreUsuario(String nameUser){this.nombreUsuario=nameUser;}
	/**
	 * Set
	 * @param surnameUser Los apellidos de un usuario
	 */
	public void setApellidosUsuario(String surnameUser){this.apellidosUsuario=surnameUser;}
	/**
	 * Set
	 * @param emailUser El correo de un usuario
	 */
	public void setCorreoUsuario(String emailUser){this.correoUsuario=emailUser;}
	/**
	 * Set
	 * @param nickUser El nick de usuario
	 */
	public void setNickUsuario(String nickUser){this.nickUsuario=nickUser;}
	/**
	 * Set
	 * @param pwdUser La contraseña de un usuario
	 */
	public void setPasswordUsuario(String pwdUser){this.passwordUsuario=pwdUser;}
	/**
	 * Set
	 * @param perUser Los permisos de un usuario
	 */
	public void setPermisosUsuario(String perUser){this.permisosUsuario=perUser;}
	/**
	 * Set
	 * @param dirUser La direccion de un usuario
	 */
	public void setdireccionUsuario(String dirUser){this.direccionUsuario=dirUser;}

}
