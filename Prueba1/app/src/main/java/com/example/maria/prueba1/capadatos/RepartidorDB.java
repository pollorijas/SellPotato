package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Repartidor;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Freddy on 06-03-2015.
 */
public class RepartidorDB implements BDInterface {
    private JSONArray ja;
    private String data;

    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Repartidor)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try
            {
                http.httpGetData("http://10.0.2.2/SSPP/repartidor_registro.php?rut=" + ((Repartidor) t).getrut()
                + "&nombre=" + ((Repartidor) t).getnombre()
                + "&apellido=" + ((Repartidor) t).getapellido()
                + "&licencia=" + ((Repartidor) t).getlicenciaConducir()
                + "&estado=" + ((Repartidor) t).getestado()
                + "&password=" + ((Repartidor) t).getPassword());
                aux = "SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return aux;
    }

    @Override
    public <T> String Update(T t) {
        String aux = "ERROR";
        if(t instanceof Repartidor)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try
            {
                http.httpGetData("http://10.0.2.2/SSPP/repartidor_actualizar.php?rut=" + ((Repartidor) t).getrut()
                        + "&licencia=" + ((Repartidor) t).getlicenciaConducir()
                        + "&estado=" + ((Repartidor) t).getestado()
                        + "&password=" + ((Repartidor) t).getPassword());
                aux = "SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return aux;
    }

    @Override
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Repartidor)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try
            {
                http.httpGetData("http://10.0.2.2/SSPP/repartidor_reliminar.php?rut=" + ((Repartidor) t).getrut());
                aux = "SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return aux;
    }

    @Override
    public <T> void Get(T t) {
        if(t instanceof Repartidor)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            ja = null;
            data = http.httpGetData("http://10.0.2.2/SSPP/repartidor_buscar.php?rut=" + ((Repartidor) t).getrut());
            if (data.length()>0){
                try {
                    ja= new JSONArray(data);
                    ((Repartidor) t).setnombre(ja.getString(1));
                    ((Repartidor) t).setapellido(ja.getString(2));
                    ((Repartidor) t).setlicenciaConducir(ja.getString(3));
                    ((Repartidor) t).setestado(ja.getString(4));
                } catch (JSONException e) {
                    Log.e("Error Conexion", "No se Pudo Realizar la Conexion");
                    e.printStackTrace();
                    t = null;
                }
            }

        }
        else t = null;
    }
}
