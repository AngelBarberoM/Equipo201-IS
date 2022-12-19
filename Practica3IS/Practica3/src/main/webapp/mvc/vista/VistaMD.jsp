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
		<title>Modificar Datos</title>
	</head>
	<body>
		<h2>Modificar Perfil</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletMD">
		<fieldset>
			<label for="name">Nombre: </label>
			<input type="text" name="name" value="<jsp:getProperty property="nombreUsuario" name="UsuarioBean"/>" required>
			<br/>
			<label for="surname">Apellidos: </label>
			<input type="text" name="surname" value="<jsp:getProperty property="apellidosUsuario" name="UsuarioBean"/>" required>
			<br/>
			<label for="direcion">Direccion: </label>
			<input type="text" name="direcion" value="<jsp:getProperty property="direccionUsuario" name="UsuarioBean"/>" required>
			<br/>
			<label for="email">Correo: </label>
			<input type="text" name="email" value="<jsp:getProperty property="correoUsuario" name="UsuarioBean"/>" readonly>
			<a>No se puede modificar</a>
			<br/>
			<label for="nick">Nickname: </label>
			<input type="text" name="nick" value="<jsp:getProperty property="nickUsuario" name="UsuarioBean"/>" required>
			<br/>
			<label for="password">Contraseña: </label>
			<input type="password" name="password" value="<jsp:getProperty property="passwordUsuario" name="UsuarioBean"/>" required>
			<br/>
			<label for="permission">Permisos:</label>
			<input type="text" name="permission" value="<jsp:setProperty property="permisosUsuario" name="UsuarioBean"/>" readonly>
			<a>No se puede modificar</a>
			<br/>
			<input class="btn" type="submit" value="Modificar Datos">
		</fieldset>
		</form>
	</body>
</html>