package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import net.proyecto.entidad.Facultad;
import net.proyecto.interfaces.FacultadDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlFacultadDAO implements FacultadDAO{

	@Override
	public List<Facultad> lisAll() {
		List<Facultad> lista=new ArrayList<Facultad>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();			//2
			String sql="select * from facultad";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Facultad f=new Facultad();
				//8
				f.setCodFacultad(rs.getInt(1));
				f.setNomFacultad(rs.getString(2));
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
