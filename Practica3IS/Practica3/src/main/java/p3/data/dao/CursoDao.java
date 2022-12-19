package p3.data.dao;


import java.io.InputStream;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import p3.business.CursoDto;
import p3.business.IdentificadorDto;
import p3.business.UsuarioDto;
import p3.data.common.ConexionBD;

/** 
 * @author José Carlos Cobos López
 * @author Angel barbero Mellado
 * @author Sergio Garcia Leiva
 */

public class CursoDao{
	/**
	 * Obtener el identificador de un curso de la base de datos
	 * @param nombre El nombre de un curso
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return id Devuelve el identificador de dicho curso
	 */
	public int identificador(String nombre, InputStream properties, ArrayList <String> credentials){
		int id=-1;
		try {
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="SELECT ID_CURSO, NOMBRE FROM CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery(query);

			while (rs.next()){
				if(rs.getString("NOMBRE").equals(nombre)){
					id=rs.getInt("ID_CURSO");
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
	 * Comprobar la existencia de un curso con el mismo nombre en la base de datos
	 * @param nombre El nombre de un curso
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return result Booleano que devuelve false si ya hay un curso con ese nombre y true en caso contrario
	 */
	public boolean checkNombreCurso(String nombre, InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT NOMBRE FROM CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if(rs.getString("NOMBRE").equals(nombre)){
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
	 * Comprobar la existencia del coordinador de recursos en un curso en la base de datos
	 * @param idUsuario El identificador del usuario
	 * @param idCurso El identificador del curso
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return result Booleano que devuelve true si existe el coordinador de recursos en ese curso y false en el caso contrario
	 */
	public boolean checkcoordinadorrecursos(int idUsuario, int idCurso,InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==idCurso) && (rs.getInt("ID_COORDINADOR_RECURSO")==idUsuario)){
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
	 * Comprobar la existencia del coordinador de cursos en un curso en la base de datos
	 * @param idUsuario El identificador del usuario
	 * @param idCurso El identificador del curso
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return result Booleano que devuelve true si existe el coordinador de cursos en ese curso y false en el caso contrario
	 */
	public boolean checkcoordinadorcursos(int idUsuario, int idCurso,InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==idCurso) && (rs.getInt("ID_COORDINADOR_CURSO")==idUsuario)){
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
	 * Adicion de un recurso a la base de datos
	 * @param idCurso El identificador de un curso
	 * @param recurso El recurso de un curso
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 */
	public void addRecurso(int idCurso, String recurso, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO RECURSOS (ID_CURSO, RECRUSOS) VALUES(?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setInt(1, idCurso);
			stmt.setString(2, recurso);
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
	 * Adicion de un ponente a la base de datos
	 * @param idCurso El identificador de un curso
	 * @param ponente El ponente de un curso
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 */
	public void addPonentes(int idCurso, String ponente, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO PONENTES (ID_CURSO, PONENTES) VALUES(?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setInt(1, idCurso);
			stmt.setString(2, ponente);
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
	 * Comprobar la existencia de un alumno inscrito en un curso en la base de datos
	 * @param identificadorCurso El identificador del curso
	 * @param identificadorUsuario El identificador del usuario
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return result Booleano que devuelve true si existe alumno inscrito a un curso y false en el caso contrario
	 */
	public boolean checkinscrito(int identificadorCurso, int identificadorUsuario,InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM NUMERO_INSCRITOS";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==identificadorCurso) && (rs.getInt("ID_USUARIO")==identificadorUsuario)){
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
	 * Comprobar que el alumno a valorado ya un curso en la base de datos
	 * @param identificadorUsuario El identificador del usuario
	 * @param identificadorCurso El identificador del curso
	 * @param properties Archivo de propiedades de la base de datos
     * @param credentials Credenciales de la base de datos
	 * @return result Booleano que devuelve true si el alumno a valorado ya un curso y false en el caso contrario
	 */
	public boolean comprobarvotacion(int identificadorUsuario, int identificadorCurso,InputStream properties, ArrayList <String> credentials){
		boolean result=false;
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM VALORACION_CURSO";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==identificadorCurso) && (rs.getInt("ID_USUARIO")==identificadorUsuario)){
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
	 * Adicion de una valoracion de un cruso a la base de datos
	 * @param id_usuario El identificador de un usuario
	 * @param id_curso El identificador de un curso
	 * @param valoracion La valoracion del usuario
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 */
	public void addValoracion(int id_usuario, int id_curso, int valoracion, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO VALORACION_CURSO (ID_CURSO, ID_USUARIO, VALORACION) VALUES(?,?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setInt(1, id_curso);
			stmt.setInt(2, id_usuario);
			stmt.setInt(3, valoracion);
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
	 * Lista cursos de la base de datos
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve la lista de todos los cursos
	 */
	public ArrayList<CursoDto> listOfCurses(InputStream properties, ArrayList <String> credentials){
        ArrayList<CursoDto> listOfCurses=new ArrayList<CursoDto>();
        try {
            ConexionBD dbConnection=new ConexionBD();
            Connection connection=dbConnection.getConnection(credentials);
            
					
            String query="SELECT * FROM CURSO";
			
            Statement stmt=connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(query);
            String coordinadorcurso="Coordinador del curso";
            String coordinadorrecurso="Coordinador del recuros";
            while(rs.next()){
                String nombre=rs.getString("NOMBRE");
                String descripcion=rs.getString("DESCRIPCION");
                int id_coordinadorcurso=rs.getInt("ID_COORDINADOR_CURSO");
                int id_coordinadorrecurso=rs.getInt("ID_COORDINADOR_RECURSO");
                float nota=rs.getInt("NOTA");
                String query2="SELECT ID_USUARIO,CORREO FROM USUARIO_CURSO";
    			
                stmt=connection.createStatement();
                ResultSet rs2=(ResultSet)stmt.executeQuery(query2);
                while(rs2.next()){
                	if((rs2.getInt("ID_USUARIO")==id_coordinadorcurso)){
                		coordinadorcurso=rs2.getString("CORREO");
    				}
                	else if(rs2.getInt("ID_USUARIO")==id_coordinadorrecurso)
                	{
                		coordinadorrecurso=rs2.getString("CORREO");
                	}
                	
            }
                listOfCurses.add(new CursoDto(nombre, descripcion, coordinadorcurso, coordinadorrecurso,nota));
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
        return listOfCurses;
    }
	
	/**
	 * Lista cursos inscritos de la base de datos
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve la lista de todos los cursos inscritos
	 */
	public ArrayList<CursoDto> listOfCursesinscritos(int identificador, InputStream properties, ArrayList <String> credentials){
        ArrayList<CursoDto> listOfCursesinscritos=new ArrayList<CursoDto>();
        try {
            ConexionBD dbConnection=new ConexionBD();
            Connection connection=dbConnection.getConnection(credentials);
            
					
            String query="SELECT * FROM CURSO WHERE ID_CURSO=";
            String coordinadorcurso="Coordinador del curso";
            String coordinadorrecurso="Coordinador del recuros";
            Statement stmt=connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(query+identificador);

            while(rs.next()){
                String nombre=rs.getString("NOMBRE");
                String descripcion=rs.getString("DESCRIPCION");
                int id_coordinadorcurso=rs.getInt("ID_COORDINADOR_CURSO");
                int id_coordinadorrecurso=rs.getInt("ID_COORDINADOR_RECURSO");
                float nota=rs.getInt("NOTA");
                String query2="SELECT * FROM USUARIO_CURSO";
    			
                stmt=connection.createStatement();
                ResultSet rs2=(ResultSet)stmt.executeQuery(query2);

                while(rs2.next()){
                	if((rs2.getInt("ID_USUARIO")==id_coordinadorcurso)){
                		coordinadorcurso=rs2.getString("CORREO");
    				}
                	else if(rs2.getInt("ID_USUARIO")==id_coordinadorrecurso)
                	{
                		coordinadorrecurso=rs2.getString("CORREO");
                	}
                	
            }
                listOfCursesinscritos.add(new CursoDto(nombre, descripcion, coordinadorcurso, coordinadorrecurso,nota));
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
        return listOfCursesinscritos;
    }
	
	/**
	 * Lista los identificadores de los cursos de la base de datos
	 * @param id_usuario identificador de un usuario en la base de datos
	 * @param properties Archivo de propiedades de la base de datos
	 * @param credentials Credenciales de la base de datos
	 * @return Devuelve la lista de todos los identificadores de los cursos inscritos 
	 */
	public ArrayList<IdentificadorDto> listOfIdentificadores(int id_usuario,InputStream properties, ArrayList <String> credentials){
        ArrayList<IdentificadorDto> listOfIdentificadores=new ArrayList<IdentificadorDto>();
        try {
            ConexionBD dbConnection=new ConexionBD();
            Connection connection=dbConnection.getConnection(credentials);
            
					
            String query="SELECT ID_CURSO FROM NUMERO_INSCRITOS WHERE ID_USUARIO=";
			
            Statement stmt=connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(query+id_usuario);

            while(rs.next()){
                String identificador=rs.getString("ID_CURSO");
                System.out.println(identificador);
                listOfIdentificadores.add(new IdentificadorDto(identificador));
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
        return listOfIdentificadores;
    }
	
	/**
	 * Adicion de una inscripcion a la base de datos
	 * @param identificador_curso El identificador del curso
	 * @param identificador_alumno El identificador del alumno
	 */
	public void inscribir(int identificador_curso,int identificador_alumno, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO NUMERO_INSCRITOS (ID_CURSO, ID_USUARIO) VALUES(?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setInt(1,identificador_curso );
			stmt.setInt(2, identificador_alumno);
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
	 * Adicion de un curso a la base de datos
	 * @param Nombre El nombre del curso
	 * @param descripcion El descripcion del curso
	 * @param id_coordinador_curso El identificador del coordinador del curso
	 * @param id_coordinador_recurso El identificador del coordinador del recurso
	 */
	public void addCurso(String Nombre, String descripcion, int id_coordinador_curso, int id_coordinador_recurso, InputStream properties, ArrayList <String> credentials){
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			
			String query="INSERT INTO CURSO (NOMBRE, DESCRIPCION, ID_COORDINADOR_CURSO, ID_COORDINADOR_RECURSO, NOTA) VALUES(?,?,?,?,?)";
			
			PreparedStatement stmt=(PreparedStatement)connection.prepareStatement(query);
			stmt.setString(1, Nombre);
			stmt.setString(2, descripcion);
			stmt.setInt(3, id_coordinador_curso);
			stmt.setInt(4, id_coordinador_recurso);
			stmt.setFloat(5, 0);
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
	 * Modificacion de la variable nota en la base de datos
	 * @param idcurso Identificador de un curso en la base de datos
	 */
	public void updatenota(int idcurso, InputStream properties, ArrayList <String> credentials){
		try {
			ConexionBD dbConnection = new ConexionBD();
			Connection connection = dbConnection.getConnection(credentials);
			
            String query="SELECT ID_CURSO,VALORACION FROM VALORACION_CURSO WHERE ID_CURSO=";
			
            Statement stmt=connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(query+idcurso);
            int contdivisor=0;
            int contadornotas=0;
            while(rs.next()){
            	contadornotas=contadornotas+rs.getInt("VALORACION");
            	contdivisor=contdivisor+1;
            	
            }
            if(stmt!=null){ 
                stmt.close(); 
            }
            float nota =contadornotas/contdivisor;
            query="UPDATE CURSO SET NOTA=? WHERE ID_CURSO=?";
			
			PreparedStatement stmt2=(PreparedStatement) connection.prepareStatement(query);
			stmt2.setFloat(1, nota);
			stmt2.setInt(2, idcurso);
			stmt2.executeUpdate();
			
			if(stmt!=null){ 
				stmt.close(); 
			}
			if(stmt2!=null){ 
				stmt2.close(); 
			}
			dbConnection.closeConnection();
		} 
		catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtener los recursos de un curso en la base de datos 
	 * @param identificadorCurso identificador de un curso en la base de datos
	 * @return Devuelve el recurso de un curso
	 */
	public String obtenerRecurso(int identificadorCurso,InputStream properties, ArrayList <String> credentials){
		String result="No se encuentra disponible";
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM RECURSOS";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==identificadorCurso)){
					result=rs.getString("RECRUSOS");
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
	 * Obtener los ponentes de un curso en la base de datos 
	 * @param identificadorCurso identificador de un curso en la base de datos
	 * @return Devuelve el ponente de un curso
	 */
	public String obtenerPonente(int identificadorCurso,InputStream properties, ArrayList <String> credentials){
		String result="No se encuentra disponible";
		try{
			ConexionBD dbConnection=new ConexionBD();
			Connection connection=dbConnection.getConnection(credentials);
			
			String query="SELECT * FROM PONENTES";
			
			Statement stmt=connection.createStatement();
			ResultSet rs=(ResultSet)stmt.executeQuery(query);

			while(rs.next()){
				if((rs.getInt("ID_CURSO")==identificadorCurso)){
					result=rs.getString("PONENTES");
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
