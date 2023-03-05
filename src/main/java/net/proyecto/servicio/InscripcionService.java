package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Inscripcion;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.InscripcionDAO;

public class InscripcionService {
	//Paso 1: enviar origen de datos "4" al método getDAOFactory
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	//Paso 2: indicar con que método del objeto "fabrica" se va a trabajar
	private InscripcionDAO objInsc = fabrica.getInscripcionDAO();
	
	//mètodos de servicio  que sirven para invocar a los métodos del objeto "objDoc" 
	public int actualizar(Inscripcion bean) {
		return objInsc.update(bean);
	}
	public int eliminarPorID(String cod) {
		return objInsc.eliminar(cod);
	}
	public Inscripcion buscarPorID(String cod) {
		return objInsc.buscar(cod);
	}
	public List<Inscripcion> listarTodos(){
		return objInsc.listAll();
	}
	
	public Alumno buscarPorDni(int dni) {
		return objInsc.buscarAlumnoInscripcion(dni);
	}
	
	public Carrera buscarPorCod(int cod) {
		return objInsc.buscarCarrera(cod);
	}
	public List<Inscripcion> listarPorEstado(String est){
		return objInsc.listPorEstado(est);
	}
}
