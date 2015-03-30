package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Pedido;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Freddy on 07-03-2015.
 */
public class PedidoDB implements BDInterface {

    JSONArray ja;
    String data;

    @Override
    public <T> String Insert(T t) {
        return null;
    }

    @Override
    public <T> String Update(T t) {
        return null;
    }

    @Override
    public <T> String Delete(T t) {
        return null;
    }

    @Override
    public <T> void Get(T t) {

    }

    public <T> T GetAll(T t)
    {
        return null;
    }

    public String GetCliente(Pedido t)
    {
        if(t instanceof Pedido)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            ja = null;
            data = http.httpGetData("http://10.0.2.2/SSPP/pedido_buscar.php?patente=" + t.getidPedido());
            if (data.length()>0){
                try {
                    ja= new JSONArray(data);
                    return ja.getString(4);
                } catch (JSONException e) {
                    Log.e("Error Conexion", "No se Pudo Realizar la Conexion");
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
}
