package com.example.maria.prueba1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.BodegueroControler;
import com.example.maria.prueba1.capanegocio.Producto;
import com.example.maria.prueba1.capanegocio.Traspaso;

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
    BodegueroControler controler;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_producto);

        controler = Traspaso.getBodegueroControler();

        registrar_producto = (Button)findViewById(R.id.registrar_producto);

        nombre_producto = (EditText)findViewById(R.id.nombre_producto);
        precio_producto = (EditText)findViewById(R.id.precio_producto);
        descripcion_producto = (EditText)findViewById(R.id.descripcion_producto);
        stock_producto = (EditText)findViewById(R.id.stock_producto);

        registrar_producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Producto p = new Producto();
                p.setdescripcion(descripcion_producto.getText().toString());
                p.setnombreProducto(nombre_producto.getText().toString());
                p.setstock(Integer.parseInt(stock_producto.getText().toString()));
                p.setprecio(Integer.parseInt(precio_producto.getText().toString()));

                controler.setProducto(p);

                new AsyncIngresar().execute(true);

            }
        });


    }

    class AsyncIngresar extends AsyncTask<Boolean,String,Boolean>
    {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(IngresarProducto.this);
            pDialog.setMessage("Ingresando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            pDialog.dismiss();

            boolean result = aBoolean;

            if(result){
                msgShow("El Cliente Ha sido Ingresado Correctamente, Redirecionando al Login");
                SystemClock.sleep(50);
                Intent iu = new Intent(IngresarProducto.this, InterfazBodeguero.class);
                finish();
            }
            else msgShow("Error: Los datos no has sido Actualizados");

        }

        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(controler.IngresarProducto()) return true;
            else return false;
        }
    }

    public void msgShow(String msg)
    {
        Toast t = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        t.show();
    }
}




