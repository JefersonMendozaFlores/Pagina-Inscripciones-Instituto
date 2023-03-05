package net.proyecto.entidad;

public class Inscripcion {
	private int IdCarrera;
	private String IdInscripcion,dni, nombre, correo, nombreCarrera, ciclo, estado;
	private String FecInscripcion;

	
	public String getIdInscripcion() {
		return IdInscripcion;
	}

	public void setIdInscripcion(String idInscripcion) {
		IdInscripcion = idInscripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdCarrera() {
		return IdCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFecInscripcion() {
		return FecInscripcion;
	}

	public void setFecInscripcion(String fecInscripcion) {
		FecInscripcion = fecInscripcion;
	}

}
