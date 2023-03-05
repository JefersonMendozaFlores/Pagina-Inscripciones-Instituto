package net.proyecto.interfaces;

import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Registro;

public interface RegistroDAO {
	
	public String numeroGenerado();
	public int save(Registro bean);

}
