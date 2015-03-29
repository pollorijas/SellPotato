package com.example.maria.prueba1.capanegocio;

/**
 * Created by Freddy on 29-03-2015.
 */
public class RepartidorControler {

    private Repartidor repartidor;
    private Camion camion;

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public boolean RegistrarCamion() {

        String get = camion.getData().Insert(camion);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }
}
