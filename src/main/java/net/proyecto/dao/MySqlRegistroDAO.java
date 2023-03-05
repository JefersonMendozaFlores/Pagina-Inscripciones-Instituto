package net.proyecto.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.Registro;
import net.proyecto.interfaces.RegistroDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlRegistroDAO implements RegistroDAO {

	@Override
	public String numeroGenerado() {
		
		String num="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			
			cn=MySqlConexion.getConexion();
			String sql="call sp_generar_numero()";
			cstm=cn.prepareCall(sql);
			
			rs=cstm.executeQuery();
			if(rs.next())
				num=rs.getString(1);
			
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return num;
	}

	@Override
	public int save(Registro bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="insert into inscripcion values(?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getIdInscripcion());
			pstm.setInt(2, bean.getId_Carrera());
			pstm.setString(3, bean.getDNI());
			pstm.setDate(4, bean.getFec_Inscripccion());
			//pstm.setString(4, bean.getNum_Registro());
			pstm.setString(5, bean.getEstado());
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

	

}
