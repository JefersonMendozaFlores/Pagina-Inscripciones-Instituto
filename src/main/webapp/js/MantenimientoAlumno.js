/**
 * 
 */
 
 /* Variables */

const validationForStudent = {
		fields: {
			dni: {
				validators: {
					notEmpty: {
						message: "Campo DNI obligatorio"
					},
					regexp: {
						regexp: /^[0-9]{8}$/,
						message: "Campo DNI 8 digitos"
					}
				}

			}, name: {
				validators: {
					notEmpty: {
						message: 'Campo nombre es obligatorio'
					},
					regexp: {
						regexp: /^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{2,25}$/,
						message: 'Campo tipo solo letras MIN:2 MAX:25'
					}
				}

			}, lastname: {
				validators: {
					notEmpty: {
						message: 'Campo apellidos es obligatorio'
					},
					regexp: {
						regexp: /^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{2,25}$/,
						message: 'Campo tipo solo letras MIN:2 MAX:25'
					}
				}

			}, birth: {
				validators: {
					notEmpty: {
						message: 'Campo fecha de nacimiento es obligatorio yy/mm/dd'
					}
				}

			}, email: {
				validators: {
					notEmpty: {
						message: 'Campo correo es obligatorio "name@gmail.com"'
					}
				}
			},

			address: {
				validators: {
					notEmpty: {
						message: 'Campo direcci&#243n es obligatorio'
					},
					regexp: {
						regexp: /^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú0-9]{10,200}$/,
						message: 'Campo tipo solo letras MIN:10 MAX:200'
					}
				}

			}, 
			distric:{
		 		validators:{
		 			notEmpty:{
		 				message:'Campo distrito es obligatorio'
		 			}
		 		}
		 	},
		 	country:{
		 		validators:{
		 			notEmpty:{
		 				message:'Campo pais es obligatorio'
		 			}
		 		}
		 	},
		}
	}; 


/** Funciones */
$(document).ready(function() {

	//validar formulario
	validateStudentForm();
	getStudents();
	filterStudent();
	getStudentByDNI();
	setStudentToDelete();
	getDistritos();
	getPaises();


});


function validateStudentForm() {
	$("#formAlumno").bootstrapValidator(validationForStudent);
	$("#formAlumnoActualizar").bootstrapValidator(validationForStudent);
}

function getStudents() {
	$.get("ServletAlumnoJSON", function(response) {
		console.log(response);
		$.each(response, function(i, item) {
 
			let nombreCarrera = (item.carrera.nomCarrera == undefined) ? ""
				: item.carrera.nomCarrera;
			let cicloCarrera = (item.carrera.ciclo == undefined) ? ""
				: item.carrera.ciclo
			let fechaInscripcion = (item.fechaInscripcion == undefined) ? ""
				: item.fechaInscripcion;
                   
			$(
				"#tableStudent")
				.append(
					"<tr>"
					+ "<td>"
					+ item.alumno.dni
					+ "</td>"
					+ "<td>"
					+ item.alumno.nombre
					+ "</td>"
					+ "<td>"
					+ item.alumno.apellido
					+ "</td>"
					+ "<td>"
					+ item.alumno.fechaNacimiento
					+ "</td>"
					+ "<td>"
					+ item.alumno.correo
					+ "</td>"
					+ "<td>"
					+ nombreCarrera
					+ "</td>"
					+ "<td>"
					+ cicloCarrera
					+ "</td>"
					+ "<td>"
					+ item.alumno.direccion
					+ "</td>"
					+ "<td>"
					+ fechaInscripcion
					+ "</td>"
					+ "<td>"
					+ item.alumno.distrito.nomDistrito
					+ "</td>"
					+ "<td>"
					+ item.alumno.pais.nomPais
					+ "</td>"
					+ "<td><button type='button' class='btn btn-info btn-buscar' data-bs-toggle='modal' data-bs-target='#modalAlumno'><i class='bi bi-search'></i>Actualizar</button></td>"
					+ "<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#modalEliminar'><i class='bi bi-archive-fill'></i>Eliminar</button></td>"
					+ "</tr>");
		});
	});
}

function filterStudent() {
	$(document).on("click", "#btn-consultar", function() {

		let dni = $("#dni").val();
		$("#tableStudent tbody").empty();

		$.get("ServletAlumno?accion=BUSCAR&dni=" + dni,
			function(response) {
                 
				if (response == null)
					return;

				let nombreCarrera = (response.carrera.nomCarrera == undefined) ? ""
				: response.carrera.nomCarrera;
				let cicloCarrera = (response.carrera.ciclo == undefined) ? ""
					: response.carrera.ciclo
				let fechaInscripcion = (response.fechaInscripcion == undefined) ? ""
					: response.fechaInscripcion;


				$("#tableStudent").append(
					"<tr>"
					+ "<td>"
					+ response.alumno.dni
					+ "</td>"
					+ "<td>"
					+ response.alumno.nombre
					+ "</td>"
					+ "<td>"
					+ response.alumno.apellido
					+ "</td>"
					+ "<td>"
					+ response.alumno.fechaNacimiento
					+ "</td>"
					+ "<td>"
					+ response.alumno.correo
					+ "</td>"
					+ "<td>"
					+ nombreCarrera
					+ "</td>"
					+ "<td>"
					+ cicloCarrera
					+ "</td>"
					+ "<td>"
					+ response.alumno.direccion
					+ "</td>"
					+ "<td>"
					+ fechaInscripcion
					+ "</td>"
					+ "<td>"
					+ response.alumno.pais
					+ "</td>"
					+ "<td><button type='button' class='btn btn-info btn-buscar' data-bs-toggle='modal' data-bs-target='#modalAlumno'>Actualizar</button></td>"
					+ "<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#modalEliminar'>Eliminar</button></td>"
					+ "</tr>");
			})
	});
}


function getStudentByDNI() {
	$(document).on(
		"click",
		".btn-buscar",
		function() {
			let dni = $(this).parents("tr").find("td")[0].innerHTML;
			$.get("ServletAlumno?accion=BUSCAR&dni=" + dni, function(response) {
				
				$("#id-update-dni").val(response.alumno.dni);
				$("#id-update-name").val(response.alumno.nombre);
				$("#id-update-lastname").val(response.alumno.apellido);
				$("#id-update-birth").val(response.alumno.fechaNacimiento);
				$("#id-update-email").val(response.alumno.correo);
				$("#id-update-address").val(response.alumno.direccion);
				$("#id-update-codDistrito").val(response.alumno.distrito.codDistrito);
				$("#id-update-codPais").val(response.alumno.pais.codPais);
			})
		})
}

function setStudentToDelete(){
	$(document).on("click",".btn-eliminar",function(){
			//variable
			let dni;
			//leer columna còdigo de la fila actual según el botòn eliminar que hizo click
			dni=$(this).parents("tr").find("td")[0].innerHTML;
			//alert(cod);
			$("#codEliminar").val(dni);
		})
}

function getDistritos(){
	//función en JQUERY que permite leer un JSON
	$.get("ServletDistritoJSON",function(response){
		//console.log(response);
		//bucle para realizar recorrido sobre "response"
		$.each(response,function(index,item){
			$(".district").append("<option value='"+item.codDistrito+"'>"+item.nomDistrito+"</option>");
		})
	})
}

function getPaises(){
	//función en JQUERY que permite leer un JSON
	$.get("ServletPaisJSON",function(response){
		//console.log(response);
		//bucle para realizar recorrido sobre "response"
		$.each(response,function(index,item){
			$(".country").append("<option value='"+item.codPais+"'>"+item.nomPais+"</option>");
		})
	})
}

