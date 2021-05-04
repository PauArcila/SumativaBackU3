<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<title>Reg Usuarios</title>
</head>
<body>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white py-1">
			<div class="container-fluid align-top">
				<h1><a class="navbar-brand px-4" href="/mantenedor"><i class="fas fa-store"></i
					>&nbsp;Mantenedor/Tienda</a>
				</h1>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav px-4">
						<a class="nav-link" href="/listado">Listado</a> <a
							class="nav-link" href="#">Mantenedor</a>
					</div>
						<!-- class ="ml-auto" -->
						<button type="button" id="volver"
							class="btn btn-outline-primary my-2 my-sm-0">
							<span class="fas fa-arrow-left"></span><a href="/listado" style="text-decoration: none;">&nbsp;Volver&nbsp;</a>
						</button>
				
				</div>
			</div>
		</nav>
	</header>



	<%	Calendar cal = Calendar.getInstance();	int anioActual = cal.get(Calendar.YEAR);	%>
			<!-- Form debe tener la url del requestMapping que recibirá los datos -->

	<div class="container-fluid">
		<section class="m-2 p-3">
			<div class="container align-bottom">
				<h2 class="text-left fs-3 ">Registro: <%out.print(anioActual); %></h2>
				<!-- formulario de registro -->
				<form:form action="mantenedor" method="post" id="producto" name="producto" modelAttribute="producto">
					<div class="row pt-3 my-2">
						<div class="col-6">
							<form:hidden path="prodId"/>
							<label for="nombre">Nombre</label>
							<input type="text" path="prodNombre" id="prodNombre" name="prodNombre" class="form-control" placeholder="Nombre del Producto" required autofocus>
						</div>
						<div class="col-6">
							<label for="descripcion">Descripción</label> 
							<input type="text" path="prodDescripcion" id="prodDescripcion" name="prodDescripcion" class="form-control"	placeholder="Descripción" required>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col-6">
							<label for="precio">Precio</label>
							 <input type="number" path="prodPrecio" id="prodPrecio" name="prodPrecio" class="form-control" placeholder="Precio" required>
							
						</div>
						<div class="col-6">
							<label for="url">URL</label> 
							<input type="text" path="prodUrl" id="prodUrl" name="prodUrl" class="form-control" placeholder="URL"> <!-- min=100	max=<!%=anioActual%> -->
						</div>
					</div>

					<div class="row p-1 mt-1">
						<button type="submit" id="guardar" class="form-control btn btn-primary">
						Guardar Información</button>
					</div>

				</form:form>

			</div>

		</section>
	</div>



<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>