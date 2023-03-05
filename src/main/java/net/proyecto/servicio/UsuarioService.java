package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Menu;
import net.proyecto.entidad.Usuario;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.UsuarioDAO;

public class UsuarioService {

	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	
	private UsuarioDAO objUsuario = fabrica.getUsuarioDAO();
	
	public Usuario IngresoUsuario(String user, String pass) {
		return objUsuario.LoginUser(user, pass);
	}
	  
	public List<Menu> MenusDelUser(int cod) {
		return objUsuario.listaMenu(cod);
	}
}
