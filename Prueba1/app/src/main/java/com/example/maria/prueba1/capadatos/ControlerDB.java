package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Cliente;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Freddy on 06-03-2015.
 */
public class ControlerDB {

    String data;
    JSONArray ja;

    public String getUser(String user, String pass)
    {
        HttpHelpingClass http = new HttpHelpingClass();
        String type = "ERROR";

        ja = null;
        data = http.httpGetData("http://10.0.2.2/SSPP/consulta.php?rut=" + user + "&pass=" + pass);
        Log.e("Data", "Data: " + data);
        if (data.length()>0){
            try {
                ja= new JSONArray(data);
                Log.e("Json","Tipo : " + ja.getString(4) );
                type = ja.getString(4);
            } catch (JSONException e) {
                Log.e("Error Conexion", "No se Pudo Realizar la Conexion");
                e.printStackTrace();
                return type;
            }
        }
        return type;
    }

}
