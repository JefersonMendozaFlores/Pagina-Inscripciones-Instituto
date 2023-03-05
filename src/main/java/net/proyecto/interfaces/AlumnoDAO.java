package net.proyecto.interfaces;

import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.ListadoAlumnos;

public interface AlumnoDAO {
	public int create(Alumno alumno);
	public int update(Alumno alumno);
	public int deleteByDni(int dni);
	public List<ListadoAlumnos>listAll();
	public ListadoAlumnos findByDni(String dni);
	
}
