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
		<title>Eliminar Usuario</title>
	</head>
	<body>
		<h2>Eliminar Usuario</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletAC">
		<fieldset>
			<label for="curso">Nombre Usuario: </label>
			<input type="text" name="Descripcion" required><br/>
			<br/>
			<input class="btn" type="submit" value="Eliminar Usuario">
		</fieldset>
		</form>
	</body>
</html>