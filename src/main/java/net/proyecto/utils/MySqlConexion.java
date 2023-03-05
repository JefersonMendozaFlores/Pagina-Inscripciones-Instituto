package net.proyecto.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {

	public static Connection getConexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/ProyectoInstituto2022?serverTimezone=UTC","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;	
	}
}
