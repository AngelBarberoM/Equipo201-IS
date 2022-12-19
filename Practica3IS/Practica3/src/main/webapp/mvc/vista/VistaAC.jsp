<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<title>Añadir Curso</title>
	</head>
	<body>
		<h2>Añadir Curso</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletAC">
		<fieldset>
			<label for="name">Nombre: </label>
			<input type="text" name="name" required><br/>
			<label for="Descripcion">Descripcion: </label>
			<input type="text" name="Descripcion" required><br/>
			<label for="CoordinadorCurse">Correo Coordinador curso:</label>
			<input type="text" name="CoordinadorCurse" required><br/>
			<label for="CoordinadorRecurse">Correo Coordinador recursos: </label>
			<input type="text" name="CoordinadorRecurse" required><br/>
			<br/>
			<input class="btn" type="submit" value="Añadir Curso">
		</fieldset>
		</form>
	</body>
</html>