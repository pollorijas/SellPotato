package com.example.maria.prueba1.capanegocio;

import java.util.ArrayList;

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
        if(get.equals("SUCCESSFUL")) {
            repartidor.setCamion(camion);
            return true;
        }
        else return false;
    }

<<<<<<< HEAD
    public void ObtenerClientes()
    {
        if(camion.getUbicacions() == null)
        {
            camion.setUbicacions(new ArrayList<Ubicacion>());
            GenerarUbicaciones();
        }

        repartidor.setM_Ruta(new Ruta());
        repartidor.getM_Ruta().setClientes( new Cliente().getData().GetAll(repartidor.getM_Ruta().getClientes()));


    }

    private void GenerarUbicaciones() {

        ArrayList<Paquete> pa = new ArrayList<>();

        pa = new Paquete().getData().GetAll(pa);
        int j = 0;
        for(int i = 0; i < pa.size(); i++)
        {
            Ubicacion u = new Ubicacion();
            if((int)(i%(Math.sqrt(camion.getDimencion()))) == 0)
                j++;
            u.setcolumna(j);
            u.setfila((int)(i%(Math.sqrt(camion.getDimencion()))) + 1);
            camion.getUbicacions().add(u);
        }

    }
=======
    public boolean ModificarCamion(){
        String get = camion.getData().Update(camion);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }


>>>>>>> origin/master
}
