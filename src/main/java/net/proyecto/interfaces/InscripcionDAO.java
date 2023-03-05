package net.proyecto.interfaces;

import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Inscripcion;

public interface InscripcionDAO {
	public int update(Inscripcion bean);
	public int eliminar(String cod);
	public Inscripcion buscar(String cod);
	public List<Inscripcion> listAll();
	public Alumno buscarAlumnoInscripcion(int dni);
	public Carrera buscarCarrera(int cod);
	public List<Inscripcion> listPorEstado(String est);
}
