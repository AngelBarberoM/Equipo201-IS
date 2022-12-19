<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="p3.business.CursoDto,p3.data.dao.CursoDao, java.util.ArrayList, java.sql.Timestamp,p3.business.IdentificadorDto" %>
<jsp:useBean  id="UsuarioBean" scope="session" class="p3.javabean.UsuarioBean"></jsp:useBean>
<!DOCTYPE html>
<html lang="es">
	<head>
		<%
		        String path = request.getContextPath();
		        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
		        request.getServerPort() + path + "/";
		%>
		<base href="<%=basePath%>">
		<link href= "<%=basePath%>estilos.css" rel="stylesheet" type="text/css">
		<meta charset="UTF-8">
		<title>Página Principal</title>
	</head>
	<body>
	
		<!-- Listar usuarios de la base de datos, mostrando su nick, permisos y fecha de última conexión -->
		<h2>Cursos inscritos</h2>
		<%
			String file=application.getInitParameter("properties");
			java.io.InputStream properties=application.getResourceAsStream(file);
			ArrayList <String> credentials=new ArrayList<String>();
			credentials.add(session.getServletContext().getInitParameter("url"));
			credentials.add(session.getServletContext().getInitParameter("user"));
			credentials.add(session.getServletContext().getInitParameter("password"));
	
					CursoDao cursoDAO=new CursoDao();
					String nombreCurso=request.getParameter("curso");
					int identificador=cursoDAO.identificador(nombreCurso, properties, credentials);
					String recursos=cursoDAO.obtenerRecurso(identificador,properties,credentials);
					String ponente=cursoDAO.obtenerPonente(identificador,properties,credentials);
				%>
					<p>
						<br>Recursos: <%=recursos%></br>
			   			<br>Ponente: <%=ponente%></br>
					</p>

				<% 
				
			
		%>
	</body>