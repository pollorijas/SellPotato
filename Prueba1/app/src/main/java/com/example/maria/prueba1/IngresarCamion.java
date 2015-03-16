package com.example.maria.prueba1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import java.io.IOException;


public class IngresarCamion extends Activity {
    EditText patente_camion, marca_camion, modelo_camion, tara_camion, dimension_camion;
    Button ingresar_camion;
    JSONArray ja;
    String data;

    Handler h1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Toast.makeText(getApplicationContext(),"Registro Exitoso",3000).show();
        }
    };


    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_camion);

        patente_camion = (EditText) findViewById(R.id.patente);
        marca_camion = (EditText) findViewById(R.id.marca);
        modelo_camion = (EditText) findViewById(R.id.modelo);
        tara_camion = (EditText) findViewById(R.id.tara);
        dimension_camion = (EditText) findViewById(R.id.dimensiones);

        ingresar_camion = (Button) findViewById(R.id.ingresar_camion);

        ingresar_camion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        httpGetData("http://10.0.2.2/SSPP/camion_registro.php?patente=" + patente_camion.getText() + "&marca=" + marca_camion.getText() + "&modelo=" + modelo_camion.getText() + "&dimensiones=" + dimension_camion.getText()
                                + "&tara=" + tara_camion.getText());
                        h1.sendEmptyMessage(1);
                    }
                }).start();
            }
        });
    }

    public String httpGetData(String mURL) {
        String response = "";
        mURL = mURL.replace(" ", "%20");
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(mURL);

        ResponseHandler<String> responsehandler = new BasicResponseHandler();
        try {
            response = httpclient.execute(httpget, responsehandler);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }
}




/**
 * Created by Maria on 09/02/2015.
 */

/*
public class IngresarCamion extends Activity {
    protected EditText patente;
    protected EditText modelo;
    protected EditText marca;
    protected EditText tara;
    protected EditText dimesion;
    protected Button ingresar_camion;

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_cliente);

        patente = (EditText) findViewById(R.id.patente_camion);
        modelo = (EditText)findViewById(R.id.modelo_camion);
        marca = (EditText)findViewById(R.id.marca_camion);
        tara = (EditText)findViewById(R.id.tara_camion);
        dimesion = (EditText)findViewById(R.id.dimension_camion);
        ingresar_camion = (Button)findViewById(R.id.ingresar_camion);

        ingresar_camion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(IngresarCamion.this, "Ingresar", Toast.LENGTH_LONG).show();
            }
        });
    }
}
*/
