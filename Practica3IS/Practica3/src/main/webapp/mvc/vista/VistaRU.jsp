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
		<title>Registro</title>
	</head>
	<body>
		<h2>Registro de Usuario</h2>
		<!-- Llamada al Servlet -->
		<form method="get" action="/Practica3/ServletRU">
		<fieldset>
			<label for="name">Nombre: </label>
			<input type="text" name="name" required><br/>
			<label for="surname">Apellidos: </label>
			<input type="text" name="surname" required><br/>
			<label for="direccion">Direcion: </label>
			<input type="text" name="Direction" required><br/>
			<label for="email">Correo: </label>
			<input type="text" name="email" required><br/>
			<label for="nick">Nickname: </label>
			<input type="text" name="nick" required><br/>
			<label for="password">Contraseña: </label>
			<input type="password" name="password" required><br/>
			<label for="permission">Permisos:</label>
			<select id="permission" name="permission">
  				<option value="ALUMNO">Alumno</option>
  				<option value="ADMINISTRADOR">Administrador</option>
  				<option value="COORDINADORRECURSO">Coordinador Recursos</option>
  				<option value="COORDINADORCURSO">Coordinador Curso</option>
			</select> 
			<br/>
			<input class="btn" type="submit" value="Registrarse">
		</fieldset>
		</form>
	</body>
</html>