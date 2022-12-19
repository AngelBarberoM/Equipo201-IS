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
		<title>Lista usuarios</title>
	</head>
	<body>
	
		<!-- Listar usuarios de la base de datos, mostrando su nick, permisos y fecha de última conexión -->
		<h2>Lista usuarios</h2>
		<%
				%>

					<p>
						<br>Curso:</br>
						<br>Correo:</br>
			   			<br>Correo:</br>
					</p>

				<% 
				
			
		%>
	</body>