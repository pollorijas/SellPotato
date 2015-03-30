package com.example.maria.prueba1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.RepartidorControler;
import com.example.maria.prueba1.capanegocio.Traspaso;


public class ModificarCamion extends ActionBarActivity {

    Button btncancel, modificar_camion;
    TextView rut, txtpatente;
    EditText marca, modelo, dimensiones, tara;

    public RepartidorControler controler;

    public ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_camion);

        controler = Traspaso.getRepartidorControler();

        rut = (TextView)findViewById(R.id.txtrut);
        txtpatente = (TextView)findViewById(R.id.txtpatente);
        marca = (EditText)findViewById(R.id.marca);
        modelo = (EditText)findViewById(R.id.modelo);
        dimensiones = (EditText)findViewById(R.id.dimensiones);
        tara = (EditText)findViewById(R.id.tara);
        btncancel = (Button)findViewById(R.id.btncancel);
        modificar_camion = (Button)findViewById(R.id.modificar_camion);

        rut.setText(controler.getRepartidor().getrut());
        txtpatente.setText(controler.getCamion().getpatente());
        marca.setText(controler.getCamion().getmarca());
        modelo.setText(controler.getCamion().getmodelo());
        dimensiones.setText(String.valueOf(controler.getCamion().getDimencion()));
        tara.setText(String.valueOf(controler.getCamion().getcarga()));


        modificar_camion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controler.getCamion().setmarca(marca.getText().toString());
                controler.getCamion().setmodelo(modelo.getText().toString());
               controler.getCamion().setDimencion(Integer.parseInt(dimensiones.getText().toString()));
               controler.getCamion().setcarga(Integer.parseInt(tara.getText().toString()));

                new AsyncModificar().execute(true);

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent can = new Intent(getApplicationContext(), GestionarCamion.class);
                startActivity(can);
            }
        });
    }

    class AsyncModificar extends AsyncTask<Boolean,String,Boolean>
    {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(ModificarCamion.this);
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

           // Log.e("Datos:", "Datos: " + controler.getCliente().getPassword());

            if(result) {
                msgShow("Datos Actualizados Correctamente");
                Traspaso.setRepartidorControler(controler);

                SystemClock.sleep(50);

                Intent iu = new Intent(ModificarCamion.this, InterfazRepartidor.class);

                finish();
            }
            else msgShow("Error: Los datos no has sido Actualizados");

        }

        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(Modificar()) return true;
            else return false;
        }
    }

    public void msgShow(String msg)
    {
        Toast t = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        t.show();
    }

    public boolean Modificar()
    {
        if(controler.ModificarCamion()) return true;
        else return false;
    }







}
