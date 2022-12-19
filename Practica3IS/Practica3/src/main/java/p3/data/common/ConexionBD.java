package p3.data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */
public class ConexionBD{
	
	protected Connection connection=null;
	 
	/**
	 * Obtener conexion con la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return connection Devuelve la conexion
	 */
	public Connection getConnection(java.util.ArrayList <String> credentials){
		String url=credentials.get(0);
		String user=credentials.get(1);
		String password=credentials.get(2);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		} 
		catch(SQLException e){
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;		
	}
	
	/**
	 * Cerrar conexion con la base de datos
	 */
	public void closeConnection(){
		try{
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} 
		catch(SQLException e){
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}
