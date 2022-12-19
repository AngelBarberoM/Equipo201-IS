package p3.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import p3.data.dao.UsuarioDao;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletRU
 */
@WebServlet(name="RegistroUsuario", urlPatterns="/ServletRU")
public class ServletRU extends HttpServlet {
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
			String direcionUsuario=request.getParameter("Direction");
			String nickUsuario=request.getParameter("nick");
			String passwordUsuario=request.getParameter("password");
			String permisosUsuario=request.getParameter("permission");
			
			//Comprobar que no se manda un espacio vacío
			if(!nombreUsuario.isBlank() && !apellidosUsuario.isBlank() && !nickUsuario.isBlank() && !passwordUsuario.isBlank() && !permisosUsuario.isBlank()&& !direcionUsuario.isBlank()){
				UsuarioDao userDAO=new UsuarioDao();
				//Evitar que existan dos usuarios con el mismo correo o nick
				if(!userDAO.checkEmail(correoUsuario, properties, credentials) && !userDAO.checkNick(nickUsuario, properties, credentials)){
					userDAO.addUser(correoUsuario, nickUsuario, passwordUsuario, nombreUsuario, apellidosUsuario, permisosUsuario, direcionUsuario, properties, credentials);
					
					//Redireccionar a la página de inicio si se ha registrado correctamente
					RequestDispatcher disp=request.getRequestDispatcher("index.jsp");
					disp.include(request, response);
				}
				//Informar que existe un usuario con el mismo correo o nick
				else{
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORyaRegistrado.jsp");
					disp.include(request, response);
				}
			}
		}
	}
}
