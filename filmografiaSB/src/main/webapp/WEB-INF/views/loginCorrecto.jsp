<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Login Correcto</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<body style="background-color: #B7FDF7;">
	<nav class="navbar navbar-light bg-light"
		style="background-color: #E7F5F4;">
		<a class="navbar-brand" href="/index"> <img
			src="https://image.flaticon.com/icons/png/512/45/45332.png"
			width="45" height="20" alt="filmografia" style="padding-left: 10px">
			Restaurante
		</a>
		<div align="center">
			<form action="/carrito" method="POST">
				<p align="center">
					<input type="submit" class="btn btn-warning" value="Ver Carrito">
				</p>
			</form>
		</div>
	</nav>

	<c:set var="nombre" value="${correo}" />
	<h4 align="center">Usuario: ${fn:toUpperCase(correo)}</h4>
	<input type="hidden" value="${id}" name="id"/>

	<br>

	<h4 align="center">Lista de Categorias</h4>

	<br>

	<div align="center">
		<p align="center">
			<a href="/bebidasCon">Bebidas Con</a>
		</p>
		<p align="center">
			<a href="/bebidasSin">Bebidas Sin</a>
		</p>
		<p align="center">
			<a href="/comida">Comida</a>
		</p>
	</div>

	<br>
	<br>

	<p align="center">
		<a href="/index"><input type="button" class="btn btn-primary"
			value="Home"></a>
	</p>

	<footer class="page-footer font-small blue"
		style="background-color: #E7F5F4; position: fixed; clear: both; bottom: 0; width: 100%">
		<div class="footer-copyright text-center py-3">
			� 2019 Copyright: <a href="/index"> Restaurante.com </a>
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