/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Producto;

/**
 *
 * @author pparedes
 */
public class ProductoDAO extends Conexion{
    
     public int registrarProducto(Producto p) throws SQLException{
      try{
           String sentencia = "insert into producto values (?,?,?,?)";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setInt(1, p.getId_producto());
           ps.setString(2, p.getNombre());
           ps.setString(3, p.getDescripcion());
           ps.setInt(4, p.getPrecio());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public Producto obtenerProducto(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from producto where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Producto p = null;
        if(rs.next()){
           p = new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("precio"));
        }
        desconectar();
        return p;
    }
    
    public ArrayList<Producto> obtenerProductos() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from producto";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Producto> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("precio")));
        }
        desconectar();
        return lista;
    }
}
