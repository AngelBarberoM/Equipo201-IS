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
<title>No encuentra titulo</title>
</head>
<body>
<fieldset><p>No se puede encontrar un espectaculo con ese titulo</p></fieldset>
</body>
</html>