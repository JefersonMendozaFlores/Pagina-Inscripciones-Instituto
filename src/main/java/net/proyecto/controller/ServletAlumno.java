package net.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Distrito;
import net.proyecto.entidad.ListadoAlumnos;
import net.proyecto.entidad.Pais;
import net.proyecto.servicio.AlumnoService;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoService alumnoService = new AlumnoService();

	public ServletAlumno() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperar párametro "accion" que viene de la pàgina docente.jsp para saber
		// que acción se va a realizar
		String tipo = "";
		tipo = request.getParameter("accion");
		// evaluar el tipo de acción
		if (tipo.equals("DELETE"))
			deleteByDni(request, response);

		else if (tipo.equals("BUSCAR"))
			findByDni(request, response);

		else if (tipo.equals("CREAR"))
			create(request, response);

		else if (tipo.equals("ACTUALIZAR"))
			update(request, response);
	}

	private void deleteByDni(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String dni = request.getParameter("dni");

		//
		String mensaje;
		// invocar al mètodo eliminar
		int salida = alumnoService.deleteByDni(Integer.parseInt(dni));
		// validar salida
		if (salida > 0)
			// mensaje cuando es +
			// request.setAttribute("MENSAJE", "Docente eliminado");
			mensaje = "Alumno eliminado";
		else
			// mensaje cuando es -
			// request.setAttribute("MENSAJE", "Error en la eliminaciòn");
			mensaje = "Error en la eliminaciòn";
		// listarDocente(request, response);
		response.sendRedirect("MantenimientoAlumno.jsp?MENSAJE=" + mensaje);

	}

	private void findByDni(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dni = request.getParameter("dni");

		ListadoAlumnos data = alumnoService.findByDni(dni);

		Gson gson = new Gson();
		String info = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(info);

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// variables
		String dni, nombre, apellido, fechaNacimiento, correo, direccion, mensaje = "";
		int pais, distrito;

		// leer los controles del formulario(cajas,select)
		dni = request.getParameter("dni");
		nombre = request.getParameter("name");
		apellido = request.getParameter("lastname");
		fechaNacimiento = request.getParameter("birth");
		correo = request.getParameter("email");
		direccion = request.getParameter("address");
		pais = Integer.parseInt(request.getParameter("country"));
		distrito = Integer.parseInt(request.getParameter("distric"));

		// crear objeto de la clase Docente
		Alumno bean = new Alumno();
		// setear los atributos del objeto "bean" con las variables
		bean.setDni(Integer.parseInt(dni));
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setFechaNacimiento(fechaNacimiento);
		bean.setCorreo(correo);
		bean.setDireccion(direccion);
		
		
		Pais beanPais = new Pais();
		beanPais.setCodPais(pais);
		bean.setPais(beanPais);
		
		Distrito beanDistrito = new Distrito();
		beanDistrito.setCodDistrito(distrito);
		bean.setDistrito(beanDistrito);

		// validar código
		// invocar al mètodo save
		int estado;
		estado = alumnoService.registrar(bean);
		// validar "estado"
		if (estado > 0) {
			mensaje = "Alumno registrado correctamente";
		} else {
			mensaje = "Error en el registro del Alumno";
		}

		// invocar
		response.sendRedirect("MantenimientoAlumno.jsp?MENSAJE=" + mensaje);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// variables
		String dni, nombre, apellido, fechaNacimiento, correo, direccion, mensaje = "";
		int pais, distrito;
		
		// leer los controles del formulario(cajas,select)
		dni = request.getParameter("dni");
		nombre = request.getParameter("name");
		apellido = request.getParameter("lastname");
		fechaNacimiento = request.getParameter("birth");
		correo = request.getParameter("email");
		direccion = request.getParameter("address");
		pais = Integer.parseInt(request.getParameter("country"));
		distrito = Integer.parseInt(request.getParameter("distric"));

		// crear objeto de la clase Docente
		Alumno bean = new Alumno();
		// setear los atributos del objeto "bean" con las variables
		bean.setDni(Integer.parseInt(dni));
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setFechaNacimiento(fechaNacimiento);
		bean.setCorreo(correo);
		bean.setDireccion(direccion);
		
		Pais beanPais = new Pais();
		beanPais.setCodPais(pais);
		bean.setPais(beanPais);
		
		Distrito beanDistrito = new Distrito();
		beanDistrito.setCodDistrito(distrito);
		bean.setDistrito(beanDistrito);

		String msj = "";
		// invocar al mètodo eliminar
		int salida = alumnoService.actualizar(bean);
		// validar salida
		if (salida > 0) {
			msj = "Alumno actualizado";
		} else {
			msj = "Error en la actualización";
		}
		response.sendRedirect("MantenimientoAlumno.jsp?MENSAJE=" + msj);
	}

}
