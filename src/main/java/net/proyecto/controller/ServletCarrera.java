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
import net.proyecto.entidad.Facultad;
import net.proyecto.servicio.CarreraService;
import net.proyecto.dao.MySqlCarreraDao;

/**
 * Servlet implementation class ServletCarrera
 */
@WebServlet("/ServletCarrera")
public class ServletCarrera extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarreraService servicioCa = new CarreraService();

	public ServletCarrera() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperar párametro "accion" que viene de la pàgina docente.jsp para saber
		// que acción se va a realizar
		String tipo;
		tipo = request.getParameter("accion");
		// evaluar el tipo de acción
		if (tipo.equals("GRABAR"))
			grabarCarrera(request, response);
		else if (tipo.equals("ELIMINAR"))
			eliminarCarrera(request, response);
		else if (tipo.equals("LISTAR"))
			listarCarrera(request, response);
		else if (tipo.equals("BUSCAR"))
			buscarCarrera(request, response);

	}

	private void buscarCarrera(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String codigo = request.getParameter("codigo");
		Carrera data = servicioCa.buscarPorID(Integer.parseInt(codigo));
		Gson gson = new Gson();
		String info = gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida = response.getWriter();
		salida.println(info);

	}

	private void listarCarrera(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Carrera> datos = servicioCa.listarTodos();

		request.setAttribute("carrera", datos);

		List<Facultad> datosFacu = servicioCa.listarFacultad();
		request.setAttribute("facultad", datosFacu);

		request.getRequestDispatcher("/carreraJSTL.jsp").forward(request, response);

	}

	private void eliminarCarrera(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reuperar còdigo a eliminar caja con atrinuto name "codigoEliminar" del modal
		// "modalEliminar"
		String codigo = request.getParameter("codigoEliminar");
		//
		String msj;
		// invocar al mètodo eliminar
		int salida = servicioCa.eliminarPorID(Integer.parseInt(codigo));
		// validar salida
		if (salida > 0)
			// mensaje cuando es +
			// request.setAttribute("MENSAJE", "Docente eliminado");
			msj = "Carrera eliminado";
		else
			// mensaje cuando es -
			// request.setAttribute("MENSAJE", "Error en la eliminaciòn");
			msj = "Error en la eliminaciòn";
		// listarDocente(request, response);
		response.sendRedirect("carrera.jsp?MENSAJE=" + msj);

	}

	private void grabarCarrera(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// variables
		String codigo, nomCarrera, codfacultad, ciclo, creditos, msj;
		// leer los controles del formulario(cajas,select)
		codigo = request.getParameter("codigo");
		nomCarrera = request.getParameter("nomCarrera");
		codfacultad = request.getParameter("facultad");
		ciclo = request.getParameter("ciclo");
		creditos = request.getParameter("creditos");
		// crear objeto de la clase Docente
		Carrera bean = new Carrera();
		// setear los atributos del objeto "bean" con las variables
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setNomCarrera(nomCarrera);
		bean.setCodfacultad(Integer.parseInt(codfacultad));
		bean.setCiclo(ciclo);
		bean.setCreditos(Integer.parseInt(creditos));
		// validar código
		if (Integer.parseInt(codigo) == 0) {
			// invocar al mètodo save
			int estado;
			estado = servicioCa.registrar(bean);
			// validar "estado"
			if (estado > 0)
				// crear atributo
				// request.setAttribute("MENSAJE", "Docente registrado correctamente");
				msj = "Carrera registrado correctamente";
			else
				// crear atributo
				// request.setAttribute("MENSAJE", "Error en el registro de Docente");
				msj = "Error en el registro de Carrera";
		} else {
			// invocar al mètodo update
			int estado;
			estado = servicioCa.actualizar(bean);
			// validar "estado"
			if (estado > 0)
				// crear atributo
				// request.setAttribute("MENSAJE", "Docente actualizado correctamente");
				msj = "Docente actualizado correctamente";
			else
				// crear atributo
				// request.setAttribute("MENSAJE", "Error en la actualizaciòn");
				msj = "Error en la actualizaciòn";
		}
		// invocar
		// listarDocente(request, response);
		response.sendRedirect("carrera.jsp?MENSAJE=" + msj);
	}

}
