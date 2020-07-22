
package modelos;

public class Estado {
    private int id_estado;
    private String nombre;

    public Estado() {
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public Estado(int id_estado) {
        this.id_estado = id_estado;
    }
        
    public Estado(int id_estado, String nombre) {
        this.id_estado = id_estado;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    @Override
   public String toString(){
       return nombre;
   }
}

