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
		<title>Añadir ponentes</title>
	</head>
	<body>
		<h2>Añadir ponentes</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletAP">
		<fieldset>
			<label for="curso">Nombre del curso: </label>
			<input type="text" name="curso" required><br/>
			<input class="btn" type="submit" value="Añadir ponentes">	
		</fieldset>
		</form>
	</body>
</html>