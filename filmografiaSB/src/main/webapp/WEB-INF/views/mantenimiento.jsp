<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento de peliculas</title>
</head>
<body>
	<h2 align="center">Peliculas</h2>

	<div align="center">
		<table border=1 style="text-align: center;">
			<tr>
				<td width=200px><b>Director</b></td>
				<td width=200px><b>Titulo</b></td>
				<td width=200px><b>Fecha</b></td>
				<td width=200px><b>Modificar</b></td>
				<td width=200px><b>Borrar</b></td>
			</tr>
			<c:forEach items="${listaPelis}" var="info">
				<tr>
					<td width=200px>${info.director}</td>
					<td width=200px>${info.titulo}</td>
					<td width=200px>${info.fecha}</td>
					<td width=200px>
						<form action="/modificarPeli" method="POST">
							<input name="id" type="hidden" value="${info.id}">
							<input name="director" type="hidden" value="${info.director}">
							<input name="titulo" type="hidden" value="${info.titulo}">
							<input name="fecha" type="hidden" value="${info.fecha}">
							<p align="center">
								<input type="submit" value="Modificar Pelicula">
							</p>
						</form>
					</td>
					<td width=200px>
						<form action="/borrarPeli" method="POST">
							<input name="id" type="hidden" value="${info.id}">
							<p align="center">
								<input type="submit" value="Borrar Pelicula">
							</p>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<p align="center">
		<a href="/nuevaPeli"><input type="button" value="Nueva Pelicula"></a>
	</p>
	<p align="center">
		<a href="/loginCorrecto"><input type="button" value="Volver atrás"></a>
	</p>
</body>
</html>