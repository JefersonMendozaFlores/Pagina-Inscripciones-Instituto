package net.proyecto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.servicio.InscripcionService;

/**
 * Servlet implementation class ServletAlumnoPorDni
 */
@WebServlet("/ServletAlumnoPorDni")
public class ServletAlumnoPorDni extends HttpServlet {
	
	private InscripcionService servicioPorDni= new InscripcionService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnoPorDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo;
		tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarAlumnoPorDni(request,response);
		else if(tipo.equals("CARRERA"))
			buscarCarreraPorCod(request, response);
	}

	private void buscarCarreraPorCod(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod=request.getParameter("cod");
		Carrera data=servicioPorDni.buscarPorCod(Integer.parseInt(cod));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
		
	}

	private void buscarAlumnoPorDni(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String dni=request.getParameter("dni");
		Alumno data=servicioPorDni.buscarPorDni(Integer.parseInt(dni));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
		
	}

}
