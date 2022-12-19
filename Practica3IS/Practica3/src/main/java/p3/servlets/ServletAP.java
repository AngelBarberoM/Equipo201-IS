package p3.servlets;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import p3.data.dao.CursoDao;
import p3.data.dao.UsuarioDao;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletAP
 */
@WebServlet(name="Añadir ponente", urlPatterns="/ServletAP")
public class ServletAP extends HttpServlet {
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
			String ponente=request.getParameter("ponente");
			String curso=request.getParameter("curso");

			
			//Comprobar que no se manda un espacio vacío
			if(!ponente.isBlank() && !curso.isBlank()){
				UsuarioDao userDAO=new UsuarioDao();
				int id_usuario=userDAO.identificadorUsuario(usuarioBean.getCorreoUsuario(), properties, credentials);
				CursoDao cursoDAO = new CursoDao();
				if(cursoDAO.checkNombreCurso(curso, properties, credentials)) {
					int id_curso=cursoDAO.identificador(curso, properties, credentials);
					if(!cursoDAO.checkcoordinadorrecursos(id_usuario,id_curso, properties, credentials))	{
						cursoDAO.addPonentes(id_curso,ponente, properties, credentials);
					}else {
						System.out.println("no es el coordiador del curso");
						RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORyaRegistrado.jsp");
						disp.include(request, response);
					}
					
				}
				//Informar que existe un usuario con el mismo correo o nick
				else{
					System.out.println("nombre del curso mal");
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORyaRegistrado.jsp");
					disp.include(request, response);
				}
			}
		}
	}
}