<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<title>Inicio</title>

</head>

<body>
<jsp:include page="nav.jsp"></jsp:include>

	<div class="container-fluid pt-4">
		<section class="mx-2 px-2 ">

			<div class="container">
				<!-- Buscador -->
				<div class="row px-5">
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Buscar">
						<button class="btn btn-outline-info" type="submit">Buscar</button>
					</form>
				</div>
				<!-- Fin Buscador -->
				<!-- Inicio row central-->
				<div class="row m-4 px-2">
					<!-- card1 -->
					<div class="col-sm-12 col-md-8 col-lg-8">
						<div class="card">
							<div class="card-header">
								<h5 class="card-title pb-2">Listado de Productos</h5>
							</div>
							<div class="card-body">
								<!-- Listado de productos -->
								<table class="table table-hover">
									<thead>
										<th>Id</th>
										<th>Nombre Producto</th>
										<th>Descripción</th>
										<th>Precio</th>
										<th>Acción</th>
									</thead>
									<tbody>
										<c:forEach items="${listaProductos}" var="prods">
											<tr>
												<td><c:out value="${prods.getId()}"></c:out></td>
												<td><c:out value="${prods.getNombre()}"></c:out></td>
												<td><c:out value="${prods.getDescripcion()}"></c:out></td>
												<td><c:out value="${prods.getPrecio()}"></c:out></td>
												<td><button type="button" class="btn btn-warning"><i class="fas fa-cart-arrow-down"></i></button>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<!-- Fin Listado de productos -->
							</div>
						</div>
					</div>
					<!-- fin card1 -->
					<!-- card2 -->
					<div class="col-sm-12 col-md-4 col-lg-4">
						<div class="card">
							<div class="card-header">
								<h5 class="card-title pb-2">Tu Carrito</h5>
							</div>
							<div class="card-body">
								<table class="table table-hover align-bottom">
									<thead class="fw-bold">
										<td>Producto</td>
										<td>Precio</td>
									</thead>
									<tbody>
										<tr>
											<td></td>
											<!-- prod.nombre -->
											<td></td>
											<!-- prod.precio -->
										</tr>
									</tbody>
								</table>
								<!--fin tabla-->
								<div class="row p-4">
									<button type="button" class="btn btn-info">Confirmar Compra</button>
								</div>

							</div>
						</div>
					</div>

					<!-- fin card2 -->
				</div>
				<!-- fin row central -->

			</div>
		</section>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>