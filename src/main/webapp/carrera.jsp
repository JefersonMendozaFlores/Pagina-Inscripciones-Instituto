<%
	if(request.getSession().getAttribute("listaMenus")==null)
		response.sendRedirect("Index.jsp?MENSAJE=Iniciar login");
%>
<jsp:include page="Principal.jsp" />
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento Carrera</title>
 <!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
	
	<style>
		.modal-header{
		color:#fff;
		background: #428bca;
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
	  
</head>
<body>
	<div class="container">
	
		<c:if test="${param.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>SISTEMA</strong> ${param.MENSAJE}
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<h3 class="text-center">LISTADO DE CARRERA</h3>	  
	  	<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalCarrera">
	  		Nueva Carrera
	  	</button>
	  	
	  	<!-- Modal PARA REGISTRAR-->
		<div class="modal fade" id="modalCarrera" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">CARRERA</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formCarrera" action="ServletCarrera?accion=GRABAR" method="post">
				  <div class="form-group">
				    <label for="exampleNombre" class="form-label">Código</label>
				    <input type="text" class="form-control" name="codigo" readonly value="0" id="id-codigo">
				  </div>
				  <div class="form-group">
				    <label for="exampleNombre" class="form-label">Nombre de Carrera</label>
				    <input type="text" class="form-control" name="nomCarrera" id="id-nomCarrera">
				  </div>
				  <div class="form-group">
				    <label for="exampleCondicion" class="form-label">Facultad</label>
				    <select class="form-select form-control" name="facultad" id="id-codfacultad">
					  <option value="" selected>[Seleccione Facultad]</option>
					</select>
				  </div>
				 <div class="form-group">
				    <label for="exampleMaterno" class="form-label">Ciclo</label>
				    <input type="text" class="form-control" name="ciclo" id="id-ciclo" >
				  </div>	
				 <div class="form-group">
				    <label for="exampleHijos" class="form-label">Creditos</label>
				    <input type="text" class="form-control" name="creditos" id="id-creditos" >
				  </div> 
				 
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-success"><i class="bi bi-arrow-up-circle-fill"></i>&nbsp Actualizar</button>
			        <button type="button" class="btn btn-warning" data-bs-dismiss="modal"><i class="bi bi-x-octagon-fill"></i>&nbsp Salir</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA REGISTRAR-->
	    
	    
	  	<!-- Modal PARA ELIMINAR-->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">SISTEMA</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="formCarrera" action="ServletCarrera?accion=ELIMINAR" method="post">
		        	<h4>Seguro de eliminar Carrera?</h4>
				    <input type="hidden" class="form-control" name="codigoEliminar" id="codEliminar">
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-primary"><i class="bi bi-check2-square"></i>&nbsp SI</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="bi bi-x-octagon-fill"></i>&nbsp NO</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	    <!--fin modal PARA ELIMINAR-->	    
	    
	    
	    
	    
	    
	    <div class="mt-5">
	    <table id="tableCarrera" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>CÓDIGO</th>
                <th>NOMBRE DE CARRERA</th>
                <th>FACULTAD</th>
                <th>CICLO</th>
                <th>CREDITOS</th>
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

	
	
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

	<!-- JS para la tabla -->
	<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

	<!--JS para validar  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
	
	<script src="datepicker/bootstrap-datepicker.js"></script> 
	
	
	<script>
		
		cargarFacultad();
		cargarCarrera();
		
		//asignar evento click a todos los botones con CLASE "btn-eliminar"
		//usamos jquery
		$(document).on("click",".btn-eliminar",function(){
			//variable
			let cod;
			//leer columna còdigo de la fila actual según el botòn eliminar que hizo click
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			//alert(cod);
			$("#codEliminar").val(cod);
		})
		//asignar evento click a todos los botones con CLASE "btn-buscar"
		//usamos jquery
		$(document).on("click",".btn-buscar",function(){
			//variables
			let codigo,nomCarrera,codfacultad,ciclo,creditos; 
			//leer columnas de la fila actual según el botòn buscar que hizo click
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			/*nom=$(this).parents("tr").find("td")[1].innerHTML;
			pat=$(this).parents("tr").find("td")[2].innerHTML;
			mat=$(this).parents("tr").find("td")[3].innerHTML;
			sexo=$(this).parents("tr").find("td")[4].innerHTML;
			hijos=$(this).parents("tr").find("td")[5].innerHTML;
			sue=$(this).parents("tr").find("td")[6].innerHTML;*/
			$.get("ServletCarrera?accion=BUSCAR&codigo="+cod,function(response){
				console.log(response);
				//mostrar en las controles del modalDocente
				$("#id-codigo").val(response.codigo);
				$("#id-nomCarrera").val(response.nomCarrera);
				$("#id-codfacultad").val(response.codfacultad);
				$("#id-ciclo").val(response.ciclo);
				$("#id-creditos").val(response.creditos);
				
			})
			
		})
		//crear función que lea el json que retorna el servlet "ServletCondicionJSON" 
		function cargarFacultad(){
			//función en JQUERY que permite leer un JSON
			$.get("ServletFacultadJSON",function(response){
				//console.log(response);
				//bucle para realizar recorrido sobre "response"
				$.each(response,function(index,item){
					$("#id-codfacultad").append("<option value='"+item.codFacultad+"'>"+item.nomFacultad+"</option>");
				})
			})
		}
		//crear función que lea el json que retorna el servlet "ServletDocenteJSON" 
		function cargarCarrera(){
			$.get("ServletCarreraJSON",function(e){
				//console.log(e);
				$.each(e,function(i,item){
					$("#tableCarrera").append("<tr>"+
			                "<td>"+item.codigo+"</td>"+
			                "<td>"+item.nomCarrera+"</td>"+
			                "<td>"+item.nomFacultad+"</td>"+
			                "<td>"+item.ciclo+"</td>"+
			                "<td>"+item.creditos+"</td>"+
			                "<td><button type='button' class='btn btn-info btn-buscar' data-bs-toggle='modal' data-bs-target='#modalCarrera'><i class='bi bi-search'></i></button></td>"+
			                "<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#modalEliminar'><i class='bi bi-archive-fill'></i></button></td>"+
			            "</tr>");
				})
			    $('#tableCarrera').DataTable();
			})
			
		}
			
	</script>

	<script>
		$(document).ready(function () {
		    //validación
		    $('#formCarrera').bootstrapValidator({      
	        	 fields:{
	        		 	nomCarrera:{
	        		 		validators:{
	        		 			notEmpty:{
	        		 				message:'Campo nombre carrera es obligatorio'
	        		 			},
	        		 			regexp:{
	        		 				regexp:/^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{3,40}$/,
	        		 				message:'Campo nombre solo letras MIN:3 MAX:20'
	        		 			}
	        		 		}
	        		 	},
	        		 	codfacultad:{
	        		 		validators:{
	        		 			notEmpty:{
	        		 				message:'Campo facultad es obligatorio'
	        		 			}
	        		 		}
	        		 	},
	        		 	ciclo:{
	        		 		validators:{
	        		 			notEmpty:{
	        		 				message:'Campo ciclo es obligatorio'
	        		 			},
	        		 			regexp:{
	        		 				regexp:/^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{1,40}$/,
	        		 				message:'Campo ciclo solo letras MIN:1 MAX:5'
	        		 			}
	        		 		}
	        		 	},
	        		 	creditos:{
	        		 		validators:{
	        		 			notEmpty:{
	        		 				message:'Campo creditos es obligatorio'
	        		 			},
	        		 			regexp:{
	        		 				regexp:/^([1-9][0-9][0-9])$/,
	        		 				message:'Campo creditos MIN:0 MAX:3'
	        		 			}
	        		 		}
	        		 	},
	        		 	
	        		 	        		 	
	        	 }
	        })
	        
		});
	</script>
	
	
</body>
</html>









