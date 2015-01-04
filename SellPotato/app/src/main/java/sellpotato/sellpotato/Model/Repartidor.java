package sellpotato.sellpotato.Model;

import java.io.Serializable;

/**
 * Created by Freddy on 04-01-2015.
 */
public class Repartidor extends Persona implements Serializable {

    private String licencia;

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Repartidor(String rut, String nombre, String apellido, String licencia) {
        super(rut, nombre, apellido);
        this.licencia = licencia;
    }

    public Repartidor(String rut, String nombre, String apellido) {
        super(rut, nombre, apellido);
    }
}
