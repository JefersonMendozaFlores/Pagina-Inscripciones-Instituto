<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link href="css/index.css" rel="stylesheet">

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<title>LOGIN</title>
</head>
<body>

	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
		<div class="modal-content">
		   <div class="col-12 user-img">
		     <img  src="img/images.png">
		   </div>
		   <form action="ServletUsuario?accion=INGRESAR" class="col-12 mt-2" method="post">
		     <div class="form-group" id="user-group">
		     <input type="text" class="form-control mt-3" placeholder="Nombre de Usuario" name="txtUser">
		     
		     </div>
		     
		     <div class="form-group" id="password-group">
		     <input type="password" class="form-control mt-3" placeholder="Contraseña" name="txtPass">
		     
		     </div>
		     
		     <button type="submit" class="btn btn-primary mt-2 mb-2"><i class="fas fa-sign-in-alt"></i>  Ingresar</button>
		   
		   </form>
		   <div class="col-12">
		    <c:if test="${param.MENSAJE!=null}">
		     
		     <p class="alerta"><strong>${param.MENSAJE}</strong> </p>
		     
		   </c:if>
		   </div>
		
		</div>
		
		</div>
	</div>




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