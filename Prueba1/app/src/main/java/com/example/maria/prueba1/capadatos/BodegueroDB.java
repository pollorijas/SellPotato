package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Bodeguero;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Freddy on 06-03-2015.
 */
public class BodegueroDB implements BDInterface {
    private JSONArray ja;
    private String data;

    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Bodeguero)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/bodeguero_registro.php?rut=" + ((Bodeguero) t).getrut()
                + "&nombre=" + ((Bodeguero) t).getnombre()
                + "&apellido=" + ((Bodeguero) t).getapellido()
                + "&direccion_local" + ((Bodeguero) t).getdireccionLocal()
                + "&nombre_local=" + ((Bodeguero) t).getnombreLocal()
                + "&password=" + ((Bodeguero) t).getPassword());
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
        String aux = "ERROR";
        if(t instanceof Bodeguero)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/bodeguero_registro.php?rut=" + ((Bodeguero) t).getrut()
                        + "&direccion_local" + ((Bodeguero) t).getdireccionLocal()
                        + "&nombre_local=" + ((Bodeguero) t).getnombreLocal()
                        + "&password=" + ((Bodeguero) t).getPassword());
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
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Bodeguero)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/bodeguero_registro.php?rut=" + ((Bodeguero) t).getrut());
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
        if(t instanceof Bodeguero)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            ja = null;
            data = http.httpGetData("http://10.0.2.2/SSPP/bodeguero_buscar.php?rut=" + ((Bodeguero) t).getrut());
            if (data.length()>0){
                try {
                    ja= new JSONArray(data);
                    ((Bodeguero) t).setnombre(ja.getString(1));
                    ((Bodeguero) t).setapellido(ja.getString(2));
                    ((Bodeguero) t).setdireccionLocal(ja.getString(3));
                    ((Bodeguero) t).setnombreLocal(ja.getString(4));
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
