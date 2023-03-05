package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Facultad;
import net.proyecto.entidad.Pais;
import net.proyecto.interfaces.IPaisDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlPaisDAO implements IPaisDAO{

	@Override
	public List<Pais> listAll() {
		List<Pais> lista=new ArrayList<Pais>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();			//2
			String sql="select * from pais";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Pais f=new Pais();
				//8
				f.setCodPais(rs.getInt(1));
				f.setNomPais(rs.getString(2));
				//9
				lista.add(f);
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
