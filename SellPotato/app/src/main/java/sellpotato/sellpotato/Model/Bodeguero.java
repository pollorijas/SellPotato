package sellpotato.sellpotato.Model;

import java.io.Serializable;

/**
 * Created by Freddy on 04-01-2015.
 */
public class Bodeguero extends Persona implements Serializable{

    private String nombre_local;

    public String getNombre_local() {
        return nombre_local;
    }

    public void setNombre_local(String nombre_local) {
        this.nombre_local = nombre_local;
    }

    public Bodeguero(String rut, String nombre, String apellido) {
        super(rut, nombre, apellido);
    }

    public Bodeguero(String rut, String nombre, String apellido, String nombre_local) {
        super(rut, nombre, apellido);
        this.nombre_local = nombre_local;
    }

}
