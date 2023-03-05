package net.proyecto.servicio;

import net.proyecto.entidad.Registro;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.RegistroDAO;

public class RegistroService {
	
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private RegistroDAO objReg=fabrica.getRegistroDAO();
	
	public String generarCodigo(){
		return objReg.numeroGenerado();
	}
	
	public int RegistrarInscripcion(Registro bean) {
		return objReg.save(bean);
	}

}
