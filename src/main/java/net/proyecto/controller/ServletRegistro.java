package net.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.proyecto.entidad.Registro;
import net.proyecto.servicio.RegistroService;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	
	private RegistroService servicio=new RegistroService();
	private static final long serialVersionUID = 1L;
       
    
    public ServletRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("CODIGO"))
			numeroRegistro(request,response);
		else if(tipo.equals("GRABAR"))
			grabarRegistro(request,response);
		}


	private void grabarRegistro(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// paso 1: leer cajas
				String idInscripcion, num, fec, dni, carrera;

				idInscripcion = request.getParameter("idInscripcion");
				num = request.getParameter("numero");
				fec = request.getParameter("fecha");
				dni = request.getParameter("dni");
				carrera = request.getParameter("facultad");
				// paso 2: crear un objeto de la clase Requerimiento
				Registro re = new Registro();
				// paso 3 setear
				re.setIdInscripcion(num);
				re.setFec_Inscripccion(Date.valueOf(fec));
				re.setDNI(dni);
				re.setId_Carrera(Integer.parseInt(carrera));
				re.setEstado("GENERADO");

				//
				int resu = servicio.RegistrarInscripcion(re);
				//
				if (resu > 0) {

					// actualizar aributo carrito

					response.sendRedirect("FichaInscripcion.jsp?MENSAJE=Registro guardado");
				} else
					response.sendRedirect("FichaInscripcion.jsp?MENSAJE=Error en el registro");
		

		
	}


	private void numeroRegistro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero=servicio.generarCodigo();
		Gson gson=new Gson();
		String json=gson.toJson(numero);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
		
	}

}
