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
		<title>Iniciar Sesión</title>
	</head>
	<body>
		<h2>Iniciar Sesión</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletIS">
		<fieldset>
			<label for="email">Correo: </label>
			<input type="text" name="email" required><br/>
			<label for="password">Contraseña: </label>
			<input type="password" name="password" required><br/>
			<input class="btn" type="submit" value="Iniciar Sesión">	
		</fieldset>
		</form>
	</body>
</html>