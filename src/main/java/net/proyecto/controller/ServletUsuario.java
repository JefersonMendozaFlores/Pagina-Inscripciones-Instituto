package net.proyecto.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.proyecto.entidad.Menu;
import net.proyecto.entidad.Usuario;
import net.proyecto.servicio.UsuarioService;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioService servicio = new UsuarioService();

	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if (tipo.equals("INGRESAR")) {
			loginUser(request, response);
		} else if (tipo.equals("CERRAR")) {
			cerrarSesion(request, response);
		}
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesionActual = request.getSession();
		// invalidar atributos de tipo sesion
		sesionActual.invalidate();
		response.sendRedirect("Index.jsp?MENSAJE=Sesion Terminada");

	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String user, pass;
		user = request.getParameter("txtUser");
		pass = request.getParameter("txtPass");

		Usuario usu = servicio.IngresoUsuario(user, pass);
		if (usu == null) {
			response.sendRedirect("Index.jsp?MENSAJE=Usuario y/o Password incorrectas");
		} else {
			List<Menu> data = servicio.MenusDelUser(usu.getIdUsuario());
			request.getSession().setAttribute("listaMenus", data);
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			request.getSession().setAttribute("fecha", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			request.getSession().setAttribute("CodigoRol", usu.getCodRol());
		}

	}

}
