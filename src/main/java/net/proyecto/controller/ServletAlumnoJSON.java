package net.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.ListadoAlumnos;
import net.proyecto.servicio.AlumnoService;

/**
 * Servlet implementation class ServletAlumnoJSON
 */
@WebServlet("/ServletAlumnoJSON")
public class ServletAlumnoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAlumnoJSON() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ListadoAlumnos> data = new AlumnoService().listAll();

		Gson gson = new Gson();
		String info = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(info);

	}

}
