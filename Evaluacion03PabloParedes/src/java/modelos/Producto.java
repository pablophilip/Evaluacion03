
package modelos;

public class Producto {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private int precio;
   
    public Producto() {
    }

    public Producto(int id_producto, String nombre, int precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
    }
        
    public Producto(int id_producto, String nombre, String descripcion, int precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return nombre;
    }
    
}
