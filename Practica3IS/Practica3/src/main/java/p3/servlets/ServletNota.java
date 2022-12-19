package p3.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import p3.business.IdentificadorDto;
import p3.data.dao.*;
import p3.javabean.UsuarioBean;

/**
 * Servlet implementation class ServletNota
 */
@WebServlet(name="Calcular nota", urlPatterns="/ServletNota")
public class ServletNota extends HttpServlet {
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
			UsuarioDao usuarioDAO=new UsuarioDao();
			CursoDao cursoDAO=new CursoDao();
			int identificadorUsuario=usuarioDAO.identificadorUsuario(usuarioBean.getCorreoUsuario(), properties, credentials);
			String curso=request.getParameter("curso");
			int nota=Integer.parseInt(request.getParameter("assessment"));
			int identificadorCurso=cursoDAO.identificador(curso, properties, credentials);
				if(cursoDAO.comprobarvotacion(identificadorUsuario,identificadorCurso,properties, credentials)) {
					cursoDAO.addValoracion(identificadorUsuario,identificadorCurso,nota, properties, credentials);
					cursoDAO.updatenota(identificadorCurso, properties, credentials);
				}
				else {
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORnick.jsp");
					disp.include(request, response);
				}
				request.getRequestDispatcher("/mvc/vista/VistaVC.jsp").forward(request, response);
				}
				//Se ha introducido mal el correo o la contraseña
				else{
					RequestDispatcher disp=request.getRequestDispatcher("/error/ERRORsesion.jsp");
					disp.include(request, response);
				}
			}
		
	}