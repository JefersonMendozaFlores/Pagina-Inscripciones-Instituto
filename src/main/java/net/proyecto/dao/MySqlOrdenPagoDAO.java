package net.proyecto.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proyecto.entidad.OrdenPago;
import net.proyecto.interfaces.OrdenPagoDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlOrdenPagoDAO implements OrdenPagoDAO {

	@Override
	public int grabarOrden(OrdenPago ord, String id) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstmOrd=null,pstmIns=null;
		try {
			//1. obtener conexion a bd
			cn=MySqlConexion.getConexion();
			//2. anular los commit`s
			cn.setAutoCommit(false);
			//3. sentencia sql para requerimiento
			String sqlOrd="insert into comprobante_pago values(?,?,?,?,?)";
			//4. crear pstmReque y retornar el c�digo de requerimento generado
			pstmOrd=cn.prepareStatement(sqlOrd);
			//5. par�metros
			pstmOrd.setString(1, ord.getIdComprobante());
			pstmOrd.setDate(2, ord.getFecha());
			pstmOrd.setDouble(3, ord.getMonto());
			pstmOrd.setString(4, ord.getIdInscripcion());
			pstmOrd.setString(5, ord.getEstado());
			salida=pstmOrd.executeUpdate();
			
			//DETALLE REQUERIMIENTO
			//paso 1: sentencia sql para detalle requerimiento
			String sqlIns="update inscripcion set estado = 'PENDIENTE DE PAGO' where idInscripcion =?";	
				pstmIns=cn.prepareStatement(sqlIns);
				pstmIns.setString(1, id);
				//paso 5: ejecutar
				salida=pstmIns.executeUpdate();
			
			//confirmar sentencias 'INSERT'S'
			cn.commit();
		} catch (SQLException e) {
			//revertir los insert's
			try {
				cn.rollback();
				salida=-1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmIns!=null) pstmIns.close();
				if(pstmOrd!=null) pstmOrd.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public String GenerarNumeroPago() {
		String num="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			
			cn=MySqlConexion.getConexion();
			String sql="call sp_generar_Pago";
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

}
