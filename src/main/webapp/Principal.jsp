<%
	if(request.getSession().getAttribute("listaMenus")==null)
		response.sendRedirect("Index.jsp?MENSAJE=Iniciar login");
%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">
<title>Principal</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-info">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					
					<c:forEach items="${sessionScope.listaMenus}" var="x">
					<li class="nav-item"><a
						style="margin-left: 12px; border: none"
						class="btn btn-outline-light" href="${x.url}">${x.descripcion}</a></li>
						</c:forEach>
				</ul>

			</div>
			
			<div class="dropdown">
				<a class="btn btn-danger"
						href="ServletUsuario?accion=CERRAR">Cerrar Sesion</a>
			</div>
		</div>
	</nav>

	<!-- JS principal -->
	<script src="js/jquery-3.5.1.js"></script>




	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>