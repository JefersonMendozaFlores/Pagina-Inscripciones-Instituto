package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Pais;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.IPaisDAO;

public class PaisService {
	private DAOFactory factory = DAOFactory.getDAOFactory(1);
	private IPaisDAO paisDAO = factory.getPaisDAO();
	
	public List<Pais> listarPais(){
		return paisDAO.listAll();
	}
}
