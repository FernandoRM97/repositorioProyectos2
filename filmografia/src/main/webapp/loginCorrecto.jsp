<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login Correcto</title>
</head>
<body>
	<h2 align="center">BIENVENIDO ${nombre}</h2>
	<p align="center">
		<a href="registrar.jsp"><input type="button"
			value="Registrar nuevo usuario"></a>
	</p>
	<p align="center">
		<a href="mantenimiento.jsp"><input type="button"
			value="Mantenimiento peliculas"></a>
	</p>
	<form method="POST">
	<p align="center">
		<a href="mantenimientoController"><input type="button" value="Inicio"></a>
	</p>
	</form>
</body>
</html>