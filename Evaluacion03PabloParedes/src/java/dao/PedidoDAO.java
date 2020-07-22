
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Estado;
import modelos.Pedido;
import modelos.Producto;


public class PedidoDAO extends Conexion{
    
    public int registrarPedido(Pedido p) throws SQLException{
      try{
           String sentencia = "insert into pedido values (?,?,?,?,?,?)";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setInt(1, p.getId_pedido());
           ps.setInt(2, p.getCantidad());
           ps.setInt(3, p.getTotal());
           ps.setString(4, p.getCorreo());
           ps.setInt(5, p.getEstado().getId_estado());
           ps.setInt(6, p.getProducto().getId_producto());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public Pedido obtenerPedido(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_pedidos where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Pedido pe = null;
        if(rs.next()){
            Estado e = new Estado(rs.getInt("estado"),rs.getString("e_nombre"));
            Producto po = new Producto(rs.getInt("producto"),rs.getString("p_nombre"),rs.getInt("precio"));
            pe = new Pedido(rs.getInt("id"),rs.getInt("cantidad"),rs.getInt("total"),
                   rs.getString("correo"),e,po);
        }
        desconectar();
        return pe;
    }
    
    public Pedido obtenerPedido(String correo) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_pedidos where  pe.correo= ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        Pedido pe = null;
        if(rs.next()){
            Estado e = new Estado(rs.getInt("estado"),rs.getString("e_nombre"));
            Producto po = new Producto(rs.getInt("producto"),rs.getString("p_nombre"),rs.getInt("precio"));
            pe = new Pedido(rs.getInt("id"),rs.getInt("cantidad"),rs.getInt("total"),
                   rs.getString("correo"),e,po);
        }
        desconectar();
        return pe;
    }
    
    public ArrayList<Pedido> obtenerPedidos() throws SQLException{
        try{
            String sentencia = "select * from v_pedidos";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Pedido> pedidos = new ArrayList();
            while(rs.next()){
                Estado e = new Estado(rs.getInt("estado"),rs.getString("e_nombre"));
                Producto po = new Producto(rs.getInt("producto"),rs.getString("p_nombre"),rs.getInt("precio"));
                pedidos.add(new Pedido(rs.getInt("id"),rs.getInt("cantidad"),rs.getInt("total"),
                        rs.getString("correo"),e,po));
            }
            return pedidos;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
