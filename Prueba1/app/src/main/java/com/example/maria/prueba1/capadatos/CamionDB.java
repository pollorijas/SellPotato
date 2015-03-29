package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Camion;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Freddy on 07-03-2015.
 */
public class CamionDB implements BDInterface {
    private JSONArray ja;
    private String data;

    @Override
    public <T> String Insert(T t) {
        String aux="ERROR";
        if(t instanceof Camion)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/camion_registro.php?patente=" + ((Camion) t).getpatente()
                + "&rut=" + ((Camion) t).getM_Repartidor().getrut()
                + "&marca=" + ((Camion) t).getmarca()
                + "&modelo=" + ((Camion) t).getmodelo()
                + "&dimensiones=" + ((Camion) t).getDimencion()
                + "&tara=" + ((Camion) t).getcarga());
                aux="SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }
        }
        return aux;
    }

    @Override
    public <T> String Update(T t) {
        String aux="ERROR";
        if(t instanceof Camion)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/camion_atualizar.php?patente=" + ((Camion) t).getpatente()
                        + "&rut=" + ((Camion) t).getM_Repartidor().getrut()
                        + "&marca=" + ((Camion) t).getmarca()
                        + "&modelo=" + ((Camion) t).getmodelo()
                        + "&dimenciones=" + ((Camion) t).getDimencion()
                        + "&tara=" + ((Camion) t).getcarga());
                aux="SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }
        }
        return aux;
    }

    @Override
    public <T> String Delete(T t) {
        String aux="ERROR";
        if(t instanceof Camion)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/camion_eliminar.php?patente=" + ((Camion) t).getpatente());
                aux="SUCCESSFUL";
            }catch(Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }
        }
        return aux;
    }

    @Override
    public <T> void Get(T t) {
        if(t instanceof Camion)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            ja = null;
            data = http.httpGetData("http://10.0.2.2/SSPP/camion_buscar.php?patente=" + ((Camion) t).getpatente());
            if (data.length()>0){
                try {
                    ja= new JSONArray(data);
                    ((Camion) t).setmarca(ja.getString(1));
                    ((Camion) t).setmodelo(ja.getString(2));
                    ((Camion) t).setDimencion(Integer.parseInt(ja.getString(3)));
                    ((Camion) t).setcarga(Integer.parseInt(ja.getString(4)));
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
