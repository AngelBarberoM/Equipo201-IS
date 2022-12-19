package p3.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import p3.data.dao.CursoDao;
import p3.data.dao.UsuarioDao;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletAC
 */
@WebServlet(name="RegistroUsuario", urlPatterns="/ServletAC")
public class ServletAC extends HttpServlet {
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
			String nombrecurso=request.getParameter("name");
			String descripcioncurso=request.getParameter("Descripcion");
			String coordinadorcurso=request.getParameter("CoordinadorCurse");
			String coordinadorerecurso=request.getParameter("CoordinadorRecurse");
			
			//Comprobar que no se manda un espacio vacío
			if(!nombrecurso.isBlank() && !descripcioncurso.isBlank() && !coordinadorcurso.isBlank() && !coordinadorerecurso.isBlank()){
				CursoDao cursoDAO=new CursoDao();
				UsuarioDao userDAO=new UsuarioDao();
				//Evitar que existan dos usuarios con el mismo correo o nick
				if(!cursoDAO.checkNombreCurso(nombrecurso, properties, credentials)){
					
					if(userDAO.checkNombrecoordinadorCurso(coordinadorcurso, properties, credentials)){
						int identificadorCursos=userDAO.identificadorUsuario(coordinadorcurso, properties, credentials);
						if(userDAO.checkNombrecoordinadorRecurso(coordinadorerecurso, properties, credentials)){
							int identificadorRecursos=userDAO.identificadorUsuario(coordinadorerecurso, properties, credentials);
							cursoDAO.addCurso(nombrecurso, descripcioncurso, identificadorCursos, identificadorRecursos, properties, credentials);
							
							//Redireccionar a la página de inicio si se ha registrado correctamente
							RequestDispatcher disp=request.getRequestDispatcher("index.jsp");
							disp.include(request, response);
						}else {
							//no encuentra el coordinador del recurso
							RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORnick.jsp");
							disp.include(request, response);
						}
					}else {
						//no encuentra el coordinador del curso
						RequestDispatcher disp=request.getRequestDispatcher("/error/ERROREP.jsp");
						disp.include(request, response);
					}
					
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
