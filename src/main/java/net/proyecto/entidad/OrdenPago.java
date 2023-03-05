package net.proyecto.entidad;

import java.sql.Date;

public class OrdenPago {

	private String idComprobante, idInscripcion, estado;
	private Date fecha;
	private Double monto;

	public String getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(String idComprobante) {
		this.idComprobante = idComprobante;
	}

	public String getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(String idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
