package net.proyecto.entidad;

import java.sql.Date;

public class Registro {

	 private String  DNI,num_Registro, estado,idInscripcion;
	 private int id_Carrera;
	 private Date fec_Inscripccion;
	 
	 
	 
	public String getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(String idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public String getNum_Registro() {
		return num_Registro;
	}
	public void setNum_Registro(String num_Registro) {
		this.num_Registro = num_Registro;
	}
	
	public int getId_Carrera() {
		return id_Carrera;
	}
	public void setId_Carrera(int id_Carrera) {
		this.id_Carrera = id_Carrera;
	}
	public Date getFec_Inscripccion() {
		return fec_Inscripccion;
	}
	public void setFec_Inscripccion(Date fec_Inscripccion) {
		this.fec_Inscripccion = fec_Inscripccion;
	}
	 
	 
	 
}
