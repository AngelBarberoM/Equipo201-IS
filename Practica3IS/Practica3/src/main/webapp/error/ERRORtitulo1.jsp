<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<%
		        String path = request.getContextPath();
		        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
		        request.getServerPort() + path + "/";
		%>
		<base href="<%=basePath%>">
		<link href= "<%=basePath%>estilos.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Ya exixte espectaculo con ese titulo</title>
</head>
<body>
<fieldset><p>No se puede anadir espectaculo con ese titulo. Ya existe uno igual.</p></fieldset>
</body>
</html>