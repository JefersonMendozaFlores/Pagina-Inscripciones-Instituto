package net.proyecto.servicio;

import net.proyecto.entidad.OrdenPago;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.OrdenPagoDAO;

public class OrdenPagoService {
	
	//Paso 1: enviar origen de datos "4" al método getDAOFactory
		private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		//Paso 2: indicar con que método del objeto "fabrica" se va a trabajar
		private OrdenPagoDAO objOrd = fabrica.getOrdenPago();
		
		
		
		public int InsertarOrdenPago(OrdenPago ord, String id) {
			return objOrd.grabarOrden(ord, id);
		}
		
		
		public String LlamarNumeroPAgo() {
			
			return objOrd.GenerarNumeroPago();
			
		}

}
