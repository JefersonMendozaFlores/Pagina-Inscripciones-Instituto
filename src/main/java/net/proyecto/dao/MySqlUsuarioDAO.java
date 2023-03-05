package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Menu;
import net.proyecto.entidad.Usuario;
import net.proyecto.interfaces.UsuarioDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public Usuario LoginUser(String user, String pass) {
		Usuario bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select idUsuario,nombres, DNI , idRol from Usuario where nombreUsuario =BINARY ? and  password=BINARY ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, user);
			pstm.setString(2, pass);
			rs = pstm.executeQuery();
			if (rs.next()) {
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setDNI(rs.getString(3));
				bean.setCodRol(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					rs.close();
				if (cn != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public List<Menu> listaMenu(int codigo) {
		List<Menu> lista = new ArrayList<Menu>();
		Menu bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select m.*  from Menu m inner join Acceso a on m.codMenu = a.codMenu where a.idUsuario = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bean = new Menu();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setUrl(rs.getString(3));
				
				lista.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					rs.close();
				if (cn != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
