<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="p3.business.CursoDto,p3.data.dao.CursoDao, p3.business.CursoDto, java.util.ArrayList, java.sql.Timestamp" %>
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
		<h2>Cursos disponibles</h2>
		<%
			String file=application.getInitParameter("properties");
			java.io.InputStream properties=application.getResourceAsStream(file);
			ArrayList <String> credentials=new ArrayList<String>();
			credentials.add(session.getServletContext().getInitParameter("url"));
			credentials.add(session.getServletContext().getInitParameter("user"));
			credentials.add(session.getServletContext().getInitParameter("password"));
	
			ArrayList<CursoDto> lista=new ArrayList<CursoDto>();
			CursoDao listadao=new CursoDao();
			lista=listadao.listOfCurses(properties, credentials);
			for(int i=0; i<lista.size(); i++){
				%>
					<p>
						<br>Nombre: <%=lista.get(i).getNombre()%></br>
			   			<br>Descripcion: <%=lista.get(i).getDescripcion()%></br>
			   			<br>Coordinador curso: <%=lista.get(i).getCoordinadorCurso()%></br>
			   			<br>Coordinador recursos: <%=lista.get(i).getCoordinadorRecursos()%></br>
			   			<br>Valoracion: <%=lista.get(i).getNota()%></br>
					</p>
					<form method="get" action="/Practica3/ServletCD">
						<input type="hidden" name="curso" value=<%=lista.get(i).getNombre()%>>
						<input class="btn" type="submit" value="Inscribirse">	
					</form>>
				<% 
				
			} 
		%>
	</body>
</html>