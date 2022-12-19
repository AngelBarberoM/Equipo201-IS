package p3.data.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import p3.business.UsuarioDto;
import p3.data.common.ConexionBD;
/** 
 * @author Jos� Carlos Cobos L�pez
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class UsuarioDao{
	
	/**
	 * Lista usuarios de la base de datos
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve la lista de todos los usuarios
	 */
	public ArrayList<UsuarioDto> listOfUsers(InputStream properties, ArrayList <String> credentials){
        ArrayList<UsuarioDto> listOfUsers=new ArrayList<UsuarioDto>();
        try {
            ConexionBD dbConnection=new ConexionBD();
            Connection connection=dbConnection.getConnection(credentials);
            
					
            String query="SELECT * FROM USUARIO_CURSO";
			
            Statement stmt=connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(query);

            while(rs.next()){
                String nombre=rs.getString("NOMBRE");
                String apellidos=rs.getString("APELLIDOS");
                String correo=rs.getString("CORREO");
                String nick=rs.getString("NICK");
                String password=rs.getString("PASSWORD");
                String permisos=rs.getString("PERMISOS");
                String direccion=rs.getString("DIRECCION");
                listOfUsers.add(new UsuarioDto(nombre, apellidos, nick, correo, password, permisos, direccion));
            }
            if(stmt!=null){ 
                stmt.close(); 
            }
            dbConnection.closeConnection();
        } 
        catch(Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        return listOfUsers;
    }
	
	/**
	 * Adicion de un usuario a la base de datos
	 * @param email El correo de un usuario
	 * @param nick El nombre de usuario
	 * @param password La contraseña de un usuario
	 * @param nombre El nombre de un usuario
	 * @param apellidos Los apellidos de un usuario
	 * @param permisos Los permisos de un usuario
	 * @param direccion La direccion de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 */
	public void addUser(String email, String nick, String password, String nombre, String apellidos, String permisos,String direccion, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO USUARIO_CURSO (CORREO, NICK, PASSWORD, NOMBRE, APELLIDOS, PERMISOS, DIRECCION) VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, nick);
			stmt.setString(3, password);
			stmt.setString(4, nombre);
			stmt.setString(5, apellidos);
			stmt.setString(6, permisos);
            stmt.setString(7, direccion);
			stmt.executeUpdate();

			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Informacion de un usuario de la base de datos
	 * @param email El correo de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve todos los datos del usuario con dicho email
	 */
	public UsuarioDto returnUser(String email, InputStream properties, ArrayList <String> credentials){
		UsuarioDto user=new UsuarioDto();
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);

			
			String query = "SELECT * FROM USUARIO_CURSO WHERE CORREO=";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query + "'" + email + "'");
			
			while(rs.next()){
				user.setNombre(rs.getString("NOMBRE"));
				user.setApellidos(rs.getString("APELLIDOS"));
				user.setCorreo(rs.getString("CORREO"));
				user.setNick(rs.getString("NICK"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setPermisos(rs.getString("PERMISOS"));
				user.setDireccion(rs.getString("DIRECCION"));
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Comprobar la existencia de un usuario con un email en la base de datos
	 * @param email El correo de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el correo de un usuario coincide con el email pasado como parametro y false en caso contrario
	 */
	public boolean checkEmail(String email, InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query = "SELECT CORREO FROM USUARIO_CURSO";

			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if(rs.getString("correo").equals(email)){
					result=true;
				}
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Comprobar la existencia de un usuario con cierto nick en la base de datos al modificarlo
	 * @param nick El nombre de usuario
	 * @param email El correo de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el nick de un usuario coincide con el nick pasado como parametro y false en caso contrario
	 */
	public boolean checkNickEmail(String nick, String email, InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query = "SELECT NICK FROM USUARIO_CURSO WHERE CORREO!=";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query + "'" + email + "'");

			while(rs.next()){
				if(rs.getString("nick").equals(nick)) {
					result=true;
				}
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Comprobar la existencia de un usuario con cierto nick en la base de datos
	 * @param nick El nombre de usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el nick de un usuario coincide con el nick pasado como parametro y false en caso contrario
	 */
	public boolean checkNick(String nick, InputStream properties, ArrayList <String> credentials) {
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT NICK FROM USUARIO_CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if(rs.getString("nick").equals(nick)){
					result=true;
				}
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Comprobar la existencia de un usuario en la base de datos
	 * @param email El correo de un usuario
	 * @param pwd La password de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el correo y la contraseña de un usuario coinciden con el email y la contraseña pasados como parametros y false en caso contrario
	 */
	public boolean checkUser(String email, String pwd, InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT CORREO, PASSWORD FROM USUARIO_CURSO WHERE CORREO=";

			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query + "'" + email + "'");
			
			while(rs.next()){
				if(rs.getString("correo").equals(email) && rs.getString("password").equals(pwd)){
					result=true;
				}
			}
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Actualizar datos usuario en la base de datos
	 * @param nombre El nombre de un usuario
	 * @param apellidos Los apellidos de un usuario
	 * @param nick El nombre de usuario
	 * @param password La contraseña de un usuario
	 * @param email El correo de un usuario
	 * @param direccion La direccion de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 */
	public void updateUser(String nombre, String apellidos, String nick, String password, String email, String direccion, InputStream properties, ArrayList <String> credentials){
		try {
			ConexionBD dbConnection = new ConexionBD();
			Connection connection = dbConnection.getConnection(credentials);
			
			String query="UPDATE USUARIO_CURSO SET NOMBRE=?, APELLIDOS=?, NICK=?, PASSWORD=?,DIRECCION=? WHERE CORREO=?";
			
			PreparedStatement stmt=(PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, nombre);
			stmt.setString(2, apellidos);
			stmt.setString(3, nick);
			stmt.setString(4, password);
			stmt.setString(5, email);
			stmt.setString(6, direccion);
			stmt.executeUpdate();
			
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	

	/**
	 * Obtener el identificador de un usuario de la base de datos
	 * @param email El email de un usuario
	 * @return Devuelve la identificacion de dicho usuario
	 */
	public int identificadorUsuario(String email, InputStream properties, ArrayList <String> credentials){
		int id=-1;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="SELECT ID_USUARIO, CORREO FROM USUARIO_CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery(query);

			while (rs.next()){
				if(rs.getString("CORREO").equals(email)){
					id=rs.getInt("ID_USUARIO");
				}
			}
			if(stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		}
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return id;
	}
	/**
	 * Comprobar la existencia de un usuario con los permisos de coordinador de cursos
	 * @param correo El correo de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el correo y los permisos son coordinador de cursos y false en caso contrario
	 */
	public boolean checkNombrecoordinadorCurso(String correo, InputStream properties, ArrayList <String> credentials) {
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM USUARIO_CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if(rs.getString("CORREO").equals(correo) && rs.getString("PERMISOS").equals("COORDINADORCURSO")){
					result=true;
				}
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Comprobar la existencia de un usuario con los permisos de coordinador de recursos
	 * @param correo El correo de un usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve true si el correo y los permisos son coordinador de recursos y false en caso contrario
	 */
	public boolean checkNombrecoordinadorRecurso(String correo, InputStream properties, ArrayList <String> credentials) {
		boolean result=false;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM USUARIO_CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if(rs.getString("CORREO").equals(correo) && rs.getString("PERMISOS").equals("COORDINADORRECURSO")){
					result=true;
				}
			}
			if(stmt!=null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return result;
	}
}