package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Distrito;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.IDistritoDAO;

public class DistritoService {
	private DAOFactory factory = DAOFactory.getDAOFactory(1);
	private IDistritoDAO distritoDAO = factory.getDistritoDAO();
	
	public List<Distrito> listarDistrito(){
		return distritoDAO.listAll();
	}
}
