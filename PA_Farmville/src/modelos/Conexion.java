package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conexion;

    // Constructor privado
    private Conexion() {
        String DSN = ""; 
        String usuario = ""; 
        String pass = ""; 

        try {
            conexion = DriverManager.getConnection(DSN, usuario, pass);
        } catch (SQLException e) {
            System.out.println("Error al conectarse con la base de datos.\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    // Instancia ÚNICA de Conexion
    public static Connection getConexion() {
        
    	if(conexion == null) {
    		Conexion singleton = new Conexion();
    		return conexion;
    	}else {
    		
    		return conexion;
    	}
    	
    }
}
