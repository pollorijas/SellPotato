package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Paquete;
import com.example.maria.prueba1.library.HttpConnection;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Freddy on 07-03-2015.
 */
public class PaqueteDB implements BDInterface {

    JSONArray ja = null;
    String data = null;

    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Paquete)
        {
            //Arreglear SQL de PAQUETE
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/paquete_registro.php?id=" + ((Paquete) t).getidPaquete());
                aux = "SUCCESSFUL";
            }catch (Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }

        }
        return aux;
    }

    @Override
    public <T> String Update(T t) {
        return null;
    }

    @Override
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Paquete)
        {
            //Arreglear SQL de PAQUETE
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/paquete_eliminar.php?id=" + ((Paquete) t).getidPaquete());
                aux = "SUCCESSFUL";
            }catch (Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }

        }
        return aux;
    }

    @Override
    public <T> void Get(T t) {

    }

    public <T> T GetAll(T t)
    {
        if(t instanceof ArrayList)
        {
            //HttpHelpingClass http = new HttpHelpingClass();
            HttpConnection http = new HttpConnection();

            ja = null;
            try {
                data = http.readUrl("http://10.0.2.2/SSPP/obtenerpaquetes.php" );
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("DATA: ", data);
            if (data.length()>0){
                try {
                    JSONObject j = new JSONObject(data);
                    ja = j.getJSONArray("result");
                    for(int i = 0; i < ja.length(); i++)
                    {
                        JSONArray pro = ja.getJSONArray(i);
                        Paquete p = new Paquete();
                        p.getPedido().setidPedido(pro.getInt(0));
                        p.setfechaArmado(pro.getString(4));
                        p.setfechaEmbarque(pro.getString(5));

                        ((ArrayList) t).add(p);
                    }
                } catch (JSONException e) {
                    Log.e("Error Conexion", "No se Pudo Realizar la Conexion");
                    e.printStackTrace();
                    return null;
                }
            }

        return t;
    }
        else return null;
    }
}
