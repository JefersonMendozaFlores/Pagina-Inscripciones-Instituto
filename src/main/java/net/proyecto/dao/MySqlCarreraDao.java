package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Carrera;
import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlCarreraDao implements CarreraDAO {

	@Override
	public int save(Carrera bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="insert into carrera values(null,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNomCarrera());
			pstm.setInt(2, bean.getCodfacultad());
			pstm.setString(3, bean.getCiclo());
			pstm.setInt(4, bean.getCreditos());
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
	public int update(Carrera bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="update carrera set nom_Carrera=?, codfacultad=?,ciclo=?,creditos=? where idCarrera=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNomCarrera());
			pstm.setInt(2, bean.getCodfacultad());
			pstm.setString(3, bean.getCiclo());
			pstm.setInt(4, bean.getCreditos());
			pstm.setInt(5, bean.getCodigo());
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
	public int delete(int codigo) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="delete  from carrera  where idCarrera=?";
			//3
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
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
	public Carrera buscar(int codigo) {
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Carrera c=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select * from carrera  where idCarrera=?";
			//3
			pstm=cn.prepareStatement(sql);
			//
			pstm.setInt(1, codigo);
			//
			rs=pstm.executeQuery();
			//
			if(rs.next()) {
				//
				c = new Carrera();
				//
				c.setCodigo(rs.getInt(1));
				c.setNomCarrera(rs.getString(2));
				c.setCodfacultad(rs.getInt(3));
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
	public List<Carrera> lisAll() {
		
		List<Carrera> lista=new ArrayList<Carrera>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select d.idCarrera,d.nom_Carrera,f.nomFacultad,d.ciclo,d.creditos "
					+ "from carrera d inner join facultad f on d.codfacultad = f.codFacultad;";
			//3
			pstm=cn.prepareStatement(sql);
			//
			
			//
			rs=pstm.executeQuery();
			//
			while(rs.next()) {
				//
				Carrera c = new Carrera();
				//
				c.setCodigo(rs.getInt(1));
				c.setNomCarrera(rs.getString(2));
				c.setNomFacultad(rs.getString(3));
				c.setCiclo(rs.getString(4));
				c.setCreditos(rs.getInt(5));
				//
				lista.add(c);
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
		return lista;
	}

	@Override
	public List<Carrera> listarPorNombre() {
		List<Carrera> lista=new ArrayList<Carrera>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select idCarrera, nom_Carrera from carrera";
			//3
			pstm=cn.prepareStatement(sql);
			//
			
			//
			rs=pstm.executeQuery();
			//
			while(rs.next()) {
				//
				Carrera c = new Carrera();
				//
				c.setCodigo(rs.getInt(1));
				c.setNomCarrera(rs.getString(2));
				//
				lista.add(c);
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
		return lista;
	}
	
	

}
