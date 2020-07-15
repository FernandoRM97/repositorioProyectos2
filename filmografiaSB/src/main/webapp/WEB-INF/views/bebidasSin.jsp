<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bebidas Sin</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<body style="background-color: #B7FDF7;">
	<nav class="navbar navbar-light bg-light"
		style="background-color: #E7F5F4;"> <a class="navbar-brand"
		href="/index"> <img
		src="https://image.flaticon.com/icons/png/512/45/45332.png" width="45"
		height="20" alt="filmografia" style="padding-left: 10px">
		Restaurante
	</a> </nav>
	<br>

	<h2 align="center">Bebidas sin Alcohol</h2>
	<br>

	<div align="center">
		<table class="table table-striped" style="text-align: center;">
			<tr>
				<td width=200px><b>Nombre</b></td>
				<td width=200px><b>Descripción</b></td>
				<td width=200px><b>Peso</b></td>
				<td width=200px><b>Stock</b></td>
				<td width=200px><b>Comprar</b></td>
				<td width=200px><b></b></td>

			</tr>
			<c:forEach items="${bebidas}" var="info">
				<tr>
					<td width=200px>${info.nombre}</td>
					<td width=200px>${info.descripcion}</td>
					<td width=200px>${info.peso}</td>
					<td width=200px>${info.stock}</td>
					<td width=200px><input type="number" min="1"
						max="${info.stock}" /></td>
					<td width=200px>
						<form action="/comprarSin" method="POST">
							<input name="nombre" type="hidden" value="${info.nombre}">
							<p align="center">
								<input type="submit" class="btn btn-warning" value="Comprar">
							</p>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<p align="center">
		<a href="/carrito"><input type="button" class="btn btn-success"
			value="Ver Carrito"></a>
	</p>
	<p align="center">
		<a href="/loginCorrecto"><input type="button"
			class="btn btn-primary" value="Volver atrás"></a>
	</p>

	<br>
	<br>

	<footer class="page-footer font-small blue"
		style="background-color: #E7F5F4; position: fixed; clear: both; bottom: 0; width: 100%">
	<div class="footer-copyright text-center py-3">
		© 2019 Copyright: <a href="/index"> Restaurante.com </a>
	</div>
	</footer>

</body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</html>