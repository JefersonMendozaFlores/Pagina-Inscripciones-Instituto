
<%
if (request.getSession().getAttribute("listaMenus") == null)
	response.sendRedirect("Index.jsp?MENSAJE=Iniciar login");
%>

<jsp:include page="Principal.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentKeeping</title>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>

<script src="js/jquery-3.5.1.js"></script>
<style>
.modal-header {
	color: #fff;
	background: #42ca65;
	display: flex;
	justify-content: center;
}

.help-block {
	color: red;
}

.form-group.has-error .form-control-label {
	color: red;
}

.form-group.has-error .form-control {
	border: 1px solid red;
	box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
}
</style>


<body>

	<div class="container">
		<c:if test="${param.MENSAJE != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong>Sistema : </strong> ${param.MENSAJE}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<h2 class="text-center mt-3">Mantenimiento Alumno</h2>
		<div>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#modalAlumnoRegistrar">New student</button>
		</div>

		<!-- Modal PARA REGISTRAR-->
		<div class="modal fade" id="modalAlumnoRegistrar"
			data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">Create new
							student</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="formAlumno" action="ServletAlumno?accion=CREAR"
							method="POST">
							<div class="form-group">
								<label for="exampleDni" class="form-label">DNI</label> <input
									type="text" class="form-control" name="dni" />
							</div>
							<div class="form-group">
								<label for="exampleName" class="form-label">Name</label> <input
									type="text" class="form-control" name="name">
							</div>
							<div class="form-group">
								<label for="exampleLastname" class="form-label">Lastname</label>
								<input type="text" class="form-control" name="lastname">
							</div>

							<div class="form-group">
								<label for="exampleBirth" class="form-label">Date of
									birth</label> <input type="text" class="form-control" name="birth">
							</div>
							<div class="form-group">
								<label for="exampleEmail" class="form-label">Email</label> <input
									type="text" class="form-control" name="email">
							</div>
							
							<div class="form-group">
								<label for="exampleCondicion" class="form-label">Distric</label>
								<select class="form-select form-control district" name="distric"
									id="id-codDistrito">
									<option value="" selected>[Seleccione Distrito]</option>
								</select>
							</div>
							
							<div class="form-group">
								<label for="exampleAddress" class="form-label">Address</label> <input
									type="text" class="form-control" name="address">
							</div>

							<div class="form-group">
								<label for="exampleCondicion" class="form-label">Country</label>
								<select class="form-select form-control country" name="country"
									id="id-codPais">
									<option value="" selected>[Seleccione País]</option>
								</select>
							</div>


							<div class="modal-footer">
								<button type="submit" class="btn btn-primary"><i class="bi bi-arrow-up-circle-fill"></i> Registrar</button>
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal"><i class="bi bi-x-octagon-fill"></i> Cerrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--fin modal PARA REGISTRAR-->

		<div class="row g-6">
			<div class="row g-3">
				<div class="col-auto">
					<label for="validationCustomUsername" class="form-label fw-bold">Enter
						Dni</label>
				</div>

				<div class="col-sm-2">
					<input type="text" class="form-control" id="dni">
				</div>
				<div class="col-auto">
					<button type="button" class="btn btn-primary" id="btn-consultar">Look
						Up</button>
				</div>
			</div>
		</div>







		<!------------------------------------ LISTAR------------------------ -->
		<div class="mt-4">
			<table id="tableStudent" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>DNI</th>
						<th>Name</th>
						<th>Last name</th>
						<th>Date of birth</th>
						<th>Email</th>
						<th>Career</th>
						<th>Cycle</th>
						<th>Address</th>
						<th>Inscription</th>
						<th>District</th>
						<th>Country</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>

		<!-- INICIO - Modal EDITAR-->
		<div class="modal fade" id="modalAlumno" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">Update
							Student</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="formAlumnoActualizar"
							action="ServletAlumno?accion=ACTUALIZAR" method="post">
							<div class="form-group">
								<label for="dni" class="form-label">Dni</label> <input
									type="text" class="form-control" name="dni" value="0"
									id="id-update-dni" readonly>
							</div>
							<div class="form-group">
								<label for="name" class="form-label">Name</label> <input
									type="text" class="form-control" name="name" id="id-update-name">
							</div>
							<div class="form-group">
								<label for="lastname" class="form-label">Lastname</label> <input
									type="text" class="form-control" name="lastname"
									id="id-update-lastname">
							</div>
							<div class="form-group">
								<label for="birth" class="form-label">Birth</label> <input
									type="text" class="form-control" name="birth" id="id-update-birth">
							</div>

							<div class="form-group">
								<label for="email" class="form-label">Email</label> <input
									type="text" class="form-control" name="email" id="id-update-email">
							</div>
							
							<div class="form-group">
								<label for="exampleCondicion" class="form-label">Distric</label>
								<select class="form-select form-control district" name="distric"
									id="id-update-codDistrito">
									<option value="" selected>[Seleccione Distrito]</option>
								</select>
							</div>

							<div class="form-group">
								<label for="address" class="form-label">Address</label> <input
									type="text" class="form-control" name="address" id="id-update-address">
							</div>

							<div class="form-group">
								<label for="exampleCondicion" class="form-label">Country</label>
								<select class="form-select form-control country" name="country"
									id="id-update-codPais">
									<option value="" selected>[Seleccione País]</option>
								</select>
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Update</button>
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Cerrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- FIN - Modal PARA EDITAR-->
		<!-----------------------------FIN------ LISTAR------------------------ -->

		<!-- Modal PARA ELIMINAR-->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">System</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="ServletAlumno?accion=DELETE" method="post">
							<h4>Seguro de eliminar Alumno?</h4>
							<input type="hidden" class="form-control" name="dni"
								id="codEliminar">
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">SI</button>
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">NO</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--fin modal PARA ELIMINAR-->

	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- JS para la tabla -->
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>


	<!-- JS principal -->
	<script src="js/jquery-3.5.1.js"></script>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- JS para la tabla -->
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

	<!--JS para validar  -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

	<script type="text/javascript" src="js/MantenimientoAlumno.js"></script>

</body>
</html>