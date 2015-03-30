package com.example.maria.prueba1.capadatos;

import android.util.Log;

import com.example.maria.prueba1.capanegocio.Producto;
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
public class ProductoDB implements BDInterface {

    private JSONArray ja;
    private String data;

    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Producto)
        {
            //SQL corregido, pero no ingresa los datos desde la aplicación...
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/producto_registro.php?nombre_producto=" + ((Producto) t).getnombreProducto()
                + "&precio_unitario=" + ((Producto) t).getprecio()
                + "&descripcion_producto=" + ((Producto) t).getdescripcion()
                + "&stock_producto=" + ((Producto) t).getstock());
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
        if(t instanceof Producto)
        {
            //Arreglear SQL de PRODUCTO
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/producto_actualizar.php?id_producto=" + ((Producto) t).getidProducto()
                        + "&nombre_producto=" + ((Producto) t).getnombreProducto()
                        + "&precio_unitario=" + ((Producto) t).getprecio()
                        + "&descripcion_producto=" + ((Producto) t).getdescripcion()
                        + "&stock_producto=" + ((Producto) t).getstock());
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
        if(t instanceof Producto)
        {
            //Arreglear SQL de PRODUCTO
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/producto_eliminar.php?id_producto=" + ((Producto) t).getidProducto());
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

        if(t instanceof Producto)
        {
            //HttpHelpingClass http = new HttpHelpingClass();
            HttpConnection http = new HttpConnection();

            ja = null;
            try {
                data = http.readUrl("http://vendepapas.esy.es/SQL/SQLTEST.php?id_producto=1" );
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
                        Log.e("Data: ", ja.getJSONArray(i).toString());
                    }
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
            //HttpHelpingClass http = new HttpHelpingClass();
            HttpConnection http = new HttpConnection();

            ja = null;
            try {
                data = http.readUrl("http://10.0.2.2/SSPP/obtenerproductos.php" );
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
                        Producto p = new Producto();
                        p.setidProducto(pro.getInt(0));
                        p.setnombreProducto(pro.getString(2));
                        p.setprecio(pro.getInt(3));
                        p.setdescripcion(pro.getString(4));
                        p.setstock(pro.getInt(5));

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
