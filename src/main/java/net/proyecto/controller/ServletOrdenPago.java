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

import net.proyecto.entidad.OrdenPago;
import net.proyecto.servicio.OrdenPagoService;

/**
 * Servlet implementation class ServletOrdenPago
 */
@WebServlet("/ServletOrdenPago")
public class ServletOrdenPago extends HttpServlet {
	public OrdenPagoService service = new OrdenPagoService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOrdenPago() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("ADICIONAR"))
			adicionarOrdenPago(request,response);
		else if(tipo.equals("CODIGO"))
			GenerarNumero(request,response);
	}

	private void GenerarNumero(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num = service.LlamarNumeroPAgo();
		
		Gson gson=new Gson();
		String json=gson.toJson(num);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
		
		
		
	}

	private void adicionarOrdenPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//paso 1: leer cajas
				String num,fec,idIns,monto,est;
				num=request.getParameter("numero");
				fec=request.getParameter("fecha");
				idIns=request.getParameter("ficha");
				monto= request.getParameter("monto");
				est=request.getParameter("estado");
				//paso 2: crear un objeto de la clase Requerimiento
				OrdenPago od=new OrdenPago();
				//paso 3 setear
				od.setIdComprobante(num);
				od.setFecha(Date.valueOf(fec));
				od.setIdInscripcion(idIns);
				od.setMonto(Double.parseDouble(monto));
				od.setEstado(est);
				//
				int resu=service.InsertarOrdenPago(od, idIns);
				//
				if(resu>0){
					response.sendRedirect("Inscripciones.jsp?MENSAJE=Orden de Pago registrada");
				}
				else
					response.sendRedirect("Inscripciones.jsp?MENSAJE=Error en el registro");
		
	}

}
