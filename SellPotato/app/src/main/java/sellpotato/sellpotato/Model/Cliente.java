package sellpotato.sellpotato.Model;

import java.io.Serializable;

/**
 * Created by Freddy on 04-01-2015.
 */
public class Cliente extends Persona implements Serializable{

    private String direccion;
    private int fono;
    private String descripcion_hogar;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getDescripcion_hogar() {
        return descripcion_hogar;
    }

    public void setDescripcion_hogar(String descripcion_hogar) {
        this.descripcion_hogar = descripcion_hogar;
    }

    public Cliente(String rut, String nombre, String apellido, String direccion, int fono, String descripcion_hogar) {
        super(rut, nombre, apellido);
        this.direccion = direccion;
        this.fono = fono;
        this.descripcion_hogar = descripcion_hogar;
    }

    public Cliente(String rut, String nombre, String apellido) {
        super(rut, nombre, apellido);
    }
}
