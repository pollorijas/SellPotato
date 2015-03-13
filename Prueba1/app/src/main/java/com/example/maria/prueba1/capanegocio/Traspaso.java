package com.example.maria.prueba1.capanegocio;

/**
 * Created by Freddy on 13-03-2015.
 */
public class Traspaso {

    private static ClienteControler controler;

    public static ClienteControler getControler()
    {
        return Traspaso.controler;
    }

    public static void setControler(ClienteControler controler)
    {
        Traspaso.controler = controler;
    }

}
