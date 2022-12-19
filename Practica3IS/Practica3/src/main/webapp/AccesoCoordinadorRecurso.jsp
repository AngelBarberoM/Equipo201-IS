<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="p3.business.UsuarioDto,p3.data.dao.UsuarioDao, java.util.ArrayList" %>
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
			¡Bienvenid@ Vista Coordinador Recursos¡
		</h3>
	
		<!-- Redireccionar Añadir recursos -->
		<form method="get" action="/Practica3/mvc/vista/VistaAR.jsp">
    		<button class="BuscarEspectaculo" type="submit">Añadir recursos</button>
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