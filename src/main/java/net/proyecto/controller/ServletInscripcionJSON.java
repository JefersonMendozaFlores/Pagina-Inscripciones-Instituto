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

import net.proyecto.entidad.Inscripcion;
import net.proyecto.servicio.InscripcionService;

@WebServlet("/ServletInscripcionJSON")
public class ServletInscripcionJSON extends HttpServlet {
	public InscripcionService servicio = new InscripcionService();
	private static final long serialVersionUID = 1L;
       
    public ServletInscripcionJSON() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rol=(int) request.getSession().getAttribute("CodigoRol");
		List<Inscripcion> data=null;
		if(rol == 2) {
			data = servicio.listarTodos();
		}else if(rol == 1){
			data = servicio.listarPorEstado("GENERADO");
		}
		
		
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

}
