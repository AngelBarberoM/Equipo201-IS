package p3.servlets;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import p3.data.dao.*;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletCD
 */
@WebServlet(name="Inscribirse en un curso", urlPatterns="/ServletCD")
public class ServletCD extends HttpServlet {
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
			String nombrecurso=request.getParameter("curso");
			System.out.println(nombrecurso);
			//Comprobar que no se manda un espacio vacio
			if(!nombrecurso.isBlank()){
				CursoDao cursoDAO=new CursoDao();
				UsuarioDao usuarioDAO=new UsuarioDao();
				//Comprobar la existencia del usuario en la base de datos y que su contraseña es correcta
				if(cursoDAO.checkNombreCurso(nombrecurso, properties, credentials)){
					
					int identificadorCurso=cursoDAO.identificador(nombrecurso, properties, credentials);
					int identificadorUsuario=usuarioDAO.identificadorUsuario(usuarioBean.getCorreoUsuario(), properties, credentials);
					if(cursoDAO.checkinscrito(identificadorCurso, identificadorUsuario,properties, credentials)) {
						RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORinscrito.jsp");
						disp.include(request, response);
					}else {
						cursoDAO.inscribir(identificadorCurso, identificadorUsuario, properties, credentials);
						
						RequestDispatcher disp=request.getRequestDispatcher("/mvc/vista/Vistainscritos.jsp");
						disp.include(request, response);
					}

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
