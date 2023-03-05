package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Distrito;
import net.proyecto.entidad.Facultad;
import net.proyecto.interfaces.IDistritoDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlDistritoDAO implements IDistritoDAO{

	@Override
	public List<Distrito> listAll() {
		List<Distrito> lista=new ArrayList<Distrito>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();			//2
			String sql="select * from distrito";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Distrito f=new Distrito();
				//8
				f.setCodDistrito(rs.getInt(1));
				f.setNomDistrito(rs.getString(2));
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
