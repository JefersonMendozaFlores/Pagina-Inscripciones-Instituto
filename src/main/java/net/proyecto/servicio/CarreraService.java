package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Facultad;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.interfaces.FacultadDAO;

public class CarreraService {
	
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private CarreraDAO objCa=fabrica.getCarreraDAO();
	private FacultadDAO objFa=fabrica.getFacultadDAO();
	
	
	
	
	
	public int registrar(Carrera bean) {
		return objCa.save(bean);
	}
	public int actualizar(Carrera bean) {
		return objCa.update(bean);
	}
	public int eliminarPorID(int codigo) {
		return objCa.delete(codigo);
	}
	public Carrera buscarPorID(int codigo) {
		return objCa.buscar(codigo);
	}
	public List<Carrera> listarTodos(){
		return objCa.lisAll(); 
		
	}
	public List<Facultad> listarFacultad(){
		return objFa.lisAll();
	}
	
	public List<Carrera> listarPorNombre(){
		return objCa.listarPorNombre();
	}

}
