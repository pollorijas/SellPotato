package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazRepartidor extends Activity {

    ImageButton imgcamion;

    ClienteControler controler;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_repartidor);

        controler = Traspaso.getControler();

        imgcamion = (ImageButton)findViewById(R.id.imgcamion);

        imgcamion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ri = new Intent(getApplicationContext(), GestionarCamion.class);
                startActivity(ri);
            }
        });






    }

}
