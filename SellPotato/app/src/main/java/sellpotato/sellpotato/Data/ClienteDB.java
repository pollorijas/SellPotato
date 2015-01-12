package sellpotato.sellpotato.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sellpotato.sellpotato.Model.Cliente;
import sellpotato.sellpotato.helpclass.Conexion;

/**
 * Created by Freddy on 09-01-2015.
 */
public class ClienteDB {

    public ClienteDB()
    {
    }

    public Cliente getCliente(Cliente cliente)
    {
        Connection cn = null;
        Statement cl = null;
        ResultSet rs = null;
        try{
            String querry = "SELECT * FROM CLIENTE WHERE CLIENTE.RUT LIKE '" + cliente.getrut() + "' AND CLIENTE.PASSWORD LIKE '" + cliente.getPass() + "'";
            cn = Conexion.getConexion();
            cl = cn.createStatement();
            rs = cl.executeQuery(querry);

            while(rs.next())
            {
                cliente.setdescripcionHogar(rs.getString("DESCRIPCION"));
                cliente.setfono(Integer.parseInt(rs.getString("TELEFONO")));
                cliente.setdireccion(rs.getString("DIRECCION"));
                cliente.setnombre(rs.getString("NOMBRE"));
                cliente.setapellido(rs.getString("APELLIDO"));
                cliente.setUserType(rs.getString("TIPO_USUARIO"));
                Conexion.cerrarConexion(rs);
                Conexion.cerrarConexion(cn);
                return cliente;
            }
           Conexion.cerrarConexion(rs);
            Conexion.cerrarConexion(cn);

        }catch(SQLException e)
        {
            Conexion.cerrarConexion(cn);
            e.printStackTrace();
        }
        return null;
    }

}
