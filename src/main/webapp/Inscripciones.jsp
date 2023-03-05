 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<%
	if(request.getSession().getAttribute("listaMenus")==null)
		response.sendRedirect("Index.jsp?MENSAJE=Iniciar login");
%>

<jsp:include page="Principal.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Listado de Inscripciones</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">

<!--   -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/EstilosInscrMant.css">

</head>
<body>

<div class="container">

<input type="hidden" id="id-rol" value="${sessionScope.CodigoRol}">

		<c:if test="${param.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>SISTEMA</strong> ${param.MENSAJE}
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<br>
		
		<h3 class="text-center">LISTADO DE INSCRIPCIONES</h3>	      
	    
	    <!-- Modal PARA ACTUALIZAR-->
		<div class="modal fade" id="modalInscripcion" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">ACTUALIZAR INSCRIPCION</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formInscripcion" action="ServletInscripcion?accion=ACTUALIZAR" method="post">
				  <div class="form-group">
				    <label for="exampleNombre" class="form-label">ID Inscripcion:</label>
				    <br>
				    <input type="text" class="form-control" name="codigo" readonly id="id-inscripcion">
				  </div>
				  <br>
				  <div class="form-group">
				    <label for="exampleMaterno" class="form-label">Estado:</label>
				    <select class="form-select form-control" name="Estado" id="id-estado">
					  <option value="" selected>[Seleccione]</option>
					  <option value="GENERADO">GENERADO</option>
					  <option value="PAGADO">PAGADO</option>
					  <option value="PENDIENTE DE PAGO">PENDIENTE DE PAGO</option>
					</select>
				  </div>		
				 
				  <div class="modal-footer">
			      	<button class="boton1"><i class="bi bi-arrow-counterclockwise"></i></button>
			        <button class="boton2" type="button" data-bs-dismiss="modal"><i class="bi bi-door-closed"></i></button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA ACTUALIZAR-->
	    
	    
	    <!-- Modal PARA ELIMINAR-->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">ELIMINAR INSCRIPCION</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formInscripcion" action="ServletInscripcion?accion=ELIMINAR" method="post">
		        	<h4>Esta seguro de eliminar inscripcion?</h4>
				    <input type="hidden" class="form-control" name="codigoEliminar" id="codEliminar">
				  <div class="modal-footer">
			      	<button class="boton3" type="submit" ><i class="bi bi-check"></i></button>
			        <button class="boton4" type="button" data-bs-dismiss="modal"><i class="bi bi-x"></i></button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA ELIMINAR-->	 
	    
	    
	     <!-- Modal PARA PAGO-->
		<div class="modal fade" id="modalOrdenPago" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">ORDEN DE PAGO</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form class="row g-2" id="formPago" action="ServletOrdenPago?accion=ADICIONAR" method="post">
		        <div class="col-md-4">
					    <label for="inputEmail4" class="form-label">Número Pago</label>
					    <input type="text" class="form-control" id="id-numero" name="numero" readonly>
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Fecha de Pago</label>
					    <input type="text" class="form-control"  value="${sessionScope.fecha}" readonly name="fecha">
					  </div>
					   <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Codigo de Ficha</label>
					    <input type="text" class="form-control" name="ficha" id="id-ficha" readonly>
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">DNI Alumno</label>
					    <input type="text" class="form-control" name="dni" id="id-dni" readonly>
					  </div>
					  <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Nombre Alumno</label>
					    <input type="text" class="form-control" name="nombre" id="id-nombre" readonly>
					  </div>
					   <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Monto de Pago</label>
					    <input type="number" class="form-control" name="monto" id="id-monto">
					  </div>
					    <div class="col-md-4">
					    <label for="inputPassword4" class="form-label">Estado</label>
					    <input type="text" class="form-control" name="estado" id="id-estado" value="GENERADO" readonly>
					  </div>
				  		
				 
				  <div class="modal-footer">
			      	<button class="boton1"><i class="bi bi-arrow-counterclockwise"></i></button>
			        <button class="boton2" type="button" data-bs-dismiss="modal"><i class="bi bi-door-closed"></i></button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA PAGO--> 
	    
	    
	    <div class="mt-5">
	    <table id="tableInscripcion" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>ID Inscripcion</th>
				<th>Nro de DNI</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>ID Carrera</th>
                <th>Nombre Carrera</th>
                <th>Ciclos</th>
                <th>Fecha Inscripcion</th>
                <th>Estado</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	
            
        </tbody>
    </table>
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
		
	<!-- JS para la tabla -->
	<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
	
	<!--JS para validar  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
	<script src="datepicker/bootstrap-datepicker.js"></script> 
	
	<script>
	
	cargarInscripciones();
	cargarNumero();
	
	$(document).on("click",".btn-eliminar",function(){
		//console.log(e);
		let cod;
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		$("#codEliminar").val(cod);
	})

	$(document).on("click",".btn-buscar",function(){
		let cod,dni,carrera,fecha
		cod=$(this).parents("tr").find("td")[0].innerHTML;

		$.get("ServletInscripcion?accion=BUSCAR&codigo="+cod,function(response){			
			$("#id-inscripcion").val(response.IdInscripcion);
			$("#id-estado").val(response.estado);
		})
		
	})
	
			function cargarInscripciones(){
		     let rol=$("#id-rol").val();
			$.get("ServletInscripcionJSON",function(e){
				
				$.each(e,function(i,item){
					if(rol==2){					
					$("#tableInscripcion").append("<tr>"+
			                "<td>"+item.IdInscripcion+"</td>"+
			                "<td>"+item.dni+"</td>"+
			                "<td>"+item.nombre+"</td>"+
			                "<td>"+item.correo+"</td>"+		                
			                "<td>"+item.IdCarrera+"</td>"+
			                "<td>"+item.nombreCarrera+"</td>"+
			                "<td>"+item.ciclo+"</td>"+
			                "<td>"+item.FecInscripcion+"</td>"+
			                "<td>"+item.estado+"</td>"+
			                "<td><button type='button' class='btn btn-info btn-buscar' data-bs-toggle='modal' data-bs-target='#modalInscripcion'><i class='bi bi-search'></i></button></td>"+
			                "<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#modalEliminar'><i class='bi bi-x-circle-fill'></i></button></td>"+
			            "</tr>");
					
					}else if(rol==1){
						$("#tableInscripcion").append("<tr>"+
				                "<td>"+item.IdInscripcion+"</td>"+
				                "<td>"+item.dni+"</td>"+
				                "<td>"+item.nombre+"</td>"+
				                "<td>"+item.correo+"</td>"+		                
				                "<td>"+item.IdCarrera+"</td>"+
				                "<td>"+item.nombreCarrera+"</td>"+
				                "<td>"+item.ciclo+"</td>"+
				                "<td>"+item.FecInscripcion+"</td>"+
				                "<td>"+item.estado+"</td>"+
				                "<td><button type='button' class='btn btn-info btn-buscar-pago' data-bs-toggle='modal' data-bs-target='#modalOrdenPago'><i class='bi bi-search'></i></button></td>"+
				            "</tr>");
						
					}
					
				})
				
			    
			})
			
		}
	
	function cargarNumero(){
		$.get("ServletOrdenPago?accion=CODIGO",function(response){
			//console.log(response);
			$("#id-numero").val(response);		
		})	
	}
	
	$(document).on("click",".btn-buscar-pago",function(){
		let cod,dni,nombre
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		dni=$(this).parents("tr").find("td")[1].innerHTML;
		nombre=$(this).parents("tr").find("td")[2].innerHTML;
		
			$("#id-ficha").val(cod);
			$("#id-dni").val(dni);
			$("#id-nombre").val(nombre);
		
		
	})
	</script> 	
	
</body>
</html>
