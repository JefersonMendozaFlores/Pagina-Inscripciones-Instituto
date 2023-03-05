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
<title>Reportes</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<link href="datepicker/bootstrap-datepicker.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<h1 class="text-center">REPORTES</h1>

		<br>
		<div class="card">
			<h2>Reporte de Fichas de Inscripcion</h2>
			<div class="card-body">
				<table id="tableFichas" class="table table-striped"
					style="width: 100%">
					<thead>
						<tr>
							<th>ID Inscripcion</th>
							<th>Nro de DNI</th>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Nombre Carrera</th>
							<th>Ciclos</th>
							<th>Fecha Inscripcion</th>
							<th>Estado</th>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
		
		<!-- JS para la tabla -->
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

	<script
		src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
		
	<script>
	cargarProductos();

	function cargarProductos() {
		$.get("ServletInscripcionJSON", function(e) {
			//console.log(e);
			$.each(e, function(i, item) {
				$("#tableFichas").append(
						"<tr>"+
		                "<td>"+item.IdInscripcion+"</td>"+
		                "<td>"+item.dni+"</td>"+
		                "<td>"+item.nombre+"</td>"+
		                "<td>"+item.correo+"</td>"+		                
		                "<td>"+item.nombreCarrera+"</td>"+
		                "<td>"+item.ciclo+"</td>"+
		                "<td>"+item.FecInscripcion+"</td>"+
		                "<td>"+item.estado+"</td>"+"</tr>");
				
				 
			})
			
			$('#tableFichas').DataTable({
				"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		        dom: 'Blfrtip',
	            buttons: [      
	                {
	                    extend: 'excelHtml5',
	                    title: 'Reporte de Fichas de Inscripcion',
	                    className: 'btn_excel',
	                    text:'Excel' 
	                },
	                {
	                    extend: 'csvHtml5',
	                    title: 'Reporte de Fichas de Inscripcion', 
	                    className: 'btn_CSV',
	                    text: 'CSV' 
	                },
	                {
	                    extend: 'pdfHtml5',
	                    title: 'Reporte de Fichas de Inscripcion',
	                    className: 'btn_pdf',
	                    text: 'PDF' 
	                },
		       ]	        
			});
			
			 $('.btn_pdf').attr("class","btn btn-success mb-2 ml-5");
		        $('.btn_excel').attr("class","btn btn-success mb-2 ml-5");
		        $('.btn_CSV').attr("class","btn btn-success mb-2 ml-5");
			
		})

	}
	
	
	
	
	</script>	
</body>
</html>