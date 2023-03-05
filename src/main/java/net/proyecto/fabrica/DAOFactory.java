package net.proyecto.fabrica;

import net.proyecto.interfaces.AlumnoDAO;
import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.interfaces.FacultadDAO;
import net.proyecto.interfaces.IDistritoDAO;
import net.proyecto.interfaces.IPaisDAO;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.interfaces.OrdenPagoDAO;
import net.proyecto.interfaces.RegistroDAO;
import net.proyecto.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract CarreraDAO getCarreraDAO();
    public abstract AlumnoDAO getAlumnoDAO();
    public abstract FacultadDAO getFacultadDAO();
    public abstract RegistroDAO getRegistroDAO();
    public abstract InscripcionDAO getInscripcionDAO();
    public abstract IDistritoDAO getDistritoDAO();
    public abstract IPaisDAO getPaisDAO();
    public abstract OrdenPagoDAO getOrdenPago();
    // registramos nuestros daos

   
   
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();*/
        	case SQLSERVER:
        	    return null;
        	/*case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
