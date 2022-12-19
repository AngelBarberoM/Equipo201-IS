<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="p3.business.UsuarioDto,p3.data.dao.UsuarioDao, java.util.ArrayList, java.sql.Timestamp" %>
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
		<!-- Pagina de principal de los administradores-->
		<h3>
			¡Bienvenid@ Vista Administrador¡
		</h3>

	
		<!-- Redireccionar a Añadir Usuario -->
		<form method="get" action="/Practica3/mvc/vista/VistaRU.jsp">
    		<button class="ModificarDatos" type="submit">Añadir Usuario</button>
		</form>	
	
		<!-- Redireccionar a Añadir Curso -->
		<form method="get" action="/Practica3/mvc/vista/VistaAC.jsp">
    		<button class="ModificarDatos" type="submit">Añadir Curso</button>
		</form>	
	
		<!-- Redireccionar a Modificar Usuario -->
		<form method="get" action="/Practica3/mvc/vista/VistaIU.jsp">
    		<button class="ModificarDatos" type="submit">Inscribir Usuario</button>
		</form>
				
		<!-- Redireccionar a Lista Usuarios -->
		<form method="get" action="/Practica3/mvc/vista/VistaLU.jsp">
    		<button class="ModificarDatos" type="submit">Lista Usuarios</button>
		</form>
		
		<!-- Redireccionar a Modificar curso -->
		<form method="get" action="/Practica3/mvc/vista/VistaMD.jsp">
    		<button class="ModificarDatos" type="submit">Modificar Usuario</button>
		</form>
		
		<!-- Redireccionar a Modificar curso -->
		<form method="get" action="/Practica3/mvc/vista/VistaMCC.jsp">
    		<button class="ModificarDatos" type="submit">Modificar Curso</button>
		</form>
		
		<!-- Redireccionar a Eliminar Usuario -->
		<form method="get" action="/Practica3/mvc/vista/VistaEU.jsp">
    		<button class="ModificarDatos" type="submit">Eliminar Usuario</button>
		</form>
		
		<!-- Redireccionar a Eliminar curso -->
		<form method="get" action="/Practica3/mvc/vista/VistaEC.jsp">
    		<button class="ModificarDatos" type="submit">Eliminar curso</button>
		</form>

		
		<!-- Redireccionar al Index -->
		<form method="get" action="/Practica3/index.jsp">
    		<button class="Desconectar" type="submit">Desconectar</button>
		</form>
	
</body>
</html>