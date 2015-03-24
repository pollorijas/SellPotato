package com.example.maria.prueba1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.Cliente;
import com.example.maria.prueba1.capanegocio.ClienteControler;

public class IngresarCliente extends Activity{

    EditText rutc, nombrec, apellidoc, telefonoc, direccionc, descripcionc, clavec;
    Button ingresar_cliente;
    private ProgressDialog pDialog;
    public ClienteControler controler;

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

                controler.setCliente(new Cliente());

                controler.getCliente().setrut(rutc.getText().toString());
                controler.getCliente().setnombre(nombrec.getText().toString());
                controler.getCliente().setapellido(apellidoc.getText().toString());
                controler.getCliente().setfono(telefonoc.getText().toString());
                controler.getCliente().setdireccion(direccionc.getText().toString());
                controler.getCliente().setdescripcionHogar(descripcionc.getText().toString());
                controler.getCliente().setPassword(clavec.getText().toString());

                new AsyncIngresar().execute(true);

            }
        });


    }

    class AsyncIngresar extends AsyncTask<Boolean,String,Boolean>
    {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(IngresarCliente.this);
            pDialog.setMessage("Actualizando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            pDialog.dismiss();

            boolean result = aBoolean;

            Log.e("Datos:", "Datos: " + controler.getCliente().getPassword());

            if(result){
                msgShow("El Cliente Ha sido Ingresado Correctamente, Redirecionando al Login");
                Intent iu = new Intent(IngresarCliente.this, MainActivity.class);
                finish();
            }
            else msgShow("Error: Los datos no has sido Actualizados");

        }

        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(controler.Registrar()) return true;
            else return false;
        }
    }

    public void msgShow(String msg)
    {
        Toast t = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        t.show();
    }
}
