package net.proyecto.interfaces;


import java.util.List;

import net.proyecto.entidad.Menu;
import net.proyecto.entidad.Usuario;

public interface UsuarioDAO {

	public Usuario LoginUser(String user, String pass);
	public List<Menu> listaMenu (int cod);
	
}
