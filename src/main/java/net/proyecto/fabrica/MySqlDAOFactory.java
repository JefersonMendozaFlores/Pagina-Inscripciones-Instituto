package net.proyecto.fabrica;

import net.proyecto.dao.MySqlAlumnoDAO;
import net.proyecto.dao.MySqlCarreraDao;
import net.proyecto.dao.MySqlDistritoDAO;
import net.proyecto.dao.MySqlFacultadDAO;
import net.proyecto.dao.MySqlInscripcionDAO;
import net.proyecto.dao.MySqlOrdenPagoDAO;
import net.proyecto.dao.MySqlPaisDAO;
import net.proyecto.dao.MySqlRegistroDAO;
import net.proyecto.dao.MySqlUsuarioDAO;
import net.proyecto.interfaces.AlumnoDAO;
import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.interfaces.FacultadDAO;
import net.proyecto.interfaces.IDistritoDAO;
import net.proyecto.interfaces.IPaisDAO;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.interfaces.OrdenPagoDAO;
import net.proyecto.interfaces.RegistroDAO;
import net.proyecto.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	public CarreraDAO getCarreraDAO() {

		return new MySqlCarreraDao();

	}

	
	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new MySqlAlumnoDAO();
	}

	@Override
	public FacultadDAO getFacultadDAO() {
		// TODO Auto-generated method stub
		return new MySqlFacultadDAO();
	}

	@Override
	public RegistroDAO getRegistroDAO() {
		// TODO Auto-generated method stub
		return new MySqlRegistroDAO();
	}

	@Override
	public InscripcionDAO getInscripcionDAO() {
		// TODO Auto-generated method stub
		return new MySqlInscripcionDAO();
	}

	@Override
	public IDistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return new MySqlDistritoDAO();
	}

	@Override
	public IPaisDAO getPaisDAO() {
		// TODO Auto-generated method stub
		return new MySqlPaisDAO();
	}

	@Override
	public OrdenPagoDAO getOrdenPago() {
		// TODO Auto-generated method stub
		return new MySqlOrdenPagoDAO();
	}


}
