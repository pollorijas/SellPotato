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
    TextView rut;
    EditText marca, modelo, dimensiones, tara;

    public RepartidorControler controler;
    public ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_camion);

        controler = Traspaso.getRepartidorControler();

        rut = (TextView)findViewById(R.id.txtrut);
        marca = (EditText)findViewById(R.id.marca);
        modelo = (EditText)findViewById(R.id.modelo);
        dimensiones = (EditText)findViewById(R.id.dimensiones);
        tara = (EditText)findViewById(R.id.dimensiones);
        btncancel = (Button)findViewById(R.id.btncancel);
        modificar_camion = (Button)findViewById(R.id.modificar_camion);

        rut.setText(controler.getRepartidor().getrut());

        modificar_camion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controler.getCamion().setmarca(marca.getText().toString());
                controler.getCamion().setmodelo(modelo.getText().toString());
                controler.getCamion().setDimencion(dimensiones.getText().length());
                controler.getCamion().setcarga(tara.getText().length());

               // new AsyncModificar().execute(true);

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





}
