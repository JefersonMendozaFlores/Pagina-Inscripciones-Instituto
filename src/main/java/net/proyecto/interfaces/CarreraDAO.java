package net.proyecto.interfaces;

import java.util.List;

import net.proyecto.entidad.Carrera;

public interface CarreraDAO {

	public int save (Carrera bean);
	public int update(Carrera bean);
	public int delete(int codigo);
	public Carrera buscar (int codigo);
	public List<Carrera> lisAll();
	public List<Carrera> listarPorNombre();
	
	
}
