<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="p3.business.CursoDto, p3.data.dao.CursoDao, java.util.ArrayList, java.sql.Timestamp" %>
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
		<title>Inicio</title>
	</head>
	<body>
		<!-- Reinicio de las variables del UsuarioBean -->
		<jsp:setProperty property="nombreUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="apellidosUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="correoUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="nickUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="passwordUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="permisosUsuario" value="" name="UsuarioBean"/>
		<jsp:setProperty property="direccionUsuario" value="" name="UsuarioBean"/>
		
		<!-- Pagina de inicio de la aplicacion web -->
		<h2>Bienvenid@</h2>
		
		<div class="botones">
			<!-- Redireccionar a la vista de Inicio de Sesion -->
			<form method="get" action="/Practica3/mvc/vista/VistaIS.jsp">
    			<button class="IniciarSesion" type="submit">Iniciar Sesión</button>
			</form>

		</div>
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

				<% 
				
			} 
		%>
	</body>
</html>