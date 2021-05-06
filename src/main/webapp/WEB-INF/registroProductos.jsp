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
<title>Registro de Usuarios</title>
</head>
<body>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white py-1">
			<div class="container-fluid">
				<h1><a class="navbar-brand px-4" href="/"><i class="fas fa-store"></i>&nbsp;Tienda</a></h1>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
               <!--  div class="navbar-nav px-4"-->
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						
						<li class="nav-item dropdown">
						<a	class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Productos </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Nuevo producto</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link" href="usuario/muestraFormulario"
							tabindex="-1" aria-disabled="true">Nuevo usuario</a></li>
					</ul>
					<!-- /div-->
            </div>
        </div>
		</nav>
	</header>

	<%	Calendar cal = Calendar.getInstance();	int anioActual = cal.get(Calendar.YEAR);	%>

	<div class="container-fluid">
		<section class="m-2 p-3">
			<div class="container align-bottom">
				<h3 class="text-left fs-3 ">Registro de productos: <%out.print(anioActual); %></h3>
				<!-- formulario de registro -->
				<form:form action="procesaFormulario" modelAttribute="producto" method="post" id="producto" name="producto">
					<div class="row pt-3 my-2">
						<div class="col-6">
							<label for="nom">Nombre</label>
							<form:input path="nombre" type="text" class="form-control" placeholder="Nombre del Producto"/><!-- id="nombre" name="nombre" -->
						</div>
						<div class="col-6">
							<label for="des">Descripción</label> 
							<form:input path="descripcion" type="text" id="descripcion" name="descripcion" 
							class="form-control" placeholder="Descripción"/>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col-6">
							<label for="pre">Precio</label>
							 <form:input path="precio" type="number" id="precio" name="precio" class="form-control" placeholder="Precio"/>
							
						</div>
						<div class="col-6">
							<label for="cat">Categoría</label>
							<form:select class="form-select" path="categoria">
								<option value=0>Seleccione categoría</option>
								<c:forEach var="categoria" items="${categorias}">
									<option value="<c:out value="${categoria.id}"></c:out>"><c:out value="${categoria.nombre}"></c:out></option>
								</c:forEach>
							</form:select> 
						</div>
					</div>
					
					<div class="row p-1 my-3 px-2">
						<button type="submit" id="guardar" class="form-control btn btn-primary" onClick="mostrarMensaje()">
						Guardar Información</button>
					</div>
				
					<script type="text/javascript">function mostrarMensaje(){
						alert("Información procesada ");//+${mensaje}
					}</script>

				</form:form>

			</div>

		</section>
	</div>



<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>