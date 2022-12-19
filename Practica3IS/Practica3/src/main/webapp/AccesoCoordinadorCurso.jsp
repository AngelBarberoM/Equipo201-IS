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
		<!-- Pagina de principal de los alumnos-->
		<h3>
		¡Bienvenid@ Vista Coordinador Cursos¡
		</h3>
		
		<!-- Redireccionar Añadir ponentes -->
		<form method="get" action="/Practica3/mvc/vista/VistaAP.jsp">
    		<button class="BuscarEspectaculo" type="submit">Añadir ponentes</button>
		</form>	
	
	
		<!-- Redireccionar Obtener lista alumnos -->
		<form method="get" action="/Practica3/mvc/vista/VistaLU.jsp">
    		<button class="BuscarEspectaculo" type="submit">Mostrar lista alumnos</button>
		</form>	
		
		<!-- Redireccionar a mostrar modificar cursos-->
		<form method="get" action="/Practica3/mvc/vista/VistaMCC.jsp">
    		<button class="PublicarCritica" type="submit">Modificar Curso</button>
		</form>	
		
		<!-- Redireccionar a mostrar modificar usuario-->
		<form method="get" action="/Practica3/mvc/vista/VistaMD.jsp">
    		<button class="PublicarCritica" type="submit">Modificar usuario</button>
		</form>	
		
				<!-- Redireccionar al Index -->
		<form method="get" action="/Practica3/index.jsp">
    		<button class="Desconectar" type="submit">Desconectar</button>
		</form>	
		
</html>