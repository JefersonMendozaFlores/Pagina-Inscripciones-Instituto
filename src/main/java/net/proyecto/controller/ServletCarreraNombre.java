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

import net.proyecto.servicio.CarreraService;

/**
 * Servlet implementation class ServletCarreraNombre
 */
@WebServlet("/ServletCarreraNombre")
public class ServletCarreraNombre extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarreraNombre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PASO 1:invocar al método listarCondiciones 
		List<Carrera> lista=new CarreraService().listarPorNombre();
		//PASO 2:crear objeto de la clase Gson
		Gson gson=new Gson();
		//PASO 3: serializar(pasar de objeto JAVA a JSON)
		//método toJson retorna un JSON pero en String
		String json=gson.toJson(lista);
		//PASO 4:indicar al navegador que el formato de salida es un JSON VERDADERO
		response.setContentType("application/json;charset=UTF-8");
		//PASO 5:mostrar el valor de la variable "json" en el navegador
		PrintWriter salida=response.getWriter();
		salida.println(json);

	}

}
