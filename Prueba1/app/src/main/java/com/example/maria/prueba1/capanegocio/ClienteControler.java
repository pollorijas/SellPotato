package com.example.maria.prueba1.capanegocio;

import android.util.Log;

import com.example.maria.prueba1.library.HttpConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Freddy on 09-03-2015.
 */
public class ClienteControler{

    private Cliente cliente;

    public ClienteControler(){}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean ModificarCliente()
    {
        String dir = cliente.getdireccion().replace(' ','+');
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=+"+ dir +",+Iquique&region=cl&sensor=false";

        HttpConnection http = new HttpConnection();

        try {
            String response = http.readUrl(url);
            boolean test = parsePoint(response);

        } catch (IOException e) {
            Log.d("Error en conectarse a google maps", e.toString());
            return false;
        }

        String get = cliente.getData().Update(cliente);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }

    public boolean Registrar()
    {
        String dir = cliente.getdireccion().replace(' ','+');
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=+"+ dir +",+Iquique&region=cl&sensor=false";

        HttpConnection http = new HttpConnection();

        try {
            String response = http.readUrl(url);
            boolean test = parsePoint(response);

        } catch (IOException e) {
            Log.d("Error en conectarse a google maps", e.toString());
            return false;
        }


        String get = cliente.getData().Insert(cliente);
        if(get.equals("SUCCESSFUL"))return true;
        else return false;
    }

    private boolean parsePoint(String strResponse)
    {
        try {
            JSONObject obj=new JSONObject(strResponse);
            JSONArray array=obj.getJSONArray("results");
            for(int i=0;i<array.length();i++)
            {
                JSONObject item=array.getJSONObject(i);
                ArrayList<HashMap<String, Object>> tblPoints=new ArrayList<HashMap<String,Object>>();
                JSONArray jsonTblPoints=item.getJSONArray("address_components");
                for(int j=0;j<jsonTblPoints.length();j++)
                {
                    JSONObject jsonTblPoint=jsonTblPoints.getJSONObject(j);
                    HashMap<String, Object> tblPoint=new HashMap<String, Object>();
                    Iterator<String> keys=jsonTblPoint.keys();
                    while(keys.hasNext())
                    {
                        String key=(String) keys.next();
                        if(tblPoint.get(key) instanceof JSONArray)
                        {
                            tblPoint.put(key, jsonTblPoint.getJSONArray(key));
                        }
                        tblPoint.put(key, jsonTblPoint.getString(key));
                    }
                    tblPoints.add(tblPoint);
                }
                //cliente.setdireccion(item.getString("formatted_address"));
                JSONObject geoJson=item.getJSONObject("geometry");
                JSONObject locJson=geoJson.getJSONObject("location");
                cliente.setLatitud(locJson.getString("lat"));
                cliente.setLongitud(locJson.getString("lng"));
                Log.e("Coordenadas: ","Lat: " + cliente.getLatitud() + ", Lng: " + cliente.getLongitud());
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
