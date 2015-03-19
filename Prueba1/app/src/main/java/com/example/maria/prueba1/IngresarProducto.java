package com.example.maria.prueba1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

import java.io.IOException;


public class IngresarProducto extends ActionBarActivity {

    EditText nombre_producto, precio_producto, descripcion_producto, stock_producto;
    Button registrar_producto;

    Handler h1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Toast.makeText(getApplicationContext(),"Ha sido regidtrado con exito",3000).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_producto);

        registrar_producto = (Button)findViewById(R.id.registrar_producto);

        nombre_producto = (EditText)findViewById(R.id.nombre_producto);
        precio_producto = (EditText)findViewById(R.id.precio_producto);
        descripcion_producto = (EditText)findViewById(R.id.descripcion_producto);
        stock_producto = (EditText)findViewById(R.id.stock_producto);

        registrar_producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        httpGetData("http://10.0.2.2/SSPP/producto_registro.php?nombre_producto="+nombre_producto.getText()+"&precio_unitario="+precio_producto.getText()+"&descripcion_producto="+descripcion_producto.getText()+"&stock_producto="+stock_producto.getText());
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


/*
    registrar_producto.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Toast.makeText(IngresarProducto.this, "Ingresar Producto", Toast.LENGTH_LONG).show();
        }
    });*/
    }




