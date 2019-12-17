<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Login Correcto</title>
</head>
<body>

	<c:set var="nombre" value="${nombre}" />

	<h2 align="center">BIENVENIDO ${fn:toUpperCase(nombre)}</h2>
	<p align="center">
		<a href="/registrar"><input type="button"
			value="Registrar nuevo usuario"></a>
	</p>
	<form action="/mantenimiento" method="POST">
		<p align="center">
			<input type="submit" value="Mantenimiento peliculas">
		</p>
	</form>

	<p align="center">
		<a href="/index"><input type="button" value="Inicio"></a>
	</p>

</body>
</html>