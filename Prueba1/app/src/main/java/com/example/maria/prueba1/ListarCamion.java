package com.example.maria.prueba1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.maria.prueba1.capanegocio.RepartidorControler;


public class ListarCamion extends ActionBarActivity {

    TextView txtpatente, marca, modelo,dimensiones, tara, txtrut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_camion);

        txtpatente = (TextView)findViewById(R.id.txtpatente);
        marca = (TextView)findViewById(R.id.marca);
        modelo = (TextView)findViewById(R.id.modelo);
        dimensiones = (TextView)findViewById(R.id.dimensiones);
        tara = (TextView)findViewById(R.id.tara);
        txtrut = (TextView)findViewById(R.id.txtrut);


    }


}
