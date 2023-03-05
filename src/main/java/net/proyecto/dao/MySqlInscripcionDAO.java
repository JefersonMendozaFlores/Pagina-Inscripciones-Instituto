package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Inscripcion;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlInscripcionDAO implements InscripcionDAO {

	@Override
	public int update(Inscripcion bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql= "update inscripcion set estado=? where idInscripcion=? ";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getEstado());
			pstm.setString(2, bean.getIdInscripcion());
			//pstm.setDate(3, new java.sql.Date(bean.getFecInscripcion().getDate()));
			//5
			salida=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int eliminar(String cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql= "update inscripcion set estado='ANULADO' where idInscripcion=? ";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1,cod);
			//pstm.setDate(3, new java.sql.Date(bean.getFecInscripcion().getDate()));
			//5
			salida=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public Inscripcion buscar(String cod) {
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Inscripcion i = null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select idInscripcion ,estado from inscripcion where idInscripcion=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, cod);;
			//5
			rs=pstm.executeQuery();
			//6
			if(rs.next()) {
				//7
				i = new Inscripcion();
				//8
				i.setIdInscripcion(rs.getString(1));
				i.setEstado(rs.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public List<Inscripcion> listAll() {
		List<Inscripcion> lista=new ArrayList<Inscripcion>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select i.idInscripcion, i.DNI, a.nombre, a.correo, i.id_Carrera, c.nom_Carrera, c.ciclo, i.fec_Inscripcion, i.estado "+
					  "from inscripcion i inner join alumno a on i.DNI = a.DNI "+
					  "inner join carrera c on i.id_Carrera = c.idCarrera";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Inscripcion i=new Inscripcion();
				//8
				i.setIdInscripcion(rs.getString(1));
				i.setDni(rs.getString(2));
				i.setNombre(rs.getString(3));
				i.setCorreo(rs.getString(4));
				i.setIdCarrera(rs.getInt(5));
				i.setNombreCarrera(rs.getString(6));
				i.setCiclo(rs.getString(7));
				i.setFecInscripcion(rs.getString(8));
				i.setEstado(rs.getString(9));
				//9
				lista.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public Alumno buscarAlumnoInscripcion(int dni) {
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Alumno a=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select * from alumno  where DNI=?";
			//3
			pstm=cn.prepareStatement(sql);
			//
			pstm.setInt(1, dni);
			//
			rs=pstm.executeQuery();
			//
			if(rs.next()) {
				//
				a = new Alumno();
				//
				a.setDni(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApellido(rs.getString(3));
				a.setFechaNacimiento(rs.getString(4));
				a.setCorreo(rs.getString(5));
				a.setDireccion(rs.getString(8));
			}
						
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return a;
	}

	@Override
	public Carrera buscarCarrera(int cod) {
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Carrera c=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select d.idCarrera,d.nom_Carrera,f.nomFacultad,d.ciclo,d.creditos \r\n"
					+ "from carrera d inner join facultad f on d.codfacultad = f.codFacultad\r\n"
					+ "where d.idCarrera=?";
			//3
			pstm=cn.prepareStatement(sql);
			//
			pstm.setInt(1, cod);
			//
			rs=pstm.executeQuery();
			//
			if(rs.next()) {
				//
				c = new Carrera();
				//
				c.setCodigo(rs.getInt(1));
				c.setNomCarrera(rs.getString(2));
				c.setNomFacultad(rs.getString(3));
				c.setCiclo(rs.getString(4));
				c.setCreditos(rs.getInt(5));
				
			}
						
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public List<Inscripcion> listPorEstado(String est) {
		List<Inscripcion> lista=new ArrayList<Inscripcion>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select i.idInscripcion, i.DNI, a.nombre, a.correo, i.id_Carrera, c.nom_Carrera, c.ciclo, i.fec_Inscripcion, i.estado "+
					  "from inscripcion i inner join alumno a on i.DNI = a.DNI "+
					  "inner join carrera c on i.id_Carrera = c.idCarrera where estado=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, est);
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Inscripcion i=new Inscripcion();
				//8
				i.setIdInscripcion(rs.getString(1));
				i.setDni(rs.getString(2));
				i.setNombre(rs.getString(3));
				i.setCorreo(rs.getString(4));
				i.setIdCarrera(rs.getInt(5));
				i.setNombreCarrera(rs.getString(6));
				i.setCiclo(rs.getString(7));
				i.setFecInscripcion(rs.getString(8));
				i.setEstado(rs.getString(9));
				//9
				lista.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
