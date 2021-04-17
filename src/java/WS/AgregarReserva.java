/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Conexion.CL_Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author CCARTES4
 */
@WebService(serviceName = "AgregarReserva")
public class AgregarReserva {

    
    public static Connection conexion = null;
    String mensaje = "";
    
    public AgregarReserva()
    {
        if (conexion == null )
        {
            conexion = new CL_Conexion().obtenerConexion();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agr")
    public boolean agr(@WebParam(name = "V_RUT_CLIENTE") String V_RUT_CLIENTE, @WebParam(name = "V_RUT_TRABAJADOR") String V_RUT_TRABAJADOR, @WebParam(name = "V_NRO_MESA") int V_NRO_MESA) {
        try {
            
            CallableStatement ps = conexion.prepareCall("{call SP_AGREGAR_ORDEN2(?,?,?)}");
            ps.setString(1, V_RUT_CLIENTE);
            ps.setString(2, V_RUT_TRABAJADOR);
            ps.setInt(3, V_NRO_MESA);
            
            boolean resultado = ps.execute();
            if (resultado == false)
            {
                ps.close();
                return true;
            }
            else
            {
                ps.close();
                return false;
            }
        } 
        catch (SQLException ex) 
        {
            return false;
        }
    }
}
