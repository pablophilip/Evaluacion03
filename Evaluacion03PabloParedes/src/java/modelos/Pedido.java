
package modelos;

public class Pedido {
    private int id_pedido;
    private int cantidad;
    private int total;
    private String correo;
    private Estado estado;
    private Producto producto;
   

    public Pedido() {
    }

    public Pedido(int id_pedido, int cantidad, int total, String correo, Estado estado, Producto producto) {
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.correo = correo;
        this.estado = estado;
        this.producto = producto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

      
    
    
}
