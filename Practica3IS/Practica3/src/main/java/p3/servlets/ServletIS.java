package p3.servlets;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import p3.business.*;
import p3.data.dao.*;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletIS
 */
@WebServlet(name="InicioSesion", urlPatterns="/ServletIS")
public class ServletIS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		UsuarioBean usuarioBean=(UsuarioBean)session.getAttribute("UsuarioBean");
		String file=session.getServletContext().getInitParameter("properties");
		ServletContext application=request.getServletContext();
		java.io.InputStream properties=application.getResourceAsStream(file);
		java.util.ArrayList <String> credentials=new java.util.ArrayList<String>();
		credentials.add(session.getServletContext().getInitParameter("url"));
		credentials.add(session.getServletContext().getInitParameter("user"));
		credentials.add(session.getServletContext().getInitParameter("password"));
		
		//Comprueba la creacion del UsuarioBean
		if(usuarioBean!=null){
			String correoUsuario=request.getParameter("email");
			String passwordUsuario=request.getParameter("password");
			//Comprobar que no se manda un espacio vacio
			if(!correoUsuario.isBlank() && !passwordUsuario.isBlank()){
				UsuarioDao userDAO=new UsuarioDao();
				//Comprobar la existencia del usuario en la base de datos y que su contraseña es correcta
				if(userDAO.checkUser(correoUsuario, passwordUsuario, properties, credentials)){
					UsuarioDto user=userDAO.returnUser(correoUsuario, properties, credentials);
					usuarioBean.setNombreUsuario(user.getNombre());
					usuarioBean.setApellidosUsuario(user.getApellidos());
					usuarioBean.setCorreoUsuario(user.getCorreo());
					usuarioBean.setNickUsuario(user.getNick());
					usuarioBean.setPasswordUsuario(user.getPassword());
					usuarioBean.setPermisosUsuario(user.getPermisos());
					//Redireccionar a una pagina de bienvenida segun sus permisos 
					if(user.getPermisos().equalsIgnoreCase("ADMINISTRADOR")){
						RequestDispatcher disp=request.getRequestDispatcher("AccesoAdministrador.jsp");
						disp.include(request, response);
					}
					else if(user.getPermisos().equalsIgnoreCase("ALUMNO")){
						RequestDispatcher disp=request.getRequestDispatcher("AccesoAlumno.jsp");
						disp.include(request, response);
					}
					else if((user.getPermisos().equalsIgnoreCase("COORDINADORCURSO"))) {
						RequestDispatcher disp=request.getRequestDispatcher("AccesoCoordinadorCurso.jsp");
						disp.include(request, response);
					}
					else if((user.getPermisos().equalsIgnoreCase("COORDINADORRECURSO"))) {
						RequestDispatcher disp=request.getRequestDispatcher("AccesoCoordinadorRecurso.jsp");
						disp.include(request, response);
					}
				}
				//Se ha introducido mal el correo o la contraseña
				else{
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORsesion.jsp");
					disp.include(request, response);
				}
			}
		}
	}
}
