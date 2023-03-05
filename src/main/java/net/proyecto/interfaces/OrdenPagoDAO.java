package net.proyecto.interfaces;

import net.proyecto.entidad.OrdenPago;

public interface OrdenPagoDAO {

	public int grabarOrden(OrdenPago ord, String ins);
	
	public String GenerarNumeroPago();
}
