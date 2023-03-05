package net.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.proyecto.entidad.Inscripcion;
import net.proyecto.servicio.InscripcionService;

@WebServlet("/ServletInscripcion")
public class ServletInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InscripcionService servicioInsc=new InscripcionService();
       
    public ServletInscripcion() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar párametro "accion" que viene de la pàgina docente.jsp para saber que acción se va a realizar
		String tipo;
		tipo=request.getParameter("accion");
		//evaluar el tipo de acción
		if(tipo.equals("ACTUALIZAR"))
			actualizarInscripcion(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarDocente(request,response);
		else if(tipo.equals("LISTAR"))
			listarDocente(request,response);	
		else if(tipo.equals("BUSCAR"))
			buscarDocente(request,response);
	}

	private void buscarDocente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod=request.getParameter("codigo");
		Inscripcion data = servicioInsc.buscarPorID(cod);
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

	private void listarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al mètodo listAll
		List<Inscripcion> datos=servicioInsc.listarTodos();
		//crear atributo
		request.setAttribute("inscripcion", datos);
		//PARA EL COMBOBOX - GUIA CLASE_SESION10 - SERVLET DOCENTE
		
		//direccionar a la pàgina para enviar atributo
		request.getRequestDispatcher("/Inscripciones.jsp").forward(request, response);
	}

	private void eliminarDocente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//recuperar codigo a eliminar caja con atrinuto name "codigoEliminar" del modal "modalEliminar"
		String cod=request.getParameter("codigoEliminar");
		//
		String msj;
		//
		int salida=servicioInsc.eliminarPorID(cod);
		//validar salida
		if(salida>0)
			//mensaje cuando es +
			//request.setAttribute("MENSAJE", "Docente eliminado");
			msj="Inscripcion eliminada";
		else
			//mensaje cuando es -
			//request.setAttribute("MENSAJE", "Error en la eliminaciòn");
			msj="Error en la eliminación";
		//listarDocente(request, response);
		response.sendRedirect("Inscripciones.jsp?MENSAJE="+msj);
	}

	private void actualizarInscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		//variables
		String idInscrip,estado,msj;
		//leer los controles del formulario(cajas,select)
		idInscrip = request.getParameter("codigo");
		estado = request.getParameter("Estado");
		Inscripcion bean = new Inscripcion();
		bean.setIdInscripcion(idInscrip);
		bean.setEstado(estado);
		//bean.getDate(new java.sql.Date(bean.setFecInscripcion().get));
		//bean.setFecInscripcion(new java.sql.Date());
		int est = servicioInsc.actualizar(bean);
		if (est>0) {
			msj = "Inscripcion actualizada";
		}else {
			msj = "Error en la actualizacion";
		}
		response.sendRedirect("Inscripciones.jsp?MENSAJE="+msj);
	}


}
