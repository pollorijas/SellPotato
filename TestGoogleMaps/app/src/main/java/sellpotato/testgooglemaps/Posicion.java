package sellpotato.testgooglemaps;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;


public class Posicion implements Serializable{

    private double latitud;
    private double longitud;
    private String direccion;
    //private LatLng coordenada;

    public Posicion() {
    }

    public Posicion(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
        //this.coordenada = new LatLng(latitud,longitud);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    /*public void CreateCoordenada()
    {
        if(coordenada == null)
            coordenada = new LatLng(latitud,longitud);
    }*/

    @Override
    public String toString() {
        return latitud + "," + longitud;
    }

    /*public LatLng toLatLng()
    {
        return coordenada;
    }*/
}
