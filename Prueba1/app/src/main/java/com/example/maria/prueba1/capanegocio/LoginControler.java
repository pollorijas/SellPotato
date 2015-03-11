package com.example.maria.prueba1.capanegocio;

import android.util.Log;

import com.example.maria.prueba1.capadatos.BodegueroDB;
import com.example.maria.prueba1.capadatos.ClienteDB;
import com.example.maria.prueba1.capadatos.ControlerDB;
import com.example.maria.prueba1.capadatos.RepartidorDB;


/**
 * Created by Freddy on 05-03-2015.
 */
public class LoginControler {

    private Cliente cliente;
    private Bodeguero bodeguero;
    private Repartidor repartidor;
    private ClienteDB clienteDB;
    private BodegueroDB bodegueroDB;
    private RepartidorDB repartidorDB;
    private ControlerDB controlerDB;
    private String UserType;

    //Constuctor
    public LoginControler(){
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public String getUserType() {
        return UserType;
    }

    public boolean LoginIn(String user, String pass)
    {
        controlerDB = new ControlerDB();

        UserType = controlerDB.getUser(user, pass);


        Log.e("UserType","User Type: " + UserType);

        if(UserType.equals("CLIENTE"))
        {
            cliente = new Cliente();
            cliente.setrut(user);
            cliente.setPassword(pass);

            clienteDB = new ClienteDB();

            clienteDB.Get(cliente);
            if(cliente == null){
                Log.e("Respuesta","Cliente no Encontrado");
                return false;
            }
            else {
                Log.e("Respuesta","Cliente Encontrado");
                return true;
            }
        }
        else{
           if(UserType.equals("BODEGUERO"))
           {
               bodeguero = new Bodeguero();
               bodeguero.setrut(user);
               bodeguero.setPassword(pass);

               bodegueroDB = new BodegueroDB();

               bodegueroDB.Get(bodeguero);
               if(bodeguero == null){
                   Log.e("Respuesta","Cliente no Encontrado");
                   return false;
               }
               else {
                   Log.e("Respuesta","Cliente Encontrado");
                   return true;
               }
           }
           else{
               if(UserType.equals("REPARTIDOR"))
               {
                   repartidor = new Repartidor();
                   repartidor.setrut(user);
                   repartidor.setPassword(pass);

                   repartidorDB = new RepartidorDB();

                   repartidorDB.Get(repartidor);
                   if(repartidor == null){
                       Log.e("Respuesta","Cliente no Encontrado");
                       return false;
                   }
                   else {
                       Log.e("Respuesta","Cliente Encontrado");
                       return true;
                   }
               }
           }
        }

        return false;
    }
}
