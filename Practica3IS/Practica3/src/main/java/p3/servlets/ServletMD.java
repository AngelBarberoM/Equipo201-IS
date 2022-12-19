package p3.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import p3.business.UsuarioDto;
import p3.data.dao.UsuarioDao;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletMD
 */
@WebServlet(name="ModificarDatos", urlPatterns="/ServletMD")
public class ServletMD extends HttpServlet {
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
		
		//Comprueba la creación del UsuarioBean
		if(usuarioBean!=null){
			String nombreUsuario=request.getParameter("name");
			String apellidosUsuario=request.getParameter("surname");
			String correoUsuario=request.getParameter("email");
			String nickUsuario=request.getParameter("nick");
			String passwordUsuario=request.getParameter("password");
			String permisosUsuario=request.getParameter("permission");
			String direcion=request.getParameter("direcion");
			//Comprobar que no se manda un espacio vacío
			if(!nombreUsuario.isBlank() && !apellidosUsuario.isBlank() && !nickUsuario.isBlank() && !passwordUsuario.isBlank()&& !direcion.isBlank()){
				UsuarioDao userDAO=new UsuarioDao();
				UsuarioDto user=userDAO.returnUser(correoUsuario, properties, credentials);
				if(!userDAO.checkNickEmail(nickUsuario, correoUsuario, properties, credentials)){
					usuarioBean.setNombreUsuario(nombreUsuario);
					usuarioBean.setApellidosUsuario(apellidosUsuario);
					usuarioBean.setCorreoUsuario(correoUsuario);
					usuarioBean.setNickUsuario(nickUsuario);
					usuarioBean.setPasswordUsuario(passwordUsuario);
					usuarioBean.setPermisosUsuario(permisosUsuario);
					usuarioBean.setdireccionUsuario(direcion);

					//Actualizar cambios
					userDAO.updateUser(nombreUsuario, apellidosUsuario, nickUsuario, passwordUsuario, correoUsuario, direcion , properties, credentials);
					//Redireccionar a una página de bienvenida según sus permisos
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
				else{
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORnick.jsp");
					disp.include(request, response);
				}
			}

		}
	}
}