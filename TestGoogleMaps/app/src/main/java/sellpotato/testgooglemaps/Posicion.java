package sellpotato.testgooglemaps;

/**
 * Created by Freddy on 15-01-2015.
 */
public class Posicion {

    private double latitud;
    private double longitud;

    public Posicion() {
    }

    public Posicion(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
