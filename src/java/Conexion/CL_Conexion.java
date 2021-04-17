/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CCARTES4
 */
public class CL_Conexion {
    Connection conn = null;
    
    public CL_Conexion()
    {
        abrirConexion();
    }
    
    private void abrirConexion() 
    {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SIGLO21", "123");
            if (conn != null)
            {
                System.out.println("Conexión buena");
            }
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            System.out.println("Conexión fallida");
        }
    }
    
    public Connection obtenerConexion ()
    {
        return conn;
    }
    
    public void cerrarConexion() 
    {
        try {
            conn.close();
        } catch (Exception e) {
            
        }
        
    }
    
    
}
