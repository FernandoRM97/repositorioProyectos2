<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Pelicula</title>
</head>
<body>
	<br>

	<form action="/modificarPelicula" method="POST">
		<input type="hidden" name="id2" value="${id}"/>
		<p align="center">Titulo</p>
		<p align="center">
			<input type="text" name="titulo2" placeholder="${titulo}" required>
		</p>
		<p align="center">Director</p>
		<p align="center">
			<input type="text" name="director2" placeholder="${director}" required>
		</p>
		<p align="center">Fecha</p>
		<p align="center">
			<input type="text" name="fecha2" placeholder="${fecha}" required>
		</p>
		<p align="center">
			<input type="submit" value="Modificar Pelicula">
		</p>
	</form>
	<p align="center">
		<a href="/mantenimiento"><input type="button" value="Volver atrás"></a>
	</p>
</body>
</html>