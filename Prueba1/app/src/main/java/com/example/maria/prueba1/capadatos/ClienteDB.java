package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Cliente;
import com.example.maria.prueba1.library.HttpConnection;
import com.example.maria.prueba1.library.HttpHelpingClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Freddy on 05-03-2015.
 */
public class ClienteDB implements BDInterface {

    private JSONArray ja;
    private String data;

    @Override
    public <T> String Insert(T t) {

        String aux = "ERROR";
        if(t instanceof Cliente)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            try {
                http.httpGetData("http://10.0.2.2/SSPP/cliente_registro.php?rut="
                        + ((Cliente) t).getrut()
                        + "&nombre=" + ((Cliente) t).getnombre()
                        + "&apellido=" + ((Cliente) t).getapellido()
                        + "&telefono=" + ((Cliente) t).getfono()
                        + "&direccion=" + ((Cliente) t).getdireccion()
                        + "&descripcion=" + ((Cliente) t).getdescripcionHogar()
                        + "&password=" + ((Cliente) t).getPassword()
                        + "&latitud=" + ((Cliente) t).getLatitud()
                        + "&longitud=" + ((Cliente) t).getLongitud());
                return "SUCCESSFUL";
            }
            catch(Exception e){
                e.printStackTrace();
                return aux;
            }

        }
        return "ERROR";
    }

    @Override
    public <T> String Update(T t) {
        String aux = "ERROR";
        if(t instanceof Cliente)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            try {
                http.httpGetData("http://10.0.2.2/SSPP/cliente_actualizar.php?rut=" + ((Cliente) t).getrut()
                        + "&telefono=" + ((Cliente) t).getfono()
                        + "&direccion=" + ((Cliente) t).getdireccion()
                        + "&descripcion=" + ((Cliente) t).getdescripcionHogar()
                        + "&password=" + ((Cliente) t).getPassword()
                        + "&latitud=" + ((Cliente) t).getLatitud()
                        + "&longitud=" + ((Cliente) t).getLongitud());
                return "SUCCESSFUL";
            }
            catch(Exception e){
                e.printStackTrace();
                return aux;
            }

        }
        return "ERROR";
    }

    @Override
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Cliente)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            try {
                http.httpGetData("http://10.0.2.2/SSPP/cliente_eliminar.php?rut=" + ((Cliente) t).getrut());
                return "SUCCESSFUL";
            }
            catch(Exception e){
                e.printStackTrace();
                return aux;
            }

        }
        return "ERROR";
    }

    @Override
    public <T> void Get(T t) {

        if(t instanceof Cliente)
        {
            HttpHelpingClass http = new HttpHelpingClass();

            ja = null;
            data = http.httpGetData("http://10.0.2.2/SSPP/cliente_buscar.php?rut=" + ((Cliente) t).getrut());
            if (data.length()>0){
                try {
                    ja= new JSONArray(data);
                    ((Cliente) t).setnombre(ja.getString(1));
                    ((Cliente) t).setapellido(ja.getString(2));
                    ((Cliente) t).setfono(ja.getString(3));
                    ((Cliente) t).setdireccion(ja.getString(4));
                    ((Cliente) t).setLatitud(ja.getString(5));
                    ((Cliente) t).setLongitud(ja.getString(6));
                    ((Cliente) t).setdescripcionHogar(ja.getString(7));
                } catch (JSONException e) {
                    Log.e("Error Conexion", "No se Pudo Realizar la Conexion");
                    e.printStackTrace();
                    t = null;
                }
            }
        }
        else t = null;
    }

    public <T> T GetAll(T t)
    {
        if(t instanceof ArrayList)
        {
            HttpConnection http = new HttpConnection();

            ja = null;
            try {
                data = http.readUrl("http://10.0.2.2/SSPP/obtenerclientes.php" );
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
                        Cliente c = new Cliente();
                        c.setrut(pro.getString(0));
                        c.setnombre(pro.getString(1));
                        c.setapellido(pro.getString(2));
                        c.setfono(pro.getString(3));
                        c.setdireccion(pro.getString(4));
                        c.setLatitud(pro.getString(5));
                        c.setLongitud(pro.getString(6));
                        c.setdescripcionHogar(pro.getString(7));

                        ((ArrayList) t).add(c);
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
