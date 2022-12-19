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
		<title>Valorar Cursos inscritos</title>
	</head>
	<body>
	
		<!-- Listar usuarios de la base de datos, mostrando su nick, permisos y fecha de última conexión -->
		<h2>Valorar Cursos inscritos</h2>
		<%
			String file=application.getInitParameter("properties");
			java.io.InputStream properties=application.getResourceAsStream(file);
			ArrayList <String> credentials=new ArrayList<String>();
			credentials.add(session.getServletContext().getInitParameter("url"));
			credentials.add(session.getServletContext().getInitParameter("user"));
			credentials.add(session.getServletContext().getInitParameter("password"));
	
			ArrayList<IdentificadorDto> listaidentificador=(ArrayList<IdentificadorDto>) request.getAttribute("identificadores");
			for(int i=0; i<listaidentificador.size(); i++){

					ArrayList<CursoDto> lista=new ArrayList<CursoDto>();
					CursoDao listadao=new CursoDao();
					int identificador=Integer.parseInt(listaidentificador.get(i).getIdentificador());
					lista=listadao.listOfCursesinscritos(identificador,properties, credentials);
				for(int f=0; f<lista.size(); f++){
				%>
					<p>
						<br>Nombre: <%=lista.get(f).getNombre()%></br>
			   			<br>Descripcion: <%=lista.get(f).getDescripcion()%></br>
			   			<br>Coordinador curso: <%=lista.get(f).getCoordinadorCurso()%></br>
			   			<br>Coordinador recursos: <%=lista.get(f).getCoordinadorRecursos()%></br>
					</p>
					<form method="get" action="/Practica3/ServletNota">
						<input type="hidden" name="curso" value=<%=lista.get(f).getNombre()%>>
						<fieldset>
							<label for="assessment">Nota del curso: </label>
							<input type="number" min="0" max="10" name="assessment" required><br/>
							<br/>
							<input class="btn" type="submit" value="Valorar curso">	
						</fieldset>
					</form>>
				<% 
				}
				
			} 
		%>
	</body>