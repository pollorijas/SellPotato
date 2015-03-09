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

public class IngresarCliente extends Activity{

    EditText rutc, nombrec, apellidoc, telefonoc, direccionc, descripcionc, clavec;
    Button ingresar_cliente;
    JSONArray ja;
    String data;

    Handler h1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Toast.makeText(getApplicationContext(),"Ha sido regidtrado con exito",3000).show();
        }
    };

    protected  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);        setContentView(R.layout.ingresar_cliente);

        rutc = (EditText)findViewById(R.id.rutc);
        nombrec = (EditText)findViewById(R.id.nombrec);
        apellidoc = (EditText)findViewById(R.id.apellidoc);
        telefonoc = (EditText)findViewById(R.id.telefonoc);
        direccionc = (EditText)findViewById(R.id.direccionc);
        descripcionc = (EditText)findViewById(R.id.descripcionc);
        clavec = (EditText)findViewById(R.id.clavec);

        ingresar_cliente = (Button)findViewById(R.id.ingresar_cliente);

        ingresar_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        httpGetData("http://10.0.2.2/SSPP/cliente_registro.php?rut="+rutc.getText()+"&nombre="+nombrec.getText()+"&apellido="+apellidoc.getText()+"&telefono="+telefonoc.getText()
                                +"&direccion="+direccionc.getText()+"&descripcion="+descripcionc.getText()+"&password="+clavec.getText());
                        h1.sendEmptyMessage(1);
                    }
                }).start();
            }
        });


    }

    public String httpGetData(String mURL){
        String response="";
        mURL=mURL.replace(" ", "%20");
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
 * Created by Maria on 15/01/2015.
 */
/*
public class IngresarCliente extends Activity {

    protected EditText rut;
    protected EditText nombre;
    protected EditText apellido;
    protected EditText telefono;
    protected EditText direccion;
    protected EditText descripcion;
    protected EditText password;
    protected Button ingresar_cliente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_cliente);

        rut = (EditText) findViewById(R.id.rutc);
        nombre = (EditText)findViewById(R.id.nombrec);
        apellido = (EditText)findViewById(R.id.apellidoc);
        telefono = (EditText)findViewById(R.id.telefonoc);
        direccion = (EditText)findViewById(R.id.direccionc);
        password = (EditText) findViewById(R.id.clavec);
        ingresar_cliente = (Button)findViewById(R.id.ingresar_cliente);

        ingresar_cliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(IngresarCliente.this, "Ingresar", Toast.LENGTH_LONG).show();
            }
        });
    }
}

*/