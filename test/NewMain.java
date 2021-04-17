
import Conexion.CL_Conexion;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CCARTES4
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    public static Connection conexion = null;
    public static void main(String[] args) {
        try {
            CL_Conexion conn = new CL_Conexion();
            conexion = conn.obtenerConexion();
        } catch (Exception e) {
        }
    }
    
}
