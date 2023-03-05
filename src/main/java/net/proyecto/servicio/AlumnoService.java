package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.ListadoAlumnos;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.AlumnoDAO;

public class AlumnoService {

	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	private AlumnoDAO alumno=fabrica.getAlumnoDAO();
	
	public int registrar(Alumno bean) {
		return alumno.create(bean);
	}
	public int actualizar(Alumno bean) {
		return alumno.update(bean);
	}
	public int deleteByDni(int dni) {
		return alumno.deleteByDni(dni);
	}
	public ListadoAlumnos findByDni(String dni) {
		return alumno.findByDni(dni);
	}
	public List<ListadoAlumnos> listAll(){
		return alumno.listAll();
		
	}

}
